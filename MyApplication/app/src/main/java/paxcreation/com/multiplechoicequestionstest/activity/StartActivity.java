package paxcreation.com.multiplechoicequestionstest.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import paxcreation.com.multiplechoicequestionstest.R;
import paxcreation.com.multiplechoicequestionstest.entity.Candidate;
import paxcreation.com.multiplechoicequestionstest.global.GlobalObject;

/**
 * Created by Administrator on 16/06/2015.
 */
public class StartActivity extends Activity  {
    private Button btnStart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start);
        TextView txtInfo = (TextView)findViewById(R.id.txtInfo_Test);
        String info;
        Candidate candidate = GlobalObject.getCandidateInstance_Test();
        if(candidate.isAndroidDev())
            info =  "Hi "+ candidate.getName() +
                    "\n Welcome to the Paxcreation entry test \n\n"+
                    "The test consists of 10 multiple-choice and 3 constructed questions. \n\n"
                    +" You have 20 minutes to complete the test. \n\n"
                    + "Press \"Start\"when you are ready.\n\n" +
                    "Good luck!";
        else
            info =  "Hi "+ candidate.getName() +
                    "\n Welcome to the Paxcreation entry test \n\n"+
                    "The test consists of 8 multiple-choice and 2 constructed questions. \n\n"
                    +" You have 20 minutes to complete the test. \n\n"
                    + "Press \"Start\"when you are ready.\n\n" +
                    "Good luck!";
        txtInfo.setText(info);
    }

    @Override
    public void onBackPressed() {
        return;
    }

    public void onClick(View v) {
        Intent intent = new Intent(this, TestActivity.class);
        startActivity(intent);
    }
}
