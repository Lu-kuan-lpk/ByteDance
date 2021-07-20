package com.example.tictok.Upload;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.tictok.Camera.CameraActivity;
import com.example.tictok.R;

public class UploadActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload);

        ImageButton back = findViewById(R.id.upload_back);
        Button submit = findViewById(R.id.upload_submit);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: 2021/7/20 可以改成有本地存储的形态
                finish();
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: 2021/7/20 提交当前的信息



                //返回拍摄界面并且删除
                Toast.makeText(UploadActivity.this,"upload success!",Toast.LENGTH_SHORT).show();
                finish();

            }
        });

    }
}