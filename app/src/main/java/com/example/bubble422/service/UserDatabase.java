package com.example.bubble422.service;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.bubble422.User;

public class UserDatabase {
    private DatabaseHelper dbHelper;
    public UserDatabase(Context context)
    {

        dbHelper=new DatabaseHelper(context,"user.db",null,1);
    }

    public boolean plogin(String username,String userphone,String password){
        SQLiteDatabase sdb=dbHelper.getReadableDatabase();
        String sql="select * from user where username=? and userphone=? and password=?";
        Cursor cursor=sdb.rawQuery(sql, new String[]{username,userphone,password});
        if(cursor.moveToFirst()==true){
            cursor.close();
            return true;
        }
        return false;
    }
    public boolean dlogin(String username,String userphone,String password){
        SQLiteDatabase sdb=dbHelper.getReadableDatabase();
        String sql="select * from doctor where username=? and userphone=? and password=?";
        Cursor cursor=sdb.rawQuery(sql, new String[]{username,userphone,password});
        if(cursor.moveToFirst()==true){
            cursor.close();
            return true;
        }
        return false;
    }
    public boolean pregister(com.example.bubble422.User user){
        SQLiteDatabase sdb=dbHelper.getReadableDatabase();
        String sql="insert into user(username,userphone,password,score,mood," +
                "speed,color,type,vocation,email,state,advice,note) " +
                "values(?,?,?,0,'unknown',50,50,'unknown','unknown','unknown','unknown','unknown','unknown')";
        Object obj[]={user.getUsername(),user.getUserphone(),user.getPassword()};
        sdb.execSQL(sql, obj);
        return true;
    }
    public boolean dregister(com.example.bubble422.User user){
        SQLiteDatabase sdb=dbHelper.getReadableDatabase();
        String sql="insert into doctor(username,userphone,password,email,level) " +
                "values(?,?,?,'unknown','unknown')";
        Object obj[]={user.getUsername(),user.getUserphone(),user.getPassword()};
        sdb.execSQL(sql, obj);
        return true;
    }
}


