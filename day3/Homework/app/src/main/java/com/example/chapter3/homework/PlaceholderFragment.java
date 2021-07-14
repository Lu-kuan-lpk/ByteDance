package com.example.chapter3.homework;


import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.airbnb.lottie.LottieAnimationView;
import android.os.Bundle;
import android.view.animation.LinearInterpolator;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class PlaceholderFragment extends Fragment {
    private LottieAnimationView lottieAnimationView;

    private List<TestData> data =new ArrayList<>();
    private RecyclerView recyclerView;
    private MyAdapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    private String TAG="fragment";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO ex3-3: 修改 fragment_placeholder，添加 loading 控件和列表视图控件
        View v=inflater.inflate(R.layout.fragment_placeholder, container, false);
        lottieAnimationView=v.findViewById(R.id.animation_view);
        InitRecycle(v);
        Log.d(TAG, "onCreateView:");
        return v;
    }

    private void InitRecycle(View v) {
        recyclerView = v.findViewById(R.id.recycler);

        recyclerView.setHasFixedSize(true);
        //创建线性布局管理器
        layoutManager = new LinearLayoutManager(v.getContext());

        //设置布局管理器
        recyclerView.setLayoutManager(layoutManager);

        //创建Adapter
        data.add(new TestData("老","good day","2021.7.14",R.drawable.num1));
        data.add(new TestData("师","good day","2021.7.14",R.drawable.num2));
        data.add(new TestData("请","good day","2021.7.14",R.drawable.num3));
        data.add(new TestData("欣","good day","2021.7.14",R.drawable.num4));
        data.add(new TestData("赏","good day","2021.7.14",R.drawable.num5));
        data.add(new TestData("本","good day","2021.7.14",R.drawable.num6));
        data.add(new TestData("人","good day","2021.7.14",R.drawable.num7));
        data.add(new TestData("的","good day","2021.7.14",R.drawable.num8));
        data.add(new TestData("作","good day","2021.7.14",R.drawable.num9));
        data.add(new TestData("业","good day","2021.7.14",R.drawable.num10));
        data.add(new TestData("采","good day","2021.7.14",R.drawable.num11));
        data.add(new TestData("取","good day","2021.7.14",R.drawable.num12));
        data.add(new TestData("了","good day","2021.7.14",R.drawable.num1));
        data.add(new TestData("recyclist","good day","2021.7.14",R.drawable.num2));
        data.add(new TestData("的","good day","2021.7.14",R.drawable.num3));
        data.add(new TestData("方","good day","2021.7.14",R.drawable.num4));
        data.add(new TestData("式","good day","2021.7.14",R.drawable.num5));
        data.add(new TestData("进","good day","2021.7.14",R.drawable.num6));
        data.add(new TestData("行","good day","2021.7.14",R.drawable.num7));
        data.add(new TestData("滚","good day","2021.7.14",R.drawable.num8));
        data.add(new TestData("动","good day","2021.7.14",R.drawable.num9));
        data.add(new TestData("界","good day","2021.7.14",R.drawable.num10));
        data.add(new TestData("面","good day","2021.7.14",R.drawable.num11));
        data.add(new TestData("~","good day","2021.7.14",R.drawable.num12));

        mAdapter = new MyAdapter(data);

        //设置Adapter
        recyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getView().postDelayed(new Runnable() {
            @Override
            public void run() {
                // 这里会在 5s 后执行
                // TODO ex3-4：实现动画，将 lottie 控件淡出，列表数据淡入
                ObjectAnimator in = ObjectAnimator.ofFloat(lottieAnimationView,"alpha",1f,0f);
                in.setDuration(1000);
                in.setRepeatCount(0);
                in.setRepeatMode(ObjectAnimator.RESTART);
                in.setInterpolator(new LinearInterpolator());

                in.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation, boolean isReverse) {
                        ObjectAnimator out = ObjectAnimator.ofFloat(recyclerView,"alpha",0f,1f);
                        out.setDuration(1000);
                        out.setRepeatCount(0);
                        out.setRepeatMode(ObjectAnimator.RESTART);
                        out.setInterpolator(new LinearInterpolator());
                        out.start();
                    }
                });

                in.start();

            }
        }, 5000);
    }
}
