package com.example.bubble422;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

/**
 * 主程序入口，也就是主页
 */
public class FirstActivity extends AppCompatActivity {

    //是否是第一次使用
    private boolean isFirstUse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        initView();
        SharedPreferences preferences = getSharedPreferences("isFirstUse", MODE_PRIVATE);
        isFirstUse = preferences.getBoolean("isFirstUse", true);
        /**
         *如果用户不是第一次使用则直接调转到显示界面,否则调转到引导界面
         */
        if (isFirstUse) {
            startActivity(new Intent(this, GuideActivity.class));
        } else {
            startActivity(new Intent(this, ChooseidActivity.class));
        }
        finish();
        //实例化Editor对象
        SharedPreferences.Editor editor = preferences.edit();
        //存入数据
        editor.putBoolean("isFirstUse", false);
        //提交修改
        editor.commit();
    }

    protected int getLayoutID() {
        return R.layout.activity_first;
    }

    protected void initListener() {

    }

    protected void initView() {

    }

    protected void initData() {

    }
}