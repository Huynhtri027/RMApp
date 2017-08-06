package example.kagan.helloworld;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddToDoList extends AppCompatActivity {
    EditText ToDoSubject, ToDoDate, ToDoDesc;

    Context context = this;
    DBHelper paymentDbHelper;
    SQLiteDatabase sqLiteDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_to_do_list);
        ToDoSubject = (EditText) findViewById(R.id.txt_subject);
        ToDoDate = (EditText) findViewById(R.id.txt_tododate);
        ToDoDesc = (EditText) findViewById(R.id.txt_tododesc);
    }

    public void saveList (View view)
    {
        String subject = ToDoSubject.getText().toString();
        String date = ToDoDate.getText().toString();
        String desc = ToDoDesc.getText().toString();

        paymentDbHelper = new DBHelper(context);
        sqLiteDatabase = paymentDbHelper.getWritableDatabase();
        paymentDbHelper.addTodolist(subject, date, desc, sqLiteDatabase);
        Toast.makeText(getBaseContext(), "ToDoList Data Saved", Toast.LENGTH_LONG).show();
        paymentDbHelper.close();
    }


}
