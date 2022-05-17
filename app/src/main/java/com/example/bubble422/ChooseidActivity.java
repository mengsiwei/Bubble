package com.example.bubble422;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class ChooseidActivity extends AppCompatActivity {
    Button choose_huanzhe_btn;
    Button choose_doctor_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chooseid);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        choose_doctor_btn=(Button)findViewById(R.id.chooseid_doctor);
        choose_doctor_btn.setBackgroundResource(R.mipmap.chooseid_doctor_yuanjiao);
        choose_huanzhe_btn=(Button)findViewById(R.id.chooseid_huanzhe);
        choose_huanzhe_btn.setBackgroundResource(R.mipmap.chooseid_huanzhe_yuanjiao);

        choose_doctor_btn.setOnClickListener(this::onClick);
        choose_huanzhe_btn.setOnClickListener(this::onClick);
    }

    private void onClick(View view) {
        switch (view.getId()) {
            case R.id.chooseid_huanzhe:
                Intent intent1 =new Intent(this,ChooseLoRActivity.class);
                intent1.putExtra("id","0");
                startActivity(intent1);
                Log.e("choose","患者登录");

                break;
            case R.id.chooseid_doctor:
                Intent intent2 =new Intent(this,ChooseLoRActivity.class);
                intent2.putExtra("id","1");
                startActivity(intent2);
                Log.e("choose","医生登录");
                break;
            default:
                break;
        }
    }
}