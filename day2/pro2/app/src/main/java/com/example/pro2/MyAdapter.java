package com.example.pro2;


import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private List<TestData> mDataset = new ArrayList<>();

    //default constructor
    public MyAdapter(List<TestData> myDataset) {
        mDataset.addAll(myDataset);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        //在layout文件夹中找到名字叫 item 的布局类型并加载到view中
        View itemv=layoutInflater.inflate(R.layout.item,parent,false);
        return new MyViewHolder(itemv);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.onBind(position, mDataset.get(position));
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView tvIndex;
        private TextView tvTitle;
        private TextView tvHot;
        private View contentView; //整体的内容，是必要的

        //通过view找到了当下块中的实例
        public MyViewHolder(View v) {
            super(v);
            contentView = v;
            tvIndex = v.findViewById(R.id.tv_index);
            tvTitle = v.findViewById(R.id.tv_title);
            tvHot = v.findViewById(R.id.tv_hot);
        }

        //进行实例的修改
        public void onBind(int position,TestData data){
            //通过stringbuilder在空的里面加入一些字符串再通过tostring函数进行提取
            tvIndex.setText(new StringBuilder().append(position).append(".  ").toString());
            tvTitle.setText(data.title);
            tvHot.setText(data.hot);
            if(position<3){
                tvIndex.setTextColor(Color.parseColor("#FFD700"));
            }else {
                tvIndex.setTextColor(Color.parseColor("#FFFFFF"));
            }
        }


    }



}
