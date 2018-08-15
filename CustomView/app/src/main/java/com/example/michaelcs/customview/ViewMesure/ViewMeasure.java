package com.example.michaelcs.customview.ViewMesure;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class ViewMeasure extends View
{

    public ViewMeasure(Context context)
    {
        super(context);
    }

    public ViewMeasure(Context context, @Nullable AttributeSet attrs)
    {
        super(context, attrs);
    }

    public ViewMeasure(Context context, @Nullable AttributeSet attrs, int defStyleAttr)
    {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec)
    {
        //这两个从View中传进来的参数包含测量模式和测量值如“mathchParent”和"200dp”
        //前者为2位后者为30位数据
        //measureWith()和measureHeight()将对其中测量值部分的默认值做修改
        setMeasuredDimension(
                measureWith(widthMeasureSpec),
                measureHeight(heightMeasureSpec)
        );
    }
    private int measureWith (int measureSpec){
        int result = 0;
        //通过MeasureSpec.getMode（）方法获取前两位数据（测量模式）
        int specMode = MeasureSpec.getMode(measureSpec);
        //获取后30位数据
        int specSize = MeasureSpec.getSize(measureSpec);

        if(specMode == MeasureSpec.EXACTLY){
            result = specSize;
        }else {
            result = 200;
            if (specMode == MeasureSpec.AT_MOST){
                result = Math.min(result,specSize);
            }
        }
        return result;
    }
    private int measureHeight (int measureSpec){
        int result = 0;
        //通过MeasureSpec.getMode（）方法获取前两位数据（测量模式）
        int specMode = MeasureSpec.getMode(measureSpec);
        //获取后30位数据
        int specSize = MeasureSpec.getSize(measureSpec);

        if(specMode == MeasureSpec.EXACTLY){
            result = specSize;
        }else {
            result = 200;
            if (specMode == MeasureSpec.AT_MOST){
                result = Math.min(result,specSize);
            }
        }
        return result;
    }
}
