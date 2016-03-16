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
import bert.examenbert.storage.databank.VakkenTabel;

/* Created by Bert Goens */
public class VakkenCursorAdapter extends CursorAdapter {

    private Cursor _cursor;
    private final LayoutInflater _inflater;

    public VakkenCursorAdapter(Context context, Cursor c) {
        super(context, c, CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
        _inflater = LayoutInflater.from(context);
        _cursor = c;
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return _inflater.inflate(R.layout.view_record_vak, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        final TextView tvVakId = (TextView) view.findViewById(R.id.view_record_vak_vak_id);
        tvVakId.setText(cursor.getString(cursor.getColumnIndex(VakkenTabel.vak_id)));

        final TextView tvVakNaam = (TextView) view.findViewById(R.id.view_record_vak_vak_naam);
        tvVakNaam.setText(cursor.getString(cursor.getColumnIndex(VakkenTabel.vak_naam)));

        final ImageButton imgbtnDelete = (ImageButton) view.findViewById(R.id.view_record_vak_img_delete);
        imgbtnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
            }
        });
    }
}
