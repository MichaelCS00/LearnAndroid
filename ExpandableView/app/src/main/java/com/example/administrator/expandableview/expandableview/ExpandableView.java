package com.example.administrator.expandableview.expandableview;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.ActivityCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.expandableview.R;

import static com.example.administrator.expandableview.expandableview.ExpandableLayout.State.COLLAPSED;
import static com.example.administrator.expandableview.expandableview.ExpandableLayout.State.COLLAPSING;
import static com.example.administrator.expandableview.expandableview.ExpandableLayout.State.EXPANDED;
import static com.example.administrator.expandableview.expandableview.ExpandableLayout.State.EXPANDING;


public class ExpandableView extends FrameLayout implements View.OnClickListener, ExpandableLayout.OnExpansionUpdateListener {

    final String TAG = "MichaelCS";

    //todo 整理变量名称，需要再抽象一层


    @Override
    public Resources getResources() {
        return super.getResources();
    }

    //左右两边按钮状态
    private int HELPFUL = 1;
    private int UNHELPFUL = 0;
    private int NONE = -1;
    private int state =-1;
    //可展开部分
    private ExpandableLayout expandableLayout;
    private TextView detailText;
    private String detail;
    //直接显示部分
    private ConstraintLayout titleContainer;
    private TextView titleText;
    private String title;
    //展开按钮
    private ImageButton expandButton;
    private Drawable expandButtonImage;
    //左侧按钮
    private LinearLayout helpful;
    private ImageView helpfulImage;
    private TextView helpfulText;
    private Drawable leftButtonImage;
    private Drawable clickedLeftButtonImage;
    private String leftButtonText;
    private String clickedLeftButtonText;
    private Drawable leftButtonBounds;
    private Drawable clickedLeftButtonBounds;
    //右侧按钮
    private LinearLayout unhelpful;
    private ImageView unhelpfulImage;
    private TextView unhelpfulText;
    private Drawable rightButtonImage;
    private Drawable clickedRightButtonImage;
    private String rightButtonText;
    private String clickedRightButtonText;
    private Drawable rightButtonBounds;
    private Drawable clickedRightButtonBounds;
    //左侧按钮点击后的颜色
    private int leftButtonTextColor;
    private int clickedLeftButtonTextColor;
    //右侧按钮点击后的颜色
    private int rightButtonTextColor;
    private int clickedRightButtonTextColor;
    //按钮监听
    FeedBackButtonListener listener;

    /**
     * 设置展开按钮
     * @param expandButton
     */
    public void setExpandButton(Drawable expandButton){
        this.expandButtonImage = expandButton;
    }

    /**
     * 设置左侧按钮
     * @param leftButtonBounds
     * @param leftButtonImage
     * @param leftButtonText
     */
    public void setLeftButton(Drawable leftButtonBounds,Drawable leftButtonImage,String leftButtonText){
        this.leftButtonBounds=leftButtonBounds;
        this.leftButtonImage=leftButtonImage;
        this.leftButtonText=leftButtonText;
    }

    /**
     * 设置右侧按钮
     * @param rightButtonBounds
     * @param rightButtonImage
     * @param rightButtonText
     */
    public void setRightButton(Drawable rightButtonBounds,Drawable rightButtonImage,String rightButtonText){
        this.rightButtonBounds=rightButtonBounds;
        this.rightButtonImage=rightButtonImage;
        this.rightButtonText=rightButtonText;
    }

    /**
     * 设置标题和具体内容
     * @param title 问题
     * @param detail 解决办法
     */
    public void setContent(String title, String detail){
        this.title = title;
        this.detail = detail;
    }

    /**
     * 设置点击后的左侧按钮
     * @param onClickedBounds
     * @param onClickedLeftButtonIcon
     * @param onClickedLeftButtonText
     */
    public void setClickedLeftButton(Drawable onClickedBounds, Drawable onClickedLeftButtonIcon, String onClickedLeftButtonText) {
        this.clickedLeftButtonBounds = onClickedBounds;
        this.clickedLeftButtonImage = onClickedLeftButtonIcon;
        this.clickedLeftButtonText = onClickedLeftButtonText;
    }
    /**
     * 设置点击后的右侧按钮
     * @param onClickedBounds
     * @param onClickedRightButtonIcon
     * @param onClickedRightButtonText
     */
    public void setClickedRightButton(Drawable onClickedBounds, Drawable onClickedRightButtonIcon, String onClickedRightButtonText){
        this.clickedRightButtonBounds = onClickedBounds;
        this.clickedRightButtonImage = onClickedRightButtonIcon;
        this.clickedRightButtonText = onClickedRightButtonText;
    }


    /**
     * 设置点击后左侧按钮的颜色
     * @param clickedLeftButtonColor
     */
    public void setLeftButtonTextColor(int leftButtonTextColor, int clickedLeftButtonColor){
        this.leftButtonTextColor = leftButtonTextColor;
        this.clickedLeftButtonTextColor = clickedLeftButtonColor;
    }

    /**
     * 点击后右侧的按钮的颜色
     * @param clickedRightButtonColor
     */
    public void setClickedRightButtonColor(int rightButtonTextColor,int clickedRightButtonColor){
        this.rightButtonTextColor = rightButtonTextColor;
        this.clickedRightButtonTextColor = clickedRightButtonColor;
    }

    /**
     * 获取布局组件
     * @param context
     */
    private void initView(Context context){

        LayoutInflater.from(context).inflate(R.layout.feed_back_view,this);

        titleContainer = findViewById(R.id.question_container);
        if (titleContainer!=null){
            Log.i(TAG, "initView: inflated");
        }
        expandButton = findViewById(R.id.open_close);

        expandableLayout = findViewById(R.id.solution_detail);
        titleText = findViewById(R.id.question);
        detailText = findViewById(R.id.solution);

        //左侧按钮
        helpful = findViewById(R.id.helpful);
        helpfulImage = findViewById(R.id.helpful_image);
        helpfulText = findViewById(R.id.helpful_text);

        //右侧按钮
        unhelpful = findViewById(R.id.unhelpful);
        unhelpfulImage = findViewById(R.id.unhelpful_image);
        unhelpfulText = findViewById(R.id.unhelpful_text);

    }

    /**
     * 初始化数据
     */
    private void initData(){
        expandButton.setBackground(expandButtonImage);

        titleText.setText(title);
        detailText.setText(detail);

        helpful.setBackground(leftButtonBounds);
        helpfulImage.setImageDrawable(leftButtonImage);
        helpfulText.setText(leftButtonText);
        helpfulText.setTextColor(leftButtonTextColor);

        unhelpful.setBackground(rightButtonBounds);
        unhelpfulImage.setImageDrawable(rightButtonImage);
        unhelpfulText.setText(rightButtonText);
        unhelpfulText.setTextColor(rightButtonTextColor);

    }
    /**
     * 默认构造器
     * @param context 传入一个上下文，一般为Activity
     */
    public ExpandableView(Context context) {
        super(context);

        //获取部件
        initView(context);
        //初始化数据
        initData();
        //给布局设置动画监听器
        expandableLayout.setOnExpansionUpdateListener(this);

        titleContainer.setOnClickListener(this);
        expandButton.setOnClickListener(this);

        helpful.setOnClickListener(this);
        unhelpful.setOnClickListener(this);
    }

    /**
     * 带属性的构造器
     * @param context 上下文
     * @param attrs 属性文件
     */
    public ExpandableView(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.feed_back_view,this);
        expandButton = findViewById(R.id.open_close);
        titleContainer = findViewById(R.id.question_container);
        expandableLayout = findViewById(R.id.solution_detail);
        titleText = findViewById(R.id.question);
        detailText = findViewById(R.id.solution);

        //左侧按钮
        helpful = findViewById(R.id.helpful);
        helpfulImage = findViewById(R.id.helpful_image);
        helpfulText = findViewById(R.id.helpful_text);

        //右侧按钮
        unhelpful = findViewById(R.id.unhelpful);
        unhelpfulImage = findViewById(R.id.unhelpful_image);
        unhelpfulText = findViewById(R.id.unhelpful_text);

        //给布局设置动画监听器
        expandableLayout.setOnExpansionUpdateListener(this);

        titleContainer.setOnClickListener(this);
        expandButton.setOnClickListener(this);

        helpful.setOnClickListener(this);
        unhelpful.setOnClickListener(this);

    }


    /**
     * 开启Activity的接口
     */
    public interface FeedBackButtonListener{
        void openRightButtonActivity();
        void openLeftButtonActivity();
    }


    /**

    /**
     * 获取按钮状态
     * @return 返回按钮当前状态
     */
    public int getButtonState(){
        return state;
    }
    /**
     * 设置按钮状态
     * 只设置HELPFUL的状态
     * @param state HELPFUL=1,UNHELPFUL=0,NONE=-1
     */
    public void setState(int state){
        this.state=state;
    }

    /**
     * 关闭拓展view
     */
    public void collapse() {
        expandableLayout.collapse();
    }
    /**
     * 获取当前下拉框的状态
     * @return false:未展开，true:已展开
     */
    public boolean getState() {
        return expandableLayout.getState() != 0 && expandableLayout.getState() != 1;
    }
    /**
     * 当左侧按钮按钮被点击时
     * 改变按钮状态
     */
    public void onHelpfulButtonClicked(){
        if (state==NONE||state==UNHELPFUL){
            //点亮左侧按钮
            this.helpful.setBackground(clickedLeftButtonBounds);
            this.helpfulImage.setImageDrawable(clickedLeftButtonImage);
            this.helpfulText.setText(clickedLeftButtonText);
            this.helpfulText.setTextColor(clickedLeftButtonTextColor);
            //熄灭右侧按钮
            this.unhelpful.setBackground(rightButtonBounds);
            this.unhelpfulImage.setImageDrawable(rightButtonImage);
            this.unhelpfulText.setText(rightButtonText);
            this.unhelpfulText.setTextColor(rightButtonTextColor);
            state=HELPFUL;
        }else{
            //左侧按钮已经点亮的情况下再次点击，熄灭左侧按钮
            this.helpful.setBackground(leftButtonBounds);
            this.helpfulImage.setImageDrawable(leftButtonImage);
            this.helpfulText.setText(leftButtonText);
            this.helpfulText.setTextColor(leftButtonTextColor);
            state=NONE;
        }
        //开启Activity
        listener.openLeftButtonActivity();
    }
    /**
     * 当右侧按钮按钮被点击时
     * 改变按钮状态
     */
    public void onUnhelpfulButtonClicked(){
        if (state==HELPFUL||state==NONE){
            //点亮右侧按钮
            this.unhelpful.setBackground(clickedRightButtonBounds);
            this.unhelpfulImage.setImageDrawable(clickedRightButtonImage);
            this.unhelpfulText.setText(clickedRightButtonText);
            this.unhelpfulText.setTextColor(clickedRightButtonTextColor);
            //熄灭左侧按钮
            this.helpful.setBackground(leftButtonBounds);
            this.helpfulImage.setImageDrawable(leftButtonImage);
            this.helpfulText.setText(leftButtonText);
            this.helpfulText.setTextColor(leftButtonTextColor);
            state=UNHELPFUL;
        }
        //开启Activity
        listener.openRightButtonActivity();
    }

    /**
     * 根据下拉动画的完成百分比
     * 来控制下拉按钮的动画旋转角度
     * @param expansionFraction Value between 0 (collapsed) and 1 (expanded) representing the the expansion progress
     * @param state             One of { } repesenting the current expansion state
     */
    @Override
    public void onExpansionUpdate(float expansionFraction, int state) {
        expandButton.setRotation(expansionFraction*180);
    }
    /**
     * 处理点击事件
     * @param v 被点击的组件
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.question_container:
                expandableLayout.toggle();
                break;
            case R.id.open_close:
                expandableLayout.toggle();
                break;
            case R.id.helpful:
                onHelpfulButtonClicked();
                break;
            case R.id.unhelpful:
                onUnhelpfulButtonClicked();
                break;
                default:
                    break;
        }
    }

}

/**
 * 自定义可拓展View
 */
class ExpandableLayout extends FrameLayout {
    public interface State {
        int COLLAPSED = 0;
        int COLLAPSING = 1;
        int EXPANDING = 2;
        int EXPANDED = 3;
    }

    public static final String KEY_SUPER_STATE = "super_state";
    public static final String KEY_EXPANSION = "expansion";

    public static final int HORIZONTAL = 0;
    public static final int VERTICAL = 1;

    private static final int DEFAULT_DURATION = 300;

    private int duration = DEFAULT_DURATION;
    private float parallax;
//    private float defaultParallax;  //默认为子View的高度
    private float expansion;
    private int orientation;
    private int state;

    private Interpolator interpolator = new FastOutSlowInInterpolator();
    private ValueAnimator animator;

    private OnExpansionUpdateListener listener;

    //当前绑定的布局中的控件
    private ExpandableLayout expandableLayout0;
    private ImageButton imageButton;
    private ConstraintLayout problem;

    public ExpandableLayout(Context context) {
        this(context, null);
    }

    public ExpandableLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        if (attrs != null) {
            //获取属性数组
            TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.ExpandableLayout);
            //获取持续时间
            duration = a.getInt(R.styleable.ExpandableLayout_el_duration, DEFAULT_DURATION);
            //获取属性值设置的当前状态是否展开
            expansion = a.getBoolean(R.styleable.ExpandableLayout_el_expanded, false) ? 1 : 0;
            //获取延展方向
            orientation = a.getInt(R.styleable.ExpandableLayout_android_orientation, VERTICAL);
            //获取延展宽度
            parallax = a.getFloat(R.styleable.ExpandableLayout_el_parallax, 1);
            //恢复状态
            a.recycle();
            //获取状态，应该收缩还是延展
            state = expansion == 0 ? COLLAPSED : EXPANDED;
            //设置延展宽度
            setParallax(parallax);
        }
    }

    /**
     * 保存状态
     * @return
     */
    @Override
    protected Parcelable onSaveInstanceState() {
        Parcelable superState = super.onSaveInstanceState();
        Bundle bundle = new Bundle();

        expansion = isExpanded() ? 1 : 0;

        bundle.putFloat(KEY_EXPANSION, expansion);
        //将当前延展状态保存进去
        bundle.putParcelable(KEY_SUPER_STATE, superState);

        return bundle;
    }

    /**
     * 重载状态
     * @param parcelable 包装
     */
    @Override
    protected void onRestoreInstanceState(Parcelable parcelable) {
        Bundle bundle = (Bundle) parcelable;
        expansion = bundle.getFloat(KEY_EXPANSION);
        state = expansion == 1 ? EXPANDED : COLLAPSED;
        Parcelable superState = bundle.getParcelable(KEY_SUPER_STATE);
        super.onRestoreInstanceState(superState);
    }

    /**
     *
     * @param widthMeasureSpec
     * @param heightMeasureSpec
     */

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int width = getMeasuredWidth();
        int height = getMeasuredHeight();

        //确定延展大小是宽度还是长度
        int size = orientation == LinearLayout.HORIZONTAL ? width : height;

        //根据当前延展状态和延展大小判断应该隐藏还是显示
        setVisibility(expansion == 0 && size == 0 ? GONE : VISIBLE);

        //
        int expansionDelta = size - Math.round(size * expansion);
        if (parallax > 0) {
            float parallaxDelta = expansionDelta * parallax;
            for (int i = 0; i < getChildCount(); i++) {
                View child = getChildAt(i);
                if (orientation == HORIZONTAL) {
                    int direction = -1;
                    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN_MR1 && getLayoutDirection() == LAYOUT_DIRECTION_RTL) {
                        direction = 1;
                    }
                    child.setTranslationX(direction * parallaxDelta);
                } else {
                    child.setTranslationY(-parallaxDelta);
                }
            }
        }

        if (orientation == HORIZONTAL) {
            setMeasuredDimension(width - expansionDelta, height);
        } else {
            setMeasuredDimension(width, height - expansionDelta);
        }
    }

    @Override
    protected void onConfigurationChanged(Configuration newConfig) {
        if (animator != null) {
            animator.cancel();
        }
        super.onConfigurationChanged(newConfig);
    }

    /**
     * Get expansion state
     *
     * @return one of {@link State}
     */
    public int getState() {
        return state;
    }

    public boolean isExpanded() {
        return state == EXPANDING || state == EXPANDED;
    }

    public void toggle() {
        toggle(true);
    }

    public void toggle(boolean animate) {
        if (isExpanded()) {
            collapse(animate);
        } else {
            expand(animate);
        }
    }

    public void expand() {
        expand(true);
    }

    public void expand(boolean animate) {
        setExpanded(true, animate);
    }

    public void collapse() {
        collapse(true);
    }

    public void collapse(boolean animate) {
        setExpanded(false, animate);
    }

    /**
     * Convenience method - same as calling setExpanded(expanded, true)
     */
    public void setExpanded(boolean expand) {
        setExpanded(expand, true);
    }

    public void setExpanded(boolean expand, boolean animate) {
        if (expand == isExpanded()) {
            return;
        }

        int targetExpansion = expand ? 1 : 0;
        if (animate) {
            animateSize(targetExpansion);
        } else {
            setExpansion(targetExpansion);
        }
    }

    public int getDuration() {
        return duration;
    }

    public void setInterpolator(Interpolator interpolator) {
        this.interpolator = interpolator;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public float getExpansion() {
        return expansion;
    }

    public void setExpansion(float expansion) {
        if (this.expansion == expansion) {
            return;
        }

        // Infer state from previous value
        float delta = expansion - this.expansion;
        if (expansion == 0) {
            state = COLLAPSED;
        } else if (expansion == 1) {
            state = EXPANDED;
        } else if (delta < 0) {
            state = COLLAPSING;
        } else if (delta > 0) {
            state = EXPANDING;
        }

        setVisibility(state == COLLAPSED ? GONE : VISIBLE);
        this.expansion = expansion;
        requestLayout();

        if (listener != null) {
            listener.onExpansionUpdate(expansion, state);
        }
    }

    public float getParallax() {
        return parallax;
    }

    public void setParallax(float parallax) {
        // Make sure parallax is between 0 and 1
        parallax = Math.min(1, Math.max(0, parallax));
        this.parallax = parallax;
    }

    public int getOrientation() {
        return orientation;
    }

    public void setOrientation(int orientation) {
        if (orientation < 0 || orientation > 1) {
            throw new IllegalArgumentException("Orientation must be either 0 (horizontal) or 1 (vertical)");
        }
        this.orientation = orientation;
    }

    public void setOnExpansionUpdateListener(OnExpansionUpdateListener listener) {
        this.listener = listener;
    }

    private void animateSize(int targetExpansion) {
        if (animator != null) {
            animator.cancel();
            animator = null;
        }

        animator = ValueAnimator.ofFloat(expansion, targetExpansion);
        animator.setInterpolator(interpolator);
        animator.setDuration(duration);

        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                setExpansion((float) valueAnimator.getAnimatedValue());
            }
        });

        animator.addListener(new ExpansionListener(targetExpansion));

        animator.start();
    }

    public interface OnExpansionUpdateListener {
        /**
         * Callback for expansion updates
         *
         * @param expansionFraction Value between 0 (collapsed) and 1 (expanded) representing the the expansion progress
         * @param state             One of {@link State} repesenting the current expansion state
         */
        void onExpansionUpdate(float expansionFraction, int state);
    }

    private class ExpansionListener implements Animator.AnimatorListener {
        private int targetExpansion;
        private boolean canceled;

        public ExpansionListener(int targetExpansion) {
            this.targetExpansion = targetExpansion;
        }

        @Override
        public void onAnimationStart(Animator animation) {
            state = targetExpansion == 0 ? COLLAPSING : EXPANDING;
        }

        @Override
        public void onAnimationEnd(Animator animation) {
            if (!canceled) {
                state = targetExpansion == 0 ? COLLAPSED : EXPANDED;
                setExpansion(targetExpansion);
            }
        }

        @Override
        public void onAnimationCancel(Animator animation) {
            canceled = true;
        }

        @Override
        public void onAnimationRepeat(Animator animation) { }
    }
}

/**
 * 差值器，根据数据间隔调整动画效果
 */
abstract class LookupTableInterpolator implements Interpolator {

    private final float[] mValues;
    private final float mStepSize;

    public LookupTableInterpolator(float[] values) {
        mValues = values;
        mStepSize = 1f / (mValues.length - 1);
    }

    @Override
    public float getInterpolation(float input) {
        if (input >= 1.0f) {
            return 1.0f;
        }
        if (input <= 0f) {
            return 0f;
        }

        // Calculate index - We use min with length - 2 to avoid IndexOutOfBoundsException when
        // we lerp (linearly interpolate) in the return statement
        int position = Math.min((int) (input * (mValues.length - 1)), mValues.length - 2);

        // Calculate values to account for small offsets as the lookup table has discrete values
        float quantized = position * mStepSize;
        float diff = input - quantized;
        float weight = diff / mStepSize;

        // Linearly interpolate between the table values
        return mValues[position] + weight * (mValues[position + 1] - mValues[position]);
    }

}

/**
 * 动画差值器，根据数据表间隔调整动画效果
 */
class FastOutSlowInInterpolator extends LookupTableInterpolator {

    /**
     * Lookup table values sampled with x at regular intervals between 0 and 1 for a total of
     * 201 points.
     */
    private static final float[] VALUES = new float[] {
            0.0000f, 0.0001f, 0.0002f, 0.0005f, 0.0009f, 0.0014f, 0.0020f,
            0.0027f, 0.0036f, 0.0046f, 0.0058f, 0.0071f, 0.0085f, 0.0101f,
            0.0118f, 0.0137f, 0.0158f, 0.0180f, 0.0205f, 0.0231f, 0.0259f,
            0.0289f, 0.0321f, 0.0355f, 0.0391f, 0.0430f, 0.0471f, 0.0514f,
            0.0560f, 0.0608f, 0.0660f, 0.0714f, 0.0771f, 0.0830f, 0.0893f,
            0.0959f, 0.1029f, 0.1101f, 0.1177f, 0.1257f, 0.1339f, 0.1426f,
            0.1516f, 0.1610f, 0.1707f, 0.1808f, 0.1913f, 0.2021f, 0.2133f,
            0.2248f, 0.2366f, 0.2487f, 0.2611f, 0.2738f, 0.2867f, 0.2998f,
            0.3131f, 0.3265f, 0.3400f, 0.3536f, 0.3673f, 0.3810f, 0.3946f,
            0.4082f, 0.4217f, 0.4352f, 0.4485f, 0.4616f, 0.4746f, 0.4874f,
            0.5000f, 0.5124f, 0.5246f, 0.5365f, 0.5482f, 0.5597f, 0.5710f,
            0.5820f, 0.5928f, 0.6033f, 0.6136f, 0.6237f, 0.6335f, 0.6431f,
            0.6525f, 0.6616f, 0.6706f, 0.6793f, 0.6878f, 0.6961f, 0.7043f,
            0.7122f, 0.7199f, 0.7275f, 0.7349f, 0.7421f, 0.7491f, 0.7559f,
            0.7626f, 0.7692f, 0.7756f, 0.7818f, 0.7879f, 0.7938f, 0.7996f,
            0.8053f, 0.8108f, 0.8162f, 0.8215f, 0.8266f, 0.8317f, 0.8366f,
            0.8414f, 0.8461f, 0.8507f, 0.8551f, 0.8595f, 0.8638f, 0.8679f,
            0.8720f, 0.8760f, 0.8798f, 0.8836f, 0.8873f, 0.8909f, 0.8945f,
            0.8979f, 0.9013f, 0.9046f, 0.9078f, 0.9109f, 0.9139f, 0.9169f,
            0.9198f, 0.9227f, 0.9254f, 0.9281f, 0.9307f, 0.9333f, 0.9358f,
            0.9382f, 0.9406f, 0.9429f, 0.9452f, 0.9474f, 0.9495f, 0.9516f,
            0.9536f, 0.9556f, 0.9575f, 0.9594f, 0.9612f, 0.9629f, 0.9646f,
            0.9663f, 0.9679f, 0.9695f, 0.9710f, 0.9725f, 0.9739f, 0.9753f,
            0.9766f, 0.9779f, 0.9791f, 0.9803f, 0.9815f, 0.9826f, 0.9837f,
            0.9848f, 0.9858f, 0.9867f, 0.9877f, 0.9885f, 0.9894f, 0.9902f,
            0.9910f, 0.9917f, 0.9924f, 0.9931f, 0.9937f, 0.9944f, 0.9949f,
            0.9955f, 0.9960f, 0.9964f, 0.9969f, 0.9973f, 0.9977f, 0.9980f,
            0.9984f, 0.9986f, 0.9989f, 0.9991f, 0.9993f, 0.9995f, 0.9997f,
            0.9998f, 0.9999f, 0.9999f, 1.0000f, 1.0000f
    };

    public FastOutSlowInInterpolator() {
        super(VALUES);
    }

}
