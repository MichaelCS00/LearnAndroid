package com.example.michaelcs.customview.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.michaelcs.customview.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button viewMeasure = findViewById(R.id.view_measure);
        Button myTextView = findViewById(R.id.my_text_view);
        Button myTextViewSec = findViewById(R.id.my_text_view_sec);
        Button topBarTest = findViewById(R.id.top_Bar_test);
        Button hiddenView = findViewById(R.id.hidden_View);
        Button test = findViewById(R.id.test);
        viewMeasure.setOnClickListener(this);
        myTextView.setOnClickListener(this);
        myTextViewSec.setOnClickListener(this);
        topBarTest.setOnClickListener(this);
        hiddenView.setOnClickListener(this);
        test.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.view_measure:
                intent = new Intent(this,MeasureViewActivity.class);
                startActivity(intent);
                break;
            case R.id.my_text_view:
                intent = new Intent(this,MyTextViewActivity.class);
                startActivity(intent);
                break;
            case R.id.my_text_view_sec:
                intent = new Intent(this,MyTextViewSecActivity.class);
                startActivity(intent);
                break;
            case R.id.top_Bar_test:
                intent = new Intent(this,TopBarActivity.class);
                startActivity(intent);
                break;
            case R.id.hidden_View:
                intent = new Intent(this,HiddenViewActivity.class);
                startActivity(intent);
                break;
            case R.id.test:
                intent = new Intent(this,TestActivity.class);
                startActivity(intent);
                break;
                default:
                    break;
        }
    }
}
