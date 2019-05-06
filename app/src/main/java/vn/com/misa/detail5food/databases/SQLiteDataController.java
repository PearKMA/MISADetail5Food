package vn.com.misa.detail5food.databases;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import vn.com.misa.detail5food.model.InfomationStore;

public class SQLiteDataController extends SQLiteOpenHelper {
    public static final String DB_NAME ="store_list";
    private static final String TABLE_NAME ="store";
    private static final String ID ="id";
    private static final String NAME_STORE ="name_store";
    private static final String TOTAL_RATE ="total_rate";
    private static final String TOTAL_FEEDBACK ="total_feedback";
    private static final String CATEGORY ="category";
    private static final String SET_OPEN ="set_open";
    private static final String TIME_OPEN ="time_open";
    private static final String ADDRESS ="address";
    private static final String DISTANE ="distane";
    private Context context;

    public SQLiteDataController(Context context){
        super(context,DB_NAME,null,1);
        this.context=context;
    }

    //Add new a InfomationStore
    public void addInfomationStore(InfomationStore infomationStore){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NAME_STORE, infomationStore.getNameStore());
        values.put(TOTAL_RATE, infomationStore.getTotalRate());
        values.put(TOTAL_FEEDBACK, infomationStore.getTotalFeedback());
        values.put(CATEGORY, infomationStore.getCategory());
        values.put(SET_OPEN, infomationStore.getSetOpen());
        values.put(TIME_OPEN, infomationStore.getTimeOpen());
        values.put(ADDRESS, infomationStore.getAddress());
        values.put(DISTANE, infomationStore.getDistance());
        //Neu de null thi khi value bang null thi loi

        db.insert(TABLE_NAME,null,values);

        db.close();
    }

/*
    Select a InfomationStore by ID
     */

    public InfomationStore getInfomationStoreById(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME, new String[] { ID,
                        NAME_STORE, TOTAL_RATE,TOTAL_FEEDBACK,CATEGORY,SET_OPEN,TIME_OPEN,ADDRESS,DISTANE },
                ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        InfomationStore infomationStore = new InfomationStore(
                cursor.getInt(1)
                ,cursor.getString(2)
                ,cursor.getFloat(3)
                ,cursor.getInt(4)
                ,cursor.getString(5)
                ,cursor.getString(6)
                ,cursor.getString(7)
                ,cursor.getString(8)
                ,cursor.getString(9));
        cursor.close();
        db.close();
        return infomationStore;
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlQuery = "CREATE TABLE "+TABLE_NAME +" (" +
                ID +" integer primary key, "+
                NAME_STORE + " TEXT, "+
                TOTAL_RATE +" FLOAT, "+
                TOTAL_FEEDBACK+" INT," +
                CATEGORY+" TEXT," +
                SET_OPEN+" TEXT," +
                TIME_OPEN+" TEXT," +
                ADDRESS+" TEXT," +
                DISTANE +" TEXT)";
        db.execSQL(sqlQuery);
        Toast.makeText(context, "Create successfylly", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }


}
