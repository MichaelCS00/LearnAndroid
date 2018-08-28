package com.example.administrator.expandableview.expandableview;

import android.app.Activity;

import com.example.administrator.expandableview.R;

/**
 * Create by MichaelCS on 2018/8/24 18:21
 * Email: junhong@turingpic.com
 */
public class Director {

    ExpandableViewBuilder builder;

    public Director(ExpandableViewBuilder builder){
        this.builder = builder;
    }

    public ExpandableView CreateExpandableView(Activity activity) {

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
                "有帮助"
        );
        builder.setRightButton(
                activity.getResources().getDrawable(R.drawable.bounds),
                activity.getResources().getDrawable(R.mipmap.sad_gray),
                "没帮助，去反馈"
        );
        builder.setLeftButtonTextColor(
                activity.getResources().getColor(R.color.buttonBounds_light),
                activity.getResources().getColor(R.color.colorAccent)
        );
        builder.setRightButtonTextColor(
                activity.getResources().getColor(R.color.buttonBounds_light),
                activity.getResources().getColor(R.color.colorAccent)
        );
        return builder.build();
    }
}
