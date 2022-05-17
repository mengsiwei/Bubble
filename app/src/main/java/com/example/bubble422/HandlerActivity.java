package com.example.bubble422;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.os.Bundle;
import android.view.WindowManager;


public class HandlerActivity extends AppCompatActivity {

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //隐藏状态栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_handler);
        initView();
        handler.sendEmptyMessageDelayed(0, 3000);
    }

    Handler handler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            intent = new Intent(HandlerActivity.this, LoginActivity.class);
            startActivity(intent);
            //执行一次后销毁本页面
            finish();
        }

    };


    protected int getLayoutID() {
        return R.layout.activity_handler;
    }


    protected void initListener() {

    }


    protected void initView() {

    }


    protected void initData() {

    }
}