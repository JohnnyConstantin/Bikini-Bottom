package com.example.a177;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.CountDownTimer;
import android.view.View;


 boolean started;
         Paint paint = new Paint();
         int N = 10; // количество шариков
         float[] x = new float[N];
         float[] y = new float[N];
         float[] vx = new float[N];
         float[] vy = new float[N];


void add(float[] array , float[] values){
         for(int i=0;i<array.length;i++){
        array[i]+=values[i];
        }
        }

void fillRandom(float[] array , float min, float max){
 for (int i = 0; i < array.length; i++){
  array[i] = rand (min, max);
 }
        }

float rand(float min , float max){
 return (float)(Math.random() * (max - min + 1)) + min;
}

public MyView(Context context) {
        super(context);
        fillRandom(x, 0, 500);
        fillRandom(y, 0, 500);
        fillRandom(vx, -3, 3);
        fillRandom(vy, 500);
        }



void drawBalls(Canvas canvas){
        for (int i = 0; i < N; i++) {
        canvas.drawCircle(x[i], y[i], 20, paint);
        }
        }

@Override
protected void onDraw (Canvas canvas){

        paint.setColor(Color.BLACK);

        drawBalls(canvas);

        // готовим массивы x и у для следущего кадра
        addValues(x, vx);
        addValues(y, vy);
        //запрашиваем перерисовку
        invalidate();
        }