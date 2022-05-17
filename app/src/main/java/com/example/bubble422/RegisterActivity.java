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

import com.example.bubble422.service.DatabaseHelper;
import com.example.bubble422.service.UserDatabase;

public class RegisterActivity extends AppCompatActivity {

    EditText username;
    EditText userphone;
    EditText password;
    EditText cpassword;
    Button register;
    public static String pphone;
    public static String dphone;
    String phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //OpenCreateDB();
        findViews();
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=username.getText().toString().trim();
                phone=userphone.getText().toString().trim();
                pphone=phone;
                dphone=phone;
                String pwd=password.getText().toString().trim();
                String cpwd=cpassword.getText().toString().trim();
                Log.e("TAG",name+"_"+phone+"_"+pwd);
                //DatabaseHelper dbHelper=new DatabaseHelper(this,"user.db",null,1);
                UserDatabase uService=new UserDatabase(com.example.bubble422.RegisterActivity.this);
                User user=new User();
                user.setUsername(name);
                user.setPassword(pwd);
                user.setUserphone(phone);
                Intent i=getIntent();
                String strId=i.getStringExtra("id1");
                if(strId.equals("0")){

                uService.pregister(user);
                Toast.makeText(com.example.bubble422.RegisterActivity.this, "注册成功", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(com.example.bubble422.RegisterActivity.this,DaohanglanActivity.class);
                intent.putExtra("emotion","unknown");
                startActivity(intent);
                }
                else if (strId.equals("1")){
                    uService.dregister(user);
                    Toast.makeText(com.example.bubble422.RegisterActivity.this, "注册成功", Toast.LENGTH_LONG).show();

                    Intent intent = new Intent(com.example.bubble422.RegisterActivity.this,DoctorShouyeActivity.class);
                    startActivity(intent);
                }
//                Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
//
//                startActivity(intent);
            }
        });
    }

    private void findViews() {
        username=(EditText)findViewById(R.id.rg_username);
        userphone=(EditText)findViewById(R.id.rg_phonenumber);
        password=(EditText)findViewById(R.id.rg_password);
        cpassword=(EditText)findViewById(R.id.rg_cpassword);
        register=(Button)findViewById(R.id.rg_register);
    }

//    //创建数据库
//    private void OpenCreateDB(){
//
//        //创建或打卡数据库BUBBLE_USERS
//        try {
//            db=openOrCreateDatabase(BUBBLE_USERS,this.MODE_PRIVATE, null);
//        }
//        catch (Throwable e){
//            Log.e("tag","openDatabaseError:"+e.getMessage());
//            db=null;
//        }
//
//        //创建表
//        try{
//            db.execSQL("CREATE TABLE IF NOT EXISTS tuserinfo(_id INTEGER PRIMARY KEY AUTOINCREMENT,username VARCHAR,userphone INTEGER,userpwd VARCHAR)");
//        }
//        catch (SQLException se){
//            String msg="doInstall.error:[%s].%s";
//            Log.d("tag",String.format(msg,se.getCause(),se.getMessage()));
//        }
//    }
//
//    //判断是否为空
//    private boolean IsStrEmpty(String strInput){
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
//    //判断用户是否存在
//    private boolean IsExistUserName(String strUserName){
//        //查询用户
//        Cursor cursor=db.rawQuery("select*from tuserinfo where username='"+strUserName+"'",null);
//
//        if(cursor.getCount()>0){
//            cursor.close();
//            return true;
//        }else {
//            cursor.close();
//            return false;
//        }
//    }
//
//    //插入用户数据
//    private void insertUserInfo(String strUserName, Integer intUserPhone,String strUserPwd){
//        if(IsExistUserName(strUserName)==false){
//            ContentValues cvRUserInfo=new ContentValues();
//            cvRUserInfo.put("username",strUserName);
//            cvRUserInfo.put("userphone",intUserPhone);
//            cvRUserInfo.put("userpwd",strUserPwd);
//            if(db!=null){
//                db.insert("tuserinfo",null,cvRUserInfo);
//                Toast.makeText(RegisterActivity.this,"succeed",Toast.LENGTH_SHORT).show();
//            }
//        }else {
//            Toast.makeText(RegisterActivity.this,"fail",Toast.LENGTH_SHORT).show();
//        }
//    }
}