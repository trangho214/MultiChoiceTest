package paxcreation.com.multiplechoicequestionstest.utils;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.List;

import paxcreation.com.multiplechoicequestionstest.entity.MultiChoiceQuestion;

/**
 * Created by Administrator on 16/06/2015.
 */
public class Util {
    public static RadioGroup createMultiChoiceView(Context context, MultiChoiceQuestion currentQuestion )
    {
        RadioGroup radioGroup = new RadioGroup(context);
        radioGroup.setOrientation(RadioGroup.VERTICAL);
        for(int i =0; i<currentQuestion.getPossibleAnswers().size(); i++)
        {
            RadioButton radioButton = new RadioButton(context);
            radioButton.setText(currentQuestion.getPossibleAnswers().get(i));
            radioGroup.addView(radioButton);
        }
        return radioGroup;
    }

}
