package com.example.bubble422;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.baidu.speech.EventListener;
import com.baidu.speech.EventManager;
import com.baidu.speech.EventManagerFactory;
import com.baidu.speech.asr.SpeechConstant;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * 点击导航栏对话icon进入Activity
 */
public class Activity_huanhze_yuyin extends AppCompatActivity implements EventListener {
    /*private RecyclerView msgRecyclerView;
    private EditText inputText;
    private Button send;
    private MsgAdapter adapter;
    private List<Msg> msgList = new ArrayList<>();*/
    private ListView msgListView;
    private EditText inputText;
    private Button send;
    private Button back;
    private Button next;
    private MsgAdapter adapter;
    private List<Msg> msgList = new ArrayList<Msg>();

//    protected EditText txtResult;//识别结果
    protected Button startBtn;//开始识别，持续一定时间不说话会自动停止，需要再次打开
    protected Button stopBtn;//停止识别,立即停止，直接输出已经识别的内容
    private EventManager asr;//语音识别核心库



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        initMsgs();
        initPermission();

        //初始化EventManager对象
        asr = EventManagerFactory.create(this, "asr");
        //注册自己的输出事件类
        asr.registerListener(this::onEvent); //  EventListener 中 onEvent方法

        adapter =  new MsgAdapter(this,R.layout.chat_item,msgList);
        inputText = (EditText)findViewById(R.id.input_text);
        send = (Button)findViewById(R.id.send);
        back=(Button)findViewById(R.id.back) ;
        next=(Button)findViewById(R.id.next) ;
        msgListView = (ListView)findViewById(R.id.list_view);
        msgListView.setAdapter((ListAdapter) adapter);

//        txtResult = (EditText) findViewById(R.id.input_text);
        startBtn = (Button) findViewById(R.id.voice);
        stopBtn = (Button) findViewById(R.id.btn_stop);

        startBtn.setOnClickListener(new View.OnClickListener() {//点击开始按钮
            @Override
            public void onClick(View v) {
                startBtn.setVisibility(View.INVISIBLE);
                stopBtn.setVisibility(View.VISIBLE);
                Log.e("left","1");
                asr.send(SpeechConstant.ASR_START, null, null, 0, 0);
            }
        });
        stopBtn.setOnClickListener(new View.OnClickListener() {//点击停止按钮
            @Override
            public void onClick(View v) {
                Log.e("right","22222222222");
                startBtn.setVisibility(View.VISIBLE);
                stopBtn.setVisibility(View.INVISIBLE);
                asr.send(SpeechConstant.ASR_STOP, null, null, 0, 0);
            }
        });

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = inputText.getText().toString();
                if(!"".equals(content)){
                    Msg msg = new Msg(content,Msg.TYPE_SEND);
                    msgList.add(msg);
                    adapter.notifyDataSetChanged();
                    msgListView.setSelection(msgList.size());
                    inputText.setText("");

                }
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content ="";
                Msg msg = new Msg(content,Msg.TYPE_RECEIVED);
                msgList.add(msg);
                adapter.notifyDataSetChanged();
                msgListView.setSelection(msgList.size());

            }
        });
    }

    /**
     * 自定义输出事件类 EventListener 回调方法
     */
    @Override
    public void onEvent(String name, String params, byte[] data, int offset, int length) {

        if (name.equals(SpeechConstant.CALLBACK_EVENT_ASR_PARTIAL)) {
            // 识别相关的结果都在这里
            if (params == null || params.isEmpty()) {
                return;
            }
            if (params.contains("\"final_result\"")) {
                // 一句话的最终识别结果
                String regrex = "\\[(.*?),";  //使用正则表达式抽取我们需要的内容
                Pattern pattern = Pattern.compile(regrex);
                Matcher matcher = pattern.matcher(params);
                if (matcher.find()) {
                    int a  = matcher.group(0).indexOf("[");
                    int b  = matcher.group(0).indexOf(",");
                    inputText.setText(matcher.group(0).substring(a+2,b-3));
                }
            }
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        asr.unregisterListener(this::onEvent);
    }

    private void initMsgs() {
        Msg msg1 = new Msg("Hello friend.", Msg.TYPE_RECEIVED);
        Msg msg2 = new Msg("What a nice day.", Msg.TYPE_RECEIVED);
        Msg msg3 = new Msg("Can I ask you some questions.", Msg.TYPE_RECEIVED);
        Msg msg4 = new Msg("Thanks.", Msg.TYPE_RECEIVED);
        Msg msg5 = new Msg("Do you sleep well last night?", Msg.TYPE_RECEIVED);
        Msg msg6 = new Msg("OK.", Msg.TYPE_RECEIVED);
        Msg msg7 = new Msg("Have a nice day.", Msg.TYPE_RECEIVED);
        Msg msg8 = new Msg("Enjoy your life.", Msg.TYPE_RECEIVED);
        Msg msg9 = new Msg("I am Bubble", Msg.TYPE_RECEIVED);
        Msg msg10 = new Msg("Hello guy.", Msg.TYPE_RECEIVED);

        msgList.add(msg1);


    }


    /**
     * android 6.0 以上需要动态申请权限
     */
    private void initPermission() {
        String permissions[] = {Manifest.permission.RECORD_AUDIO,
                Manifest.permission.ACCESS_NETWORK_STATE,
                Manifest.permission.INTERNET,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
        };

        ArrayList<String> toApplyList = new ArrayList<String>();

        for (String perm : permissions) {
            if (PackageManager.PERMISSION_GRANTED != ContextCompat.checkSelfPermission(this, perm)) {
                toApplyList.add(perm);
                //进入到这里代表没有权限
            }
        }
        String tmpList[] = new String[toApplyList.size()];
        if (!toApplyList.isEmpty()) {
            ActivityCompat.requestPermissions(this, toApplyList.toArray(tmpList), 123);
        }

    }

    /**
     * 权限申请回调，可以作进一步处理
     * @param requestCode
     * @param permissions
     * @param grantResults
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        // 此处为android 6.0以上动态授权的回调，用户自行实现。
    }




}
