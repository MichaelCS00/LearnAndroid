package com.example.administrator.problemviewtest;

import android.content.Intent;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.administrator.problemviewtest.customview.FeedBackView;



public class MainActivity extends AppCompatActivity {

    final int COLLAPSE = 0;
    final int EXPANDED = 1;
    final String test = "你还有什么问题，你哪里有问题？脑子？";
    final String solutiontest = "你还有什么问题，你哪里有问题？脑子？你还有什么问题，你哪里有问题？脑子？你还有什么问题，你哪里有问题？脑子？你还有什么问题，你哪里有问题？脑子？你还有什么问题，你哪里有问题？脑子？你还有什么问题，你哪里有问题？脑子？你还有什么问题，你哪里有问题？脑子？";
    private FeedBackView feedBackView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        feedBackView = findViewById(R.id.feed_back);

        Button collapse = findViewById(R.id.collapse);
        Button getState = findViewById(R.id.get_state);
        Button showQuestion = findViewById(R.id.show_question);

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

        feedBackView.setFeedBackButtonListener(new FeedBackView.FeedBackButtonListener() {
            @Override
            public void openFeedBackActivityButton() {
                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent);
            }
        });

        showQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                feedBackView.setContent(test,solutiontest);
            }
        });
    }
}
