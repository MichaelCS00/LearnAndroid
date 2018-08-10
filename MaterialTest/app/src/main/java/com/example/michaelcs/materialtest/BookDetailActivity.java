package com.example.michaelcs.materialtest;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

/**
 * Create by MichaelCS on 2018/8/9 19:09
 * Email: junhong@turingpic.com
 */
public class BookDetailActivity extends AppCompatActivity{
    public static final String BOOK_NAME = "book_name";
    public static final String BOOK_IMAGE_ID = "book_image_id";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.book_detail);
        Intent intent = getIntent();
        String bookName = intent.getStringExtra(BOOK_NAME);
        int bookImageId = intent.getIntExtra(BOOK_IMAGE_ID,0);
        Toolbar toolbar = findViewById(R.id.toolbar);
        CollapsingToolbarLayout collapsingToolbar = findViewById(R.id.collapsing_toolbar);
        ImageView bookImageView = findViewById(R.id.book_image_view);
        TextView bookDetailText = findViewById(R.id.book_detail_text);
        setSupportActionBar(toolbar);
        ActionBar actionBar =getSupportActionBar();
        if(actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        collapsingToolbar.setTitle(bookName);
        Glide.with(this).load(bookImageId).into(bookImageView);
        String bookDetail = generateBookDetail(bookName);
        bookDetailText.setText(bookDetail);
    }
    private String generateBookDetail(String bookName){
        StringBuilder bookDetail = new StringBuilder();
        for (int i = 0; i<500;i++){
            bookDetail.append(bookName);
        }
        return bookDetail.toString();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
