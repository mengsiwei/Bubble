package com.example.bubble422;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ChooseLoRActivity extends AppCompatActivity {

    private Button btn_login;
    private Button btn_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_loginorregister);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        btn_login=(Button) findViewById(R.id.login);
        btn_register=(Button) findViewById(R.id.register);

        Intent i=getIntent();
        String strId=i.getStringExtra("id");
        Log.e("111",strId);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ChooseLoRActivity.this,LoginActivity.class);
                Log.e("有账号","登录");
                intent.putExtra("id1",strId);
                Log.e("id",strId);
                startActivity(intent);
            }
        });

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("没账号","注册");
                Intent intent=new Intent(ChooseLoRActivity.this,RegisterActivity.class);
                intent.putExtra("id1",strId);
                startActivity(intent);
            }
        });

    }


}