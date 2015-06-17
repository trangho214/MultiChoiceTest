package paxcreation.com.multiplechoicequestionstest.fragment;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import paxcreation.com.multiplechoicequestionstest.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CandidateListFragment extends Fragment {


    public CandidateListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_candidate_list, container, false);
    }


}
