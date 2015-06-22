package paxcreation.com.multiplechoicequestionstest.global;

import java.util.ArrayList;
import java.util.List;

import paxcreation.com.multiplechoicequestionstest.entity.Candidate;

/**
 * Created by Administrator on 17/06/2015.
 */
public class GlobalObject {
    private static Candidate candidate_test;
    public static Candidate getCandidateInstance_Test()
    {
        if(candidate_test ==null)
            candidate_test = new Candidate();
        return candidate_test;
    }

    private static Candidate candidate_admin;
    public static Candidate getCandidateInstance_Admin()
    {
        if(candidate_admin ==null)
            candidate_admin = new Candidate();
        return candidate_admin;
    }


    private static List<Candidate> candidates;
    public static List<Candidate> getCandidatesInstance()
    {
        if(candidates == null)
            candidates = new ArrayList<Candidate>();
        return candidates;
    }
    public static List<Candidate> getCandidates() {
        return candidates;
    }

    public static void setCandidates(List<Candidate> candidates) {
        GlobalObject.candidates = candidates;
    }


}
