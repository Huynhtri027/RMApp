package example.kagan.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    private Button register;
    private Button sign;
    //private EditText mail;
    private EditText pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        register = (Button) findViewById(R.id.btn_register);
        sign = (Button) findViewById(R.id.btn_sign);
        //mail = (EditText) findViewById(R.id.txt_email);
        pass = (EditText) findViewById(R.id.txt_password);


        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                Intent i = new Intent(getApplicationContext(), TodayActivity.class);
                if((pass.getText().toString()).equals("haneden")) {
                    startActivity(i);
                }

            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v1) {
                // TODO Auto-generated method stub
                Intent i = new Intent(getApplicationContext(),RegisterActivity.class);
                startActivity(i);
            }
        });

    }

}
