package com.example.administrator.expandableview.expandableview;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.support.v4.app.ActivityCompat;

/**
 * Create by MichaelCS on 2018/8/23 18:01
 * Email: junhong@turingpic.com
 */
public interface expandableViewBuilder {
    questionsViewBuilder setContent(String title, String detail);

    questionsViewBuilder setRightButton(Drawable bounds, Drawable rightButtonIcon, String rightButtonText, Activity rightButtonActivity);

    questionsViewBuilder setClickedRightButton(Drawable onClickedBounds, Drawable onClickedRightButtonIcon, String onClickedRightButtonText);

    questionsViewBuilder setRightButtonTextColor(int RightButtonTextColor, int clickedRightTextButtonColor);

    questionsViewBuilder setLeftButton(Drawable bounds, Drawable leftButtonIcon, String leftButtonText, Activity leftButtonActivity);

    questionsViewBuilder setClickedLeftButton(Drawable onClickedBounds, Drawable onClickedLeftButtonIcon, String onClickedLeftButtonText);

    questionsViewBuilder setLeftButtonTextColor(int leftButtonTextColor, int clickedLeftButtonTextColor);

    questionsViewBuilder setExpandButton(Drawable expandButtonImage);

    ExpandableView build();
}
