package com.example.bubble422;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;


/**
 * 第一个页面的Fragment的JAVA类
 */
public class Fragment_guide1 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_guide1, null);
        //得到第一张图片的控件对象
        RelativeLayout guide1 =v.findViewById(R.id.content);
        GifImageView gifImageView=v.findViewById(R.id.gif1);
        gifImageView.setVisibility(View.VISIBLE);

        return v;
    }

}
