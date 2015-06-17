package paxcreation.com.multiplechoicequestionstest.utils;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.List;

import paxcreation.com.multiplechoicequestionstest.entity.Candidate;
import paxcreation.com.multiplechoicequestionstest.entity.MultiChoiceQuestion;

/**
 * Created by Administrator on 16/06/2015.
 */
public class Util {
   private static Candidate candidate;
    public Candidate getInstance()
    {
        if(candidate == null)
            candidate = new Candidate();
        return candidate;
    }

}
