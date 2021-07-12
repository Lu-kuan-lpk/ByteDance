package com.example.pro1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.nfc.Tag;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    int i=0;
    int j=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn1 = findViewById(R.id.advise);
        Button btn2 = findViewById(R.id.change);
        ImageView iv1= findViewById(R.id.bytedance);
        ImageView iv2= findViewById(R.id.zju);
        Switch s1 =  findViewById(R.id.switch1);
        final TextView tv1=findViewById(R.id.Testviewing);

        btn1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                tv1.setText("thanks for your checking!");
                Log.d("Main","btn1");
            }

        });

        btn2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(i%2==1){
                    iv1.setVisibility(View.VISIBLE);//显示
                    iv2.setVisibility(View.GONE);//
                    i++;
                }
                else{
                    iv2.setVisibility(View.VISIBLE);//显示
                    iv1.setVisibility(View.GONE);//显示
                    i++;
                }
                Log.d("Main","btn2");
            }

        });

        s1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (j%2==0) {
                    j++;
                    btn1.setBackgroundColor(0xff0f0f0f);
                    btn2.setBackgroundColor(0xff0f0f0f);
                }
                else {
                    j++;
                    btn1.setBackgroundColor(0xfff0f0f0);
                    btn2.setBackgroundColor(0xfff0f0f0);
                }
                Log.d("Main","s1");
            }
        });

    }
}