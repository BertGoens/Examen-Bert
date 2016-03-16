package bert.examenbert.storage.databank;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import bert.examenbert.storage.dao.VakDAO;

/* Created by Bert Goens */
public class VakkenDB extends MyDatabaseHelper {

    public VakkenDB(Context context) {
        super(context);
    }

    //region CRUD operaties
    //create
    public long addVak(VakDAO vak) {
        ContentValues contentValues = new ContentValues();

        //vak_id wordt gegenereerd
        contentValues.put(VakkenTabel.vak_naam, vak.getVak_naam());

        SQLiteDatabase database = getWritableDatabase();

        return database.insert(VakkenTabel.TABEL_NAAM, VakkenTabel.vak_id, contentValues);
    }

    //read (all)
    public Cursor getAllVakken() {
        SQLiteDatabase database = getWritableDatabase();
        return database.rawQuery("SELECT * FROM " + VakkenTabel.TABEL_NAAM, null);
    }

    //read (1)
    public Cursor getVak(int vak_id) {
        SQLiteDatabase database = getWritableDatabase();
        String qry = "SELECT * FROM " + VakkenTabel.TABEL_NAAM + " WHERE "
                + VakkenTabel.vak_id + " = " + vak_id;
        return database.rawQuery(qry, null);
    }

    //update
    public int updateVak(VakDAO vak) {
        SQLiteDatabase database = getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        //vak_id niet veranderen (pk)
        contentValues.put(VakkenTabel.vak_naam, vak.getVak_naam());

        String qryWhere = VakkenTabel.vak_id + " = " + vak.getVak_id();

        return database.update(VakkenTabel.TABEL_NAAM, contentValues, qryWhere, null);
    }

    //delete
    public int deleteVak(VakDAO vak) {
        return deleteVak(vak.getVak_id());
    }

    //delete
    public int deleteVak(int vak_id) {
        SQLiteDatabase database = getWritableDatabase();

        String[] deleteParams = new String[]{String.valueOf(vak_id)};

        String qryWhere = VakkenTabel.vak_id + " =? ";

        return database.delete(VakkenTabel.TABEL_NAAM, qryWhere, deleteParams);
    }
}
