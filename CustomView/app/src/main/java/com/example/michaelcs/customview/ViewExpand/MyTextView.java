package com.example.michaelcs.customview.ViewExpand;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * 这个类定义了一个自定义TextView
 * 用类似的方法可以使得自定义控件不断重用
 */
public class MyTextView extends android.support.v7.widget.AppCompatTextView
{
    Paint paint1 = new Paint();
    Paint paint2 = new Paint();
    public MyTextView(Context context)
    {
        super(context);
    }

    /**
     * Paint是画笔：
     * 在构造方法里面初始化画笔属性
     *
     * @param context
     * @param attrs
     */
    public MyTextView(Context context, @Nullable AttributeSet attrs)
    {
        super(context, attrs);
        paint1.setColor(getResources().getColor(android.R.color.holo_blue_light));
        paint1.setStyle(Paint.Style.FILL);
        paint2.setColor(Color.YELLOW);
        paint2.setStyle(Paint.Style.FILL);
    }

    /**
     * 可以在super.onDraw(canvas)之前，即回调父类方法之前实现自己的逻辑
     * 也可以在回调父类方法之后实现自己的逻辑
     * @param canvas canvas是一个画板
     */
    @Override
    protected void onDraw(Canvas canvas)
    {
        //绘制外层矩形
        canvas.drawRect(
                0,
                0,
                getMeasuredWidth(),
                getMeasuredHeight(),
                paint1
        );
        //绘制内层矩形
        canvas.drawRect(
                10,
                10,
                getMeasuredWidth()-10,
                getMeasuredHeight()-10,
                paint2
        );
        //确认完成绘制
        canvas.save();
        //绘制文字前平移十个像素
        canvas.translate(10,0);
        super.onDraw(canvas);
        canvas.restore();
    }
}
