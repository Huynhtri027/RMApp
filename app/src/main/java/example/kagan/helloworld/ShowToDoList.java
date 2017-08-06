package example.kagan.helloworld;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

public class ShowToDoList extends AppCompatActivity {
    ListView listView;
    SQLiteDatabase sqLiteDatabase;
    DBHelper dbHelper;
    Cursor cursor;
    LDAToDoList listDataAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_to_do_list);
        listView = (ListView) findViewById(R.id.lv_todolist);
        listDataAdapter = new LDAToDoList(getApplicationContext(),R.layout.todolist_layout);
        listView.setAdapter(listDataAdapter);
        dbHelper = new DBHelper(getApplicationContext());
        sqLiteDatabase = dbHelper.getReadableDatabase();
        cursor = dbHelper.getToDoListInfo(sqLiteDatabase);

        if(cursor.moveToFirst())
        {
            do {

                String sub,date,desc;
                sub = cursor.getString(0);
                date = cursor.getString(1);
                desc = cursor.getString(2);

                DPToDoList dpToDoList = new DPToDoList(sub,date,desc);
                listDataAdapter.add(dpToDoList);

            }while (cursor.moveToNext());
        }
    }
}
