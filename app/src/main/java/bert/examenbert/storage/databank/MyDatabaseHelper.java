package bert.examenbert.storage.databank;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* Created by Bert Goens */
public class MyDatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "BertGoensDB";

    private static final int DATABASE_VERSION = 1;

    public MyDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Create elke tabel
        //studenten
        db.execSQL("CREATE TABLE " + StudentenTabel.TABEL_NAAM
                        + " (" + StudentenTabel.student_id + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                        + StudentenTabel.student_naam + " TEXT, "
                        + StudentenTabel.student_voornaam + " TEXT, "
                        + StudentenTabel.klas_id + "INTEGER);"
        );
        //vakken
        db.execSQL("CREATE TABLE " + VakkenTabel.TABEL_NAAM
                        + " (" + VakkenTabel.vak_id + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                        + VakkenTabel.vak_naam + " TEXT);"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ StudentenTabel.TABEL_NAAM);
        db.execSQL("DROP TABLE IF EXISTS "+ VakkenTabel.TABEL_NAAM);

        onCreate(db);
    }
}
