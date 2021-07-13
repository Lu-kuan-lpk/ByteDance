package com.example.pro2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class RollActivity extends AppCompatActivity {

    private static final String TAG="ROLL";

    private RecyclerView recyclerView;
    private MyAdapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private GridLayoutManager gridLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roll);
        Log.d(TAG, "Recycle list activity was created!");
        initview();
    }

    //首先通过id找到我们定义的那个recycler（如果有样式可以在那个xml里面设置）
    // recycle 需要设置
//    1.LayoutManager:限定其的布局方式
//    2.mAdapter：进行内部数据的渲染
//        2.1 ：类中有create函数onCreateViewHolder：在这个函数中将重复的布局进行加载
//        2.2：类中有bind函数：将每一个布局进行渲染
//        2.3：MyViewHolder 通过view找到实例从而可以修改实例

    private void initview(){
        //获取实例
        recyclerView = findViewById(R.id.recycler);
        //更改数据时不会变更宽高
        recyclerView.setHasFixedSize(true);
        //创建线性布局管理器
        layoutManager = new LinearLayoutManager(this);
        //创建格网布局管理器
        gridLayoutManager = new GridLayoutManager(this, 2);
        //设置布局管理器
        recyclerView.setLayoutManager(layoutManager);
        //创建Adapter
        mAdapter = new MyAdapter(TestDataSet.getData());
        //设置Adapter
        recyclerView.setAdapter(mAdapter);
        //设置动画
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        //动画
        DefaultItemAnimator animator = new DefaultItemAnimator();
        animator.setAddDuration(3000);
        recyclerView.setItemAnimator(animator);
    }


}