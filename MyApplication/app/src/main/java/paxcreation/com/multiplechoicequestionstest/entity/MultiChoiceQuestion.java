package paxcreation.com.multiplechoicequestionstest.entity;

import java.util.List;

/**
 * Created by Administrator on 12/06/2015.
 */
public class MultiChoiceQuestion extends Question {
    private List<String> possibleAnswers;
    private int rightAnswer;

    public MultiChoiceQuestion(){}

    public MultiChoiceQuestion(int id, String question,int questionTypeId,List<String> possibleAnswers, int rightAnswer) {
        super(id, question, questionTypeId);
        this.possibleAnswers = possibleAnswers;
        this.rightAnswer = rightAnswer;
    }

    public List<String> getPossibleAnswers() {
        return possibleAnswers;
    }

    public void setPossibleAnswers(List<String> possibleAnswers) {
        this.possibleAnswers = possibleAnswers;
    }

    public int getRightAnswer() {
        return rightAnswer;
    }

    public void setRightAnswer(int rightAnswer) {
        this.rightAnswer = rightAnswer;
    }
}
