package com.example.bubble422.service;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper{
    private  Context mcontext;
    public static int version=1;
    //static String name="user.db";
    //static int dbVersion=1;
    public DatabaseHelper(Context context,String name,SQLiteDatabase.CursorFactory factory,int version) {
        super(context,name,factory,version);
        mcontext=context;
    }

    public void onCreate(SQLiteDatabase db) {
        String sql="create table user(id integer primary key autoincrement," +
                "username varchar(20)," +
                "userphone text," +
                "password varchar(20)," +
                "score integer," +
                "mood text," +
                "speed integer," +
                "color integer," +
                "type text," +
                "vocation text," +
                "email text," +
                "state text," +
                "advice text," +
                "note text)";
        db.execSQL(sql);
        db.execSQL("create table doctor(id integer primary key autoincrement," +
                "username text," +
                "userphone text," +
                "password text," +
                "email text," +
                "level text)");
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
