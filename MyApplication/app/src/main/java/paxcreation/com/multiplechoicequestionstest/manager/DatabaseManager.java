package paxcreation.com.multiplechoicequestionstest.manager;

import android.database.Cursor;
import android.os.AsyncTask;

import java.util.Objects;

/**
 * Created by Administrator on 18/06/2015.
 */
public abstract class DatabaseManager extends AsyncTask<Object, Object, Cursor> {
    @Override
    protected Cursor doInBackground(Object... params) {
        return doBackGround(params);
    }

    @Override
    protected void onPostExecute(Cursor cursor) {
        doPost(cursor);
    }

    public abstract Cursor doBackGround(Object... params);
    public abstract void doPost(Cursor cursor);

}
