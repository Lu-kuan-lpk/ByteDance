package com.example.mediaworksdemo;

import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.TransitionOptions;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.transition.DrawableCrossFadeFactory;

public class PictureDetailActivity extends AppCompatActivity {

    String mockUrl = "https://lf1-cdn-tos.bytescm.com/obj/static/ies/bytedance_official_cn/_next/static/images/0-390b5def140dc370854c98b8e82ad394.png";
    String mockErrorUrl = "https://upload.wikimedia.org/wikipedia/commons/thumb/6/64/Android_logo_2019_%28stacked%29.svg/400px-Android_logo_2019_%28stacked%29.svg.png";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture_detail);

        ImageView imageView = findViewById(R.id.iv_detail);
        Button btnSuccess = findViewById(R.id.btn_load_success);
        Button btnFail = findViewById(R.id.btn_load_fail);
        Button btnRoundedCorners = findViewById(R.id.btn_rounded_corners);
        Button btncircle = findViewById(R.id.btn_circle);

        btnSuccess.setOnClickListener( v -> {
            Glide.with(this).load(mockUrl)
                    .placeholder(R.drawable.placeholder_blue)//表示在加载的时候显示的东西
                    .error(R.drawable.error_red)
                    .into(imageView);
        });

        btnFail.setOnClickListener( v -> {
            Glide.with(this).load(mockErrorUrl)
                    .placeholder(R.drawable.loading_green)
                    .error(R.drawable.error_red)
                    .into(imageView);
        });

        btnRoundedCorners.setOnClickListener( v-> {
            DrawableCrossFadeFactory drawableCrossFadeFactory = new DrawableCrossFadeFactory.Builder(300).setCrossFadeEnabled(true).build();

            Glide.with(this).load(mockUrl)
                    .placeholder(R.drawable.loading_green)
                    .error(R.drawable.error_red)
                    .apply(RequestOptions.bitmapTransform(new RoundedCorners(50)))
                    .transition(DrawableTransitionOptions.with(drawableCrossFadeFactory))
                    .into(imageView);
        });

        btncircle.setOnClickListener( v -> {
            RequestOptions requestOptions = new RequestOptions();
            requestOptions.centerCrop().circleCrop();
            Glide.with(this).load(mockUrl)
                    .placeholder(R.drawable.loading_green)
                    .error(R.drawable.error_red)
                    .apply(requestOptions)
                    .transition(withCrossFade())
                    .into(imageView);
        });
    }
}