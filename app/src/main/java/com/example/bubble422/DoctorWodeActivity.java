package com.example.bubble422;

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
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.example.bubble422.service.DatabaseHelper;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import static com.example.bubble422.RegisterActivity.dphone;

public class DoctorWodeActivity extends AppCompatActivity {


    private Button back;
    Button save;
    TextView name;
    EditText level;
    TextView ph;
    EditText email;
    String n="";
    String l="";
    String em="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_wode);
        Log.e("cursor","null");
        DatabaseHelper db=new DatabaseHelper(this,"user.db",null,1);;
        SQLiteDatabase sdb=db.getReadableDatabase();
        Log.e("cursor","null");
        back=(Button) findViewById(R.id.doctor_wode_back_btn);
        name=(TextView)findViewById(R.id.textView5) ;
        level=(EditText)findViewById(R.id.textView6) ;
        ph=(TextView)findViewById(R.id.textView8) ;
        email=(EditText)findViewById(R.id.textView10) ;
        save=(Button)findViewById(R.id.doctor_save_btn) ;
        Log.e("cursor","null");
        Cursor cursor=sdb.rawQuery("select * from doctor where userphone=?",new String[]{dphone});

        if(cursor==null)
            Log.e("cursor","null");
        else if(cursor.moveToFirst()) {
            n = cursor.getString(cursor.getColumnIndex("username"));
            l = cursor.getString(cursor.getColumnIndex("level"));
            em = cursor.getString(cursor.getColumnIndex("email"));
        }
        name.setText(n);
        level.setText(l);
        ph.setText(dphone);
        email.setText(em);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                l=level.getText().toString();
                em=email.getText().toString();
                sdb.execSQL("update doctor set level=?,email=? where userphone=?",new String[]{l,em,dphone});
                finish();
            }
        });

    }


    //可能会进行软键盘处理
//    private void showCreateDialog() {
//        //1、使用Dialog、设置style
//        final Dialog create_huanzhe_dialog = new Dialog(this, R.style.create_huanzhe_dialog);
//        //2、设置布局
//        View view = View.inflate(this, R.layout.create_huanzhe_dialog, null);
//        create_huanzhe_dialog.setContentView(view);
//
//        Window window = create_huanzhe_dialog.getWindow();
//        //设置弹出位置
//        window.setGravity(Gravity.CENTER);
//
//        //设置对话框大小
//        window.setLayout(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//        create_huanzhe_dialog.show();
//
//        create_huanzhe_dialog.findViewById(R.id.create_huanzhe_finish).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Log.e("finish", "finish");
//                create_huanzhe_dialog.dismiss();
//            }
//        });
//
//        create_huanzhe_dialog.findViewById(R.id.create_huanzhe_delete).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Log.e("finish", "finish");
//                create_huanzhe_dialog.dismiss();
//            }
//        });
//
//    }

}