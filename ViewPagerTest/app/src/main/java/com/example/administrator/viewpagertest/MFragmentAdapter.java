package com.example.administrator.viewpagertest;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Create by MichaelCS on 2018/8/13 15:58
 * Email: junhong@turingpic.com
 */
public class MFragmentAdapter extends FragmentPagerAdapter {

    List<Fragment> mFragment = new ArrayList<>();
    String[] mtitles;

    public MFragmentAdapter(FragmentManager fm,List<Fragment> Fragments,String[] mtitles){
        super(fm);
        this.mFragment = Fragments;
        this.mtitles = mtitles;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragment.get(position);
    }

    @Override
    public int getCount() {
        return mFragment.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mtitles[position];
    }
}
