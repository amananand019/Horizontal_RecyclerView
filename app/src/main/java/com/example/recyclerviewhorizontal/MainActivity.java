package com.example.recyclerviewhorizontal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    //vars
    private ArrayList<String> mImageUrls = new ArrayList<>();
    private ArrayList<String> mNames = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initImageBitmaps();
    }

    private void initImageBitmaps(){
        Log.d(TAG, "initImageBitmaps: preparing bitmaps. ");

        mImageUrls.add("https://rb.gy/jtycn8");
        mNames.add("Naruto Uzumaki");

        mImageUrls.add("https://rb.gy/h3aw1o");
        mNames.add("Sasuke Uchiha");

        mImageUrls.add("https://rb.gy/ioiqs5");
        mNames.add("Kakashi Hatake");

        mImageUrls.add("https://rb.gy/9goc0p");
        mNames.add("Itachi Uchiha");

        mImageUrls.add("https://rb.gy/uv3whq");
        mNames.add("Hinata Hyuga");

        mImageUrls.add("https://rb.gy/wkfx4z");
        mNames.add("Minato Namikaze");

        mImageUrls.add("https://rb.gy/h44z9c");
        mNames.add("Sakura Haruno");

        mImageUrls.add("https://rb.gy/35r9ad");
        mNames.add("Jiraiya");

        mImageUrls.add("https://rb.gy/rixuls");
        mNames.add("Kushina Uzumaki");

        initRecyclerView();
    }

    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: initializing horizontal recyclerView. ");

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        HorizontalRecyclerViewAdapter horizontalRecyclerViewAdapter =
                new HorizontalRecyclerViewAdapter(this, mImageUrls, mNames);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(horizontalRecyclerViewAdapter);
    }
}