package com.example.bubble422;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.bubble422.service.DatabaseHelper;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import static com.example.bubble422.RegisterActivity.dphone;

public class DoctorShouyeActivity extends AppCompatActivity {

    private TextView state_tv,type_tv;
    FragmentManager fm;
    private FloatingActionButton flaot_button;
    private List<Huanzhe> mData;
    private ListView mListViewArray;
    private Button state_all,state_changed,state_unchanged;
    private Button type_all,type_mild,type_moderate,type_severe;
    private LinearLayout state_btn,type_btn;
    private ImageView photo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_shouye);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        fm =  getSupportFragmentManager();
//        setTabSelection(0);
        state_btn=(LinearLayout) findViewById(R.id.state_1);
        type_btn=(LinearLayout) findViewById(R.id.type_1);
        state_tv=(TextView) findViewById(R.id.state_tv);
        type_tv=(TextView)findViewById(R.id.type_tv);
        state_tv.setOnClickListener(this::onClick);
        type_tv.setOnClickListener(this::onClick);

        //悬浮按钮
        flaot_button=(FloatingActionButton)findViewById(R.id.float_button);
        flaot_button.setOnClickListener(this::onClick);

        state_all=(Button)findViewById(R.id.state_all);
        state_changed=(Button)findViewById(R.id.state_changed);
        state_unchanged=(Button)findViewById(R.id.state_unchanged);
        type_all=(Button)findViewById(R.id.type_all);
        type_mild=(Button)findViewById(R.id.type_mild);
        type_moderate=(Button)findViewById(R.id.type_moderate);
        type_severe=(Button)findViewById(R.id.type_severe);

        photo=findViewById(R.id.doctor_photo);
        photo.setImageDrawable(getResources().getDrawable(R.mipmap.happy_2));
        photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 =new Intent(DoctorShouyeActivity.this,DoctorWodeActivity.class);
                startActivity(intent1);
            }
        });


        mListViewArray=(ListView)findViewById(R.id.huanzhe_card);
        LayoutInflater inflater1 =getLayoutInflater();
        initData();
        HuanzheAdapter adapter=new HuanzheAdapter(inflater1,mData);
        mListViewArray.setAdapter(adapter);

        state_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                state_all.setTextColor(getResources().getColor(R.color.white));
                state_all.setBackgroundResource(R.drawable.state_btn_select);
                state_changed.setTextColor(getResources().getColor(R.color.tag1tv));
                state_changed.setBackgroundResource(R.drawable.state_btn_unselect);
                state_unchanged.setTextColor(getResources().getColor(R.color.tag1tv));
                state_unchanged.setBackgroundResource(R.drawable.state_btn_unselect);

                mData.clear();
                initData();
                HuanzheAdapter adapter=new HuanzheAdapter(inflater1,mData);
                mListViewArray.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }

            public void onNotingSelected(AdapterView<?> parent){}
        });

        state_changed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                state_all.setTextColor(getResources().getColor(R.color.tag1tv));
                state_all.setBackgroundResource(R.drawable.state_btn_unselect);
                state_changed.setTextColor(getResources().getColor(R.color.white));
                state_changed.setBackgroundResource(R.drawable.state_btn_select);
                state_unchanged.setTextColor(getResources().getColor(R.color.tag1tv));
                state_unchanged.setBackgroundResource(R.drawable.state_btn_unselect);
                mData.clear();
                initData();
                HuanzheAdapter adapter=new HuanzheAdapter(inflater1,mData);
                mListViewArray.setAdapter(adapter);
                adapter.notifyDataSetChanged();
                String str_state=state_changed.getText().toString();
                for (int a=0;a<mData.size();a++){
                    if(!mData.get(a).getHuanzhe_state().equals(str_state)){
                        mData.remove(a);
                        a--;
                    }
                    adapter.notifyDataSetChanged();
                }
            }

            public void onNotingSelected(AdapterView<?> parent){}
        });

        state_unchanged.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                state_all.setTextColor(getResources().getColor(R.color.tag1tv));
                state_all.setBackgroundResource(R.drawable.state_btn_unselect);
                state_changed.setTextColor(getResources().getColor(R.color.tag1tv));
                state_changed.setBackgroundResource(R.drawable.state_btn_unselect);
                state_unchanged.setTextColor(getResources().getColor(R.color.white));
                state_unchanged.setBackgroundResource(R.drawable.state_btn_select);
                mData.clear();
                initData();
                HuanzheAdapter adapter=new HuanzheAdapter(inflater1,mData);
                mListViewArray.setAdapter(adapter);
                adapter.notifyDataSetChanged();
                String str_state=state_unchanged.getText().toString();
                for (int a=0;a<mData.size();a++){
                    if(!mData.get(a).getHuanzhe_state().equals(str_state)){
                        mData.remove(a);
                        a--;
                    }
                    adapter.notifyDataSetChanged();
                }
            }

            public void onNotingSelected(AdapterView<?> parent){}
        });

        type_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                type_all.setTextColor(getResources().getColor(R.color.white));
                type_all.setBackgroundResource(R.drawable.state_btn_select);
                type_mild.setTextColor(getResources().getColor(R.color.tag1tv));
                type_mild.setBackgroundResource(R.drawable.state_btn_unselect);
                type_moderate.setTextColor(getResources().getColor(R.color.tag1tv));
                type_moderate.setBackgroundResource(R.drawable.state_btn_unselect);
                type_severe.setTextColor(getResources().getColor(R.color.tag1tv));
                type_severe.setBackgroundResource(R.drawable.state_btn_unselect);
                mData.clear();
                initData();
                HuanzheAdapter adapter=new HuanzheAdapter(inflater1,mData);
                mListViewArray.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }

            public void onNotingSelected(AdapterView<?> parent){}
        });

        type_mild.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                type_mild.setTextColor(getResources().getColor(R.color.white));
                type_mild.setBackgroundResource(R.drawable.state_btn_select);
                type_all.setTextColor(getResources().getColor(R.color.tag1tv));
                type_all.setBackgroundResource(R.drawable.state_btn_unselect);
                type_moderate.setTextColor(getResources().getColor(R.color.tag1tv));
                type_moderate.setBackgroundResource(R.drawable.state_btn_unselect);
                type_severe.setTextColor(getResources().getColor(R.color.tag1tv));
                type_severe.setBackgroundResource(R.drawable.state_btn_unselect);
                mData.clear();
                initData();
                HuanzheAdapter adapter=new HuanzheAdapter(inflater1,mData);
                mListViewArray.setAdapter(adapter);
                adapter.notifyDataSetChanged();
                String str_state=type_mild.getText().toString();
                for (int a=0;a<mData.size();a++){
                    if(!mData.get(a).getHuanzhe_state().equals(str_state)){
                        mData.remove(a);
                        a--;
                    }
                    adapter.notifyDataSetChanged();
                }
            }

            public void onNotingSelected(AdapterView<?> parent){}
        });

        type_moderate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                type_moderate.setTextColor(getResources().getColor(R.color.white));
                type_moderate.setBackgroundResource(R.drawable.state_btn_select);
                type_mild.setTextColor(getResources().getColor(R.color.tag1tv));
                type_mild.setBackgroundResource(R.drawable.state_btn_unselect);
                type_all.setTextColor(getResources().getColor(R.color.tag1tv));
                type_all.setBackgroundResource(R.drawable.state_btn_unselect);
                type_severe.setTextColor(getResources().getColor(R.color.tag1tv));
                type_severe.setBackgroundResource(R.drawable.state_btn_unselect);
                mData.clear();
                initData();
                HuanzheAdapter adapter=new HuanzheAdapter(inflater1,mData);
                mListViewArray.setAdapter(adapter);
                adapter.notifyDataSetChanged();
                String str_state=type_moderate.getText().toString();
                for (int a=0;a<mData.size();a++){
                    if(!mData.get(a).getHuanzhe_state().equals(str_state)){
                        mData.remove(a);
                        a--;
                    }
                    adapter.notifyDataSetChanged();
                }
            }

            public void onNotingSelected(AdapterView<?> parent){}
        });

        type_severe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                type_severe.setTextColor(getResources().getColor(R.color.white));
                type_severe.setBackgroundResource(R.drawable.state_btn_select);
                type_mild.setTextColor(getResources().getColor(R.color.tag1tv));
                type_mild.setBackgroundResource(R.drawable.state_btn_unselect);
                type_moderate.setTextColor(getResources().getColor(R.color.tag1tv));
                type_moderate.setBackgroundResource(R.drawable.state_btn_unselect);
                type_all.setTextColor(getResources().getColor(R.color.tag1tv));
                type_all.setBackgroundResource(R.drawable.state_btn_unselect);
                mData.clear();
                initData();
                HuanzheAdapter adapter=new HuanzheAdapter(inflater1,mData);
                mListViewArray.setAdapter(adapter);
                adapter.notifyDataSetChanged();
                String str_state=type_severe.getText().toString();
                for (int a=0;a<mData.size();a++){
                    if(!mData.get(a).getHuanzhe_state().equals(str_state)){
                        mData.remove(a);
                        a--;
                    }
                    adapter.notifyDataSetChanged();
                }
            }

            public void onNotingSelected(AdapterView<?> parent){}
        });

        mListViewArray.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                int huanzheid=view.getId();
                String strHuanzheName=mData.get(position).getHuanzhe_name();
                Log.e("huanzhecard", String.valueOf(position));
                Log.e("huanzhename", strHuanzheName);

                Intent intent =new Intent(DoctorShouyeActivity.this,SendAdviseActivity.class);
                intent.putExtra("huanzhename",strHuanzheName);
                startActivity(intent);
                finish();

            }
        });

    }


    public void setTextColor(int color){

    }

    @SuppressLint("ResourceAsColor")
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.state_tv:
//                setTabSelection(0);
                state_btn.setVisibility(View.VISIBLE);
                type_btn.setVisibility(View.INVISIBLE);

                type_tv.setTextColor(getResources().getColor(R.color.white));
                state_tv.setTextColor(getResources().getColor(R.color.tag1tv));
                Log.d("state","state");
                break;
            case R.id.type_tv:
//                setTabSelection(1);
                type_btn.setVisibility(View.VISIBLE);
                state_btn.setVisibility(View.INVISIBLE);
                state_tv.setTextColor(getResources().getColor(R.color.white));
                type_tv.setTextColor(getResources().getColor(R.color.tag1tv));
                Log.d("type","type");
                break;
            case R.id.float_button:
                Log.d("float","create");
                showCreateDialog();
                break;
            default:
                break;
        }
    }

    //点击创建
    private void showCreateDialog() {
        //1、使用Dialog、设置style
        final Dialog create_huanzhe_dialog = new Dialog(this, R.style.create_huanzhe_dialog);
        //2、设置布局
        View view = View.inflate(this, R.layout.create_huanzhe_dialog, null);
        create_huanzhe_dialog.setContentView(view);

        Window window = create_huanzhe_dialog.getWindow();
        //设置弹出位置
        window.setGravity(Gravity.CENTER);

        //设置对话框大小
        window.setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        create_huanzhe_dialog.show();

        create_huanzhe_dialog.findViewById(R.id.create_huanzhe_finish).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("finish", "finish");
                create_huanzhe_dialog.dismiss();
            }
        });

        create_huanzhe_dialog.findViewById(R.id.create_huanzhe_delete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("finish", "finish");
                create_huanzhe_dialog.dismiss();
            }
        });

    }

    private void initData(){
        DatabaseHelper db=new DatabaseHelper(this,"user.db",null,1);;
        SQLiteDatabase sdb=db.getReadableDatabase();

        mData=new ArrayList<Huanzhe>();
        Cursor cursor=sdb.rawQuery("select * from user",null);

        String n="",state="",m="",score="0";
        int sp=0,c=0;
        while(cursor.moveToNext()) {
            n = cursor.getString(cursor.getColumnIndex("username"));
            sp = cursor.getInt(cursor.getColumnIndex("speed"));
            c = cursor.getInt(cursor.getColumnIndex("color"));
            m = cursor.getString(cursor.getColumnIndex("mood"));
            score=String.valueOf(cursor.getInt(cursor.getColumnIndex("score")));

            if((sp+c)/2<34)
                state="slow";
            else if((sp+c)/2<67)
                state="calm";
            else
                state="fast";
            Huanzhe a=new Huanzhe(R.mipmap.happy_1,n,state,m,score);
            mData.add(a);
        }
        /*Huanzhe BaoZai=new Huanzhe(R.mipmap.happy_1,"BaoZai","well","happy","10");
        Huanzhe Dan=new Huanzhe(R.mipmap.angry_1,"Dan","bad","angry","1");
        Huanzhe YangLing=new Huanzhe(R.mipmap.neutral_1,"YangLing","well","neutral","6");
        Huanzhe Rhine=new Huanzhe(R.mipmap.sad_1,"Rhine","bad","sad","2");
        Huanzhe LiLanXin=new Huanzhe(R.mipmap.discard_1,"LiLanXin","emmm","discard","4");
        Huanzhe LiuQiong=new Huanzhe(R.mipmap.surprise_1,"LiuQiong","well","surprise","8");
        Huanzhe Test1=new Huanzhe(R.mipmap.surprise_1,"Test1","changed","surprise","7");
        Huanzhe Test2=new Huanzhe(R.mipmap.surprise_1,"Test2","unchanged","surprise","9");
        Huanzhe Test3=new Huanzhe(R.mipmap.happy_1,"Test3","unchanged","happy_1","9");

        mData.add(BaoZai);
        mData.add(Dan);
        mData.add(YangLing);
        mData.add(Rhine);
        mData.add(LiLanXin);
        mData.add(LiuQiong);
        mData.add(Test1);
        mData.add(Test2);
        mData.add(Test3);*/

    }

}