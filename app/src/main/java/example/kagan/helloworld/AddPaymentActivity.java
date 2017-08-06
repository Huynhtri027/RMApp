package example.kagan.helloworld;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddPaymentActivity extends AppCompatActivity {

    EditText PaymentTo, PaymentValue, PaymentDate, PaymentType, PaymentDesc;

    Context context = this;
    DBHelper paymentDbHelper;
    SQLiteDatabase sqLiteDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_payment);
        PaymentTo = (EditText) findViewById(R.id.txt_paymentplace);
        PaymentValue = (EditText) findViewById(R.id.txt_paymentvalue);
        PaymentDate = (EditText) findViewById(R.id.txt_paymentdate);
        PaymentType = (EditText) findViewById(R.id.txt_paymenttype);
        PaymentDesc = (EditText) findViewById(R.id.txt_paymentdescription);
    }

    public void addPayment (View view)
    {
        String payto = PaymentTo.getText().toString();
        String payvalue = PaymentValue.getText().toString();
        String paydate = PaymentDate.getText().toString();
        String paytype = PaymentType.getText().toString();
        String paydesc = PaymentDesc.getText().toString();
        paymentDbHelper = new DBHelper(context);
        sqLiteDatabase = paymentDbHelper.getWritableDatabase();
        paymentDbHelper.addPayment(payto, payvalue, paydate, paytype, paydesc, sqLiteDatabase);
        Toast.makeText(getBaseContext(), "Payment Data Saved", Toast.LENGTH_LONG).show();
        paymentDbHelper.close();
    }

    public void notPaid (View view)
    {
        String debtname = PaymentTo.getText().toString();
        String debtvalue = PaymentValue.getText().toString();
        String debtdate = PaymentDate.getText().toString();
        String debtdesc = PaymentDesc.getText().toString();
        paymentDbHelper = new DBHelper(context);
        sqLiteDatabase = paymentDbHelper.getWritableDatabase();
        paymentDbHelper.addDebt(debtname, debtvalue, debtdate, debtdesc, sqLiteDatabase);
        Toast.makeText(getBaseContext(), "Debt Data Saved", Toast.LENGTH_LONG).show();
        paymentDbHelper.close();
    }


}
