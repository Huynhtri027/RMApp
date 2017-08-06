package example.kagan.helloworld;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateToDoList extends AppCompatActivity {
    EditText SearchSub_ToDo,ShowSub_ToDo,Date_ToDo,Desc_ToDo;

    Button delete,update;
    DBHelper dbHelper;
    SQLiteDatabase sqLiteDatabase;
    String search_todo;
    String search_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_to_do_list);
        SearchSub_ToDo = (EditText)findViewById(R.id.txt_searchtodo);
        ShowSub_ToDo = (EditText)findViewById(R.id.txt_showsubject);
        Date_ToDo = (EditText)findViewById(R.id.txt_showtododate);
        Desc_ToDo = (EditText)findViewById(R.id.txt_showtododesc);
        delete = (Button)findViewById(R.id.btn_tododelete);
        update = (Button)findViewById(R.id.btn_todoupdate);

        ShowSub_ToDo.setVisibility(View.GONE);
        Date_ToDo.setVisibility(View.GONE);
        Desc_ToDo.setVisibility(View.GONE);
        delete.setVisibility(View.GONE);
        update.setVisibility(View.GONE);

    }

    public void searchToDo(View view)
    {
        search_todo = SearchSub_ToDo.getText().toString();
        dbHelper = new DBHelper(getApplicationContext());
        sqLiteDatabase = dbHelper.getReadableDatabase();
        Cursor cursor = dbHelper.searchToDoList(search_todo, sqLiteDatabase);
        if(cursor.moveToFirst())
        {
            String SUBJECT = cursor.getString(0);
            String DATE = cursor.getString(1);
            String DESC = cursor.getString(2);
            ;

            ShowSub_ToDo.setText(SUBJECT);
            Date_ToDo.setText(DATE);
            Desc_ToDo.setText(DESC);


            ShowSub_ToDo.setVisibility(View.VISIBLE);
            Date_ToDo.setVisibility(View.VISIBLE);
            Desc_ToDo.setVisibility(View.VISIBLE);

            delete.setVisibility(View.VISIBLE);
            update.setVisibility(View.VISIBLE);

        }

    }

    public void updateToDo (View view)
    {
        dbHelper = new DBHelper(getApplicationContext());
        sqLiteDatabase = dbHelper.getWritableDatabase();
        String upsubject,update,updesc;

        upsubject =ShowSub_ToDo.getText().toString();
        update =Date_ToDo.getText().toString();
        updesc =Desc_ToDo.getText().toString();


        int count =dbHelper.updateToDoList(search_todo, upsubject, update, updesc, sqLiteDatabase);
        Toast.makeText(getApplicationContext(), count + "List Updated", Toast.LENGTH_LONG).show();
        finish();

    }

    public void deleteToDo(View view)
    {
        search_id = SearchSub_ToDo.getText().toString();
        dbHelper = new DBHelper(getApplicationContext());
        sqLiteDatabase = dbHelper.getReadableDatabase();
        dbHelper.deleteToDoList(search_id, sqLiteDatabase);
        Toast.makeText(getBaseContext(),"List Deleted",Toast.LENGTH_LONG).show();

    }
}
