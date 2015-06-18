package paxcreation.com.multiplechoicequestionstest.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import paxcreation.com.multiplechoicequestionstest.entity.Candidate;

/**
 * Created by Administrator on 18/06/2015.
 */
public class CandidateDAO {
    public static final String TAG = "CandidateDAO";
    public Context context;


    private static CandidateDAO instance = null;

    public static CandidateDAO getInstance(Context context ) {
        if (instance == null){
            instance = new CandidateDAO(context);
        }
        return instance;
    }

    //    Database fields
    private SQLiteDatabase database;
    private DBHelper dbHelper;

    private String[] allColumns = {
            DBHelper.CANDIDATE_ID,
            DBHelper.CANDIDATE_NAME,
            DBHelper.CANDIDATE_ISANDROIDDEV,
            DBHelper.CANDIDATE_CREATE_AT
            };

    public CandidateDAO(Context context) {
        dbHelper = DBHelper.getInstance(context);
        this.context = context;
    }

    public void open() {
        try {
           database = dbHelper.getWritableDatabase();
        } catch (Exception e) {
            Log.e(TAG, "SQLException on openning database " + e.getMessage());
        }
    }

    public void close() {
        dbHelper.close();
    }

    public long insertCandidate(String name, boolean isAndroidDev, long createdAtInMilliseconds)
    {
        ContentValues values = new ContentValues();
        values.put(DBHelper.CANDIDATE_NAME, name);
        values.put(DBHelper.CANDIDATE_ISANDROIDDEV, (isAndroidDev) ? 1 : 0);
        values.put(DBHelper.CANDIDATE_CREATE_AT, createdAtInMilliseconds);
        return database.insert(DBHelper.TABLE_CANDIDATE, null,values);
//        long insertId = database.insert(DBHelper.TABLE_CANDIDATE, null,values);
//        Cursor cursor = database.query(DBHelper.TABLE_CANDIDATE, allColumns, DBHelper.CANDIDATE_ID + " = " + insertId, null, null, null, null);
//        cursor.moveToFirst();
//        Candidate candidate = cursorToCandidate(cursor);
//        cursor.close();
//        close();
//        return candidate.getId();
    }

    public boolean deleteCandidate(int candidateId)
    {
        int rowEffected = database.delete(DBHelper.TABLE_CANDIDATE, DBHelper.CANDIDATE_ID + " = " + candidateId, null);
//        should delete answers belong to this candidate too. Can do it by CASCADING or manually
        Log.d("row effected", String.valueOf(rowEffected));
        return (rowEffected>0)? true:false;
    }

    public List<Candidate> getAllCandidate()
    {
        open();
        AnswerDAO answerDAO = new AnswerDAO(context);
        List<Candidate> candidates = new ArrayList<Candidate>();
        Cursor cursor = database.query(DBHelper.TABLE_CANDIDATE, allColumns, null,null,null,null,null);
        if(cursor!= null)
        {
            cursor.moveToNext();
            while (!cursor.isAfterLast())
            {
                Candidate candidate = cursorToCandidate(cursor);
                candidate.setAnswers(answerDAO.getAnswersByCID(candidate.getId()));
                candidates.add(candidate);
                cursor.moveToNext();
            }
        }
        cursor.close();
        close();
        return candidates;
    }


    private Candidate cursorToCandidate(Cursor cursor)
    {
        Candidate candidate = new Candidate();
        candidate.setId(cursor.getLong(0));
        candidate.setName(cursor.getString(1));
        candidate.setIsAndroidDev((cursor.getInt(2) == 1) ? true : false);
        candidate.setCreate_at(cursor.getLong(3));
        return candidate;
    }
}
