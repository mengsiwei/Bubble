package com.example.bubble422;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.bubble422.service.DatabaseHelper;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class DaohanglanActivity extends AppCompatActivity {
    public DatabaseHelper db;
    public SQLiteDatabase sdb;
    FragmentManager huanzhe_yemian;
    private Fragment_huanhze_shouye shouye;
    private Fragment_huanhze_yuyin yuyin;
    private Fragment_huanhze_wode wode;
    public static Button d_shouye;
    public static Button d_yuyin;
    public static Button d_wode;
    Button s_liangbiao;
    Button s_zhaoxiang;
    Button s_shezhi;
    public static String e="unknown";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daohanglan);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        huanzhe_yemian = getSupportFragmentManager();

        db=new DatabaseHelper(this,"user.db",null,1);
        sdb=db.getReadableDatabase();


        d_shouye=(Button)findViewById(R.id.shouye_btn);
        d_yuyin=(Button)findViewById(R.id.yuyin_btn);
        d_wode=(Button)findViewById(R.id.wode_btn);
        s_liangbiao=(Button)findViewById(R.id.liangbiao_btn);
        s_zhaoxiang=(Button)findViewById(R.id.zhaoxiang_btn);
        s_shezhi=(Button)findViewById(R.id.shezhi_btn);

        d_shouye.setOnClickListener(this::onClick);
        d_yuyin.setOnClickListener(this::onClick);
        d_wode.setOnClickListener(this::onClick);
        s_liangbiao.setOnClickListener(this::onClick);
        s_zhaoxiang.setOnClickListener(this::onClick);
        s_shezhi.setOnClickListener(this::onClick);

        setTabSelection(0);

    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.shouye_btn:
                setTabSelection(0);
                Log.e("shouye","shouye");
                break;
            case R.id.yuyin_btn:
                Intent intent1=new Intent(DaohanglanActivity.this,Activity_huanhze_yuyin.class);
                startActivity(intent1);
                Log.e("yuyin","duihua");
                break;
            case R.id.wode_btn:
//                setTabSelection(2);
                Intent intent2=new Intent(DaohanglanActivity.this,Activity_huanzhe_wode.class);
                startActivity(intent2);
                Log.e("wode","wode");
                break;
            case R.id.zhaoxiang_btn:
                Intent i1 =new Intent(this,live_face.class);
                startActivityForResult(i1,10);
                Log.e("wode","zhaoxiaong");
                break;
            case R.id.liangbiao_btn:
                Intent intent =new Intent(this,ShowWenjuanActivity.class);
                startActivity(intent);
                Log.e("wode","wenjuan");
                break;
            default:
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode,int resultCode,Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==100){
            if(requestCode==10){
                e=data.getStringExtra("emotion");
                Log.e("e",e);
//                Toast.makeText(DaohanglanActivity.this, e, Toast.LENGTH_LONG).show();
            }
        }
    }


    private void setTabSelection(int index) {
        FragmentTransaction ft = huanzhe_yemian.beginTransaction();
        hideFragment(ft);
        switch (index) {
            case 0:
                if (shouye == null) {
                    Log.e("test","test");
                    shouye = new Fragment_huanhze_shouye();
                    Log.e("test","test");
                    ft.add(R.id.fragment_huanzhe, shouye);
                }
                ft.show(shouye);

                break;
//            case 1:
//                if (yuyin == null) {
//                    yuyin = new Fragment_huanhze_yuyin();
//                    ft.add(R.id.fragment_huanzhe, yuyin);
//                }
//                yuyin = new Fragment_huanhze_yuyin();
//                FragmentManager fragmentManager=getSupportFragmentManager();
//                FragmentTransaction transaction=fragmentManager.beginTransaction();
//                transaction.replace(R.id.fragment_huanzhe,yuyin);
//                transaction.commit();
//
//                d_shouye.setVisibility(View.INVISIBLE);
//                d_yuyin.setVisibility(View.INVISIBLE);
//                d_wode.setVisibility(View.INVISIBLE);
//
////                ft.show(yuyin);
//                break;
            case 1:
                break;
            case 2:
//                if (wode == null) {
//                    wode = new Fragment_huanhze_wode();
//                    ft.add(R.id.fragment_huanzhe, wode);
//                }
//                ft.show(wode);
                break;

        }
        ft.commit();
    }

    //用于隐藏fragment

    private void hideFragment(FragmentTransaction ft) {
        if (shouye != null) {
            ft.hide(shouye);
        }
        if (yuyin != null) {
            ft.hide(yuyin);
        }
        if (wode!=null){
            ft.hide(wode);
        }
    }

}