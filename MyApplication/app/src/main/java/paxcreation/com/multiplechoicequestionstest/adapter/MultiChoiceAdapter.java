package paxcreation.com.multiplechoicequestionstest.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.List;

import paxcreation.com.multiplechoicequestionstest.R;
import paxcreation.com.multiplechoicequestionstest.entity.Candidate;
import paxcreation.com.multiplechoicequestionstest.entity.ConstructedQuestion;
import paxcreation.com.multiplechoicequestionstest.entity.MultiChoiceQuestion;
import paxcreation.com.multiplechoicequestionstest.global.GlobalObject;

/**
 * Created by Administrator on 16/06/2015.
 */
public class MultiChoiceAdapter extends PagerAdapter {
    List<MultiChoiceQuestion> multiChoiceQuestions;
    List<ConstructedQuestion> constructedQuestions;
    Context context;
    LayoutInflater inflater;
    ViewPagerListener viewPagerListener;
    Candidate currentCandidate;

    public MultiChoiceAdapter(Context context, List<MultiChoiceQuestion> multiChoiceQuestions, List<ConstructedQuestion> constructedQuestions,ViewPagerListener viewPagerListener)
    {
        this.context = context;
        this.multiChoiceQuestions = multiChoiceQuestions;
        this.constructedQuestions = constructedQuestions;
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.viewPagerListener = viewPagerListener;
        currentCandidate = GlobalObject.getCandidateInstance_Test();
    }


    @Override
    public Object instantiateItem(ViewGroup container, final int position) {

        final View view = inflater.inflate(R.layout.question_element, container, false);
        LinearLayout llo = (LinearLayout)view.findViewById(R.id.llo_MultiChoiceElement);

        TextView txtQuestion = (TextView)view.findViewById(R.id.txtQuestion_MultiChoiceElement);
        TextView txtContent = (TextView)view.findViewById(R.id.txtContent_MultiChoiceElement);
        EditText editText = (EditText)view.findViewById(R.id.edAnswerConstructed_MultiChoiceElement);
        LinearLayout lloGroupView =(LinearLayout)view.findViewById(R.id.lloGroupView_MultiChoiceElement);
        ((LinearLayout)view.findViewById(R.id.lloResult_MultiChoiceElement)).setVisibility(View.GONE);
        if(position< getMultiChoiceCount())
        {
            MultiChoiceQuestion currentQuestion = multiChoiceQuestions.get(position);
            editText.setVisibility(View.GONE);
            txtQuestion.setText(currentQuestion.getQuestion());
            txtContent.setText(currentQuestion.getContent());
            lloGroupView.addView(createMultiChoiceView(context, currentQuestion, position));
//            llo.addView(createMultiChoiceView(context, currentQuestion, position));
        }
        else
        {
            ConstructedQuestion currentConstructedQuestion = constructedQuestions.get(position-getMultiChoiceCount());
            editText.setVisibility(View.VISIBLE);
            editText.setText((getAnsweredText(position).equals("DEFAULT")? "": getAnsweredText(position)));
            editText.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    Log.d("Text change",s.toString() +" "+ position );
                    viewPagerListener.onTextChange(position, s.toString());
                }

                @Override
                public void afterTextChanged(Editable s) {

                }
            });
            txtQuestion.setText(currentConstructedQuestion.getQuestion());
            txtContent.setText(currentConstructedQuestion.getContent());
        }
        container.addView(view);
        return view;
    }

    public RadioGroup createMultiChoiceView(final Context context, MultiChoiceQuestion currentQuestion, final int position )
    {
        RadioGroup radioGroup = new RadioGroup(context);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                viewPagerListener.onRadioClick(position, group.indexOfChild(group.findViewById(checkedId)));
            }
        });
        for(int i =0; i<currentQuestion.getPossibleAnswers().size(); i++)
        {
            RadioButton radioButton = new RadioButton(context);
            radioButton.setText(currentQuestion.getPossibleAnswers().get(i));
            radioGroup.addView(radioButton);
        }
        if(getAnsweredRadioIndex(position) != -1)
            ((RadioButton)radioGroup.getChildAt(getAnsweredRadioIndex(position))).setChecked(true);
        return radioGroup;

    }

    //    being used in case of reviewing answer after chosen
    private int getAnsweredRadioIndex(int position)
    {
        try {
            int index = currentCandidate.getAnswers().get(position).getMultiChoiceAnswer();
            Log.d("index after click", String.valueOf(index));
            return (index==-1)? -1:index;
        }
        catch (Exception e)
        {
            return -1;
        }
    }

    //    being used in case of reviewing answer after chosen
    private String getAnsweredText(int position)
    {
        String text;
        try {
            text= currentCandidate.getAnswers().get(position).getConstructedAnswer();
        }
        catch (Exception e)
        {
            text = "DEFAULT";
        }
        return text;
    }

    @Override
    public int getCount() {
        return getMultiChoiceCount() + getConstructedQuestionCount();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((ScrollView)object);
    }



    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((ScrollView)object);
    }

    public int getMultiChoiceCount()
    {
        return multiChoiceQuestions.size();
    }

    private int getConstructedQuestionCount()
    {
        return constructedQuestions.size();
    }

    public interface ViewPagerListener
    {
        void onRadioClick(int position, int index);
        void onTextChange(int position, String text);
    }
}
