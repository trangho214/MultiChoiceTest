package paxcreation.com.multiplechoicequestionstest.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 12/06/2015.
 */

public class Candidate implements Serializable{
    public static final String TAG ="candidate";
    private static final long SERIAL_VERSION_UID = -7406082437623008161L;

    private long id;
    private String name;
    private boolean isAndroidDev;
    private long create_at;
    private List<Answer> answers;


    public Candidate(int id, String name, List<Answer> answers) {
        this.id = id;
        this.name = name;
        this.answers = answers;
    }

    public Candidate(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public long getCreate_at() {
        return create_at;
    }

    public void setCreate_at(long create_at) {
        this.create_at = create_at;
    }
}
