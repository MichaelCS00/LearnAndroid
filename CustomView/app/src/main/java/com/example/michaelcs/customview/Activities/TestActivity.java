package com.example.michaelcs.customview.Activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
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
public class TestActivity extends AppCompatActivity {
    private ExpandableLayout expandableLayout0;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.anime_test);
        ImageButton imageButton = findViewById(R.id.open_close);
        expandableLayout0 = findViewById(R.id.problem_detail);
        expandableLayout0.setOnExpansionUpdateListener(new ExpandableLayout.OnExpansionUpdateListener() {
            @Override
            public void onExpansionUpdate(float expansionFraction, int state) {
                Log.d("ExpandableLayout0", "State: " + state);
            }
        });
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(expandableLayout0.isExpanded()){
                    expandableLayout0.collapse();
                }else {
                    expandableLayout0.expand();
                }
            }
        });

    }
}
