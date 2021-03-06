package paxcreation.com.multiplechoicequestionstest.entity;

import java.io.Serializable;

/**
 * Created by Administrator on 12/06/2015.
 */
public class Answer implements Serializable {
    public static final String TAG = "answer";
    private static final long serialVersionUID = -7406082437623008162L;

    private long answerId;
    private long candidateId;
    private int questionId;
    private int multiChoiceAnswer;
    private String constructedAnswer;
    private float point;

    public Answer(){}
    public Answer(int questionId){
        this.questionId = questionId;
        multiChoiceAnswer = -1;
        constructedAnswer = "DEFAULT";
    }
    public Answer(int questionId, int multiChoiceAnswer, String constructedAnswer) {
        this.questionId = questionId;
        this.multiChoiceAnswer = multiChoiceAnswer;
        this.constructedAnswer = constructedAnswer;
    }

    public Answer(int questionId, String constructedAnswer) {
        this.questionId = questionId;
        this.multiChoiceAnswer =-1;
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

    public long getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(int candidateId) {
        this.candidateId = candidateId;
    }

    public float getPoint() {
        return point;
    }

    public void setPoint(float point) {
        this.point = point;
    }

    public long getAnswerId() {
        return answerId;
    }

    public void setAnswerId(long answerId) {
        this.answerId = answerId;
    }
}
