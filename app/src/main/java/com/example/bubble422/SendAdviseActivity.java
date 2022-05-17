package com.example.bubble422;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bubble422.service.DatabaseHelper;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import static com.example.bubble422.RegisterActivity.pphone;

public class SendAdviseActivity extends AppCompatActivity {


    private SeekBar state_change_sb;
    private List<StateAdvice> mData_state;
    private HorizontalListView mListViewArray;
    private TextView state_change_num_tv,gethuanzhe_name_tv;
    EditText textnote_tv;
    private Button stateadvice_finish,sendadvice_back_btn;
    public int change_seekbar_number;
    public String strNum="0";
    public String strStateName="";
    public String te="";
    Button f;
    String na;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_advise);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Intent in=getIntent();
        na=in.getStringExtra("huanzhename");
        DatabaseHelper db=new DatabaseHelper(this,"user.db",null,1);;
        SQLiteDatabase sdb=db.getReadableDatabase();
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN|WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

        textnote_tv=(EditText) findViewById(R.id.textnote_etv);
        f=(Button)findViewById(R.id.stateadvice_finish) ;

        state_change_num_tv=(TextView) findViewById(R.id.state_change_num_tv);
        gethuanzhe_name_tv=(TextView) findViewById(R.id.gethuanzhe_name_tv);

        Intent i=getIntent();
        String strName=i.getStringExtra("huanzhename");
        gethuanzhe_name_tv.setText(strName);

        state_change_sb=(SeekBar) findViewById(R.id.state_change_sb);




        state_change_sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                change_seekbar_number=progress-100;
                strNum=String.valueOf(change_seekbar_number);
                state_change_num_tv.setText(strNum);
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
//        int change_seekbar_num=state_change_sb.getProgress()-101;
//        strNum=String.valueOf(change_seekbar_num);
//        state_change_num_tv.setText(strNum);
//
//
//

        mListViewArray=(HorizontalListView) findViewById(R.id.state_advice_lv);

//        change_seekbar_num=state_change_sb.getProgress();

        LayoutInflater inflater1 =getLayoutInflater();
        initData();
        StateAdviceAdapter adapter1=new StateAdviceAdapter(inflater1,mData_state);
        mListViewArray.setAdapter(adapter1);

        mListViewArray.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                int huanzheid=view.getId();
                strStateName=mData_state.get(position).getState_name();
                Log.e("huanzhecard", String.valueOf(position));
                Log.e("huanzhename", strStateName);

//                Intent intent =new Intent(DoctorShouyeActivity.this,SendAdviseActivity.class);
//                intent.putExtra("huanzhename",strHuanzheName);
//                startActivity(intent);
//                finish();

            }
        });

        stateadvice_finish=(Button)findViewById(R.id.stateadvice_finish);
        sendadvice_back_btn=(Button)findViewById(R.id.sendadvice_back_btn);

//        sendadvice_back_btn.setOnClickListener(this::onClick);
//        stateadvice_finish.setOnClickListener(this::onClick);

        stateadvice_finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(SendAdviseActivity.this,DoctorShouyeActivity.class);
                startActivity(intent1);
//                Toast.makeText(this,"advice send to your patient",Toast.LENGTH_LONG).show();
            }
        });

        sendadvice_back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2=new Intent(SendAdviseActivity.this,DoctorShouyeActivity.class);
                startActivity(intent2);
//                Toast.makeText(this,"advice send to your patient",Toast.LENGTH_LONG).show();
            }
        });
        f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                te=textnote_tv.getText().toString();
                sdb.execSQL("update user set state=?,advice=?,note=? where username=?",new String[]{strNum,strStateName,te,na});
                // sdb.execSQL("update user set type=?,vocation=?,phone=?,email=? where phone=?",new String[]{t,vo,p,em});
                //sdb.execSQL("update user set type=?,vocation=?,phone=?,email=? where phone=?",new String[]{t,vo,p,em});
                finish();
            }
        });
    }


    private void initData(){
        mData_state=new ArrayList<StateAdvice>();
        StateAdvice stateAdvice1=new StateAdvice(R.mipmap.happy_2,"sport");
        StateAdvice stateAdvice2=new StateAdvice(R.mipmap.angry_2,"music");
        StateAdvice stateAdvice3=new StateAdvice(R.mipmap.neutral_2,"book");
        StateAdvice stateAdvice4=new StateAdvice(R.mipmap.sad_2,"tea");
        StateAdvice stateAdvice5=new StateAdvice(R.mipmap.discard_2,"film");
        StateAdvice stateAdvice6=new StateAdvice(R.mipmap.surprise_2,"sing");
        StateAdvice stateAdvice7=new StateAdvice(R.mipmap.scare_2,"sunshower");

        mData_state.add(stateAdvice1);
        mData_state.add(stateAdvice2);
        mData_state.add(stateAdvice3);
        mData_state.add(stateAdvice4);
        mData_state.add(stateAdvice5);
        mData_state.add(stateAdvice6);
        mData_state.add(stateAdvice7);

        mData_state.add(stateAdvice1);
        mData_state.add(stateAdvice2);
        mData_state.add(stateAdvice3);
    }
}