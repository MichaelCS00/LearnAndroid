package com.example.administrator.timecounter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    final String TAG = "MichaelCS";

    //更新基数
    int radix;
    //更新时间间隔
    int span;
    //更新总数
    int total;
    EditText radixText;
    EditText spanText;
    EditText totalText;
    TextView timeCostText;
    Button confirmButton;

    TimeCounter timeCounter;
    String timeCost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        radixText = findViewById(R.id.radix_text);
        spanText = findViewById(R.id.span_text);
        totalText = findViewById(R.id.total_text);
        timeCostText = findViewById(R.id.time_cost_text);
        confirmButton = findViewById(R.id.confirm_button);


        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timeCounter = new TimeCounter(
                        Integer.parseInt(radixText.getText().toString()),
                        Integer.parseInt(spanText.getText().toString()),
                        Integer.parseInt(totalText.getText().toString())

                );
//                Log.i(TAG, "countTimeCost: "+
//                        Integer.parseInt(radixText.getText().toString())+" "+
//                        Integer.parseInt(spanText.getText().toString())+" "+
//                        Integer.parseInt(totalText.getText().toString()));

                timeCounter.countTimeCost();
                timeCost = timeCounter.showTimeCost();
                timeCostText.setText(timeCost);
            }
        });
    }


}
