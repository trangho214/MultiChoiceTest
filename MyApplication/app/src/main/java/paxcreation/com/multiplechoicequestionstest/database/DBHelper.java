package paxcreation.com.multiplechoicequestionstest.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Administrator on 18/06/2015.
 */
public class DBHelper extends SQLiteOpenHelper{



    private  static  DBHelper instance = null;

    public static DBHelper getInstance(Context context) {
        if (instance == null){
            instance = new DBHelper(context);
        }
        return instance;
    }

    public static final String TAG = "DBHelper";

    //    Columns of the candidate table
    public static final String TABLE_CANDIDATE = "candidate";
    public static final String CANDIDATE_ID = "candidate_id";
    public static final String CANDIDATE_NAME = "name";
    public static final String CANDIDATE_ISANDROIDDEV = "candidate";
    public static final String CANDIDATE_CREATE_AT = "created_at";


    //    Columns of answer
    public static final String TABLE_ANSWER = "answer";
    public static final String ANSWER_ID = "answer_id";
    public static final String ANSWER_C_ID = "candidate_id";
    public static final String ANSWER_Q_ID = "question_id";
    public static final String ANSWER_MULTI_ANSWER = "multichoice_answer";
    public static final String ANSWER_CONSTRUCTED_ANSWER = "constructed_answer";
    public static final String ANSWER_POINT = "point";


    private static final String DATABASE_NAME = "MultiChoiceTest.db";
    private static final int DATABASE_VERSION = 1;


    private static final String SQL_CREATE_TABLE_CANDIDATE = "CREATE TABLE " + TABLE_CANDIDATE +" ( "
            + CANDIDATE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + CANDIDATE_NAME + " TEXT NOT NULL, "
            + CANDIDATE_ISANDROIDDEV + " INTEGER NOT NULL, "
            + CANDIDATE_CREATE_AT + " INTEGER "
            + ");";

    private static final String SQL_CREATE_TABLE_ANSWER = "CREATE TABLE "+ TABLE_ANSWER + " ( "
            + ANSWER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + ANSWER_C_ID + " INTEGER NOT NULL, "
            + ANSWER_Q_ID + " INTEGER NOT NULL, "
            + ANSWER_MULTI_ANSWER + " INTEGER, "
            + ANSWER_CONSTRUCTED_ANSWER + " TEXT, "
            + ANSWER_POINT + " REAL "
            +" );";


    public DBHelper(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_TABLE_CANDIDATE);
        db.execSQL(SQL_CREATE_TABLE_ANSWER);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(TAG, "Upgrading the database from version " + oldVersion + " to " + newVersion);

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ANSWER);
        db.execSQL("DROP TABLE IF EXIST " + TABLE_CANDIDATE);

        onCreate(db);
    }
}
