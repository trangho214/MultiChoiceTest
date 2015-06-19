package paxcreation.com.multiplechoicequestionstest.activity;

import android.app.Activity;
import android.os.Bundle;

import paxcreation.com.multiplechoicequestionstest.R;
import paxcreation.com.multiplechoicequestionstest.fragment.ResultFragment;

/**
 * Created by Administrator on 19/06/2015.
 */
public class ResultActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acticity_result);
        int index = getIntent().getExtras().getInt("index");
        ResultFragment resultFragment = ResultFragment.newInstance(index);
        getFragmentManager().beginTransaction().replace(R.id.frResult, resultFragment).commit();
    }

}
