package example.kagan.helloworld;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

public class ShowReservations extends AppCompatActivity {
    ListView listView;
    SQLiteDatabase sqLiteDatabase;
    DBHelper dbHelper;
    Cursor cursor;
    LDAReservations listDataAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_servations);
        listView = (ListView) findViewById(R.id.lv_reservations);
        listDataAdapter = new LDAReservations(getApplicationContext(),R.layout.reservations_layout);
        listView.setAdapter(listDataAdapter);
        dbHelper = new DBHelper(getApplicationContext());
        sqLiteDatabase = dbHelper.getReadableDatabase();
        cursor = dbHelper.getReservationInfo(sqLiteDatabase);

        if(cursor.moveToFirst())
        {
            do {

                String name,people,phone,date,hour;
                name = cursor.getString(0);
                people = cursor.getString(1);
                phone = cursor.getString(2);
                date = cursor.getString(3);
                hour = cursor.getString(4);
                DPReservation dpReservations = new DPReservation(name,people,phone,date,hour);
                listDataAdapter.add(dpReservations);

            }while (cursor.moveToNext());
        }

    }
}
