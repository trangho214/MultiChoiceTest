package paxcreation.com.multiplechoicequestionstest.entity;

/**
 * Created by Administrator on 12/06/2015.
 */
public class QuestionType {
    private int id;
    private String type;

    public QuestionType(int id, String type) {
        this.id = id;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
