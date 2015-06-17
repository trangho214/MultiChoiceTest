package paxcreation.com.multiplechoicequestionstest.entity;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 12/06/2015.
 */

public class Candidate {
    private static Candidate instance = null;

    private int id;
    private String name;
    private boolean isAndroidDev;
    private List<Answer> answers;

    public Candidate(int id, String name, List<Answer> answers) {
        this.id = id;
        this.name = name;
        this.answers = answers;
    }

    public Candidate(){}

    public static Candidate getInstance()
    {
        if(instance == null)
        {
            instance = new Candidate();
        }
        return instance;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public boolean isAndroidDev() {
        return isAndroidDev;
    }

    public void setIsAndroidDev(boolean isAndroidDev) {
        this.isAndroidDev = isAndroidDev;
    }
}
