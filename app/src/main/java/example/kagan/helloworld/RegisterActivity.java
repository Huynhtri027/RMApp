package example.kagan.helloworld;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity  {
    EditText RegisterName, RegisterEmail, RegisterPassword;
    Context context = this;
    DBHelper registerDbHelper;
    SQLiteDatabase sqLiteDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        RegisterName = (EditText) findViewById(R.id.txt_recompname);
        RegisterEmail = (EditText) findViewById(R.id.txt_reemail);
        RegisterPassword = (EditText) findViewById(R.id.txt_repassword);
    }

    public void addRegister (View view){
        String name = RegisterName.getText().toString();
        String email = RegisterEmail.getText().toString();
        String password = RegisterPassword.getText().toString();
        registerDbHelper = new DBHelper(context);
        sqLiteDatabase = registerDbHelper.getWritableDatabase();
        registerDbHelper.addregister(name,email,password,sqLiteDatabase);
        Toast.makeText(getBaseContext(),"Register Data Saved",Toast.LENGTH_LONG).show();
        registerDbHelper.close();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_register, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
