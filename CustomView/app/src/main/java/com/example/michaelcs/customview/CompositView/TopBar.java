package com.example.michaelcs.customview.CompositView;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.net.sip.SipSession;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.michaelcs.customview.R;

/**
 * Create by MichaelCS on 2018/8/15 13:09
 * Email: junhong@turingpic.com
 * 《组合控件》
 * 这是一个自定义顶部工具栏
 */
public class TopBar extends RelativeLayout {

//    TypedArray typedArray = new TypedArray();
    Context context = this.getContext();
    int mLeftTextColor;
    Drawable mLeftBackground;
    String mLeftText;
    int mRightTextColor;
    Drawable mRightBackground;
    String mRightText;
    float mTitleTextSize;
    int mTileColor;
    String mTitle;

    Button mLeftButton;
    Button mRightButton;
    TextView mTitleView;

    LayoutParams mLeftParams;
    LayoutParams mRightParams;
    LayoutParams mTitleParams;

    topBarClickListener mListener;

    public TopBar(Context context) {
        super(context);
    }

    /**
     * 在构造方法里面完成数据初始化
     * 即从TypeArray中获取出各个属性值
     * @param context
     * @param attrs
     */


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public TopBar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs,R.styleable.TopBar);
        mLeftTextColor = typedArray.getColor(R.styleable.TopBar_leftTextColor,0);
        mLeftBackground = typedArray.getDrawable(R.styleable.TopBar_leftBackground);
        mLeftText = (String) typedArray.getText(R.styleable.TopBar_lefText);

        mRightTextColor = typedArray.getColor(R.styleable.TopBar_rightTextColor,0);
        mRightBackground = typedArray.getDrawable(R.styleable.TopBar_rightBackground);
        mRightText = (String) typedArray.getText(R.styleable.TopBar_rightText);

        mTitleTextSize = typedArray.getDimension(R.styleable.TopBar_titleTextSize,10);
        mTileColor = typedArray.getColor(R.styleable.TopBar_titleTextColor,0);
        mTitle = typedArray.getString(R.styleable.TopBar_title);

        //获取完TypeArray的值后，一般要调用
        //recycle 方法来避免重新创建的时候的错误
        typedArray.recycle();

        mLeftButton = new Button(context);
        mRightButton = new Button(context);
        mTitleView = new TextView(context);

        //为创建的组件赋值
        //值的来源就是我们在引用的xml文件中给对应属性的赋值
        mLeftButton.setTextColor(mLeftTextColor);
        mLeftButton.setBackground(mLeftBackground);
        mLeftButton.setText(mLeftText);

        mRightButton.setTextColor(mRightTextColor);
        mRightButton.setBackground(mRightBackground);
        mRightButton.setText(mRightText);

        mTitleView.setText(mTitle);
        mTitleView.setTextColor(mTileColor);
        mTitleView.setTextSize(mTitleTextSize);
        mTitleView.setGravity(Gravity.CENTER);

        //为组件设置相应的布局元素
        mLeftParams = new LayoutParams(
                LayoutParams.WRAP_CONTENT,
                LayoutParams.MATCH_PARENT
        );
        mLeftParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT,TRUE);
        //添加到ViewGroup
        addView(mLeftButton,mLeftParams);

        mRightParams = new LayoutParams(
                LayoutParams.WRAP_CONTENT,
                LayoutParams.MATCH_PARENT
        );
        mRightParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT,TRUE);
        addView(mRightButton,mRightParams);

        mTitleParams = new LayoutParams(
                LayoutParams.WRAP_CONTENT,
                LayoutParams.MATCH_PARENT
        );
        mTitleParams.addRule(RelativeLayout.CENTER_IN_PARENT,TRUE);
        addView(mTitleView,mTitleParams);



         //按钮的点击事件，不需要具体的实现
         //只需要调用接口的方法，回调的时候，会有具体的实现
        mRightButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.rightClick();
            }
        });
//        mLeftButton.setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mListener.leftClick();
//            }
//        });

    }

    //暴露一个方法来给调用者来注册接口回调
    //通过接口来获得回调者对接口的实现
    public void setOnTopBarClickListener(topBarClickListener mListener){
        this.mListener = mListener;
    }

    //因为外部无法方位mLeftButton变量
    //暴露一个方法给调用者，用来注册回调
    public void setlListener(OnClickListener lListener) {
        //然后给mLeftButton设定系统监听方法，再调用自己在Activity中的具体重写后的实现
        mLeftButton.setOnClickListener(lListener);
    }

    /**
     * 接口对象，实现回调机制，在回调方法中
     * 通过映射的接口对象调用接口中的方法
     * 而不用去考虑如何实现，具体实现由调用者去创建
     */
    public interface topBarClickListener{
        //左按钮点击事件
        void leftClick();
        //右按钮点击事件
        void rightClick();

    }

    public void setButtonVisable(int id,boolean flag){
        if(flag){

            if (id==0){
                mLeftButton.setVisibility(View.VISIBLE);
            }else {
                mRightButton.setVisibility(View.VISIBLE);
            }
        }else {
            if (id==0){
                mLeftButton.setVisibility(View.INVISIBLE);
            }else{
                mRightButton.setVisibility(View.INVISIBLE);
            }
        }
    }


}
