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

public class UpdatePayment extends AppCompatActivity {
    EditText Search_PayTo,Update_PayTo,Update_PayValue,Update_PayDate,Update_PayType,Update_PayDesc;
    TextView Update_PayID;
    Button updatepayment;
    DBHelper dbHelper;
    SQLiteDatabase sqLiteDatabase;
    String search_payto;
    String search_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_payment);
        Search_PayTo = (EditText)findViewById(R.id.txt_serachuppayment);
        Update_PayID = (TextView)findViewById(R.id.lbl_searchuppayid);
        Update_PayTo = (EditText)findViewById(R.id.txt_updatepayname);
        Update_PayValue = (EditText)findViewById(R.id.txt_updatepayvalue);
        Update_PayDate = (EditText)findViewById(R.id.txt_updatepaydate);
        Update_PayType = (EditText)findViewById(R.id.txt_updatepaytype);
        Update_PayDesc = (EditText)findViewById(R.id.txt_updatepaydesc);
        updatepayment = (Button)findViewById(R.id.btn_updatepay);

        Update_PayID.setVisibility(View.GONE);
        Update_PayTo.setVisibility(View.GONE);
        Update_PayValue.setVisibility(View.GONE);
        Update_PayDate.setVisibility(View.GONE);
        Update_PayType.setVisibility(View.GONE);
        Update_PayDesc.setVisibility(View.GONE);
        updatepayment.setVisibility(View.GONE);
    }

    public void searchupPayment(View view)
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

            Update_PayID.setText(PID);
            Update_PayTo.setText(PTO);
            Update_PayValue.setText(PVALUE);
            Update_PayDate.setText(PDATE);
            Update_PayType.setText(PTYPE);
            Update_PayDesc.setText(PDESC);

            Update_PayID.setVisibility(View.VISIBLE);
            Update_PayTo.setVisibility(View.VISIBLE);
            Update_PayValue.setVisibility(View.VISIBLE);
            Update_PayDate.setVisibility(View.VISIBLE);
            Update_PayType.setVisibility(View.VISIBLE);
            Update_PayDesc.setVisibility(View.VISIBLE);
            updatepayment.setVisibility(View.VISIBLE);

        }
    }

    public void updatePayment (View view)
    {
        dbHelper = new DBHelper(getApplicationContext());
        sqLiteDatabase = dbHelper.getWritableDatabase();
        String upcname,upvalue,update,uptype,updesc;

        upcname =Update_PayTo.getText().toString();
        upvalue =Update_PayValue.getText().toString();
        update =Update_PayDate.getText().toString();
        uptype =Update_PayType.getText().toString();
        updesc =Update_PayDesc.getText().toString();

        int count =dbHelper.updateupPayment(search_payto, upcname, upvalue, update, uptype, updesc, sqLiteDatabase);
        Toast.makeText(getApplicationContext(), count + "Updated", Toast.LENGTH_LONG).show();
        finish();
    }
}
