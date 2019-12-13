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

        EditText name;
        EditText password;
        TextView result;
        Button button1;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            name = (EditText) findViewById(R.id.login);
            result = (TextView) findViewById(R.id.result);
            password = (EditText) findViewById(R.id.password);
            button1 = (Button) findViewById(R.id.button);
            View.OnClickListener listener = new View.OnClickListener(){

            @Override
            public void onClick(View v){
                Intent i;
                if (v.getId() == R.id.button) {
                    if ((password.getText().toString()).equals("1234") && ((name.getText().toString()).equals("john"))){
                        result.setTextColor(Color.GREEN);
                        result.setText("Верно");
                        i = new Intent(MainActivity.this, MainActivity2.class);
                        startActivity(i);
                    } else {
                        result.setTextColor(Color.RED);
                        result.setText("Вы ошиблись в логине или пароле");
                    }
                }
            }
            };
            button1.setOnClickListener(listener);
        }
}