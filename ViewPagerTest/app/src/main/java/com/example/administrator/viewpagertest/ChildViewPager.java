package com.example.administrator.viewpagertest;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

/**
 * Create by MichaelCS on 2018/8/13 12:38
 * Email: junhong@turingpic.com
 */
public class ChildViewPager extends ViewPager {
    final String TAG = "MichaelCS";
    public ChildViewPager(@NonNull Context context) {
        super(context);
    }

    public ChildViewPager(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        int curPosition;
        switch (ev.getAction()){
            case MotionEvent.ACTION_DOWN:
                getParent().requestDisallowInterceptTouchEvent(true);
                break;
            case MotionEvent.ACTION_MOVE:
                curPosition = this.getCurrentItem();
                int count = this.getAdapter().getCount();
                if(curPosition == count-1 || curPosition == 0){
                    Log.d(TAG, "dispatchTouchEvent: count"+curPosition);
                    Log.d(TAG, "dispatchTouchEvent: 父亲拦截");
                    //在最后一页和第一页由父亲拦截触摸事件
                    getParent().requestDisallowInterceptTouchEvent(false);
                }else {
                    //其他情况由孩子拦截触摸事件
                    Log.d(TAG, "dispatchTouchEvent: 孩子拦截");
                    getParent().requestDisallowInterceptTouchEvent(true);
                }
                break;
                default:
                    break;
        }
        return super.dispatchTouchEvent(ev);
    }
}
