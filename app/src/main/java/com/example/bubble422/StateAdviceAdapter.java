package com.example.bubble422;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class StateAdviceAdapter extends BaseAdapter {

    //定义数据
    private List<StateAdvice> mData_state;
    //定义inflater，加载布局
    private LayoutInflater mInflater_state;

    //定义构造器，当activity创建对象Adapter的时候将数据data和inflater传入自定义的Adapter中
    public StateAdviceAdapter(LayoutInflater inflater, List<StateAdvice> data){
        mInflater_state=inflater;
        mData_state=data;
    }

    @Override
    public int getCount() {
        return mData_state.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View viewStateAdvice=mInflater_state.inflate(R.layout.stateadvice,null);
        StateAdvice stateAdvice=mData_state.get(position);

        ImageView stateadvice_img=(ImageView)viewStateAdvice.findViewById(R.id.state_advice_img);
        TextView stateadvice_name=(TextView)viewStateAdvice.findViewById(R.id.state_advice_name);


        stateadvice_img.setImageResource(stateAdvice.getState_img());
        stateadvice_name.setText(stateAdvice.getState_name());

        return viewStateAdvice;
    }
}
