package paxcreation.com.multiplechoicequestionstest.entity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by Administrator on 12/06/2015.
 */
public class CandidateAnswers {
    private int candidateId;
    private List<MultiChoiceQuestion> multiChoiceAnswers;
    private List<ConstructedQuestion> constructedAnswer;

    private String getDateTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        Date date = new Date();
        return dateFormat.format(date);
    }
}
