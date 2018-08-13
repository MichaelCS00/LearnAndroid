package com.example.administrator.viewpagertest;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Random;

/**
 * Create by MichaelCS on 2018/8/13 17:20
 * Email: junhong@turingpic.com
 */
public class BaseFragment extends Fragment {
    private int[] colors = {0xff009999, 0xffc6e2ff, 0xff668b8b, 0xff7A67EE, 0xffCD853F, 0xffEECFA1};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.base_fragment, container, false);

        TextView textView = view.findViewById(R.id.text_view);
        textView.setBackgroundColor(colors[new Random().nextInt(colors.length)]);

        return view;
    }
}
