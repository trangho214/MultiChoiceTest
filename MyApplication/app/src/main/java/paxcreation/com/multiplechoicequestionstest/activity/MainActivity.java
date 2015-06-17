package paxcreation.com.multiplechoicequestionstest.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import paxcreation.com.multiplechoicequestionstest.R;
import paxcreation.com.multiplechoicequestionstest.entity.Candidate;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText edNameMain;
    private Spinner spSubjectMain;
    private Spinner spRoleMain;
    private Button btnOkMain;
    private ArrayAdapter<String> subjectAdapter, roleAdapter;

    private String role, subject;
    private Candidate candidate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
    }

    /**
     * Find the Views in the layout<br />
     * <br />
     * Auto-created on 2015-06-16 10:35:29 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */
    private void findViews() {

        edNameMain = (EditText)findViewById( R.id.edName_Main );
        spSubjectMain = (Spinner)findViewById( R.id.spSubject_Main );
        spRoleMain = (Spinner)findViewById( R.id.spRole_Main );
        btnOkMain = (Button)findViewById( R.id.btnOk_Main );
        candidate = Candidate.getInstance();

        subjectAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, getResources().getStringArray(R.array.subjects));
        spSubjectMain.setAdapter(subjectAdapter);

        roleAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, getResources().getStringArray(R.array.role));
        spRoleMain.setAdapter(roleAdapter);

        btnOkMain.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        candidate.setName(edNameMain.getText().toString());
        subject = spSubjectMain.getSelectedItem().toString();
        role = spRoleMain.getSelectedItem().toString();
        if(subject.equals(getResources().getString(R.string.android)))
            candidate.setIsAndroidDev(true);
        else candidate.setIsAndroidDev(false);

        if ( v == btnOkMain ) {
           if (role.equals(getString(R.string.dev)))
           {
               Intent intent = new Intent(MainActivity.this, StartActivity.class);
               startActivity(intent);
           }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
