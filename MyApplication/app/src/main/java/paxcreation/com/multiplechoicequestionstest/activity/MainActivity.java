package paxcreation.com.multiplechoicequestionstest.activity;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import paxcreation.com.multiplechoicequestionstest.R;
import paxcreation.com.multiplechoicequestionstest.database.CandidateDAO;
import paxcreation.com.multiplechoicequestionstest.entity.Candidate;
import paxcreation.com.multiplechoicequestionstest.global.GlobalObject;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText edNameMain;
    private Spinner spSubjectMain;
    private Spinner spRoleMain;
    private Button btnOkMain;
    private ArrayAdapter<String> subjectAdapter, roleAdapter;

    private String position, subject;
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
        View v = findViewById(R.id.lloMainActivity);
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!(v instanceof EditText))
                    hideKeyboard();
            }
        });
        edNameMain = (EditText)findViewById( R.id.edName_Main );

        spSubjectMain = (Spinner)findViewById( R.id.spSubject_Main );
        spRoleMain = (Spinner)findViewById( R.id.spRole_Main );
        btnOkMain = (Button)findViewById( R.id.btnOk_Main );
        candidate = GlobalObject.getCandidateInstance_Test();

        subjectAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, getResources().getStringArray(R.array.subjects));
        spSubjectMain.setAdapter(subjectAdapter);

        roleAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, getResources().getStringArray(R.array.role));
        spRoleMain.setAdapter(roleAdapter);

        btnOkMain.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Toast toast;
        String name =edNameMain.getText().toString().trim();
        if(isEmpty(name))
        {
            toast = Toast.makeText(MainActivity.this, "Please enter name", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER,0,0);
            toast.show();
        }
        else
        {
            candidate.setName(name);
            subject = spSubjectMain.getSelectedItem().toString();
            boolean isAndroidDev = (subject.equals(getString(R.string.android)))? true:false;
            position = spRoleMain.getSelectedItem().toString();
            candidate.setIsAndroidDev(isAndroidDev);
            if ( v == btnOkMain ) {
                if (position.equals(getString(R.string.dev)) || position.equals(getString(R.string.intern)))
                {
                    if(name.toLowerCase().equals("admin"))
                    {
                        toast = Toast.makeText(MainActivity.this, "You are not admin", Toast.LENGTH_LONG);
                        toast.setGravity(Gravity.CENTER,0,0);
                        toast.show();
                    }
                    else
                    {
                        addNewCandidate();
                        Intent intent = new Intent(MainActivity.this, StartActivity.class);
                        intent.putExtra("position", position);
                        startActivity(intent);
                    }
                }
                else
                {
                    if(name.equals("admin")) {
                        Intent intent = new Intent(MainActivity.this, AdminActivity.class);
                        startActivity(intent);
                    }
                    else {
                        toast = Toast.makeText(MainActivity.this, "You are not admin", Toast.LENGTH_LONG);
                        toast.setGravity(Gravity.CENTER, 0, 0);
                        toast.show();
                    }
                }
            }
        }
    }

    private void hideKeyboard() {
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(edNameMain.getWindowToken(), 0);
    }

    private boolean isEmpty(String name)
    {
        return (name.equals("")|| name.length()==0);
    }

       private void addNewCandidate (){
        AsyncTask<Candidate, Void, Boolean> asyncTask = new AsyncTask<Candidate, Void, Boolean>() {
        @Override
        protected Boolean doInBackground(Candidate... params) {
            CandidateDAO candidateDAO = CandidateDAO.getInstance(MainActivity.this.getApplicationContext());
            candidateDAO.open();
            long id = candidateDAO.insertCandidate(candidate.getName(), candidate.isAndroidDev(), System.currentTimeMillis());
            if(id != -1) {
                candidate.setId(id);
                candidateDAO.close();
                return true;
            }
            candidateDAO.close();
            return false;
        }
    };
        asyncTask.execute();
    }
}
