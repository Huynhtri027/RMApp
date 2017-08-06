package example.kagan.helloworld;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class AddStockActivity extends AppCompatActivity {
    ListView listView;
    EditText StockName;
    TextView StockNumber;
    Cursor cursor;
    LDAStock listDataAdapter;


    Context context = this;
    DBHelper stockDbHelper;
    SQLiteDatabase sqLiteDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_stock);

        StockName = (EditText)findViewById(R.id.txt_stockname);
        StockNumber = (TextView)findViewById(R.id.lbl_zerostock);
        listView = (ListView) findViewById(R.id.lv_stock);
        listDataAdapter = new LDAStock(getApplicationContext(),R.layout.stock_layout);
        listView.setAdapter(listDataAdapter);
        stockDbHelper = new DBHelper(getApplicationContext());
        sqLiteDatabase = stockDbHelper.getReadableDatabase();
        cursor = stockDbHelper.getStockInfo(sqLiteDatabase);

        if(cursor.moveToFirst())
        {
            do {

                String stockname,stoackmunber;
                stockname = cursor.getString(0);
                stoackmunber = cursor.getString(1);


                DPStock dpStock = new DPStock(stockname,stoackmunber);
                listDataAdapter.add(dpStock);

            }while (cursor.moveToNext());
        }

    }

    public void addStock (View view)
    {
        String stockname = StockName.getText().toString();
        String stocknumber = StockNumber.getText().toString();

        stockDbHelper = new DBHelper(context);
        sqLiteDatabase = stockDbHelper.getWritableDatabase();
        stockDbHelper.addStock(stockname, stocknumber, sqLiteDatabase);
        Toast.makeText(getBaseContext(), "Stock Data Saved", Toast.LENGTH_LONG).show();
        stockDbHelper.close();
    }


}
