package com.example.michaelcs.customview.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.michaelcs.customview.CompositView.TopBar;
import com.example.michaelcs.customview.R;

public class TopBarActivity extends AppCompatActivity {

    TopBar topBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_bar);
        topBar = findViewById(R.id.top_Bar);
        topBar.setOnTopBarClickListener(new TopBar.topBarClickListener(){
            @Override
            public void rightClick() {
                Toast.makeText(TopBarActivity.this,"right",Toast.LENGTH_SHORT).show();
            }
            @Override
            public void leftClick() {
                Toast.makeText(TopBarActivity.this,"left",Toast.LENGTH_SHORT).show();
            }
        });
        //设置右边的按钮不可见
        topBar.setButtonVisable(1,false);
    }
}
