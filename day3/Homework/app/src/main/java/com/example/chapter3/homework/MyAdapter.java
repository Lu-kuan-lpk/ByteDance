package com.example.chapter3.homework;

import android.graphics.Color;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private List<TestData> mDataset = new ArrayList<>();

    public MyAdapter(List<TestData> myData){
        mDataset.addAll(myData);
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int position) {
        LayoutInflater layoutInflater=LayoutInflater.from(viewGroup.getContext());
        //将一个布局转化为一个view并返回
        View itemv= layoutInflater.inflate(R.layout.items,viewGroup,false);
        return new MyViewHolder(itemv);
    }

    @Override
    public void onBindViewHolder(MyAdapter.MyViewHolder myViewHolder, int position) {
        myViewHolder.bind(position,mDataset.get(position));
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView out;
        private TextView in1;
        private TextView in2;
        private ImageView img;
        private View contentView; //整体的内容，是必要的


        public MyViewHolder(View v) {
            super(v);
            contentView = v;
            in1=v.findViewById(R.id.inner1);
            in2=v.findViewById(R.id.inner2);
            out=v.findViewById(R.id.out);
           img=v.findViewById(R.id.pic);
            //out=v.findViewById(R.id.t);
        }

        public void bind(int position, TestData data){
            in1.setText(data.s1);
            in2.setText(data.s2);
            out.setText(data.name);
            //Uri imgu=Uri.parse(R.drawable.num1);
            //img.setImageURI(imgu);
            img.setImageResource(data.pic);
            //out.setText(data.name);
        }
    }
}
