package com.example.michaelcs.customview.Activities;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.michaelcs.customview.ExpandableView.ExpandableLayout;
import com.example.michaelcs.customview.R;

/**
 * Create by MichaelCS on 2018/8/17 10:46
 * Email: junhong@turingpic.com
 */
public class TestActivity extends AppCompatActivity implements View.OnClickListener, ExpandableLayout.OnExpansionUpdateListener {
    private ExpandableLayout expandableLayout0;
    private ImageButton imageButton;
    private ConstraintLayout problem;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.anime_test);
        imageButton = findViewById(R.id.open_close);
        problem = findViewById(R.id.problem);
        expandableLayout0 = findViewById(R.id.problem_detail);

        //给布局设置动画监听器
        expandableLayout0.setOnExpansionUpdateListener(this);
        problem.setOnClickListener(this);
        imageButton.setOnClickListener(this);

//        expandableLayout0.setVisibility(View.GONE);
//        expandableLayout0.setOnExpansionUpdateListener(new ExpandableLayout.OnExpansionUpdateListener() {
//            @Override
//            public void onExpansionUpdate(float expansionFraction, int state) {
//                Log.d("ExpandableLayout0", "State: " + state);
//            }
//        });
//        imageButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.i("Michael", "onClick: ");
//
//                if(expandableLayout0.isExpanded()){
//                    expandableLayout0.collapse();
//                }else {
//                    expandableLayout0.expand();
//                }
//            }
//        });

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
