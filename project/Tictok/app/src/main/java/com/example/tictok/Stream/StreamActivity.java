package com.example.tictok.Stream;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.tictok.Broad.BroadActivity;
import com.example.tictok.Camera.CameraActivity;
import com.example.tictok.Mine.MineActivity;
import com.example.tictok.Mine.MineFragment;
import com.example.tictok.Network.MessageListResponse;
import com.example.tictok.Network.PullData;
import com.example.tictok.Network.PullEndListener;
import com.example.tictok.R;
import com.example.tictok.Upload.UploadActivity;

import java.util.ArrayList;

public class StreamActivity extends AppCompatActivity {

    private RecyclerView stream;
    private ImageButton camera;
    public int flag=2; //表示开始的界面
    public static MessageListResponse tmpmessage =null; //里面储存网上扒拉下来的所有数据
    public static MessageListResponse likemessage =null;
    public StreamAdapter adapter;
    public Button mine;
    public Button upload;
    public Button message;
    int num=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stream);

        Thread netpull = new Thread(new Runnable() {
            @Override
            public void run() {
                NetworkRequesting();
                while(true){
                    if(flag==1){
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                SetView();

                                SetRecycler();

                                SetListener();
                            }
                        });
                        flag=2;
                        break;
                    }
                }

            }
        });
        netpull.start();

//
//        //等待网络线程执行结束之后再进行UI绘制
//        while(true){
//            if(flag==1){
//                SetView();
//
//                SetRecycler();
//
//                SetListener();
//
//                break;
//            }
//        }

//        SetView();
//
//        SetRecycler();
//
//        SetListener();



    }

    public void SetView(){
        upload=findViewById(R.id.stream_upload);
        mine=findViewById(R.id.stream_mine);
        message=findViewById(R.id.stream_message);
        likemessage = new MessageListResponse();
        likemessage.feeds = new ArrayList<>();
    }

    public void NetworkRequesting(){
        //开启网络的线程
        PullData netthread = new PullData();
        netthread.setPullEndListener(new PullEndListener() {
            @Override
            public void Finish() {
                flag=1; //表示异步线程已经结束了，可以开始进行UI界面的绘画
                return;
            }

            @Override
            public void DataReturn(MessageListResponse messageListResponse) {
                tmpmessage=messageListResponse;
                return;
            }
        });
        netthread.start();
    }


    void SetRecycler(){
        //初始化recycler和其监听
        stream = findViewById(R.id.stream);
        stream.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        adapter = new StreamAdapter(tmpmessage,StreamActivity.this);
        adapter.setBroadClickListener(new BroadClickListener() {
            @Override
            public void jump(int position) {
                Intent intent = new Intent(StreamActivity.this, BroadActivity.class);
                intent.putExtra("pos",position);
                intent.putExtra("Activity","Stream");
                startActivity(intent);
            }
        });
        stream.setAdapter(adapter);
    }

    void SetListener(){
        //设置camera图标的监听
        camera = findViewById(R.id.stream_camera);
        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StreamActivity.this, CameraActivity.class);
                startActivity(intent);
            }
        });

        //三个button的跳转事件
        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StreamActivity.this, UploadActivity.class);
                startActivity(intent);
            }
        });

        mine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StreamActivity.this, MineActivity.class);
                startActivity(intent);
            }
        });

        message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StreamActivity.this, MineActivity.class);
                startActivity(intent);
            }
        });
    }


    @Override
    protected void onResume() {
        super.onResume();
        flag=2;
        if(num!=0){
            Thread netrefresh = new Thread(new Runnable() {
                @Override
                public void run() {
                    NetworkRequesting();
                    while(true){
                        if(flag==1){
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    adapter.refresh();
                                }
                            });

                            break;
                        }
                    }
                }
            });
            netrefresh.start();
        }
        num++;
//        NetworkRequesting();
//        while(true){
//            if(flag==1){
//                adapter.refresh();
//                break;
//            }
//        }
//        adapter.refresh();
    }
}