package example.kagan.helloworld;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SearchReservation extends AppCompatActivity {
    TextView Display_ID,Display_Name,Display_People,Display_Phone,Display_Date,Display_Hour,Display_Desc;
    EditText Search_Name;
    DBHelper dbHelper;
    SQLiteDatabase sqLiteDatabase;
    String search_name;
    String search_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_reservation);
        Search_Name = (EditText)findViewById(R.id.txt_searchname);
        Display_ID = (TextView)findViewById(R.id.lbl_searchid);
        Display_Name = (TextView)findViewById(R.id.lbl_searchname);
        Display_People = (TextView)findViewById(R.id.lbl_searchpeople);
        Display_Phone = (TextView)findViewById(R.id.lbl_searchphone);
        Display_Date = (TextView)findViewById(R.id.lbl_searchdate);
        Display_Hour = (TextView)findViewById(R.id.lbl_searchhour);
        Display_Desc = (TextView)findViewById(R.id.lbl_searchdesc);

        Display_ID.setVisibility(View.GONE);
        Display_Name.setVisibility(View.GONE);
        Display_People.setVisibility(View.GONE);
        Display_Phone.setVisibility(View.GONE);
        Display_Date.setVisibility(View.GONE);
        Display_Hour.setVisibility(View.GONE);
        Display_Desc.setVisibility(View.GONE);
    }

    public void searchReservation(View view)
    {
        search_name = Search_Name.getText().toString();
        dbHelper = new DBHelper(getApplicationContext());
        sqLiteDatabase = dbHelper.getReadableDatabase();
        Cursor cursor = dbHelper.searchReservation(search_name,sqLiteDatabase);
        if(cursor.moveToFirst())
        {
            String ID = cursor.getString(0);
            String NAME = cursor.getString(1);
            String PEOPLE = cursor.getString(2);
            String PHONE = cursor.getString(3);
            String DATE = cursor.getString(4);
            String HOUR = cursor.getString(5);
            String DESC = cursor.getString(6);

            Display_ID.setText(ID);
            Display_Name.setText(NAME);
            Display_People.setText(PEOPLE);
            Display_Phone.setText(PHONE);
            Display_Date.setText(DATE);
            Display_Hour.setText(HOUR);
            Display_Desc.setText(DESC);

            Display_ID.setVisibility(View.VISIBLE);
            Display_Name.setVisibility(View.VISIBLE);
            Display_People.setVisibility(View.VISIBLE);
            Display_Phone.setVisibility(View.VISIBLE);
            Display_Date.setVisibility(View.VISIBLE);
            Display_Hour.setVisibility(View.VISIBLE);
            Display_Desc.setVisibility(View.VISIBLE);
        }

    }

    public void deleteReservation(View view)
    {
        search_id = Display_ID.getText().toString();
        dbHelper = new DBHelper(getApplicationContext());
        sqLiteDatabase = dbHelper.getReadableDatabase();
        dbHelper.deleteReservation(search_id,sqLiteDatabase);
        Toast.makeText(getBaseContext(),"Reservation Deleted",Toast.LENGTH_LONG).show();

    }


}
