package example.kagan.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class TodayActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_today);

    }

    public void viewReservations(View view)
    {
        Intent intent = new Intent (this,ReservationActivity.class);
        startActivity(intent);
    }

    public void viewPayments(View view)
    {
        Intent intent = new Intent (this,PaymentsActivity.class);
        startActivity(intent);
    }

    public void viewDebts(View view)
    {
        Intent intent = new Intent (this,DebtActivity.class);
        startActivity(intent);
    }

    public void viewStock(View view)
    {
        Intent intent = new Intent (this,StockActivity.class);
        startActivity(intent);
    }

    public void viewToDoList(View view)
    {
        Intent intent = new Intent (this,ToDoListActivity.class);
        startActivity(intent);
    }

}
