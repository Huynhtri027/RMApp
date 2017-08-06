package example.kagan.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class ToDoListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do_list);
    }
    public void createList(View view)
    {
        Intent intent = new Intent (this,AddToDoList.class);
        startActivity(intent);
    }
    public void showList(View view)
    {
        Intent intent = new Intent (this,ShowToDoList.class);
        startActivity(intent);
    }
    public void updateList(View view)
    {
        Intent intent = new Intent (this,UpdateToDoList.class);
        startActivity(intent);
    }
}
