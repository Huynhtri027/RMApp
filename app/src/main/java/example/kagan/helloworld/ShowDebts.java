package example.kagan.helloworld;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

public class ShowDebts extends AppCompatActivity {

    ListView listView;
    SQLiteDatabase sqLiteDatabase;
    DBHelper dbHelper;
    Cursor cursor;
    LDADebts listDataAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_debts);
        listView = (ListView) findViewById(R.id.lv_debt);
        listDataAdapter = new LDADebts(getApplicationContext(),R.layout.debts_layout);
        listView.setAdapter(listDataAdapter);
        dbHelper = new DBHelper(getApplicationContext());
        sqLiteDatabase = dbHelper.getReadableDatabase();
        cursor = dbHelper.getDebtInfo(sqLiteDatabase);

        if(cursor.moveToFirst())
        {
            do {

                String debtto,debtvalue,debtdate,debtdesc;
                debtto = cursor.getString(0);
                debtvalue = cursor.getString(1);
                debtdate = cursor.getString(2);
                debtdesc = cursor.getString(3);

                DPDebt dpDebt = new DPDebt(debtto,debtvalue,debtdate,debtdesc);
                listDataAdapter.add(dpDebt);

            }while (cursor.moveToNext());
        }
    }
}
