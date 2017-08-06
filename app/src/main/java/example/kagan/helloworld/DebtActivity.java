package example.kagan.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class DebtActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_debt);
    }

    public void viewDebt(View view)
    {
        Intent intent = new Intent (this,ShowDebts.class);
        startActivity(intent);
    }

    public void searchDebt(View view)
    {
        Intent intent = new Intent (this,SearchDebt.class);
        startActivity(intent);
    }
}
