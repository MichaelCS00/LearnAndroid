package com.example.michaelcs.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.TextView;

public class MyTextView extends android.support.v7.widget.AppCompatTextView
{
    Paint paint1 = new Paint();
    Paint paint2 = new Paint();
    public MyTextView(Context context)
    {
        super(context);
    }

    public MyTextView(Context context, @Nullable AttributeSet attrs)
    {
        super(context, attrs);
        paint1.setColor(getResources().getColor(android.R.color.holo_blue_light));
        paint1.setStyle(Paint.Style.FILL);
        paint2.setColor(Color.YELLOW);
        paint2.setStyle(Paint.Style.FILL);
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        canvas.drawRect(
                0,
                0,
                getMeasuredWidth(),
                getMeasuredHeight(),
                paint1
        );
        canvas.drawRect(
                10,
                10,
                getMeasuredWidth()-10,
                getMeasuredHeight()-10,
                paint2
        );
        canvas.save();
        canvas.translate(10,0);
        super.onDraw(canvas);
        canvas.restore();
    }
}
