package paxcreation.com.multiplechoicequestionstest.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import paxcreation.com.multiplechoicequestionstest.entity.Answer;

/**
 * Created by Administrator on 18/06/2015.
 */
public class AnswerDAO {
    public final static String TAG = "ANswerDAO";
    public Context context;

    private SQLiteDatabase database;
    private DBHelper dbHelper;
    private String[] allColumns = {
            DBHelper.ANSWER_ID,
            DBHelper.ANSWER_C_ID,
            DBHelper.ANSWER_Q_ID,
            DBHelper.ANSWER_MULTI_ANSWER,
            DBHelper.ANSWER_CONSTRUCTED_ANSWER,
            DBHelper.ANSWER_POINT};

    private static AnswerDAO instance = null;

    public static AnswerDAO getInstance(Context context) {
        if(instance == null)
        {
            instance = new AnswerDAO(context);
        }
        return instance;
    }

    public AnswerDAO(Context context)
    {
        dbHelper = new DBHelper(context);
        this.context = context;
    }

    public void open()
    {
        try {
            database = dbHelper.getWritableDatabase();
        }
        catch (Exception e)
        {
            Log.e(TAG, "SQLException on openning database " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void close()
    {
        dbHelper.close();
    }

    public boolean insertAnswer(long candidateId, int questionId, int multiChoiceAnswer, String constructedAnswer, float point)
    {
        ContentValues values = new ContentValues();
        values.put(DBHelper.ANSWER_C_ID, candidateId);
        values.put(DBHelper.ANSWER_Q_ID, questionId);
        values.put(DBHelper.ANSWER_MULTI_ANSWER, multiChoiceAnswer);
        values.put(DBHelper.ANSWER_CONSTRUCTED_ANSWER, constructedAnswer);
        values.put(DBHelper.ANSWER_POINT, point);
        long insertId = database.insert(DBHelper.TABLE_ANSWER, null, values);
        return (insertId >=0)? true: false;
    }

    public boolean updateAnswer(long answerId,float point)
    {
        ContentValues values = new ContentValues();
        values.put(DBHelper.ANSWER_POINT, point);
        int rowEffected =database.update(DBHelper.TABLE_ANSWER, values, DBHelper.ANSWER_ID + " = " + answerId, null);
        return (rowEffected>0)? true : false;
    }


    public List<Answer>  getAnswersByCID(long candidateId)
    {
        List<Answer> answers = new ArrayList<Answer>();
        Cursor cursor = database.query(DBHelper.TABLE_ANSWER, allColumns, DBHelper.ANSWER_C_ID + " = "+ candidateId, null,null,null,null);
        if(cursor!=null)
        {
            cursor.moveToFirst();
            while (!cursor.isAfterLast())
            {
                answers.add(cursorToAnswer(cursor));
                cursor.moveToNext();
            }
        }
        cursor.close();
        return answers;

    }

    public int deleteAnswerByCandidate(long candidateId)
    {
        open();
        int rowEffect = database.delete(DBHelper.TABLE_ANSWER, DBHelper.ANSWER_C_ID + " = " + candidateId, null);
        close();
        return rowEffect;

    }

    private Answer cursorToAnswer(Cursor cursor)
    {
        Answer answer = new Answer();
        answer.setAnswerId(cursor.getInt(0));
        answer.setCandidateId(cursor.getInt(1));
        answer.setQuestionId(cursor.getInt(2));
        answer.setMultiChoiceAnswer(cursor.getInt(3));
        answer.setConstructedAnswer(cursor.getString(4));
        answer.setPoint(cursor.getFloat(5));
        return answer;
    }


    public void insertAnswer(long candidateId, int questionId, int multiChoiceAnswer, String constructedAnswer) {
        ContentValues values = new ContentValues();
        values.put(DBHelper.ANSWER_C_ID, candidateId);
        values.put(DBHelper.ANSWER_Q_ID, questionId);
        values.put(DBHelper.ANSWER_MULTI_ANSWER, multiChoiceAnswer);
        values.put(DBHelper.ANSWER_CONSTRUCTED_ANSWER, constructedAnswer);
        database.insert(DBHelper.TABLE_ANSWER, null, values);

    }
}
