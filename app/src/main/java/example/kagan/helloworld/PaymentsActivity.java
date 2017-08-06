package example.kagan.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class PaymentsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payments);
    }

    public void addPayment(View view)
    {
        Intent intent = new Intent (this,AddPaymentActivity.class);
        startActivity(intent);
    }
    public void showPayment(View view)
    {
        Intent intent = new Intent (this,ShowPaymentActivity.class);
        startActivity(intent);
    }
     public void searchPayment(View view)
    {
        Intent intent = new Intent (this,SearchPayment.class);
        startActivity(intent);
    }

    public void updatePayment(View view)
    {
        Intent intent = new Intent (this,UpdatePayment.class);
        startActivity(intent);
    }
}
