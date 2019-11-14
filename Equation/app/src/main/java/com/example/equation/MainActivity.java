package com.example.equation;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
        // Вызывается при создании активности
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            // Инициализирует активность.
            setContentView(R.layout.activity_main);
        }

        /** Вызывается при нажатии пользователем на кнопку Решить */
        public void solveEquation(View view) {
            // ax+b=c
            double a = Double.parseDouble(((EditText)
                    findViewById(R.id.coefficient_a)).getText().toString());
            double b = Double.parseDouble(((EditText)
                    findViewById(R.id.coefficient_b)).getText().toString());
            double c = Double.parseDouble(((EditText)
                    findViewById(R.id.coefficient_c)).getText().toString());
            if (Math.sqrt(Math.pow(b, 2) - 4 * a * c) < 0) {
                TextView result = (TextView) findViewById(R.id.result);
                result.setText("Корней нет");
            } else if(a ==0, b ==0, c==0) {

            } else if {
                TextView result = (TextView) findViewById(R.id.result);
                result.setText("" + String.valueOf((-b + Math.sqrt(Math.pow(b, 2) - 4 * a * c)) / 2 * a) + String.valueOf((-b - Math.sqrt(Math.pow(b, 2) - 4 * a * c)) / 2 * a))
            }
        }
    }

