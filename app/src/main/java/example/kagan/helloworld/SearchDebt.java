package example.kagan.helloworld;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SearchDebt extends AppCompatActivity {

    TextView Display_DebtID,Display_DebtName,Display_DebtValue,Display_DebtDate,Display_DebtDesc;
    EditText Search_DebtName,DebtPayType;

    DBHelper dbHelper;

    String search_debtto;
    String search_id;
    Context context = this;

    SQLiteDatabase sqLiteDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_debt);
        Search_DebtName = (EditText)findViewById(R.id.txt_searchdebt);
        DebtPayType = (EditText)findViewById(R.id.txt_debtpaytype);
        Display_DebtID = (TextView)findViewById(R.id.lbl_debtid);
        Display_DebtName = (TextView)findViewById(R.id.lbl_debtname);
        Display_DebtValue = (TextView)findViewById(R.id.lbl_debtvalue);
        Display_DebtDate = (TextView)findViewById(R.id.lbl_debtdate);
        Display_DebtDesc = (TextView)findViewById(R.id.lbl_debtdesc);


        DebtPayType.setVisibility(View.GONE);
        Display_DebtID.setVisibility(View.GONE);
        Display_DebtName.setVisibility(View.GONE);
        Display_DebtValue.setVisibility(View.GONE);
        Display_DebtDate.setVisibility(View.GONE);
        Display_DebtDesc.setVisibility(View.GONE);

    }

    public void searchDebts (View view)
    {
        search_debtto = Search_DebtName.getText().toString();
        dbHelper = new DBHelper(getApplicationContext());
        sqLiteDatabase = dbHelper.getReadableDatabase();
        Cursor cursor = dbHelper.searchDept(search_debtto, sqLiteDatabase);
        if(cursor.moveToFirst())
        {
            String DEBTID = cursor.getString(0);
            String DEBTNAME = cursor.getString(1);
            String DEBTVALUE = cursor.getString(2);
            String DEBTDATE = cursor.getString(3);
            String DEBTDESC = cursor.getString(4);

            Display_DebtID.setText(DEBTID);
            Display_DebtName.setText(DEBTNAME);
            Display_DebtValue.setText(DEBTVALUE);
            Display_DebtDate.setText(DEBTDATE);
            Display_DebtDesc.setText(DEBTDESC);

            DebtPayType.setVisibility(View.VISIBLE);
            Display_DebtID.setVisibility(View.VISIBLE);
            Display_DebtName.setVisibility(View.VISIBLE);
            Display_DebtValue.setVisibility(View.VISIBLE);
            Display_DebtDate.setVisibility(View.VISIBLE);
            Display_DebtDesc.setVisibility(View.VISIBLE);
        }
    }

    public void payaDebt(View view)
    {
        String payto = Display_DebtName.getText().toString();
        String payvalue = Display_DebtValue.getText().toString();
        String paydate = Display_DebtDate.getText().toString();
        String paytype = DebtPayType.getText().toString();
        String paydesc = Display_DebtDesc.getText().toString();

        dbHelper = new DBHelper(context);
        sqLiteDatabase = dbHelper.getWritableDatabase();
        dbHelper.payDebtInsertToPayment(payto, payvalue, paydate, paytype, paydesc, sqLiteDatabase);
        Toast.makeText(getBaseContext(), "Payment Data Saved", Toast.LENGTH_LONG).show();


        search_id = Display_DebtID.getText().toString();
        dbHelper = new DBHelper(getApplicationContext());
        sqLiteDatabase = dbHelper.getReadableDatabase();
        dbHelper.deleteDebt(search_id, sqLiteDatabase);
        Toast.makeText(getBaseContext(), "Debt Deleted", Toast.LENGTH_LONG).show();

        dbHelper.close();
    }
}
