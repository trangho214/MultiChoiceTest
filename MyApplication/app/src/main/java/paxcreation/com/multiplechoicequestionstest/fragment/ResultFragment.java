package paxcreation.com.multiplechoicequestionstest.fragment;

import android.app.Activity;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import paxcreation.com.multiplechoicequestionstest.R;
import paxcreation.com.multiplechoicequestionstest.adapter.ResultAdapter;
import paxcreation.com.multiplechoicequestionstest.database.AnswerDAO;
import paxcreation.com.multiplechoicequestionstest.entity.Answer;
import paxcreation.com.multiplechoicequestionstest.entity.Candidate;
import paxcreation.com.multiplechoicequestionstest.entity.ConstructedQuestion;
import paxcreation.com.multiplechoicequestionstest.entity.MultiChoiceQuestion;
import paxcreation.com.multiplechoicequestionstest.global.GlobalObject;
import paxcreation.com.multiplechoicequestionstest.utils.Data;

public class ResultFragment extends Fragment {
    private static final String INDEX = "index";

    private ListView lvResult;

    private List<MultiChoiceQuestion> multiChoiceQuestions;
    private List<ConstructedQuestion> constructedQuestions;
    private Candidate currentCandidate;
    private ResultAdapter adapter;

    private List<Candidate> candidates;
    private int index;


    public static ResultFragment newInstance(int index) {
        ResultFragment fragment = new ResultFragment();
        Bundle args = new Bundle();
        args.putInt(INDEX, index);
        fragment.setArguments(args);
        return fragment;
    }

    public int getShownIndex()
    {
        return getArguments().getInt(INDEX, -1);
    }
    public ResultFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_result, container, false);
        index = getArguments().getInt(INDEX);
        init(v);
        return v;
    }
    private void init(View v)
    {

        lvResult = (ListView)v.findViewById(R.id.lvMultiChoice_Result);
        currentCandidate = GlobalObject.getCandidateInstance_Admin();
        List<Candidate> candidates = GlobalObject.getCandidatesInstance();
        currentCandidate = candidates.get(index);

        if(currentCandidate.isAndroidDev())
        {
            multiChoiceQuestions = Data.getMultiChoiceQuestionsAndroid();
            constructedQuestions = Data.getConstructedQuestionAndroid();
        }
        else
        {
            multiChoiceQuestions = Data.getMultiChoiceQuestionIOS();
            constructedQuestions = Data.getConstructedQuestionIOS();
        }
        asyncTask.execute();

    }

    AsyncTask<Void, Void, List<Answer>> asyncTask = new AsyncTask<Void, Void, List<Answer>>() {
        @Override
        protected List<Answer> doInBackground(Void... params) {
            List<Answer> answers = new ArrayList<Answer>();
            AnswerDAO answerDAO = AnswerDAO.getInstance(getActivity());
            answerDAO.open();
            answers = answerDAO.getAnswersByCID(currentCandidate.getId());
            answerDAO.close();
            return answers;
        }

        @Override
        protected void onPostExecute(List<Answer> answers) {
            super.onPostExecute(answers);
            adapter = new ResultAdapter(getActivity(),multiChoiceQuestions, constructedQuestions, currentCandidate,answers);
            lvResult.setAdapter(adapter);
        }
    };





    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */


}
