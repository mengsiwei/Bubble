package com.example.bubble422;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.SeekBar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.bubble422.wenjuan.WJFragment1;
import com.example.bubble422.wenjuan.WJFragment10;
import com.example.bubble422.wenjuan.WJFragment11;
import com.example.bubble422.wenjuan.WJFragment12;
import com.example.bubble422.wenjuan.WJFragment13;
import com.example.bubble422.wenjuan.WJFragment14;
import com.example.bubble422.wenjuan.WJFragment15;
import com.example.bubble422.wenjuan.WJFragment16;
import com.example.bubble422.wenjuan.WJFragment17;
import com.example.bubble422.wenjuan.WJFragment18;
import com.example.bubble422.wenjuan.WJFragment19;
import com.example.bubble422.wenjuan.WJFragment2;
import com.example.bubble422.wenjuan.WJFragment20;
import com.example.bubble422.wenjuan.WJFragment3;
import com.example.bubble422.wenjuan.WJFragment4;
import com.example.bubble422.wenjuan.WJFragment5;
import com.example.bubble422.wenjuan.WJFragment6;
import com.example.bubble422.wenjuan.WJFragment7;
import com.example.bubble422.wenjuan.WJFragment8;
import com.example.bubble422.wenjuan.WJFragment9;

import java.util.ArrayList;

public class ShowWenjuanActivity extends AppCompatActivity {

    private ViewPager pager;
    private Boolean isPageChanged=false;
    public static SeekBar jindutiao;
    private Button liangbiao_btn;

    int count=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wenjuan_item);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

//获取资源ID
        liangbiao_btn=(Button) findViewById(R.id.liangbiao_back_btn);
        pager = findViewById(R.id.wenjuan);

        jindutiao=findViewById(R.id.progress);

        liangbiao_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        jindutiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        final ArrayList<Fragment> list = new ArrayList<>();

        list.add(new WJFragment1());
        list.add(new WJFragment2());
        list.add(new WJFragment3());
        list.add(new WJFragment4());
        list.add(new WJFragment5());
        list.add(new WJFragment6());
        list.add(new WJFragment7());
        list.add(new WJFragment8());
        list.add(new WJFragment9());
        list.add(new WJFragment10());
        list.add(new WJFragment11());
        list.add(new WJFragment12());
        list.add(new WJFragment13());
        list.add(new WJFragment14());
        list.add(new WJFragment15());
        list.add(new WJFragment16());
        list.add(new WJFragment17());
        list.add(new WJFragment18());
        list.add(new WJFragment19());
        list.add(new WJFragment20());

//内部类adapter

//        pager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
//            @Override
//            public Fragment getItem(int i) {
//                return list.get(i);
//            }
//
//            @Override
//            public int getCount() {
//                return list.size();
//            }
//        });

        pager.setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int i) {
                return list.get(i);
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });

        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            private int position;
            private int oldposition;
            @Override
            public void onPageScrolled(int i, float v, int i1) {
                this.position=i;
            }

            @Override
            public void onPageSelected(int i) {

            }

            @Override
            public void onPageScrollStateChanged(int i) {
                isPageChanged=true;
                switch (i){
                    case 1:
                        oldposition=position;
                        break;
                    case 0:
                        if(position==oldposition){
                            if (position==0){
                                Log.e("p", "左到右");

                            }else if(position==pager.getAdapter().getCount()-1){
                                Log.e("p", "右到左");

                            }else {
                                Log.e("p", "没滑");

                            }
                        }else {
                            if(position<oldposition){
                                Log.e("s", "左到右");
                                count-=1;
                                Log.e("count左滑", String.valueOf(count));
                                jindutiao.setProgress(count);

                            }else {
                                Log.e("s", "右到左");
                                count+=1;
                                Log.e("count右滑", String.valueOf(count));
                                jindutiao.setProgress(count);

                            }
                        }
                        break;
                    default:
                        break;
                }
            }
        });
    }
}