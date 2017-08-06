package example.kagan.helloworld;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class UpdateStock extends AppCompatActivity {

    TextView Stock_Name;
    EditText Search_Name,Update_Number;
    DBHelper dbHelper;
    Button update,delete;
    SQLiteDatabase sqLiteDatabase;
    String search_name;
    String search_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_stock);
        Search_Name = (EditText)findViewById(R.id.txt_searchitem);
        Stock_Name = (TextView)findViewById(R.id.lbl_itemname);
        Update_Number = (EditText)findViewById(R.id.txt_numberitem);

        update = (Button)findViewById(R.id.btn_updatestock);
        delete = (Button)findViewById(R.id.btn_deletestock);

        Stock_Name.setVisibility(View.GONE);
        Update_Number.setVisibility(View.GONE);

        update.setVisibility(View.GONE);
        delete.setVisibility(View.GONE);
    }

    public void searchStock(View view)
    {
        search_name = Search_Name.getText().toString();
        dbHelper = new DBHelper(getApplicationContext());
        sqLiteDatabase = dbHelper.getReadableDatabase();
        Cursor cursor = dbHelper.searchStock(search_name, sqLiteDatabase);
        if(cursor.moveToFirst())
        {
            String NAME = cursor.getString(0);
            String NUMBER = cursor.getString(1);


            Stock_Name.setText(NAME);
            Update_Number.setText(NUMBER);


            Stock_Name.setVisibility(View.VISIBLE);
            Update_Number.setVisibility(View.VISIBLE);

            update.setVisibility(View.VISIBLE);
            delete.setVisibility(View.VISIBLE);
        }
    }

    public void updateStock (View view)
    {
        dbHelper = new DBHelper(getApplicationContext());
        sqLiteDatabase = dbHelper.getWritableDatabase();
        String name,number;
        int num;

        name =Stock_Name.getText().toString();
        number =Update_Number.getText().toString();

        int count =dbHelper.updateupStock(search_name, name, number, sqLiteDatabase);
        Toast.makeText(getApplicationContext(), count + "Stock Updated", Toast.LENGTH_LONG).show();

        num=Integer.parseInt(Update_Number.getText().toString());

        if (num<20){
            NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
            builder.setSmallIcon(R.mipmap.restaurant);
            builder.setContentTitle("RMApp");
            builder.setContentText("Your stock item running out");
            Intent intent = new Intent(this,ShowStock.class);
            TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
            stackBuilder.addParentStack(ShowStock.class);
            stackBuilder.addNextIntent(intent);
            PendingIntent pendingIntent = stackBuilder.getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT);
            builder.setContentIntent(pendingIntent);
            NotificationManager NM = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            NM.notify(0,builder.build());
        }
        finish();
    }

    public void deleteStock(View view)
    {
        search_id = Stock_Name.getText().toString();
        dbHelper = new DBHelper(getApplicationContext());
        sqLiteDatabase = dbHelper.getReadableDatabase();
        dbHelper.deleteStock(search_id, sqLiteDatabase);
        Toast.makeText(getBaseContext(),"Item Deleted",Toast.LENGTH_LONG).show();

    }
}
