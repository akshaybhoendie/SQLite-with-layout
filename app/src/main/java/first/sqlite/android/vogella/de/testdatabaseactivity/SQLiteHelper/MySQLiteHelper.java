package first.sqlite.android.vogella.de.testdatabaseactivity.SQLiteHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by abhoendie on 2/16/2017.
 */

public class MySQLiteHelper extends SQLiteOpenHelper{

    public static final String TABLE_COMMENTS = "comments";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_COMMENT = "comment";

    public static final String DATABASE_NAME = "comments.db";
    public static final int DATABASE_VERSION = 1;

    // Database creation sql Statement
    private static final String DATABASE_CREATE = "create table " + TABLE_COMMENTS
                                                                 + "( "
                                                                 + COLUMN_ID
                                                                 + " integer primary key autoincrement, "
                                                                 + COLUMN_COMMENT
                                                                 + " text not null);";

    public MySQLiteHelper (Context context){
        super(context, DATABASE_NAME, null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(MySQLiteHelper.class.getName(),
                    "Upgrading database from version " + oldVersion + " to " + newVersion + ", Which will destroy all old data");

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_COMMENTS);
        onCreate(db);

    }
}
