package com.example.administrator.expandableview.expandableview;

import android.graphics.drawable.Drawable;

/**
 * Create by MichaelCS on 2018/8/23 18:01
 * Email: junhong@turingpic.com
 */
public interface ExpandableViewBuilder {
    QuestionsItemsBuilder setContent(String title, String detail);

    QuestionsItemsBuilder setRightButton(Drawable bounds, Drawable rightButtonIcon, String rightButtonText);

    QuestionsItemsBuilder setClickedRightButton(Drawable onClickedBounds, Drawable onClickedRightButtonIcon, String onClickedRightButtonText);

    QuestionsItemsBuilder setRightButtonTextColor(int RightButtonTextColor, int clickedRightTextButtonColor);

    QuestionsItemsBuilder setLeftButton(Drawable bounds, Drawable leftButtonIcon, String leftButtonText);

    QuestionsItemsBuilder setClickedLeftButton(Drawable onClickedBounds, Drawable onClickedLeftButtonIcon, String onClickedLeftButtonText);

    QuestionsItemsBuilder setLeftButtonTextColor(int leftButtonTextColor, int clickedLeftButtonTextColor);

    QuestionsItemsBuilder setExpandButton(Drawable expandButtonImage);

    ExpandableView build();
}
