package paxcreation.com.multiplechoicequestionstest.fragment;


import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

import paxcreation.com.multiplechoicequestionstest.R;
import paxcreation.com.multiplechoicequestionstest.activity.ResultActivity;
import paxcreation.com.multiplechoicequestionstest.adapter.CandidateAdapter;
import paxcreation.com.multiplechoicequestionstest.database.CandidateDAO;
import paxcreation.com.multiplechoicequestionstest.entity.Candidate;
import paxcreation.com.multiplechoicequestionstest.global.GlobalObject;

/**
 * A simple {@link Fragment} subclass.
 */
public class CandidateListFragment extends Fragment {
    private static final String CURRENTCHOICE = "CurrentChoice";

    ListView lvCandidate;
    List<Candidate> candidates;
    CandidateAdapter adapter;

    boolean dualPane;
    int currentCheckPosition = 0;

    public CandidateListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_candidate_list, container, false);
        init(v, savedInstanceState);
        return v;
    }

    private void init(View v, Bundle savedInstanceState)
    {
        candidates = GlobalObject.getCandidatesInstance();
        lvCandidate = (ListView)v.findViewById(R.id.lvCandidate_CandidateFragment);
        async.execute();
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//        FrameLayout can first find onActivityCreated not onCreateView
        View resultFrame =getActivity().findViewById(R.id.frResult);
        dualPane = resultFrame!=null && resultFrame.getVisibility() == View.VISIBLE;
        if(dualPane)
        {
            lvCandidate.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
            showDetails(currentCheckPosition);
        }
        if(savedInstanceState!= null)
        {
            currentCheckPosition = savedInstanceState.getInt(CURRENTCHOICE);
        }

        lvCandidate.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                showDetails(position);
            }
        });
    }

    private void showDetails(int index)
    {
        currentCheckPosition = index;

        if(dualPane)
        {
            lvCandidate.setItemChecked(index, true);

            ResultFragment resultFragment = (ResultFragment)getFragmentManager().findFragmentById(R.id.frResult);
            if(resultFragment ==null || resultFragment.getShownIndex()!= index)
            {
                resultFragment = ResultFragment.newInstance(index);

                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.frResult, resultFragment);
                transaction.commit();
            }

        }
        else
        {
            Intent intent = new Intent(getActivity(), ResultActivity.class);
            intent.putExtra("index",index);
            startActivity(intent);
        }
    }

    //configuration/orientation change
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(CURRENTCHOICE, currentCheckPosition);
    }

    AsyncTask<Void, Void, List<Candidate>> async = new AsyncTask<Void, Void, List<Candidate>>() {
        @Override
        protected List<Candidate> doInBackground(Void... params) {
            CandidateDAO candidateDao = CandidateDAO.getInstance(getActivity());
            candidateDao.open();
            candidates= candidateDao.getAllCandidate();
            GlobalObject.setCandidates(candidates);
            Log.d("candidate size", String.valueOf(candidates.size()));
            candidateDao.close();
            return candidates;
        }

        @Override
        protected void onPostExecute(final List<Candidate> candidates) {
            super.onPostExecute(candidates);
            adapter = new CandidateAdapter(getActivity(),candidates);
            lvCandidate.setAdapter(adapter);

//            TODO: change the current candidate

        }
    };


}
