package example.kagan.helloworld;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

public class ShowPaymentActivity extends AppCompatActivity {

    ListView listView;
    SQLiteDatabase sqLiteDatabase;
    DBHelper dbHelper;
    Cursor cursor;
    LDAPayments listDataAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_payment);
        listView = (ListView) findViewById(R.id.lv_payment);
        listDataAdapter = new LDAPayments(getApplicationContext(),R.layout.payment_layout);
        listView.setAdapter(listDataAdapter);
        dbHelper = new DBHelper(getApplicationContext());
        sqLiteDatabase = dbHelper.getReadableDatabase();
        cursor = dbHelper.getPaymentInfo(sqLiteDatabase);

        if(cursor.moveToFirst())
        {
            do {

                String payto,payvalue,paydate,paytype;
                payto = cursor.getString(0);
                payvalue = cursor.getString(1);
                paydate = cursor.getString(2);
                paytype = cursor.getString(3);

                DPPayment dpPayment = new DPPayment(payto,payvalue,paydate,paytype);
                listDataAdapter.add(dpPayment);

            }while (cursor.moveToNext());
        }
    }
}
