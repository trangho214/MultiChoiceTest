package paxcreation.com.multiplechoicequestionstest.adapter;

import android.app.Activity;
import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.List;

import paxcreation.com.multiplechoicequestionstest.R;
import paxcreation.com.multiplechoicequestionstest.entity.Answer;
import paxcreation.com.multiplechoicequestionstest.entity.Candidate;
import paxcreation.com.multiplechoicequestionstest.entity.ConstructedQuestion;
import paxcreation.com.multiplechoicequestionstest.entity.MultiChoiceQuestion;

/**
 * Created by Administrator on 18/06/2015.
 */
public class ResultAdapter extends BaseAdapter {
    String[] answerStrings;
    Context context;
    List<Answer> answers;
    Candidate currentCandidate;
    List<MultiChoiceQuestion> multiChoiceQuestions;
    List<ConstructedQuestion> constructedQuestions;
    LayoutInflater inflater;

    public ResultAdapter(Context context, List<MultiChoiceQuestion> multiChoiceQuestions, List<ConstructedQuestion> constructedQuestions, Candidate currentCandidate, List<Answer> answers) {
        this.context = context;
        this.answers = answers;
        this.multiChoiceQuestions = multiChoiceQuestions;
        this.constructedQuestions = constructedQuestions;
        this.currentCandidate = currentCandidate;
        answerStrings = new String[]{"a", "b","c","d","e","f"};
        currentCandidate.setAnswers(answers);
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return answers.size();
    }

    @Override
    public Answer getItem(int position) {
        return answers.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public int getMultiChoiceCount() {
        return multiChoiceQuestions.size();
    }

    public int getConstructedCount() {
        return constructedQuestions.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
//        inflater = (LayoutInflater) ((Activity)context).getLayoutInflater();
        final Answer currentAnswer = answers.get(position);
        Log.d("candidate answer count", "answer count " + answers.size());
        View view = inflater.inflate(R.layout.question_element, null);
        TextView txtQuestion = (TextView) view.findViewById(R.id.txtQuestion_MultiChoiceElement);
        TextView txtContent = (TextView) view.findViewById(R.id.txtContent_MultiChoiceElement);
        ((EditText) view.findViewById(R.id.edAnswerConstructed_MultiChoiceElement)).setVisibility(View.GONE);
        LinearLayout lloRadioGroup = (LinearLayout) view.findViewById(R.id.lloGroupView_MultiChoiceElement);
        TextView txtResult = (TextView) view.findViewById(R.id.txtAnswer_MultiChoiceElement);
        EditText edPoint = (EditText) view.findViewById(R.id.txtPoint_MultiChoiceElement);
        edPoint.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(!editable.toString().equals("") || !(editable.toString().length() ==0))
                    currentAnswer.setPoint(Float.parseFloat(editable.toString()));
            }
        });

        if (position < getMultiChoiceCount()) {
            MultiChoiceQuestion currentQuestion = multiChoiceQuestions.get(currentAnswer.getQuestionId());
            txtQuestion.setText(currentQuestion.getQuestion());
            txtContent.setText(currentQuestion.getContent());
            lloRadioGroup.addView(createMultiChoiceView(context, currentQuestion));
            if(currentAnswer.getMultiChoiceAnswer()== -1)
                txtResult.setText("No answer");
            else
                txtResult.setText(answerStrings[currentAnswer.getMultiChoiceAnswer()]);
            edPoint.setText(String.valueOf(currentAnswer.getPoint()));
        }
        else {
            ConstructedQuestion currentConstructed = constructedQuestions.get(position-getMultiChoiceCount());
            txtQuestion.setText(currentConstructed.getQuestion());
            txtContent.setText(currentConstructed.getContent());
            txtResult.setText(currentAnswer.getConstructedAnswer().trim());
            edPoint.setText(String.valueOf(currentAnswer.getPoint()));
        }
        return view;
    }


    public RadioGroup createMultiChoiceView(final Context context, MultiChoiceQuestion currentQuestion) {
        RadioGroup radioGroup = new RadioGroup(context);
        for (int i = 0; i < currentQuestion.getPossibleAnswers().size(); i++) {
            RadioButton radioButton = new RadioButton(context);
            radioButton.setText(currentQuestion.getPossibleAnswers().get(i));
            radioGroup.addView(radioButton);
        }
        ((RadioButton) radioGroup.getChildAt(currentQuestion.getRightAnswer())).setChecked(true);
        return radioGroup;
    }


}
