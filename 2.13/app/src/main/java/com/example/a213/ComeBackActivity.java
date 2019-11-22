package com.example.a213;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class ComeBackActivity extends AppCompatActivity {
    EditText et;
    Button bt;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.comebackactivity);
        et= (EditText) findViewById(R.id.et);
        bt= (Button) findViewById(R.id.bt);
        View.OnClickListener listener=new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.putExtra("et",et.getText().toString());
                setResult(RESULT_OK, i);
                finish();
            }
        };
        bt.setOnClickListener(listener);
    }
}