package com.example.bubble422;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.SeekBar;

import com.airbnb.lottie.LottieAnimationView;
//discarded
public class ActivityHuanzheShouye extends AppCompatActivity {
    public static LottieAnimationView bubble;
    private String strColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_huanzhe_shouye);

        bubble=findViewById(R.id.bubble);
        bubble.setOnClickListener(new DoubleClickListener() {
            @Override
            public void onDoubleClick(View v) {
                showBottomDialog();
            }
        });
    }


    public  abstract static class DoubleClickListener implements View.OnClickListener {
        private static final long DOUBLE_TIME = 1000;
        private static long lastClickTime = 0;

        @Override
        public void onClick(View v) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - lastClickTime < DOUBLE_TIME) {
                onDoubleClick(v);
            }
            lastClickTime = currentTimeMillis;
        }

        public abstract void onDoubleClick(View v);
    }

    private void showBottomDialog() {
        //1、使用Dialog、设置style
        final Dialog editbubbledialog = new Dialog(this, R.style.eidt_bubble_dialog);
        //2、设置布局
        View view = View.inflate(this, R.layout.edit_bubble_dialog, null);
        editbubbledialog.setContentView(view);

        Window window = editbubbledialog.getWindow();
        //设置弹出位置
        window.setGravity(Gravity.BOTTOM);
        //设置弹出动画
        window.setWindowAnimations(R.style.dialogstyle);
        //设置对话框大小
        window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        editbubbledialog.show();
        Button color1,color2,color3,color4,color5;
        color1=view.findViewById(R.id.bubble_color_1);
        color2=view.findViewById(R.id.bubble_color_2);
        color3=view.findViewById(R.id.bubble_color_3);
        color4=view.findViewById(R.id.bubble_color_4);
        color5=view.findViewById(R.id.bubble_color_5);
        String strColor1 =color1.getText().toString();
        String strColor2 =color2.getText().toString();
        String strColor3 =color3.getText().toString();
        String strColor4 =color4.getText().toString();
        String strColor5 =color5.getText().toString();


        color1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strColor=strColor1;
//                bubble.setImageAssetsFolder("color1/");
                ActivityHuanzheShouye.bubble.playAnimation();

            }
        });

        color2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strColor=strColor2;
//                bubble.setImageAssetsFolder("color2/");
                ActivityHuanzheShouye.bubble.playAnimation();

            }
        });

        color3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strColor=strColor3;
//                bubble.setImageAssetsFolder("color3/");
                ActivityHuanzheShouye.bubble.playAnimation();

            }
        });

        color4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strColor=strColor4;
//                bubble.setImageAssetsFolder("color4/");
                ActivityHuanzheShouye.bubble.playAnimation();

            }
        });

        color5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strColor=strColor5;
//                bubble.setImageAssetsFolder("color5/");
                ActivityHuanzheShouye.bubble.playAnimation();

            }
        });

        SeekBar seekBar_v = (SeekBar)view.findViewById(R.id.seekBar_v);
        seekBar_v.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                switch (progress){
                    case 10:
                        if (strColor.equals(strColor1.toString())){
                            ActivityHuanzheShouye.bubble.setAnimation(".lottie1/leve1.json");
                        }
                        if (strColor.equals(strColor2.toString())){
                            ActivityHuanzheShouye.bubble.setAnimation(".lottie2/leve1.json");
                        }
                        if (strColor.equals(strColor3.toString())){
                            ActivityHuanzheShouye.bubble.setAnimation(".lottie3/leve1.json");
                        }
                        if (strColor.equals(strColor4.toString())){
                            ActivityHuanzheShouye.bubble.setAnimation(".lottie4/leve1.json");
                        }
                        if (strColor.equals(strColor5.toString())){
                            ActivityHuanzheShouye.bubble.setAnimation(".lottie5/leve1.json");
                        }
                        Log.e("1", "1");
//                        ActivityHuanzheShouye.bubble.setAnimation(".lottie1/1_1.json");
                        ActivityHuanzheShouye.bubble.playAnimation();
                        break;
                    case 30:
                        if (strColor.equals(strColor1.toString())){
                            ActivityHuanzheShouye.bubble.setAnimation(".lottie1/leve2.json");
                        }
                        if (strColor.equals(strColor2.toString())){
                            ActivityHuanzheShouye.bubble.setAnimation(".lottie2/leve2.json");
                        }
                        if (strColor.equals(strColor3.toString())){
                            ActivityHuanzheShouye.bubble.setAnimation(".lottie3/leve2.json");
                        }
                        if (strColor.equals(strColor4.toString())){
                            ActivityHuanzheShouye.bubble.setAnimation(".lottie4/leve2.json");
                        }
                        if (strColor.equals(strColor5.toString())){
                            ActivityHuanzheShouye.bubble.setAnimation(".lottie5/leve2.json");
                        }
                        Log.e("2", "2");
//                        ActivityHuanzheShouye.bubble.setAnimation("2/1_2.json");
                        ActivityHuanzheShouye.bubble.playAnimation();
                        break;
                    case 50:
                        if (strColor.equals(strColor1.toString())){
                            ActivityHuanzheShouye.bubble.setAnimation(".lottie1/leve3.json");
                        }
                        if (strColor.equals(strColor2.toString())){
                            ActivityHuanzheShouye.bubble.setAnimation(".lottie2/leve3.json");
                        }
                        if (strColor.equals(strColor3.toString())){
                            ActivityHuanzheShouye.bubble.setAnimation(".lottie3/leve3.json");
                        }
                        if (strColor.equals(strColor4.toString())){
                            ActivityHuanzheShouye.bubble.setAnimation(".lottie4/leve3.json");
                        }
                        if (strColor.equals(strColor5.toString())){
                            ActivityHuanzheShouye.bubble.setAnimation(".lottie5/leve3.json");
                        }
                        Log.e("3", "3");
//                        ActivityHuanzheShouye.bubble.setAnimation("3/1_3.json");
                        ActivityHuanzheShouye.bubble.playAnimation();
                        break;
                    case 80:
                        if (strColor.equals(strColor1.toString())){
                            ActivityHuanzheShouye.bubble.setAnimation(".lottie1/leve4.json");
                        }
                        if (strColor.equals(strColor2.toString())){
                            ActivityHuanzheShouye.bubble.setAnimation(".lottie2/leve4.json");
                        }
                        if (strColor.equals(strColor3.toString())){
                            ActivityHuanzheShouye.bubble.setAnimation(".lottie3/leve4.json");
                        }
                        if (strColor.equals(strColor4.toString())){
                            ActivityHuanzheShouye.bubble.setAnimation(".lottie4/leve4.json");
                        }
                        if (strColor.equals(strColor5.toString())){
                            ActivityHuanzheShouye.bubble.setAnimation(".lottie5/leve4.json");
                        }
                        Log.e("4", "4");
//                        ActivityHuanzheShouye.bubble.setAnimation("4/1_4.json");
                        ActivityHuanzheShouye.bubble.playAnimation();
                        break;
                    case 100:
                        if (strColor.equals(strColor1.toString())){
                            ActivityHuanzheShouye.bubble.setAnimation(".lottie1/leve5.json");
                        }
                        if (strColor.equals(strColor2.toString())){
                            ActivityHuanzheShouye.bubble.setAnimation(".lottie2/leve5.json");
                        }
                        if (strColor.equals(strColor3.toString())){
                            ActivityHuanzheShouye.bubble.setAnimation(".lottie3/leve5.json");
                        }
                        if (strColor.equals(strColor4.toString())){
                            ActivityHuanzheShouye.bubble.setAnimation(".lottie4/leve5.json");
                        }
                        if (strColor.equals(strColor5.toString())){
                            ActivityHuanzheShouye.bubble.setAnimation(".lottie5/leve5.json");
                        }
                        Log.e("5", "5");
//                        ActivityHuanzheShouye.bubble.setAnimation("5/1_5.json");
                        ActivityHuanzheShouye.bubble.playAnimation();
                        break;
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //触碰SeekBar
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                //放开SeekBar
            }
        });

        editbubbledialog.findViewById(R.id.edit_bubble_finish).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("finish", "finish");
                editbubbledialog.dismiss();
            }
        });

    }


}