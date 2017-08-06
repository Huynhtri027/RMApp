package example.kagan.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class ReservationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation);
    }

    public void addReserv(View view)
    {
        Intent intent = new Intent (this,AddReservationActivity.class);
        startActivity(intent);
    }
    public void showReserv(View view)
    {
        Intent intent = new Intent (this,ShowReservations.class);
        startActivity(intent);
    }
    public void searchReserv(View view)
    {
        Intent intent = new Intent (this,SearchReservation.class);
        startActivity(intent);
    }

    public void updateReserv(View view)
    {
        Intent intent = new Intent (this,UpdateReservation.class);
        startActivity(intent);
    }

}
