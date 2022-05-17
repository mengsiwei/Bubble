package com.example.bubble422;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;


/**
 * 已经换成Activity_huanzhe_yuyin
 */
public class Fragment_huanhze_yuyin extends Fragment {
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


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.chat, null);
        initMsgs();
        adapter =  new MsgAdapter(getContext(),R.layout.chat_item,msgList);
        inputText = (EditText)v.findViewById(R.id.input_text);
        send = (Button)v.findViewById(R.id.send);
        back=(Button)v.findViewById(R.id.back) ;
        next=(Button)v.findViewById(R.id.next) ;
        msgListView = (ListView)v.findViewById(R.id.list_view);
        msgListView.setAdapter((ListAdapter) adapter);

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
                Intent intent=new Intent(getContext(),DaohanglanActivity.class);
                startActivity(intent);
                getActivity().onBackPressed();
//                Fragment_huanhze_shouye f=new Fragment_huanhze_shouye();
//                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_huanzhe,f).commit();
                DaohanglanActivity.d_shouye.setVisibility(View.VISIBLE);
                DaohanglanActivity.d_wode.setVisibility(View.VISIBLE);
                DaohanglanActivity.d_yuyin.setVisibility(View.VISIBLE);
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content ="next";
                Msg msg = new Msg(content,Msg.TYPE_RECEIVED);
                msgList.add(msg);
                adapter.notifyDataSetChanged();
                msgListView.setSelection(msgList.size());

            }
        });


        return v;
    }
    private void initMsgs() {
        Msg msg1 = new Msg("Hello guy.", Msg.TYPE_RECEIVED);
        msgList.add(msg1);
    }



}
