package com.example.administrator.expandableview.expandableview;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.app.ActivityCompat;

/**
 * Create by MichaelCS on 2018/8/23 18:16
 * Email: junhong@turingpic.com
 */
public class questionsViewBuilder implements expandableViewBuilder {

    ExpandableView expandableView;

    public questionsViewBuilder(Context context) {
        expandableView = new ExpandableView(context);
    }

    @Override
    public questionsViewBuilder setContent(String question, String solution) {
        expandableView.setContent(question,solution);
        return this;
    }

    @Override
    public questionsViewBuilder setRightButton(Drawable bounds, Drawable RightButtonIcon, String RightButtonText, Activity rightButtonActivity) {
        expandableView.setRightButton(bounds,RightButtonIcon,RightButtonText,rightButtonActivity);
        return this;
    }

    @Override
    public questionsViewBuilder setClickedRightButton(Drawable onClickedBounds, Drawable onClickedRightButtonIcon, String onClickedRightButtonText) {
        expandableView.setClickedRightButton(onClickedBounds,onClickedRightButtonIcon,onClickedRightButtonText);
        return this;
    }

    @Override
    public questionsViewBuilder setLeftButton(Drawable bounds, Drawable LeftButtonIcon, String LeftButtonText, Activity leftButtonActivity) {
        expandableView.setLeftButton(bounds,LeftButtonIcon, LeftButtonText,leftButtonActivity);
        return this;
    }

    @Override
    public questionsViewBuilder setClickedLeftButton(Drawable onClickedBounds, Drawable onClickedLeftButtonIcon, String onClickedLeftButtonText) {
        expandableView.setClickedLeftButton(onClickedBounds,onClickedLeftButtonIcon,onClickedLeftButtonText);
        return this;
    }

    @Override
    public questionsViewBuilder setExpandButton(Drawable expandButtonImage) {
        expandableView.setExpandButton(expandButtonImage);
        return this;
    }

    @Override
    public ExpandableView build() {

        return expandableView;
    }

    @Override
    public questionsViewBuilder setRightButtonTextColor(int RightTextButtonColor, int clickedRightTextButtonColor) {
        expandableView.setClickedRightButtonColor(RightTextButtonColor,clickedRightTextButtonColor);
        return this;
    }

    @Override
    public questionsViewBuilder setLeftButtonTextColor(int leftButtonTextColor, int clickedLeftButtonTextColor) {
        expandableView.setLeftButtonTextColor(leftButtonTextColor,clickedLeftButtonTextColor);
        return this;
    }


}
