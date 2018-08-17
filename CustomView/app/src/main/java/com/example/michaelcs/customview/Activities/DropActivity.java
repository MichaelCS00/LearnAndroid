//package com.example.michaelcs.customview.Activities;
//
//import android.animation.Animator;
//import android.animation.AnimatorListenerAdapter;
//import android.animation.ValueAnimator;
//import android.app.Activity;
//import android.os.Bundle;
//import android.support.constraint.ConstraintLayout;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageButton;
//import android.widget.LinearLayout;
//
//import com.example.michaelcs.customview.R;
//
///**
// * Create by MichaelCS on 2018/8/17 10:50
// * Email: junhong@turingpic.com
// */
//public class DropActivity extends Activity {
//
//    private LinearLayout mHiddenView;
//    private float mDensity;
//    private int mHiddenViewMeasuredHeight;
//    private ImageButton imageButton ;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.anime_test);
//        imageButton = findViewById(R.id.image_bt);
//        mHiddenView =  findViewById(R.id.constrain2);
//        mHiddenView.setVisibility(View.GONE);
//        mHiddenView.getHeight();
//        // 获取像素密度
//        mDensity = getResources().getDisplayMetrics().density;
//        // 获取布局的高度,40是在XML文件中定义的布局高度
//        mHiddenViewMeasuredHeight = (int) (mDensity * mHiddenView.getHeight() + 0.5);
//        imageButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                llClick(mHiddenView);
//            }
//        });
//    }
//
//    public void llClick(View view) {
//        if (mHiddenView.getVisibility() == View.GONE) {
//            // 打开动画
//            animateOpen();
//        } else {
//            // 关闭动画
//            animateClose();
//        }
//    }
//
//    private void animateClose() {
//        ValueAnimator animator = createDropAnimator(mHiddenView.getHeight(), 0);
//        animator.addListener(new AnimatorListenerAdapter() {
//            @Override
//            public void onAnimationEnd(Animator animation) {
//                mHiddenView.setVisibility(View.GONE);
//            }
//        });
//        animator.start();
//    }
//
//    private void animateOpen() {
//        mHiddenView.setVisibility(View.VISIBLE);
//        ValueAnimator animator = createDropAnimator(0, mHiddenViewMeasuredHeight);
//        animator.start();
//    }
//
//    private ValueAnimator createDropAnimator(int start, int end) {
//        ValueAnimator animator = ValueAnimator.ofInt(start, end);
//        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//            @Override
//            public void onAnimationUpdate(ValueAnimator valueAnimator) {
//                //通过ValueAnimator创建的数值发生器，并由此来改变View的布局属性
//                int value = (int) valueAnimator.getAnimatedValue();
//                ViewGroup.LayoutParams params = mHiddenView.getLayoutParams();
//                params.height = value;
//                mHiddenView.setLayoutParams(params);
//            }
//        });
//        return animator;
//    }
//}
