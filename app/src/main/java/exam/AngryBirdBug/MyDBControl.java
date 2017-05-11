package exam.AngryBirdBug;

import MyEngine.myLog;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MyDBControl
{
    private static final String DB_NAME = "test.db";
    private static final String DB_TABLE = "test";
    private static final int DB_VERSION = 1;
    private SQLiteDatabase db;

    public MyDBControl(Context paramContext)
    {
        this.db = new MyDBHelper(paramContext).getWritableDatabase();
    }

    private String readDB()
            throws Exception
    {
        Cursor localCursor = this.db.query("test", new String[] { "Date", "Score", "Level" }, null, null, null, null, "LENGTH(Score) DESC, Score DESC");
        if (localCursor.getCount() == 0) {
            throw new Exception();
        }
        localCursor.moveToFirst();
        String str1 = "";
        int i = 0;
        for (;;)
        {
            if (i >= localCursor.getCount())
            {
                localCursor.close();
                return str1;
            }
            String str2 = localCursor.getString(0);
            String str3 = localCursor.getString(1);
            String str4 = localCursor.getString(2);
            Log.e("readDB", str2 + " " + str3 + " " + str4);
            str1 = str1 + str2 + " " + str3 + " " + str4 + " ";
            localCursor.moveToNext();
            i += 1;
        }
    }

    private void writeDB(String paramString1, String paramString2, String paramString3)
            throws Exception
    {
        ContentValues localContentValues = new ContentValues();
        localContentValues.put("Date", paramString1);
        localContentValues.put("Score", paramString2);
        localContentValues.put("Level", paramString3);
        this.db.insert("test", null, localContentValues);
    }

    public String _openData()
    {
        try
        {
            String str = readDB();
            return str;
        }
        catch (Exception localException)
        {
            localException.printStackTrace();
        }
        return null;
    }

    public void _saveData(String paramString, int paramInt1, int paramInt2)
    {
        try
        {
            writeDB(paramString, String.valueOf(paramInt1), String.valueOf(paramInt2));
            return;
        }
        catch (Exception e)
        {
            myLog.e("_saveData Error");
            e.printStackTrace();
        }
    }

    private static class MyDBHelper
            extends SQLiteOpenHelper
    {
        public MyDBHelper(Context context) {
            super(context, "test.db", null, 1);
        }
        //        public MyDBHelper(Context paramContext)
//        {
//            super("test.db", null, 1);
//        }

        public void onCreate(SQLiteDatabase paramSQLiteDatabase)
        {
            paramSQLiteDatabase.execSQL("create table if not exists test(Date text ,Score text, Level text)");
        }

        public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
        {
            Log.e("onUpgrade", "test");
            paramSQLiteDatabase.execSQL("drop table if exists test");
            onCreate(paramSQLiteDatabase);
        }
    }
}
