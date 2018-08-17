package com.example.michaelcs.customview.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.michaelcs.customview.CompositView.ProblemHiddenAnimView;
import com.example.michaelcs.customview.R;

public class HiddenViewActivity extends AppCompatActivity {

    private int openHeight;//伸展高度

    private View hideView;//需要展开隐藏的布局

    private View openButton;//打开detail的向下的方向按钮

    private ProblemHiddenAnimView hiddenAnimUtils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hidden_view);

        hideView = findViewById(R.id.problem_detail);
        openHeight = hideView.getHeight();
        openButton = findViewById(R.id.open_close);
        //hideView.setVisibility(View.GONE);

        hiddenAnimUtils= ProblemHiddenAnimView.newInstance(this,hideView,openButton,openHeight);

        openButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hiddenAnimUtils.toggle();
            }
        });
    }
}
