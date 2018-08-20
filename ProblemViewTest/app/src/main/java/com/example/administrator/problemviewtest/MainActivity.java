package com.example.administrator.problemviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.administrator.problemviewtest.customview.FeedBackView;

public class MainActivity extends AppCompatActivity {

    final int COLLAPSE = 0;
    final int EXPANDED = 1;
    private FeedBackView feedBackView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        feedBackView = findViewById(R.id.feed_back);

        Button collapse = findViewById(R.id.collapse);
        Button getState = findViewById(R.id.get_state);
        collapse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                feedBackView.collapse();
            }
        });

        getState.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"state:"+feedBackView.getState(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}
