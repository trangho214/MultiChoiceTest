package paxcreation.com.multiplechoicequestionstest.activity;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import paxcreation.com.multiplechoicequestionstest.R;
import paxcreation.com.multiplechoicequestionstest.adapter.MultiChoiceAdapter;
import paxcreation.com.multiplechoicequestionstest.adapter.MultiChoiceAdapter.ViewPagerListener;
import paxcreation.com.multiplechoicequestionstest.database.AnswerDAO;
import paxcreation.com.multiplechoicequestionstest.entity.Answer;
import paxcreation.com.multiplechoicequestionstest.entity.Candidate;
import paxcreation.com.multiplechoicequestionstest.entity.ConstructedQuestion;
import paxcreation.com.multiplechoicequestionstest.entity.MultiChoiceQuestion;
import paxcreation.com.multiplechoicequestionstest.global.GlobalObject;
import paxcreation.com.multiplechoicequestionstest.utils.Data;

/**
 * Created by Administrator on 16/06/2015.
 */
public class TestActivity extends Activity implements ViewPagerListener{

    private ViewPager vp;
    private MultiChoiceAdapter adapter;
    private TextView txtTimer;

    private Candidate candidate;
    private  List<Answer> answers;
    private int currentPosition=0;

    List<MultiChoiceQuestion> multiChoiceQuestions;
    List<ConstructedQuestion> constructedQuestions;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);
        init();
    }

    private void init()
    {
        txtTimer = (TextView)findViewById(R.id.txtTime);
        answers = new ArrayList<Answer>();
        candidate = GlobalObject.getCandidateInstance_Test();
        Log.d("candidate name", candidate.getName());
        multiChoiceQuestions = new ArrayList<MultiChoiceQuestion>();
        constructedQuestions = new ArrayList<ConstructedQuestion>();
        vp = (ViewPager)findViewById(R.id.vpQuestion_Test);
        if(candidate.isAndroidDev()){
            multiChoiceQuestions = Data.getMultiChoiceQuestionsAndroid();
            constructedQuestions = Data.getConstructedQuestionAndroid();
        }
        else {
            multiChoiceQuestions = Data.getMultiChoiceQuestionIOS();
            constructedQuestions = Data.getConstructedQuestionIOS();
        }
        adapter = new MultiChoiceAdapter(this,multiChoiceQuestions, constructedQuestions, this);

        for(int i =0; i<adapter.getCount(); i++)
        {
            answers.add(new Answer(i));
        }

        vp.setAdapter(adapter);
        vp.setOnPageChangeListener(onPageChangeListener);
        candidate.setAnswers(answers);
        startCountdown(10 * 60 * 1000);
    }

    private void startCountdown(int timeInMilliseconds)
    {
        ( new CountDownTimer(timeInMilliseconds,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                long durationSeconds = millisUntilFinished/1000;
                txtTimer.setText(String.format("%02d:%02d", (durationSeconds % 3600) / 60, (durationSeconds % 60)));
            }

            @Override
            public void onFinish() {
//                TODO: save answer to database, then stop the test
            }
        }).start();
    }
    //   set viewpager to OnPageChangeListener to get the current position when sliding
//   CurrentPosition will be used to next and previous button
    ViewPager.OnPageChangeListener onPageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        }

        @Override
        public void onPageSelected(int position) {
            currentPosition = position;
        }

        @Override
        public void onPageScrollStateChanged(int state) {
        }
    };

    //    Click next or previous
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.ibtmNext_Test:
                if(currentPosition<adapter.getCount()-1)
                {
                    currentPosition++;
                    vp.setCurrentItem(currentPosition);
                }
                break;
            case R.id.ibtnPrevious_Test:
                if(currentPosition>0)
                {
                    currentPosition--;
                    vp.setCurrentItem(currentPosition);
                }
                break;
            case R.id.btnFinish:
                asyncTask.execute(candidate);
                break;
        }
    }

    AsyncTask<Candidate, Void, Boolean > asyncTask = new AsyncTask<Candidate, Void, Boolean>() {
        AnswerDAO answerDAO;
        @Override
        protected Boolean doInBackground(Candidate... params) {
            try{
                answerDAO = AnswerDAO.getInstance(TestActivity.this.getApplicationContext());
                answerDAO.open();
                for (int i = 0; i<candidate.getAnswers().size(); i++)
                {
                    Answer answer = candidate.getAnswers().get(i);
                    Log.d("candidate answer", answer.getConstructedAnswer());
                    answerDAO.insertAnswer(candidate.getId(), answer.getQuestionId(), answer.getMultiChoiceAnswer(), answer.getConstructedAnswer(), answer.getPoint());
                }
                answerDAO.close();
                return true;
            }
            catch (Exception e)
            {
                answerDAO.close();
                return false;
            }
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            super.onPostExecute(aBoolean);
        }
    };

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
//        TODO: handle change configuration here.
    }

    @Override
    public void onRadioClick(int position, int index) {
        candidate.getAnswers().get(position).setMultiChoiceAnswer(index);
        if(multiChoiceQuestions.get(position).getRightAnswer() == index)
            candidate.getAnswers().get(position).setPoint(1);
        else
            candidate.getAnswers().get(position).setPoint(0);
        Log.d("tiateItem click tion", String.valueOf(candidate.getAnswers().get(position).getMultiChoiceAnswer()));
    }

    @Override
    public void onTextChange(int position, String text) {
        candidate.getAnswers().get(position).setConstructedAnswer(text);
        Log.d("tiateItem position", String.valueOf(position));
    }
}
