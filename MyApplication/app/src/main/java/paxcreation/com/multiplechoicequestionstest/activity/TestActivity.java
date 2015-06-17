package paxcreation.com.multiplechoicequestionstest.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.ViewParent;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import paxcreation.com.multiplechoicequestionstest.R;
import paxcreation.com.multiplechoicequestionstest.adapter.MultiChoiceAdapter;
import paxcreation.com.multiplechoicequestionstest.adapter.MultiChoiceAdapter.ViewPagerListener;
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

    ViewPager vp;
    MultiChoiceAdapter adapter;
    Candidate candidate;

    List<Answer> answers;
    int currentPosition=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);
        init();
    }


    private void init()
    {
        answers = new ArrayList<Answer>();
        candidate = GlobalObject.getCandidateInstance();
        vp = (ViewPager)findViewById(R.id.vpQuestion_Test);
        if(candidate.isAndroidDev()) {
            adapter = new MultiChoiceAdapter(this, Data.getMultiChoiceQuestionsAndroid(), Data.getConstructedQuestionAndroid(), this);
        }
        else {
            adapter = new MultiChoiceAdapter(this, Data.getMultiChoiceQuestionIOS(), Data.getConstructedQuestionIOS(), this);
        }
        for(int i =0; i<adapter.getCount(); i++)
        {
            answers.add(new Answer(i));
        }
        vp.setAdapter(adapter);
        vp.setOnPageChangeListener(onPageChangeListener);
        candidate.setAnswers(answers);
    }


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
        }
    }

    @Override
    public void onRadioClick(int position, int index) {

        candidate.getAnswers().get(position).setMultiChoiceAnswer(index);
        Log.d("tiateItem click tion", String.valueOf(candidate.getAnswers().get(position).getMultiChoiceAnswer()));

    }

    @Override
    public void onTextChange(int position, String text) {
       candidate.getAnswers().get(position).setConstructedAnswer(text);
        Log.d( "tiateItem position", String.valueOf(position));
    }
}
