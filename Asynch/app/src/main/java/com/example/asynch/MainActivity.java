package com.example.asynch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button bStart, bStop;
    TextView text1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);
                bStart = (Button) findViewById(R.id.bt1);
                bStop= (Button) findViewById(R.id.bt2);
                text1 = (TextView) findViewById(R.id.text1);

                bStart.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(MainActivity.this, "Начинаем подсчет", Toast.LENGTH_SHORT).show();
                        new Counting().execute();
                    }
                });
            }


    class Counting extends AsyncTask<Void, Integer, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }
        protected Void doInBackground(Integer args) {
            for (int i = 0; i < 100; i += 10) {
                try {
                    Thread.sleep(1000);
                    publishProgress(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            publishProgress(100);
            return null;
        }
        protected void onPostExecute(Void image) {
            text.setText("Задача завершена");
        }
        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            progressBar.setProgress(values[0]);
            text.setText("Выполнено : " + values[0] + "/100");
        }
    }
}
