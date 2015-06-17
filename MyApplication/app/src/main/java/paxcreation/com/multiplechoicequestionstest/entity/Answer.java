package paxcreation.com.multiplechoicequestionstest.entity;

/**
 * Created by Administrator on 12/06/2015.
 */
public class Answer {
    private int questionId;
    private int multiChoiceAnswer;
    private String constructedAnswer;

    public Answer(int questionId, int multiChoiceAnswer, String constructedAnswer) {
        this.questionId = questionId;
        this.multiChoiceAnswer = multiChoiceAnswer;
        this.constructedAnswer = constructedAnswer;
    }

    public Answer(int questionId, int multiChoiceAnswer) {
        this.questionId = questionId;
        this.multiChoiceAnswer = multiChoiceAnswer;
        this.constructedAnswer = "";
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public int getMultiChoiceAnswer() {
        return multiChoiceAnswer;
    }

    public void setMultiChoiceAnswer(int multiChoiceAnswer) {
        this.multiChoiceAnswer = multiChoiceAnswer;
    }

    public String getConstructedAnswer() {
        return constructedAnswer;
    }

    public void setConstructedAnswer(String constructedAnswer) {
        this.constructedAnswer = constructedAnswer;
    }

    public Answer(int questionId, String constructedAnswer) {
        this.questionId = questionId;
        this.multiChoiceAnswer =-1;
        this.constructedAnswer = constructedAnswer;
    }
}
