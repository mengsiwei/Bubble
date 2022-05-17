package com.example.bubble422.wenjuan;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.example.bubble422.R;


/**
 * 第一个页面的Fragment的JAVA类
 */
public class WJFragment3 extends Fragment {
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Boolean isButtonPressed=false;
    private TextView question2;


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_wenjuan3, null);
        question2=(TextView)v.findViewById(R.id.question);

        //得到第一张图片的控件对象
        CardView card1=v.findViewById(R.id.wenjuan2);
        button1=v.findViewById(R.id.button11);
        button2=v.findViewById(R.id.button12);
        button3=v.findViewById(R.id.button13);
        button4=v.findViewById(R.id.button14);

        button1.setOnClickListener(this::onClick);
        button2.setOnClickListener(this::onClick);
        button3.setOnClickListener(this::onClick);
        button4.setOnClickListener(this::onClick);
        question2.setText("I have crying spells or feel like it.");

        return v;
    }

    @SuppressLint("ResourceAsColor")
    public void onClick(View v) {

        switch(v.getId()){

            case R.id.button11:
                button1.setBackgroundResource(R.drawable.wenjuan_btn_s);
                button2.setBackgroundResource(R.drawable.wenjuan_btn_uns);
                button3.setBackgroundResource(R.drawable.wenjuan_btn_uns);
                button4.setBackgroundResource(R.drawable.wenjuan_btn_uns);

                button2.setTextColor(getResources().getColor(R.color.wenjuan_btn_t_un));
                button3.setTextColor(getResources().getColor(R.color.wenjuan_btn_t_un));
                button4.setTextColor(getResources().getColor(R.color.wenjuan_btn_t_un));
                button1.setTextColor(getResources().getColor(R.color.wenjuan_btn_t_s));

                Log.d("button","1");
                break;

            case R.id.button12:
                button2.setBackgroundResource(R.drawable.wenjuan_btn_s);
                button1.setBackgroundResource(R.drawable.wenjuan_btn_uns);
                button3.setBackgroundResource(R.drawable.wenjuan_btn_uns);
                button4.setBackgroundResource(R.drawable.wenjuan_btn_uns);
                button1.setTextColor(getResources().getColor(R.color.wenjuan_btn_t_un));
                button3.setTextColor(getResources().getColor(R.color.wenjuan_btn_t_un));
                button4.setTextColor(getResources().getColor(R.color.wenjuan_btn_t_un));
                button2.setTextColor(getResources().getColor(R.color.wenjuan_btn_t_s));


                Log.d("button","2");
                break;

            case R.id.button13:
                button3.setBackgroundResource(R.drawable.wenjuan_btn_s);
                button2.setBackgroundResource(R.drawable.wenjuan_btn_uns);
                button1.setBackgroundResource(R.drawable.wenjuan_btn_uns);
                button4.setBackgroundResource(R.drawable.wenjuan_btn_uns);
                button1.setTextColor(getResources().getColor(R.color.wenjuan_btn_t_un));
                button2.setTextColor(getResources().getColor(R.color.wenjuan_btn_t_un));
                button4.setTextColor(getResources().getColor(R.color.wenjuan_btn_t_un));
                button3.setTextColor(getResources().getColor(R.color.wenjuan_btn_t_s));


                Log.d("button","3");
                break;

            case R.id.button14:
                button4.setBackgroundResource(R.drawable.wenjuan_btn_s);
                button2.setBackgroundResource(R.drawable.wenjuan_btn_uns);
                button3.setBackgroundResource(R.drawable.wenjuan_btn_uns);
                button1.setBackgroundResource(R.drawable.wenjuan_btn_uns);
                button1.setTextColor(getResources().getColor(R.color.wenjuan_btn_t_un));
                button2.setTextColor(getResources().getColor(R.color.wenjuan_btn_t_un));
                button3.setTextColor(getResources().getColor(R.color.wenjuan_btn_t_un));
                button4.setTextColor(getResources().getColor(R.color.wenjuan_btn_t_s));


                Log.d("button","4");
                break;

        }
    }

}