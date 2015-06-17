package paxcreation.com.multiplechoicequestionstest.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import paxcreation.com.multiplechoicequestionstest.R;
import paxcreation.com.multiplechoicequestionstest.entity.ConstructedQuestion;
import paxcreation.com.multiplechoicequestionstest.entity.MultiChoiceQuestion;
import paxcreation.com.multiplechoicequestionstest.utils.Util;

/**
 * Created by Administrator on 16/06/2015.
 */
public class MultiChoiceAdapter extends PagerAdapter {
    List<MultiChoiceQuestion> multiChoiceQuestions;
    List<ConstructedQuestion> constructedQuestions;
    Context context;
    LayoutInflater inflater;


    public MultiChoiceAdapter(Context context, List<MultiChoiceQuestion> multiChoiceQuestions, List<ConstructedQuestion> constructedQuestions)
    {
        this.context = context;
        this.multiChoiceQuestions = multiChoiceQuestions;
        this.constructedQuestions = constructedQuestions;
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    public MultiChoiceAdapter(Context context, List<MultiChoiceQuestion> multiChoiceQuestions)
    {
        this.context = context;
        this.multiChoiceQuestions = multiChoiceQuestions;
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        View view = inflater.inflate(R.layout.multichoice_element, container, false);
        LinearLayout llo = (LinearLayout)view.findViewById(R.id.llo_MultiChoiceElement);

        TextView txtQuestion = (TextView)view.findViewById(R.id.txtQuestion_MultiChoiceElement);
        TextView txtContent = (TextView)view.findViewById(R.id.txtContent_MultiChoiceElement);
        EditText editText = (EditText)view.findViewById(R.id.edAnswer_MultiChoiceElement);
        if(position< getMultiChoiceCount())
        {
            MultiChoiceQuestion currentQuestion = multiChoiceQuestions.get(position);
            editText.setVisibility(View.GONE);
            txtQuestion.setText(currentQuestion.getQuestion());
            txtContent.setText(currentQuestion.getContent());
            llo.addView(createMultiChoiceView(context, currentQuestion, position));
        }

        else
        {
            ConstructedQuestion currentConstructedQuestion = constructedQuestions.get(position-getMultiChoiceCount());
            editText.setVisibility(View.VISIBLE);
            txtQuestion.setText(currentConstructedQuestion.getQuestion());
            txtContent.setText(currentConstructedQuestion.getContent());

        }
//        if(position<= getMultiChoiceCount())
//        {
//            LinearLayout llo = (LinearLayout)view.findViewById(R.id.llo_MultiChoiceElement);
//            MultiChoiceQuestion currentQuestion = multiChoiceQuestions.get(position);
//            TextView txtQuestion = (TextView)view.findViewById(R.id.txtQuestion_MultiChoiceElement);
//            TextView txtContent = (TextView)view.findViewById(R.id.txtContent_MultiChoiceElement);
//            txtQuestion.setText(currentQuestion.getQuestion());
//            txtContent.setText(currentQuestion.getContent());
//            llo.addView(createMultiChoiceView(context, currentQuestion, position));
//        }
        container.addView(view);
        return view;
    }
    public RadioGroup createMultiChoiceView(final Context context, MultiChoiceQuestion currentQuestion, final int position )
    {
        RadioGroup radioGroup = new RadioGroup(context);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Toast.makeText(context, String.valueOf(group.indexOfChild(group.findViewById(checkedId))) + position, Toast.LENGTH_SHORT).show();
            }
        });
        for(int i =0; i<currentQuestion.getPossibleAnswers().size(); i++)
        {
            RadioButton radioButton = new RadioButton(context);
            radioButton.setText(currentQuestion.getPossibleAnswers().get(i));
            radioGroup.addView(radioButton);
        }
        return radioGroup;
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

    private int getMultiChoiceCount()
    {
        return multiChoiceQuestions.size();
    }

    private int getConstructedQuestionCount()
    {
        return constructedQuestions.size();
    }

}
