package com.example.tictok.Stream;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;

import com.example.tictok.R;

public class StreamActivity extends AppCompatActivity {

    private RecyclerView stream;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stream);

        stream = findViewById(R.id.stream);
        stream.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        stream.setAdapter(new StreamAdapter(StreamActivity.this));
    }
}