package com.example.administrator.viewpagertest;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import java.util.ArrayList;
import java.util.List;


/**
 * Create by MichaelCS on 2018/8/13 15:14
 * Email: junhong@turingpic.com
 */
public class ListFragment extends android.support.v4.app.Fragment {

    private final int TITLECOUNT =3;

    private View view;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private List<android.support.v4.app.Fragment> mFragments;
    private String[] titles = {
            "标题1","标题2","标题3"
    };


    static final String key = "key";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.list_fragment,container,false);

        initView();
        initData();
        return view;
    }

    public static ListFragment newInstance(String title) {

        Bundle args = new Bundle();
        args.putString(key,title);
        ListFragment fragment = new ListFragment();
        fragment.setArguments(args);
        return fragment;
    }
    public void initView(){
        mTabLayout = view.findViewById(R.id.child_tab);
        mViewPager = view.findViewById(R.id.child_viewpager);
    }

    /**
     * 将数据组装到ListFragment中
     * 并建立相应的Adapter
     * 将该Adapter设定到ViewPager中
     * 最后还要绑定viewPager到TabLayout
     */
    public void initData(){
        mFragments = new ArrayList<>();
        for (int i=0;i<TITLECOUNT;i++){
            BaseFragment baseFragment = new BaseFragment();
            mFragments.add(baseFragment);
        }
        MFragmentAdapter mFragmentAdapter = new MFragmentAdapter(getFragmentManager(),mFragments,titles);
        mViewPager.setAdapter(mFragmentAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
    }
}
