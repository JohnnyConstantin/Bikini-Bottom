package com.example.a177;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class MyView extends View {

    public MyView(Context context) {
        super(context);
    }

    @Override

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(20);
        canvas.drawCircle(300, 300, 200, paint);

        Paint paint1 = new Paint();
        paint1.setColor(Color.RED);
        paint1.setStyle(Paint.Style.STROKE);
        paint1.setStrokeWidth(20);
        canvas.drawCircle(500, 500, 180, paint1);

        Paint paint2 = new Paint();
        paint2.setColor(Color.BLACK);
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setStrokeWidth(20);
        canvas.drawCircle(700, 700, 160, paint2);

        Paint paint3 = new Paint();
        paint3.setColor(Color.BLACK);
        paint3.setStyle(Paint.Style.STROKE);
        paint3.setStrokeWidth(20);
        canvas.drawCircle(900, 900, 140, paint3);


    }
}

