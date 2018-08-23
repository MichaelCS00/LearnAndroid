package com.example.administrator.problemviewtest;

import android.content.Intent;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.administrator.problemviewtest.customview.FeedBackView;



public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    final int COLLAPSE = 0;
    final int EXPANDED = 1;
    final int HELPFUL = 1;
    final int UNHELPFUL = 0;
    final int NONE = -1;

    private int feedBackButtonState = -1;

    final String questions = "你还有什么问题，你哪里有问题？脑子？";
    final String solutions = "你还有什么问题，你哪里有问题？脑子？你还有什么问题，你哪里有问题？脑子？你还有什么问题，你哪里有问题？脑子？你还有什么问题，你哪里有问题？脑子？你还有什么问题，你哪里有问题？脑子？你还有什么问题，你哪里有问题？脑子？你还有什么问题，你哪里有问题？脑子？";
    private FeedBackView feedBackView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        feedBackView = findViewById(R.id.feed_back);

        Button collapse = findViewById(R.id.collapse);
        Button getState = findViewById(R.id.get_state);
        Button showQuestion = findViewById(R.id.show_question);
        Button getButtonState = findViewById(R.id.get_button_state);

        //测试关闭expandableView方法
        collapse.setOnClickListener(this);

        //测试状态获取方法
        getState.setOnClickListener(this);

        //将问题和解决办法设置到对应的位置
        showQuestion.setOnClickListener(this);

        //获取反馈按钮状态
        getButtonState.setOnClickListener(this);
        //测试打开反馈Activity
        feedBackView.setFeedBackButtonListener(new FeedBackView.FeedBackButtonListener() {
            @Override
            public void openFeedBackActivityButton() {
                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent);
            }
        });



    }

    public void showButtonState(){
        //获取反馈按钮状态
        if (feedBackButtonState==UNHELPFUL){
            Toast.makeText(MainActivity.this,"UNHELPFUL",Toast.LENGTH_SHORT).show();
        }else if(feedBackButtonState==HELPFUL){
            Toast.makeText(MainActivity.this,"HELPFUL",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(MainActivity.this,"NONE",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.collapse:
                feedBackView.collapse();
                break;
            case R.id.get_state:
                Toast.makeText(MainActivity.this,"state:"+feedBackView.getState(),Toast.LENGTH_SHORT).show();
                break;
            case R.id.get_button_state:
                feedBackButtonState = feedBackView.getButtonState();
                showButtonState();
                break;
            case R.id.show_question:
                feedBackView.setContent(questions, solutions);
                break;
            default:
                break;
        }
    }
}
