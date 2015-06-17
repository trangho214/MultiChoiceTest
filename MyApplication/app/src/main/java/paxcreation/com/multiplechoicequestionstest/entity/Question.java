package paxcreation.com.multiplechoicequestionstest.entity;

/**
 * Created by Administrator on 12/06/2015.
 */
public class Question {
    private int id;
    private String question;
    private String content;

    public Question(){}
    public Question(int id, String question)
    {
        this.id = id;
        this.question = question;
    }

    public Question(int id, String question, int questionTypeId) {
        this.id = id;
        this.question = question;
    }

    public Question(int id, String question,String content, int questionTypeId) {
        this.id = id;
        this.question = question;
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}
