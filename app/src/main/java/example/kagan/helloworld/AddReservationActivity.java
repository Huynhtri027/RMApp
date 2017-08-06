package example.kagan.helloworld;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AddReservationActivity extends AppCompatActivity {

    EditText ReservationName, ReservationPhone, ReservationDate, ReservationHour, ReservationDesc;

    Context context = this;
    DBHelper reservationDbHelper;
    SQLiteDatabase sqLiteDatabase;

    Button incpeople;
    Button decpeople;
    Button incten;
    TextView peopleno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_reservation);

        incpeople = (Button) findViewById(R.id.btn_incpeople);
        decpeople = (Button) findViewById(R.id.btn_decpeople);
        incten = (Button) findViewById(R.id.btn_incten);
        peopleno = (TextView) findViewById(R.id.lbl_peoplecount);
        ReservationName = (EditText) findViewById(R.id.txt_rezervname);
        ReservationPhone = (EditText) findViewById(R.id.txt_phone);
        ReservationDate = (EditText) findViewById(R.id.txt_resdate);
        ReservationHour = (EditText) findViewById(R.id.txt_hour);
        ReservationDesc = (EditText) findViewById(R.id.txt_resdescription);

        incpeople.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v7) {
                // TODO Auto-generated method stub
                int guess = Integer.valueOf(peopleno.getText().toString());
                guess = guess + 1;
                peopleno.setText("" + guess);
            }
        });

        decpeople.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v8) {
                // TODO Auto-generated method stub
                int guess = Integer.valueOf(peopleno.getText().toString());
                guess = guess - 1;
                peopleno.setText("" + guess);
            }
        });

        incten.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v9) {
                // TODO Auto-generated method stub
                int guess = Integer.valueOf(peopleno.getText().toString());
                guess = guess + 10;
                peopleno.setText("" + guess);
            }
        });
    }

    public void addReservation (View view)
    {
        String resname = ReservationName.getText().toString();
        String respeople = peopleno.getText().toString();
        String resphone = ReservationPhone.getText().toString();
        String resdate = ReservationDate.getText().toString();
        String reshour = ReservationHour.getText().toString();
        String resdesc = ReservationDesc.getText().toString();
        reservationDbHelper = new DBHelper(context);
        sqLiteDatabase = reservationDbHelper.getWritableDatabase();
        reservationDbHelper.addReservation(resname, respeople, resphone, resdate, reshour, resdesc, sqLiteDatabase);
        Toast.makeText(getBaseContext(), "Reservation Data Saved", Toast.LENGTH_LONG).show();
        reservationDbHelper.close();
    }


}
