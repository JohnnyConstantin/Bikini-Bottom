package com.example.programm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView txt1, txt2, txt3, output;
    EditText editText1, editText2;
    Button bt1, bt2;
    int REQ_C = 0;

    int[][] a;
    static int m;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt1 = (TextView) findViewById(R.id.title);
        txt2 = (TextView) findViewById(R.id.txt2);
        txt3 = (TextView) findViewById(R.id.txt1);
        editText1 = (EditText) findViewById(R.id.etxt1);
        bt1 = (Button) findViewById(R.id.btn1);
        editText2 = (EditText) findViewById(R.id.etxt2);
        bt2 = (Button) findViewById(R.id.btn2);
        output = (TextView) findViewById(R.id.output);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.btn1:
                        m = Integer.valueOf(editText1.getText().toString());
                        if(m >= 2 && m <= 8 && m % 2 == 0){
                            a = new int[m][m];
                            txt3.setText("Вы ввели правильно(" + m + ")");
                            editText1.setText("");
                        }else{
                            txt3.setText("Число должно лежать в промежутке от 2 до 8 и быть четным! Введите число заново");
                            editText1.setText("");
                        }
                        break;
                    case R.id.btn2:
                        int x = Integer.valueOf(editText2.getText().toString());
                        editText2.setText("");
                        if(x != 1 && x != 2){
                            txt2.setText("Число должно быть 1 или 2! Повторите ввод");
                        }else if(x == 2){
                            Random random = new Random();
                            ArrayList<Integer> arr = new ArrayList<>();
                            for(int i = 0; i < m; i++){
                                for(int j = 0; j < m; j++){
                                    a[i][j] = Math.abs(random.nextInt() % 100 + 1);
                                    arr.add(a[i][j]);
                                }
                            }


                            arr = bubble_sort(arr);
                            StringBuilder s = new StringBuilder();

                            int k = 0;
                            for(int i = 0; i < m; i++){
                                for(int j = 0; j < m; j++){
                                    a[i][j] = arr.get(k);
                                    k++;
                                    s.append(a[i][j]).append(" ");
                                }
                                s.append("\n");
                            }
                            output.setText(s);
                        }else{
                            Intent intent = new Intent(MainActivity.this, UserInput.class);
                            startActivityForResult(intent, REQ_C);
                        }
                }
            }
        };
        bt1.setOnClickListener(listener);
        bt2.setOnClickListener(listener);
    }

    private ArrayList<Integer> bubble_sort(ArrayList<Integer> a){
        boolean f;
        int k = a.size();
        for(int i = 0; i < k; i++){
            f = false;
            for(int j = 0; j < k - i - 1; j++){
                if(a.get(j + 1) > a.get(j)){
                    int y = a.get(j + 1);
                    a.set(j + 1, a.get(j));
                    a.set(j, y);
                    f = true;
                }
            }
            if(!f){
                return a;
            }
        }
        return a;
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (resultCode) {
            case RESULT_OK:
                ArrayList<Integer> arr = UserInput.arr;
                arr = bubble_sort(arr);
                int k = 0;
                StringBuilder s = new StringBuilder();
                for(int i = 0; i < m; i++){
                    for(int j = 0; j < m; j++){
                        a[i][j] = arr.get(k);
                        k++;
                        s.append(a[i][j]).append(" ");
                    }
                    s.append("\n");
                }
                output.setText(s);
                break;
        }
    }
}
