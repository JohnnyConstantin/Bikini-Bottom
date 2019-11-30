package com.example.journal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txt;
    EditText login_in, password_in;
    Button bt1;
    String login_true = "Johnny";
    String password_true = "12345";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login_in = findViewById(R.id.login);
        password_in = findViewById(R.id.password);
        bt1 = findViewById(R.id.button);
        View.OnClickListener listener =  new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent i;
                switch(v.getId()){
                    case R.id.button:
                        if(login_in.getText().toString().equals(login_true) && password_in.getText().toString().equals(password_true)){
                            txt.setText("Верно");
                            txt.setTextColor(Color.GREEN);
                        }else{
                            txt.setText("Неправильный логин или пароль");
                            txt.setTextColor(Color.RED);
                        };
                        i = new Intent(this, MainActivity2);
                        startActivity();
                        break;
                }
                login_in.setText("");
                login_in.setText("");
            }
        };
        bt1.setOnClickListener(listener);
    }
}

