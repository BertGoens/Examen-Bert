package bert.examenbert.storage.databank;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import bert.examenbert.storage.dao.StudentDAO;

/* Created by Bert Goens */
public class StudentenDB extends MyDatabaseHelper {

    public StudentenDB(Context context) {
        super(context);
    }

    //region CRUD operaties
    //Create
    public long addStudent(StudentDAO student) {
        ContentValues contentValues = new ContentValues();

        //student_id wordt gegenereerd
        contentValues.put(StudentenTabel.student_naam, student.getStudent_naam());
        contentValues.put(StudentenTabel.student_voornaam, student.getStudent_voornaam());
        contentValues.put(StudentenTabel.klas_id, student.getKlas_id());

        SQLiteDatabase database = getWritableDatabase();

        return database.insert(StudentenTabel.TABEL_NAAM, StudentenTabel.student_id, contentValues);
    }

    //Read (all)
    public Cursor getAllStudenten() {
        SQLiteDatabase database = getWritableDatabase();
        return database.rawQuery("SELECT * FROM " + StudentenTabel.TABEL_NAAM, null);
    }

    //Read (1)
    public Cursor getStudent(int student_id) {
        SQLiteDatabase database = getWritableDatabase();
        String qry = "SELECT * FROM " + StudentenTabel.TABEL_NAAM + " WHERE "
                + StudentenTabel.student_id + " = " + student_id;
        return database.rawQuery(qry, null);
    }

    //Update
    public int updateStudent(StudentDAO student) {
        SQLiteDatabase database = getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        //student_id niet veranderen (pk)
        contentValues.put(StudentenTabel.student_naam, student.getStudent_naam());
        contentValues.put(StudentenTabel.student_voornaam, student.getStudent_voornaam());
        contentValues.put(StudentenTabel.klas_id, student.getKlas_id());

        String qryWhere = StudentenTabel.student_id + " = " + student.getStudent_id();

        return database.update(StudentenTabel.TABEL_NAAM, contentValues, qryWhere, null);
    }

    //Delete
    public int deleteStudent(StudentDAO student) {
        return deleteStudent(student.getStudent_id());
    }

    //Delete
    public int deleteStudent(int student_id) {
        SQLiteDatabase database = getWritableDatabase();

        String[] deleteParams = new String[]{String.valueOf(student_id)};

        String qryWhere = StudentenTabel.klas_id + " =? ";

        return database.delete(StudentenTabel.TABEL_NAAM, qryWhere, deleteParams);
    }
    //endregion

    //Verdere specifieke queries
}
