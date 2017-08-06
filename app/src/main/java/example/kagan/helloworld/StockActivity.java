package example.kagan.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class StockActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stock);
    }

    public void addItem(View view)
    {
        Intent intent = new Intent (this,AddStockActivity.class);
        startActivity(intent);
    }

    public void showItem(View view)
    {
        Intent intent = new Intent (this,ShowStock.class);
        startActivity(intent);
    }

    public void updateItem(View view)
    {
        Intent intent = new Intent (this,UpdateStock.class);
        startActivity(intent);
    }

}
