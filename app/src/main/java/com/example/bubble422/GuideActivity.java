package com.example.bubble422;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;
import java.util.List;

public class GuideActivity extends FragmentActivity {
    private List<Fragment> fragmentList;
    private static final int NUM_PAGES = 3;
    private ViewPager2 viewPager2;
    // 适配器，为ViewPager2提供页面
    private FragmentStateAdapter pagerAdapter;

    private Button start_btn;
    private TextView skip_btn;

    private ArrayList<View> dots;
    private View view1, view2, view3;
    private int oldPosition = 0;// 记录上一次点的位置
    private int currentItem; // 当前页面

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //隐藏状态栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_guide);

        initView();
    }

    protected int getLayoutID() {
        return R.layout.activity_guide;
    }

    protected void initListener() {

    }

    protected void initView() {

        dots = new ArrayList<View>();
        dots.add(findViewById(R.id.dot_1));
        dots.add(findViewById(R.id.dot_2));
        dots.add(findViewById(R.id.dot_3));

        //把Fragment添加到List集合里面
        fragmentList = new ArrayList<>();
        fragmentList.add(new Fragment_guide1());
        fragmentList.add(new Fragment_guide2());
        fragmentList.add(new Fragment_guide3());

        viewPager2 = (ViewPager2) findViewById(R.id.gimage);
        pagerAdapter = new ScreenSlidePagerAdapter(this);
        viewPager2.setAdapter(pagerAdapter);
        start_btn = (Button) findViewById(R.id.start_btn);
        skip_btn=(TextView) findViewById(R.id.skip);

        skip_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GuideActivity.this, ChooseidActivity.class);
                startActivity(intent);
                finish();
            }
        });

        start_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //点击进入的时候直接跳转到登录界面
                Intent intent = new Intent(GuideActivity.this, ChooseidActivity.class);
                startActivity(intent);
                finish();
            }
        });

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {

                switch (position){
                    case 0:
                        skip_btn.setVisibility(View.VISIBLE);
                        start_btn.setVisibility(View.INVISIBLE);
                        break;
                    case 1:
                        skip_btn.setVisibility(View.VISIBLE);
                        start_btn.setVisibility(View.INVISIBLE);
                        break;
                    case 2:
                        skip_btn.setVisibility(View.INVISIBLE);
                        start_btn.setVisibility(View.VISIBLE);
                        break;
                }


                dots.get(oldPosition).setBackgroundResource(R.drawable.sharp_point1);
                dots.get(position).setBackgroundResource(R.drawable.sharp_point2);
                oldPosition = position;
                currentItem = position;
                super.onPageSelected(position);
            }
        });
    }


    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onBackPressed() {
        if (viewPager2.getCurrentItem() == 0) {
            super.onBackPressed();
        } else {
            viewPager2.setCurrentItem(viewPager2.getCurrentItem() - 1);
        }
    }

    //自定义的类，继承自FragmentStateAdapter适配器
    private class ScreenSlidePagerAdapter extends FragmentStateAdapter {
        private ScreenSlidePagerAdapter mCurrentFragment;
        public ScreenSlidePagerAdapter(FragmentActivity fa) {
            super(fa);
        }

        //主要是createFragment这个方法
        @Override
        public Fragment createFragment(int position) {
            return new mFragment(position);
        }

        public ScreenSlidePagerAdapter getmCurrentFragment(){
            return mCurrentFragment;
        }

        @Override
        public int getItemCount() {
            return NUM_PAGES;
        }
    }
}