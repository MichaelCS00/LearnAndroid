package com.example.michaelcs.customview.ExpandableView;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;

import com.example.michaelcs.customview.R;

/**
 * Create by MichaelCS on 2018/8/20 10:14
 * Email: junhong@turingpic.com
 */
public class ProblemView extends ConstraintLayout implements View.OnClickListener, ExpandableLayout.OnExpansionUpdateListener {

    private ExpandableLayout expandableLayout0;
    private ImageButton imageButton;
    private ConstraintLayout problem;

    public ProblemView(Context context) {
        super(context);
    }

    public ProblemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.provlem_view,this);
        imageButton = findViewById(R.id.open_close);
        problem = findViewById(R.id.problem);
        expandableLayout0 = findViewById(R.id.problem_detail);

        //给布局设置动画监听器
        expandableLayout0.setOnExpansionUpdateListener(this);
        problem.setOnClickListener(this);
        imageButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        expandableLayout0.toggle();
    }

    @Override
    public void onExpansionUpdate(float expansionFraction, int state) {
        Log.i("Michael", "onExpansionUpdate: ");
        imageButton.setRotation(expansionFraction*180);
    }
}
