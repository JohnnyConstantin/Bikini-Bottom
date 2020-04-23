package com.example.programm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class UserInput extends AppCompatActivity {

    EditText editText;
    TextView txt;
    Button bt;
    static ArrayList<Integer> arr = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.user_input);

        txt = (TextView) findViewById(R.id.title2);
        editText = (EditText) findViewById(R.id.etxt3);
        bt = (Button) findViewById(R.id.user_bt);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int x = Integer.valueOf(editText.getText().toString());
                if(x >= 1 && x <= 100){
                    arr.add(x);
                    if(arr.size() == MainActivity.m * MainActivity.m){
                        Intent i = new Intent();
                        setResult(RESULT_OK, i);
                        finish();
                    }
                }else{
                    txt.setText("Число должно лежать в промежутке от 1 до 100!!!");
                }
                editText.setText("");
            }
        };
        bt.setOnClickListener(listener);



    }
}
