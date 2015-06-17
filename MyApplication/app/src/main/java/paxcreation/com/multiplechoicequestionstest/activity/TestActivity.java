package paxcreation.com.multiplechoicequestionstest.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewParent;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.List;

import paxcreation.com.multiplechoicequestionstest.R;
import paxcreation.com.multiplechoicequestionstest.adapter.MultiChoiceAdapter;
import paxcreation.com.multiplechoicequestionstest.entity.MultiChoiceQuestion;
import paxcreation.com.multiplechoicequestionstest.utils.Data;

/**
 * Created by Administrator on 16/06/2015.
 */
public class TestActivity extends Activity{

    ViewPager vp;
    MultiChoiceAdapter adapter;

    int currentPosition=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.test);
        setContentView(R.layout.test);
        init();
    }

    private void init()
    {
        vp = (ViewPager)findViewById(R.id.vpQuestion_Test);
        adapter= new MultiChoiceAdapter(this, Data.getMultiChoiceQuestionsAndroid(), Data.getConstructedQuestionAndroid());
        vp.setAdapter(adapter);
        vp.setOnPageChangeListener(onPageChangeListener);
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


//    private RadioGroup createRadioGroup(int position)
//    {
//        RadioGroup radioGroup = new RadioGroup(this);
//        radioGroup.setOrientation(RadioGroup.VERTICAL);
//        MultiChoiceQuestion currentQuestion = multiChoiceQuestions.get(position);
//        txtContent.setText(currentQuestion.getContent());
//        for (int i = 0; i < currentQuestion.getPossibleAnswers().size(); i++)
//        {
//            RadioButton radioButton = new RadioButton(this);
//            radioButton.setText(currentQuestion.getPossibleAnswers().get(i));
//            radioGroup.addView(radioButton);
//        }
//        return radioGroup;
//    }

}
