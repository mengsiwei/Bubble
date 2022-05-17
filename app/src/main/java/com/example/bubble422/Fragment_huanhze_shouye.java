package com.example.bubble422;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.app.Dialog;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.airbnb.lottie.LottieAnimationView;
import com.example.bubble422.service.DatabaseHelper;
import com.xiaoqi.litedragview.LiteDragHelper;

import java.util.ArrayList;
import java.util.List;

import static com.example.bubble422.DaohanglanActivity.e;
import static com.example.bubble422.RegisterActivity.pphone;


/**
 * 第一个页面的Fragment的JAVA类
 */
public class Fragment_huanhze_shouye extends Fragment {
    DatabaseHelper db;
    SQLiteDatabase sdb;
    public static LottieAnimationView bubble;
    private FrameLayout getadvice1,getadvice2,getadvice3;
    private ImageView face1,face2,face3,face4,face5,face6,face7,advice1_bg,advice2_bg,advice3_bg;
    private LinearLayout lyface;
    private TextView tvtest;
    private String strFace;
    private TextView ad1;
    private TextView ad2;
    private TextView ad3;

    String a1="a1",a2="a2",a3="a3";
    int icolor=3;


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_huanzhe_shouye, null);
//        Intent intent =new Intent(getActivity(),ActivityHuanzheShouye.class);
//        startActivity(intent);

        db=new DatabaseHelper(this.getActivity(),"user.db",null,1);;
        sdb=db.getReadableDatabase();
        Log.e("test","hhh");
        Log.e("phone",pphone);
        Cursor cursor=sdb.rawQuery("select * from user where userphone=?",new String[]{pphone});
        if(cursor==null)
            Log.e("cursor","null");
        else if(cursor.moveToFirst()) {
            a1 = cursor.getString(cursor.getColumnIndex("state"));
            a2 = cursor.getString(cursor.getColumnIndex("advice"));
            a3 = cursor.getString(cursor.getColumnIndex("note"));
        }
        Log.e("test","this");
        lyface=v.findViewById(R.id.facejihe_ly);
        face1=v.findViewById(R.id.imageView_happy);
        face2=v.findViewById(R.id.imageView_surprise);
        face3=v.findViewById(R.id.imageView_scare);
        face4=v.findViewById(R.id.imageView_sad);
        face5=v.findViewById(R.id.imageView_discard);
        face6=v.findViewById(R.id.imageView_angry);
        face7=v.findViewById(R.id.imageView_neutral);

        face1.setImageResource(R.mipmap.happy_2);
        face2.setImageResource(R.mipmap.surprise_2);
        face3.setImageResource(R.mipmap.scare_2);
        face4.setImageResource(R.mipmap.sad_2);
        face5.setImageResource(R.mipmap.discard_2);
        face6.setImageResource(R.mipmap.angry_2);
        face7.setImageResource(R.mipmap.neutral_2);

        face1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                face1.setImageResource(R.mipmap.happy_1);
                face2.setImageResource(R.mipmap.surprise_2);
                face3.setImageResource(R.mipmap.scare_2);
                face4.setImageResource(R.mipmap.sad_2);
                face5.setImageResource(R.mipmap.discard_2);
                face6.setImageResource(R.mipmap.angry_2);
                face7.setImageResource(R.mipmap.neutral_2);
            }
        });

        face2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                face1.setImageResource(R.mipmap.happy_2);
                face2.setImageResource(R.mipmap.surprise_1);
                face3.setImageResource(R.mipmap.scare_2);
                face4.setImageResource(R.mipmap.sad_2);
                face5.setImageResource(R.mipmap.discard_2);
                face6.setImageResource(R.mipmap.angry_2);
                face7.setImageResource(R.mipmap.neutral_2);
            }
        });

        face3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                face1.setImageResource(R.mipmap.happy_2);
                face2.setImageResource(R.mipmap.surprise_2);
                face3.setImageResource(R.mipmap.scare_1);
                face4.setImageResource(R.mipmap.sad_2);
                face5.setImageResource(R.mipmap.discard_2);
                face6.setImageResource(R.mipmap.angry_2);
                face7.setImageResource(R.mipmap.neutral_2);
            }
        });

        face4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                face1.setImageResource(R.mipmap.happy_2);
                face2.setImageResource(R.mipmap.surprise_2);
                face3.setImageResource(R.mipmap.scare_2);
                face4.setImageResource(R.mipmap.sad_1);
                face5.setImageResource(R.mipmap.discard_2);
                face6.setImageResource(R.mipmap.angry_2);
                face7.setImageResource(R.mipmap.neutral_2);
            }
        });

        face5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                face1.setImageResource(R.mipmap.happy_2);
                face2.setImageResource(R.mipmap.surprise_2);
                face3.setImageResource(R.mipmap.scare_2);
                face4.setImageResource(R.mipmap.sad_2);
                face5.setImageResource(R.mipmap.discard_1);
                face6.setImageResource(R.mipmap.angry_2);
                face7.setImageResource(R.mipmap.neutral_2);
            }
        });

        face6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                face1.setImageResource(R.mipmap.happy_2);
                face2.setImageResource(R.mipmap.surprise_2);
                face3.setImageResource(R.mipmap.scare_2);
                face4.setImageResource(R.mipmap.sad_2);
                face5.setImageResource(R.mipmap.discard_2);
                face6.setImageResource(R.mipmap.angry_1);
                face7.setImageResource(R.mipmap.neutral_2);
            }
        });

        face7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                face1.setImageResource(R.mipmap.happy_2);
                face2.setImageResource(R.mipmap.surprise_2);
                face3.setImageResource(R.mipmap.scare_2);
                face4.setImageResource(R.mipmap.sad_2);
                face5.setImageResource(R.mipmap.discard_2);
                face6.setImageResource(R.mipmap.angry_2);
                face7.setImageResource(R.mipmap.neutral_1);
            }
        });

        ad1=v.findViewById(R.id.get_advice1_ft_img);
        ad2=v.findViewById(R.id.get_advice2_ft_img);
        ad3=v.findViewById(R.id.get_advice3_ft_img);

        ad1.setText(a1);
        ad2.setText(a2);
        ad3.setText(a3);
        advice1_bg=v.findViewById(R.id.get_advice1_bg_img);
        advice2_bg=v.findViewById(R.id.get_advice2_bg_img);
        advice3_bg=v.findViewById(R.id.get_advice3_bg_img);

//        tvtest=v.findViewById(R.id.youtv);

        advice1_bg.setImageResource(R.mipmap.gmsg);
        advice2_bg.setImageResource(R.mipmap.gmsg);
        advice3_bg.setImageResource(R.mipmap.gmsg);

        bubble=v.findViewById(R.id.bubble);
        bubble.setOnClickListener(new ActivityHuanzheShouye.DoubleClickListener() {
            @Override
            public void onDoubleClick(View v) {
                showBottomDialog();
            }
        });

        getadvice1=v.findViewById(R.id.get_advice1);

        floatAnim(getadvice1,700);
        LiteDragHelper.bind(getContext(),getadvice1, Color.TRANSPARENT);

        getadvice2=v.findViewById(R.id.get_advice2);
        floatAnim(getadvice2,1100);
        LiteDragHelper.bind(getContext(),getadvice2, Color.TRANSPARENT);

        getadvice3=v.findViewById(R.id.get_advice3);
        floatAnim(getadvice3,1600);
        LiteDragHelper.bind(getContext(),getadvice3, Color.TRANSPARENT);

        getadvice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.e("click","getadvice1");
            }
        });
        getadvice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("click","getadvice2");
            }
        });
        getadvice3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("click","getadvice3");
            }
        });
        return v;
    }

    @Override
    public void onResume(){
        super.onResume();
        bubble.playAnimation();
        switch (e){
            case "Smile":
//                lyface=new LinearLayout(getContext());
                face1.setImageResource(R.mipmap.happy_1);
                face2.setImageResource(R.mipmap.surprise_2);
                face3.setImageResource(R.mipmap.scare_2);
                face4.setImageResource(R.mipmap.sad_2);
                face5.setImageResource(R.mipmap.discard_2);
                face6.setImageResource(R.mipmap.angry_2);
                face7.setImageResource(R.mipmap.neutral_2);
                break;
            case "Surprise":
//                lyface=new LinearLayout(getContext());
                face1.setImageResource(R.mipmap.happy_2);
                face2.setImageResource(R.mipmap.surprise_1);
                face3.setImageResource(R.mipmap.scare_2);
                face4.setImageResource(R.mipmap.sad_2);
                face5.setImageResource(R.mipmap.discard_2);
                face6.setImageResource(R.mipmap.angry_2);
                face7.setImageResource(R.mipmap.neutral_2);
                break;
            case "Fear":
//                lyface=new LinearLayout(getContext());
                face1.setImageResource(R.mipmap.happy_2);
                face2.setImageResource(R.mipmap.surprise_2);
                face3.setImageResource(R.mipmap.scare_1);
                face4.setImageResource(R.mipmap.sad_2);
                face5.setImageResource(R.mipmap.discard_2);
                face6.setImageResource(R.mipmap.angry_2);
                face7.setImageResource(R.mipmap.neutral_2);
                break;
            case "Sad":
//                lyface=new LinearLayout(getContext());
                face1.setImageResource(R.mipmap.happy_2);
                face2.setImageResource(R.mipmap.surprise_2);
                face3.setImageResource(R.mipmap.scare_2);
                face4.setImageResource(R.mipmap.sad_1);
                face5.setImageResource(R.mipmap.discard_2);
                face6.setImageResource(R.mipmap.angry_2);
                face7.setImageResource(R.mipmap.neutral_2);
                break;
            case "Disgust":
//                lyface=new LinearLayout(getContext());
                face1.setImageResource(R.mipmap.happy_2);
                face2.setImageResource(R.mipmap.surprise_2);
                face3.setImageResource(R.mipmap.scare_2);
                face4.setImageResource(R.mipmap.sad_2);
                face5.setImageResource(R.mipmap.discard_1);
                face6.setImageResource(R.mipmap.angry_2);
                face7.setImageResource(R.mipmap.neutral_2);
                break;
            case "Angry":
//                lyface=new LinearLayout(getContext());
                face1.setImageResource(R.mipmap.happy_2);
                face2.setImageResource(R.mipmap.surprise_2);
                face3.setImageResource(R.mipmap.scare_2);
                face4.setImageResource(R.mipmap.sad_2);
                face5.setImageResource(R.mipmap.discard_2);
                face6.setImageResource(R.mipmap.angry_1);
                face7.setImageResource(R.mipmap.neutral_2);
                break;
            case "Neutral":
//                lyface=new LinearLayout(getContext());
                face1.setImageResource(R.mipmap.happy_2);
                face2.setImageResource(R.mipmap.surprise_2);
                face3.setImageResource(R.mipmap.scare_2);
                face4.setImageResource(R.mipmap.sad_2);
                face5.setImageResource(R.mipmap.discard_2);
                face6.setImageResource(R.mipmap.angry_2);
                face7.setImageResource(R.mipmap.neutral_1);
                break;
            default:
                lyface=new LinearLayout(getContext());
        }
        sdb.execSQL("update user set mood=? where userphone=?",new String[]{e,pphone});

    }


    //编辑泡泡
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

    //泡泡弹窗
    private void showBottomDialog() {
        //1、使用Dialog、设置style
        final Dialog editbubbledialog = new Dialog(getContext(), R.style.eidt_bubble_dialog);
        //2、设置布局
        View view = View.inflate(getContext(), R.layout.edit_bubble_dialog, null);
        editbubbledialog.setContentView(view);

        Window window = editbubbledialog.getWindow();
        //设置弹出位置
        window.setGravity(Gravity.BOTTOM);
        //设置弹出动画
        window.setWindowAnimations(R.style.dialogstyle);
        //设置对话框大小
        window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        editbubbledialog.show();
        SeekBar seekBar_v = (SeekBar)view.findViewById(R.id.seekBar_v);
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
                icolor=1;
                //bubble.setImageAssetsFolder("color1/");
//                ActivityHuanzheShouye.bubble.playAnimation();
                Log.e("color", String.valueOf(icolor));
            }
        });

        color2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                icolor=2;
                Log.e("color", String.valueOf(icolor));

                bubble.setImageAssetsFolder("color2/");
//                ActivityHuanzheShouye.bubble.playAnimation();

            }
        });

        color3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                icolor=3;
                Log.e("color", String.valueOf(icolor));

                bubble.setImageAssetsFolder("color3/");
//                ActivityHuanzheShouye.bubble.playAnimation();

            }
        });

        color4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                icolor=4;
                Log.e("color", String.valueOf(icolor));
                bubble.setImageAssetsFolder("color4/");
//                ActivityHuanzheShouye.bubble.playAnimation();

            }
        });

        color5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                icolor=5;
                Log.e("color", String.valueOf(icolor));
                bubble.setImageAssetsFolder("color5/");
//                ActivityHuanzheShouye.bubble.playAnimation();

            }
        });

        seekBar_v.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                switch (progress){
                    case 1:
                        bubble.setAnimation("level1.json");
                        bubble.playAnimation();
                        break;
                    case 2:
                        bubble.setAnimation("level2.json");
                        bubble.playAnimation();
                        break;
                    case 3:
                        bubble.setAnimation("level3.json");
                        bubble.playAnimation();
                        break;
                    case 4:
                        bubble.setAnimation("level4.json");
                        bubble.playAnimation();
                        break;
                    case 5:
                        bubble.setAnimation("level5.json");
                        bubble.playAnimation();
                        break;
                    default:
                        break;
                }
//                switch (progress){
//                    case 1:
//                        Log.e("1", "1");
//                        bubble.setAnimation(".lottie1/1_1.json");
//                        bubble.playAnimation();
//                        break;
//                    case 2:
//                        Log.e("2", "2");
//                        bubble.setAnimation(".lottie1/1_2.json");
//                        bubble.playAnimation();
//                        break;
//                    case 3:
//                        Log.e("3", "3");
//                        bubble.setAnimation("1_3.json");
//                        bubble.playAnimation();
//                        break;
//                    case 4:
//                        Log.e("4", "4");
//                        bubble.setAnimation(".lottie1/1_4.json");
//                        bubble.playAnimation();
//                        break;
//                    case 5:
//                        Log.e("5", "5");
//                        bubble.setAnimation(".lottie1/1_5.json");
//                        bubble.playAnimation();
//                        break;
//                    default:
//                        break;
//                }
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


    @SuppressLint("WrongConstant")
    private void floatAnim(View view, int delay){
        List<Animator> animators = new ArrayList<>();
        ObjectAnimator translationXAnim = ObjectAnimator.ofFloat(view, "translationX", -3.0f,3.0f,-3.0f);
        translationXAnim.setDuration(2800);
        translationXAnim.setRepeatCount(ValueAnimator.INFINITE);//无限循环
        translationXAnim.setRepeatMode(ValueAnimator.INFINITE);//
        translationXAnim.start();
        animators.add(translationXAnim);
        ObjectAnimator translationYAnim = ObjectAnimator.ofFloat(view, "translationY", -7.0f,7.0f,-7.0f);
        translationYAnim.setDuration(3500);
        translationYAnim.setRepeatCount(ValueAnimator.INFINITE);
        translationYAnim.setRepeatMode(ValueAnimator.INFINITE);
        translationYAnim.start();
        animators.add(translationYAnim);

        AnimatorSet btnSexAnimatorSet = new AnimatorSet();
        btnSexAnimatorSet.playTogether(animators);
        btnSexAnimatorSet.setStartDelay(delay);
        btnSexAnimatorSet.start();
    }

}
