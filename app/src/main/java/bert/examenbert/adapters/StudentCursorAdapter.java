package bert.examenbert.adapters;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import bert.examenbert.R;
import bert.examenbert.storage.databank.StudentenDB;
import bert.examenbert.storage.databank.StudentenTabel;

/* Created by Bert Goens */
public class StudentCursorAdapter extends CursorAdapter {

    private final LayoutInflater _layoutInflater;
    private Cursor _cursor;
    public StudentCursorAdapter(Context context, Cursor c) {
        super(context, c, CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
        _layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return _layoutInflater.inflate(R.layout.view_record_student, parent, false);
    }

    //componenten uit onze view voorzien van data die we uit onze cursor halen
    //wordt per record opgeroepen
    @Override
    public void bindView(View view, final Context context, Cursor cursor) {
        final TextView tvStudentId = (TextView) view.findViewById(R.id.view_record_student_student_id);
        tvStudentId.setText(cursor.getString(cursor.getColumnIndex(StudentenTabel.student_id)));

        final TextView tvStudentNaam = (TextView) view.findViewById(R.id.view_record_student_student_naam);
        tvStudentNaam.setText(cursor.getString(cursor.getColumnIndex(StudentenTabel.student_naam)));

        final TextView tvStudentVoornaam = (TextView) view.findViewById(R.id.view_record_student_student_voornaam);
        tvStudentVoornaam.setText(cursor.getString(cursor.getColumnIndex(StudentenTabel.student_voornaam)));

        final TextView tvKlasId = (TextView) view.findViewById(R.id.view_record_student_klas_id);
        tvKlasId.setText(cursor.getString(cursor.getColumnIndex(StudentenTabel.klas_id)));

        final ImageButton imgbtnDelete = (ImageButton) view.findViewById(R.id.view_record_student_img_delete);
        imgbtnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StudentenDB studentenDB = new StudentenDB(context);
                int student_id = Integer.parseInt(tvStudentId.getText().toString());
                studentenDB.deleteStudent(student_id);

                _cursor = studentenDB.getAllStudenten();

                //swapCursor omdat er een record verwijdert werdt, de cursor aanpassen
                swapCursor(_cursor);

                //notify dat je de view moet wijzigen
                notifyDataSetChanged();
            }
        });
    }
}
