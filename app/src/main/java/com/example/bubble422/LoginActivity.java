package com.example.bubble422;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bubble422.service.UserDatabase;

import static com.example.bubble422.RegisterActivity.dphone;
import static com.example.bubble422.RegisterActivity.pphone;

public class LoginActivity extends AppCompatActivity {

    private EditText username;
    private EditText userphone;
    private EditText userpwd;
    private Button login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        findViews();
    }

    private void findViews() {
        username=(EditText)findViewById(R.id.lg_username);
        userphone=(EditText)findViewById(R.id.lg_phonenumber);
        userpwd=(EditText)findViewById(R.id.lg_password);
        login=(Button)findViewById(R.id.lg_login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=username.getText().toString();
                System.out.println(name);
                String phone=userphone.getText().toString();
                System.out.println(phone);
                String pass=userpwd.getText().toString();
                System.out.println(pass);

                Intent i=getIntent();
                String strId=i.getStringExtra("id1");
                Log.e("id1",strId);
                Log.i("TAG",name+"_"+phone+pass);
                UserDatabase uService=new UserDatabase(com.example.bubble422.LoginActivity.this);
                if(strId.equals("0")) {
                    pphone=phone;
                    boolean flag = uService.plogin(name, phone, pass);
                    if (flag) {
                        Log.i("TAG", "登录成功");
                        Toast.makeText(com.example.bubble422.LoginActivity.this, "登录成功", Toast.LENGTH_LONG).show();

                        Intent intent = new Intent(com.example.bubble422.LoginActivity.this, DaohanglanActivity.class);
                        intent.putExtra("emotion", "unknwon");
                        intent.putExtra("tel", phone);
                        startActivity(intent);
                    } else {
                        Log.i("TAG", "登录失败");
                        Toast.makeText(com.example.bubble422.LoginActivity.this, "登录失败", Toast.LENGTH_LONG).show();
                    }
                }
                if (strId.equals("1")){
                    dphone=phone;
                    boolean flag = uService.dlogin(name, phone, pass);
                    if (flag) {
                        Log.i("TAG", "登录成功");
                        Toast.makeText(com.example.bubble422.LoginActivity.this, "登录成功", Toast.LENGTH_LONG).show();

                        Intent intent = new Intent(com.example.bubble422.LoginActivity.this,DoctorShouyeActivity.class);
                        startActivity(intent);
                    } else {
                        Log.i("TAG", "登录失败");
                        Toast.makeText(com.example.bubble422.LoginActivity.this, "登录失败", Toast.LENGTH_LONG).show();
                    }

                }


            }
        });
    }



//    public boolean IsStrEmpty(String strInput){
//        if(strInput==null){
//            return true;
//        }else{
//            return false;
//        }
//    }
//
//    //确认密码是否一致
//    private boolean IsPwdSame(String strUserPwd,String strRePwd){
//        if(strRePwd==strUserPwd){
//            return true;
//        }else {
//            return false;
//        }
//    }
//
//    //判断手机号是否超过11位
////    private boolean IsPhoneOver(Integer iUserPhone){
////        if(toString(iUserPhone).length()>11){
////
////        }
////    }
//
//    //用户登录
//    //判断用户是否存在
//    private boolean isValidUser(String strUserName, Integer intUserPhone,String strUserPwd){
//        Cursor cursor=db.rawQuery("select*from tuserinfo where username='"+strUserName+"' and userphone='"+intUserPhone+"' and userpwd='"+strUserPwd+"'",null);
//        if(cursor.getCount()==1){
//            cursor.close();
//            return true;
//        }else {
//            cursor.close();
//            return false;
//        }
//    }
//
//    Button.OnClickListener listener=new Button.OnClickListener(){
//        @Override
//        public void onClick(View v) {
//            if(v.getId()==R.id.login){
//                String strUserName=tv_username.getText().toString();
////                    Integer intUserPhone=tv_userphone.get;
//                String strUserPwd=tv_userpwd.getText().toString();
//
//                if(IsStrEmpty(strUserName)==false){
//
//                }
//            }else if(v.getId()==R.id.register){
//
//            }
//        }
//    };


}