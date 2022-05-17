package com.example.bubble422;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class HuanzheAdapter extends BaseAdapter {

    //定义数据
    private List<Huanzhe> mData;
    //定义inflater，加载布局
    private LayoutInflater mInflater;

    //定义构造器，当activity创建对象Adapter的时候将数据data和inflater传入自定义的Adapter中
    public HuanzheAdapter(LayoutInflater inflater,List<Huanzhe> data){
        mInflater=inflater;
        mData=data;
    }

    @Override
    public int getCount() {
        return mData.size();
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
        View viewHuanzhe=mInflater.inflate(R.layout.huanzhe,null);
        Huanzhe huanzhe=mData.get(position);

        ImageView huanzhe_image=(ImageView)viewHuanzhe.findViewById(R.id.huanzhe_image);
        TextView huanzhe_name=(TextView)viewHuanzhe.findViewById(R.id.huanzhe_name);
        Button huanzhe_state=(Button)viewHuanzhe.findViewById(R.id.huanzhe_state);
        Button huanzhe_face=(Button)viewHuanzhe.findViewById(R.id.huanzhe_face);
        Button huanzhe_xinqing=(Button)viewHuanzhe.findViewById(R.id.huanzhe_xinqing);


        huanzhe_image.setImageResource(huanzhe.getHuanzhe_image());
        huanzhe_name.setText(huanzhe.getHuanzhe_name());
        huanzhe_state.setText(huanzhe.getHuanzhe_state());
        huanzhe_face.setText(huanzhe.getHuanzhe_face());
        huanzhe_xinqing.setText(huanzhe.getHuanzhe_xinqing());

        return viewHuanzhe;
    }
}
