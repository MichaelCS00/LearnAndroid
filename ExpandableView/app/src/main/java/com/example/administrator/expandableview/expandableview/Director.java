package com.example.administrator.expandableview.expandableview;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.app.ActivityCompat;

import com.example.administrator.expandableview.R;

/**
 * Create by MichaelCS on 2018/8/24 18:21
 * Email: junhong@turingpic.com
 */
public class Director {
    public Director(expandableViewBuilder builder,Activity activity,Activity intentActivity) {

        builder.setClickedLeftButton(
                activity.getResources().getDrawable(R.drawable.bounds_sel),
                activity.getResources().getDrawable(R.mipmap.happy),
                "有帮助"
        );
        builder.setClickedRightButton(
                activity.getResources().getDrawable(R.drawable.bounds_sel),
                activity.getResources().getDrawable(R.mipmap.sad),
                "没帮助，去反馈"
        );
        builder.setContent(" "," ");
        builder.setExpandButton(
                activity.getResources().getDrawable(R.mipmap.open_detail)
        );
        builder.setLeftButton(
                activity.getResources().getDrawable(R.drawable.bounds),
                activity.getResources().getDrawable(R.mipmap.happy_bfbfbf),
                "有帮助",
                null
        );
        builder.setRightButton(
                activity.getResources().getDrawable(R.drawable.bounds),
                activity.getResources().getDrawable(R.mipmap.sad_gray),
                "没帮助，去反馈",
                intentActivity
        );
        builder.setLeftButtonTextColor(
                activity.getResources().getColor(R.color.buttonBounds_light),
                activity.getResources().getColor(R.color.colorAccent)
        );
        builder.setRightButtonTextColor(
                activity.getResources().getColor(R.color.buttonBounds_light),
                activity.getResources().getColor(R.color.colorAccent)
        );
        builder.build();
    }
}
