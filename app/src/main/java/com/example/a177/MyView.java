package com.example.a177;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class MyView extends View {
    boolean started;
    Paint paint = new Paint();
    int N = 10; // количество шариков
    float[] x = new float[N];
    float[] y = new float[N];
    float[] vx = new float[N];
    float[] vy = new float[N];

    public MyView(Context context) {
        super(context);
        if (!started) {

            for (int i = 0; i < N; i++) {
                x[i] = (float) (Math.random() * 500);
                y[i] = (float) (Math.random() * 500);
                vx[i] = (float) (Math.random() * 6 - 3);
                vy[i] = (float) (Math.random() * 6 - 3);
            }
        }
    }
        @Override
        protected void onDraw (Canvas canvas){

                paint.setColor(Color.BLACK);

                for (int i = 0; i < N; i++) {
                    canvas.drawCircle(x[i], y[i], 20, paint);
                }
                // готовим массивы x и у для следущего кадра
                for (int i = 0; i < N; i++) {
                    x[i] += vx[i];
                    y[i] += vy[i];
                }
                //запрашиваем перерисовку
                started = true;
            invalidate();
        }
    }


