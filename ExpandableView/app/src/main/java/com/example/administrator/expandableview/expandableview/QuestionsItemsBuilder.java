package com.example.administrator.expandableview.expandableview;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup;

/**
 * Create by MichaelCS on 2018/8/23 18:16
 * Email: junhong@turingpic.com
 */
public class QuestionsItemsBuilder implements ExpandableViewBuilder {

    private ExpandableView questionItemsView;
    private Context context;

    public QuestionsItemsBuilder(Context context) {

        this.context = context;
        questionItemsView = new ExpandableView(context);
    }

    @Override
    public QuestionsItemsBuilder setContent(String question, String solution) {
        questionItemsView.setContent(question,solution);
        return this;
    }

    @Override
    public QuestionsItemsBuilder setRightButton(Drawable bounds, Drawable RightButtonIcon, String RightButtonText) {
        questionItemsView.setRightButton(bounds,RightButtonIcon,RightButtonText);
        return this;
    }

    @Override
    public QuestionsItemsBuilder setClickedRightButton(Drawable onClickedBounds, Drawable onClickedRightButtonIcon, String onClickedRightButtonText) {
        questionItemsView.setClickedRightButton(onClickedBounds,onClickedRightButtonIcon,onClickedRightButtonText);
        return this;
    }

    @Override
    public QuestionsItemsBuilder setLeftButton(Drawable bounds, Drawable LeftButtonIcon, String LeftButtonText) {
        questionItemsView.setLeftButton(bounds,LeftButtonIcon, LeftButtonText);
        return this;
    }

    @Override
    public QuestionsItemsBuilder setClickedLeftButton(Drawable onClickedBounds, Drawable onClickedLeftButtonIcon, String onClickedLeftButtonText) {
        questionItemsView.setClickedLeftButton(onClickedBounds,onClickedLeftButtonIcon,onClickedLeftButtonText);
        return this;
    }

    @Override
    public QuestionsItemsBuilder setExpandButton(Drawable expandButtonImage) {
        questionItemsView.setExpandButton(expandButtonImage);
        return this;
    }

    @Override
    public QuestionsItemsBuilder setRightButtonTextColor(int RightTextButtonColor, int clickedRightTextButtonColor) {
        questionItemsView.setClickedRightButtonColor(RightTextButtonColor,clickedRightTextButtonColor);
        return this;
    }

    @Override
    public QuestionsItemsBuilder setLeftButtonTextColor(int leftButtonTextColor, int clickedLeftButtonTextColor) {
        questionItemsView.setLeftButtonTextColor(leftButtonTextColor,clickedLeftButtonTextColor);
        return this;
    }

    @Override
    public ExpandableView build() {
//        final ViewGroup decorView = (ViewGroup) ((Activity) questionItemsView.getContext()).getWindow().getDecorView();
//        decorView.addView(questionItemsView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        return questionItemsView;
    }


}
