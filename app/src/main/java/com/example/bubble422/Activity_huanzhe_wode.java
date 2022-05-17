package com.example.bubble422;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bubble422.service.DatabaseHelper;
import static com.example.bubble422.RegisterActivity.pphone;

public class Activity_huanzhe_wode extends AppCompatActivity {

    Button back;
    Button save;
    TextView name;
    EditText type;
    EditText vocation;
    TextView ph;
    EditText email;
    String n="";
    String t="";
    String vo="";
    String em="";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_huanhze_wod);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        DatabaseHelper db=new DatabaseHelper(this,"user.db",null,1);;
        SQLiteDatabase sdb=db.getReadableDatabase();
        Log.e("wode","this");
        save=findViewById(R.id.huanzhe_save_btn);
        Cursor cursor=sdb.rawQuery("select * from user where userphone=?",new String[]{pphone});

        if(cursor==null)
            Log.e("cursor","null");
        else if(cursor.moveToFirst()) {
            n = cursor.getString(cursor.getColumnIndex("username"));
            t = cursor.getString(cursor.getColumnIndex("type"));
            vo = cursor.getString(cursor.getColumnIndex("vocation"));
            em = cursor.getString(cursor.getColumnIndex("email"));
        }
        Log.e("n",n);

        type=(EditText) findViewById(R.id.textView6);
        type.setText(t);
        vocation=(EditText) findViewById(R.id.huanzhe_vocation_etv);
        vocation.setText(vo);
        ph=(TextView) findViewById(R.id.huanzhe_phonenum_tv) ;
        ph.setText(pphone);
        email=(EditText)findViewById(R.id.huanzhe_email_tv) ;
        email.setText(em);
        name=(TextView) findViewById(R.id.textView5);

        name.setText(n);
        back=(Button)findViewById(R.id.huanzhe_wode_back_btn) ;

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                t=type.getText().toString();
                vo=vocation.getText().toString();
                em=email.getText().toString();
                //sdb.execSQL("update user set type=? where phone=?",new String[]{t,vo,p,em});
                sdb.execSQL("update user set type=?,vocation=?,email=? where userphone=?",new String[]{t,vo,em,pphone});
               // sdb.execSQL("update user set type=?,vocation=?,phone=?,email=? where phone=?",new String[]{t,vo,p,em});
                //sdb.execSQL("update user set type=?,vocation=?,phone=?,email=? where phone=?",new String[]{t,vo,p,em});
                finish();

            }
        });

    }
}
