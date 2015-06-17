package paxcreation.com.multiplechoicequestionstest.global;

import paxcreation.com.multiplechoicequestionstest.entity.Candidate;

/**
 * Created by Administrator on 17/06/2015.
 */
public class GlobalObject {
    private static Candidate candidate;
    public static Candidate getCandidateInstance()
    {
        if(candidate ==null)
            candidate = new Candidate();
        return candidate;
    }
}
