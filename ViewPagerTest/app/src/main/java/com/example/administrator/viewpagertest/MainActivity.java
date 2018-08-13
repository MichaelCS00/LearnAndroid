package com.example.administrator.viewpagertest;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ViewPager mViewPager;
    TabLayout mTabLayout;
    final String[] mtables = new String[]{
            "标签1","标签2","标签3"
    };
    private ArrayList<Fragment> mFragments;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }
    private void initView(){
        mViewPager = findViewById(R.id.view_pager);
        mTabLayout = findViewById(R.id.table_layout);
    }

    /**
     * 初始化数据
     * 将ChildFragment实例加入到mFragments[]数组列表中
     * 为mViewPager设置Adapter
     * 将mViewPager绑定到mtables
     */
    private void initData(){
        mFragments = new ArrayList<>();
        for (int i= 0;i<mtables.length;i++){
            ListFragment listFragment = ListFragment.newInstance(mtables[i]);
            mFragments.add(listFragment);
        }
        MFragmentAdapter mFragmentAdapter = new MFragmentAdapter(getSupportFragmentManager(),mFragments,mtables);
        mViewPager.setAdapter(mFragmentAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
    }
}
