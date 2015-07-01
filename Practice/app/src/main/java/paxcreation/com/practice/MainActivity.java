package paxcreation.com.practice;

import android.annotation.TargetApi;
import android.os.Build;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Slide;
import android.transition.TransitionManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ViewGroup viewGroup;
    private View vOrange, vGreen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewGroup = (ViewGroup)findViewById(R.id.llo);
        viewGroup.setOnClickListener(this);
        vOrange = (View)findViewById(R.id.vOrange);
        vGreen = (View)findViewById(R.id.vGreen);


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

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onClick(View v) {
        TransitionManager.beginDelayedTransition(viewGroup,new Explode());
        toggle(vOrange, vGreen);
    }

    private void toggle(View...views)
    {
        for (View view : views)
        {
            boolean isVisible = view.getVisibility() == View.VISIBLE;
            view.setVisibility(isVisible? View.INVISIBLE : View.VISIBLE);
        }
    }
}
