package paxcreation.com.multiplechoicequestionstest.fragment;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import paxcreation.com.multiplechoicequestionstest.R;
import paxcreation.com.multiplechoicequestionstest.activity.MainActivity;
import paxcreation.com.multiplechoicequestionstest.activity.ResultActivity;
import paxcreation.com.multiplechoicequestionstest.adapter.CandidateAdapter;
import paxcreation.com.multiplechoicequestionstest.database.CandidateDAO;
import paxcreation.com.multiplechoicequestionstest.entity.Candidate;
import paxcreation.com.multiplechoicequestionstest.global.GlobalObject;
import paxcreation.com.multiplechoicequestionstest.interfaces.IDialog;
import paxcreation.com.multiplechoicequestionstest.utils.Util;

/**
 * A simple {@link Fragment} subclass.
 */
public class CandidateListFragment extends Fragment{
    private static final String CURRENTCHOICE = "CurrentChoice";

    ListView lvCandidate;
    List<Candidate> candidateList;
    CandidateAdapter adapter;
    View v;
    boolean dualPane;
    boolean isFirstTime = true;
    int currentCheckPosition = 0;

    public CandidateListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v= inflater.inflate(R.layout.fragment_candidate_list, container, false);
        init(v, savedInstanceState);
        return v;
    }

    private void init(View v, Bundle savedInstanceState)
    {
        candidateList = GlobalObject.getCandidatesInstance();
        lvCandidate = (ListView)v.findViewById(R.id.lvCandidate_CandidateFragment);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
//        FrameLayout can first find from onActivityCreated not onCreateView
        View resultFrame = getActivity().findViewById(R.id.frResult);
        dualPane = resultFrame != null && resultFrame.getVisibility() == View.VISIBLE;
        if (dualPane) {
            lvCandidate.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
            Log.d("Candidate lshow", "Show detail");
            showDetails(currentCheckPosition);
            if (savedInstanceState != null) {
                currentCheckPosition = savedInstanceState.getInt(CURRENTCHOICE);
            }

            lvCandidate.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    view.setBackgroundColor(Color.BLUE);
                    showDetails(position);
                }
            });
            lvCandidate.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                @Override
                public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                    final int copyPosition = position;
                    Util.showConfirmationDialog(
                            getActivity(),
                            "Confirmation",
                            "Are you sure you that you want delete " + candidateList.get(position).getName(),
                            true,
                            "Yes",
                            "No",
                            new IDialog() {
                                @Override
                                public void dimissDialog(boolean isPositive) {
                                    if(isPositive)
                                    {
                                        Candidate candidate = adapter.getItem(copyPosition);
                                        deleteCandidate(candidate.getId());
                                    }
                                    else
                                        return;
                                }
                            });
                    return true;
                }
            });
        }
    }

    private void showDetails(int index)
    {
        if( candidateList.size()== 0)
            getAllCandidate();
        else
        {
            if(isFirstTime)
                getAllCandidate();
            else {
                currentCheckPosition = index;
                if(dualPane)
                {
                    if(adapter == null || adapter.getCount()==0)
                    {
                        adapter = new CandidateAdapter(getActivity(),candidateList);
                    }
                    lvCandidate.setAdapter(adapter);
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

        }
    }

    //configuration/orientation change
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(CURRENTCHOICE, currentCheckPosition);
    }

    private void deleteCandidate(final long candidateId){
        AsyncTask<Void, Void, List<Candidate>> async = new AsyncTask<Void, Void, List<Candidate>>() {
            @Override
            protected List<Candidate> doInBackground(Void... params) {
                CandidateDAO candidateDao = CandidateDAO.getInstance(getActivity());
                candidateDao.open();
                List<Candidate> candidates;
                candidates = candidateDao.deleteCandidate(candidateId);
                candidateDao.close();
                return candidates;
            }

            @Override
            protected void onPostExecute(final List<Candidate> candidates) {
                super.onPostExecute(candidates);
                adapter.clearData();
                adapter.addData(candidates);
                GlobalObject.setCandidates(candidates);
                adapter.notifyDataSetChanged();
                if(dualPane)
                    showDetails(currentCheckPosition);
//            TODO: change the current candidate
            }
        };
        async.execute();
    }

    private void getAllCandidate()
    {
        AsyncTask<Void, Void, List<Candidate>> async = new AsyncTask<Void, Void, List<Candidate>>() {
            @Override
            protected List<Candidate> doInBackground(Void... params) {
                CandidateDAO candidateDao = CandidateDAO.getInstance(getActivity());
                candidateDao.open();
                List<Candidate> candidates;
                candidates = candidateDao.getAllCandidate();
                candidateDao.close();
                return candidates;
            }

            @Override
            protected void onPostExecute(final List<Candidate> candidates) {
                if(candidates.size()!= 0) {
                    Log.d("candidate load", "Load all candidate");
                    super.onPostExecute(candidates);
                    isFirstTime = false;
                    candidateList = candidates;
                    GlobalObject.setCandidates(candidates);
                    adapter = new CandidateAdapter(getActivity(), candidateList);
                    lvCandidate.setAdapter(adapter);
                    if (dualPane)
                        showDetails(currentCheckPosition);
//            TODO: change the current candidate
                }
                else
                    Toast.makeText(getActivity(), "No Candidate", Toast.LENGTH_LONG).show();
            }
        };
        async.execute();
    }
}
