package com.example.mvcmvpdemo.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

import com.example.mvcmvpdemo.R;

/**
 * Author GWJ
 * 2021/7/28 13:48
 **/
public class MyView extends View {
    Paint paint = new Paint();
    public MyView(Context context) {
        super(context);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setColor(Color.BLUE);
        canvas.drawCircle(50,50,100,paint);
    }
}
