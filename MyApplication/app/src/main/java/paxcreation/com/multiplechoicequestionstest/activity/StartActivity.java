package paxcreation.com.multiplechoicequestionstest.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import paxcreation.com.multiplechoicequestionstest.R;
import paxcreation.com.multiplechoicequestionstest.entity.Candidate;

/**
 * Created by Administrator on 16/06/2015.
 */
public class StartActivity extends Activity  {
    private Button btnStart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start);

    }

    public void onClick(View v) {
        Intent intent = new Intent(this, TestActivity.class);
        startActivity(intent);
    }
}
