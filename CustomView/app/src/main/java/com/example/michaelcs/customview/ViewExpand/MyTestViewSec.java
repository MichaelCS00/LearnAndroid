package com.example.michaelcs.customview.ViewExpand;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Create by MichaelCS on 2018/8/15 10:58
 * Email: junhong@turingpic.com
 * 实现文字闪耀效果
 */
public class MyTestViewSec extends android.support.v7.widget.AppCompatTextView {

    private float mTranslate;
    private int mViewWidth;
    private Paint mPaint;
    private LinearGradient mLinearGradient;
    private Matrix mGradientMatrix;

    public MyTestViewSec(Context context) {
        super(context);
    }

    public MyTestViewSec(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * 在这个方法中完成一些对象初始化工作
     * 并根据View的宽度设置一个LinearGradient渐变渲染器
     * @param w
     * @param h
     * @param oldw
     * @param oldh
     */
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if(mViewWidth == 0){
            mViewWidth = getMeasuredWidth();
            if (mViewWidth>0){
                //获取当前绘制TextView的Paint对象
                //并给这个对象添加原生TextView没有的LinearGradient属性
                mPaint = getPaint();
                mLinearGradient = new LinearGradient(
                        0,
                        0,
                        mViewWidth,
                        0,
                        new int[]{
                                Color.BLACK,0xfffffff,
                                Color.BLUE
                        },
                        null,
                        Shader.TileMode.MIRROR
                );
                mPaint.setShader(mLinearGradient);
                mGradientMatrix = new Matrix();
            }
        }
    }

    /**
     * 通过矩阵的方式来不断平移渐变效果
     * @param canvas
     */
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //todo???
        if (mGradientMatrix != null){
            //设置每次平移距离
            mTranslate += mViewWidth/5;
            if (mTranslate>2*mViewWidth){
                mTranslate = -mViewWidth;
            }
            //平移矩阵
            mGradientMatrix.setTranslate(mTranslate,0);
            //将渐变梯度设置成矩阵大小
            mLinearGradient.setLocalMatrix(mGradientMatrix);
            //设置平移时间间隔
            postInvalidateDelayed(300);
        }
    }
}
