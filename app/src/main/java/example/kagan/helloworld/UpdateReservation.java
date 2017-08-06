package example.kagan.helloworld;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class UpdateReservation extends AppCompatActivity {

    TextView Display_ID;
    EditText Search_Name,Display_Name,Display_People,Display_Phone,Display_Date,Display_Hour,Display_Desc;
    DBHelper dbHelper;
    Button update;
    SQLiteDatabase sqLiteDatabase;
    String search_name;
    String search_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_reservation);
        Search_Name = (EditText)findViewById(R.id.txt_serachuppayment);
        Display_ID = (TextView)findViewById(R.id.lbl_searchupid);
        Display_Name = (EditText)findViewById(R.id.txt_updatepayname);
        Display_People = (EditText)findViewById(R.id.txt_updatepayvalue);
        Display_Phone = (EditText)findViewById(R.id.txt_updatepayphone);
        Display_Date = (EditText)findViewById(R.id.txt_updatepaydate);
        Display_Hour = (EditText)findViewById(R.id.txt_updatepaytype);
        Display_Desc = (EditText)findViewById(R.id.txt_updatedesc);
        update = (Button)findViewById(R.id.btn_update);

        Display_ID.setVisibility(View.GONE);
        Display_Name.setVisibility(View.GONE);
        Display_People.setVisibility(View.GONE);
        Display_Phone.setVisibility(View.GONE);
        Display_Date.setVisibility(View.GONE);
        Display_Hour.setVisibility(View.GONE);
        Display_Desc.setVisibility(View.GONE);
        update.setVisibility(View.GONE);
    }

    public void searchupReservation(View view)
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
            update.setVisibility(View.VISIBLE);
        }
    }

    public void updateReservation (View view)
    {
        dbHelper = new DBHelper(getApplicationContext());
        sqLiteDatabase = dbHelper.getWritableDatabase();
        String upname,uppeople,upphone,update,uphour,updesc;

        upname =Display_Name.getText().toString();
        uppeople =Display_People.getText().toString();
        upphone =Display_Phone.getText().toString();
        update =Display_Date.getText().toString();
        uphour =Display_Hour.getText().toString();
        updesc =Display_Desc.getText().toString();
        int count =dbHelper.updateupReservation(search_name,upname,uppeople,upphone,update,uphour,updesc,sqLiteDatabase);
        Toast.makeText(getApplicationContext(),count+"Updated",Toast.LENGTH_LONG).show();
        finish();

    }
}
