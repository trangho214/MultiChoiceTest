package paxcreation.com.multiplechoicequestionstest.fragment;

import android.app.Fragment;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
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
    private TextView txtCandidateName;
    private List<Answer> answerList;
    private ResultAdapter adapter;


    private List<MultiChoiceQuestion> multiChoiceQuestions;
    private List<ConstructedQuestion> constructedQuestions;
    private Candidate currentCandidate;


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
        index = getArguments().getInt(INDEX,0);
        init(v);
        return v;
    }
    private void init(View v)
    {

        String isAndroid;
        answerList = new ArrayList<Answer>();
        lvResult = (ListView)v.findViewById(R.id.lvMultiChoice_Result);
        txtCandidateName = (TextView)v.findViewById(R.id.txtCandidateName_Result);
//        currentCandidate = GlobalObject.getCandidateInstance_Admin();
        candidates = GlobalObject.getCandidatesInstance();
        Log.d("candidate size result", String.valueOf(candidates.size()) + " index " + index);
        currentCandidate = candidates.get(index);

        if(currentCandidate.isAndroidDev())
        {
            multiChoiceQuestions = Data.getMultiChoiceQuestionsAndroid();
            constructedQuestions = Data.getConstructedQuestionAndroid();
            isAndroid = "(Android)";
        }
        else
        {
            multiChoiceQuestions = Data.getMultiChoiceQuestionIOS();
            constructedQuestions = Data.getConstructedQuestionIOS();
            isAndroid = "(IOS)";
        }
        txtCandidateName.setText("Candidate: " + currentCandidate.getName() + isAndroid);
        getAnswerAsyncTask.execute();

    }

    AsyncTask<Void, Void, List<Answer>> getAnswerAsyncTask = new AsyncTask<Void, Void, List<Answer>>() {
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
            answerList = answers;
            adapter = new ResultAdapter(getActivity(),multiChoiceQuestions, constructedQuestions, currentCandidate,answerList);
            lvResult.setAdapter(adapter);
            lvResult.addFooterView(footer());
            txtSum.setText(String.valueOf(getSum(answers)));
        }
    };

    private float getSum(List<Answer> answers)
    {
        float sum = 0;
        for (int i =0; i<answers.size(); i++)
        {
            sum = sum + answers.get(i).getPoint();
        }
        return sum;

    }
    private Button btnOk;
    private TextView txtSum;
    private View footer()
    {
        View v = ((LayoutInflater)getActivity().getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.footer_result,null);
        txtSum = (TextView)v.findViewById(R.id.txtSum_Result);
        btnOk = (Button)v.findViewById(R.id.btnOK_Result);
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateAsyncTask.execute();
            }
        });
        return v;
    }

    AsyncTask<Void, Void, Boolean> updateAsyncTask = new AsyncTask<Void, Void, Boolean>() {
        boolean isUpdated = false;
        @Override
        protected Boolean doInBackground(Void... voids) {

            AnswerDAO answerDAO = AnswerDAO.getInstance(getActivity());
            answerDAO.open();
            for (int i =answerList.size()-1; i >= answerList.size()-adapter.getConstructedCount();i-- )
            {
                isUpdated =   answerDAO.updateAnswer(answerList.get(i).getAnswerId(), answerList.get(i).getPoint());
                Log.d("candidate async point", " id:  "  + answerList.get(i).getAnswerId() + " point " +  answerList.get(i).getPoint() );
                Log.d("candidate async point", " is update " +  isUpdated );
            }
            answerDAO.close();
            return isUpdated;
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            super.onPostExecute(aBoolean);
            if(isUpdated)
            {
                txtSum.setText(String.valueOf(getSum(answerList)));
                Log.d("candidate result", String.valueOf(isUpdated));
            }
        }
    };
}
