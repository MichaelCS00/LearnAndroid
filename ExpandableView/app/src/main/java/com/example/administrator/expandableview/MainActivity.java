package com.example.administrator.expandableview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;

import com.example.administrator.expandableview.expandableview.Director;
import com.example.administrator.expandableview.expandableview.ExpandableView;
import com.example.administrator.expandableview.expandableview.ExpandableViewBuilder;
import com.example.administrator.expandableview.expandableview.QuestionsItemsBuilder;

public class MainActivity extends AppCompatActivity {

    ExpandableView questionItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        QuestionsItemsBuilder builder = new QuestionsItemsBuilder(this);

//        Director questionItemsDirector = new Director(builder);
//        questionItems = questionItemsDirector.CreateExpandableView(this);

        builder.
                setClickedLeftButton(
                this.getResources().getDrawable(R.drawable.bounds_sel),
                this.getResources().getDrawable(R.mipmap.happy),
                "有帮助"
                )
                .setClickedRightButton(
                this.getResources().getDrawable(R.drawable.bounds_sel),
                this.getResources().getDrawable(R.mipmap.sad),
                "没帮助，去反馈"
                )
                .setContent(
                        " "," "
                )
                .setExpandButton(
                this.getResources().getDrawable(R.mipmap.open_detail)
                )
                .setLeftButton(
                this.getResources().getDrawable(R.drawable.bounds),
                this.getResources().getDrawable(R.mipmap.happy_bfbfbf),
                "有帮助"
                )
                .setRightButton(
                this.getResources().getDrawable(R.drawable.bounds),
                this.getResources().getDrawable(R.mipmap.sad_gray),
                "没帮助，去反馈"
                )
                .setLeftButtonTextColor(
                this.getResources().getColor(R.color.buttonBounds_light),
                this.getResources().getColor(R.color.colorAccent)
                )
                .setRightButtonTextColor(
                this.getResources().getColor(R.color.buttonBounds_light),
                this.getResources().getColor(R.color.colorAccent)
                );

        View decorView = getWindow().getDecorView();

        FrameLayout contentParent =
                (FrameLayout) decorView.findViewById(android.R.id.content);
        contentParent.addView(builder.build());

        //todo 不能显示
    }

}
