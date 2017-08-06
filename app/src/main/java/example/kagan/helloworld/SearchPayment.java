package example.kagan.helloworld;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SearchPayment extends AppCompatActivity {

    TextView Display_PayID,Display_PayTo,Display_PayValue,Display_PayDate,Display_PayType,Display_PayDesc;
    EditText Search_PayTo;
    DBHelper dbHelper;
    SQLiteDatabase sqLiteDatabase;
    String search_payto;
    String search_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_payment);
        Search_PayTo = (EditText)findViewById(R.id.txt_searchpayment);
        Display_PayID = (TextView)findViewById(R.id.lbl_searchidpayment);
        Display_PayTo = (TextView)findViewById(R.id.lbl_searchpayto);
        Display_PayValue = (TextView)findViewById(R.id.lbl_searchvalue);
        Display_PayDate = (TextView)findViewById(R.id.lbl_searchdatepayment);
        Display_PayType = (TextView)findViewById(R.id.lbl_searchtype);
        Display_PayDesc = (TextView)findViewById(R.id.lbl_searchdescpayment);

        Display_PayID.setVisibility(View.GONE);
        Display_PayTo.setVisibility(View.GONE);
        Display_PayValue.setVisibility(View.GONE);
        Display_PayDate.setVisibility(View.GONE);
        Display_PayType.setVisibility(View.GONE);
        Display_PayDesc.setVisibility(View.GONE);

    }

    public void searchPayment (View view)
    {
        search_payto = Search_PayTo.getText().toString();
        dbHelper = new DBHelper(getApplicationContext());
        sqLiteDatabase = dbHelper.getReadableDatabase();
        Cursor cursor = dbHelper.searchPayment(search_payto, sqLiteDatabase);
        if(cursor.moveToFirst())
        {
            String PID = cursor.getString(0);
            String PTO = cursor.getString(1);
            String PVALUE = cursor.getString(2);
            String PDATE = cursor.getString(3);
            String PTYPE = cursor.getString(4);
            String PDESC = cursor.getString(5);

            Display_PayID.setText(PID);
            Display_PayTo.setText(PTO);
            Display_PayValue.setText(PVALUE);
            Display_PayDate.setText(PDATE);
            Display_PayType.setText(PTYPE);
            Display_PayDesc.setText(PDESC);

            Display_PayID.setVisibility(View.VISIBLE);
            Display_PayTo.setVisibility(View.VISIBLE);
            Display_PayValue.setVisibility(View.VISIBLE);
            Display_PayDate.setVisibility(View.VISIBLE);
            Display_PayType.setVisibility(View.VISIBLE);
            Display_PayDesc.setVisibility(View.VISIBLE);

        }
    }

    public void deletePayment(View view)
    {
        search_id = Display_PayID.getText().toString();
        dbHelper = new DBHelper(getApplicationContext());
        sqLiteDatabase = dbHelper.getReadableDatabase();
        dbHelper.deletePayment(search_id,sqLiteDatabase);
        Toast.makeText(getBaseContext(), "Payment Deleted", Toast.LENGTH_LONG).show();
    }
}
