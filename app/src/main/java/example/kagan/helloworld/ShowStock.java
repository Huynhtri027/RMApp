package example.kagan.helloworld;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

public class ShowStock extends AppCompatActivity {
    ListView listView;
    SQLiteDatabase sqLiteDatabase;
    DBHelper dbHelper;
    Cursor cursor;
    LDAStock listDataAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_stock);
        listView = (ListView) findViewById(R.id.lv_showstock);
        listDataAdapter = new LDAStock(getApplicationContext(),R.layout.stock_layout);
        listView.setAdapter(listDataAdapter);
        dbHelper = new DBHelper(getApplicationContext());
        sqLiteDatabase = dbHelper.getReadableDatabase();
        cursor = dbHelper.getStockInfo(sqLiteDatabase);

        if(cursor.moveToFirst())
        {
            do {

                String name,number;
                name = cursor.getString(0);
                number = cursor.getString(1);

                DPStock dpStock = new DPStock(name,number);
                listDataAdapter.add(dpStock);

            }while (cursor.moveToNext());
        }
    }
}
