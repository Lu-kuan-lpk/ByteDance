package com.example.tictok.Camera;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.tictok.R;
import com.example.tictok.Upload.UploadActivity;

public class CameraActivity extends AppCompatActivity {

    private int num =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

        ImageButton back = findViewById(R.id.camera_back);
        ImageButton shot = findViewById(R.id.camera_shot);

        shot.setOnClickListener(new View.OnClickListener() {
            //点击拍摄的事件
            @Override
            public void onClick(View v) {
                if(num==0){
                    //开始拍摄

                    num++;
                }
                else if(num==1){
                    //结束拍摄,储存视频


                    //跳转到upload界面
                    Intent intent= new Intent(CameraActivity.this, UploadActivity.class);
                    startActivity(intent);
                }
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });




    }
}