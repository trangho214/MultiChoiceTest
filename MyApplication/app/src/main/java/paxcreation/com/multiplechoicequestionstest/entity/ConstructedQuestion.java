package paxcreation.com.multiplechoicequestionstest.entity;

/**
 * Created by Administrator on 12/06/2015.
 */
public class ConstructedQuestion extends Question {


    private String answer;

    public ConstructedQuestion(){}
    public ConstructedQuestion(int id, String question,int questionTypeId, String answer)
    {
        super(id,question, questionTypeId);
        this.answer = answer;
    }


    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

}
