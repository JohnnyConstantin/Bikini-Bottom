package com.example.a176try;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

class MyDraw extends View {
    public MyDraw(Context context) {
        super(context);
    }

    @Override

    protected void onDraw(Canvas canvas) {
        Paint paint = new Paint();
        int y = 0;
        while (y < getHeight()) {
            canvas.drawLine(0, y,
                    this.getWidth(), y, paint);
            y += 30;
        }
}}
