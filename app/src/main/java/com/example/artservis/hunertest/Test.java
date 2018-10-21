package com.example.artservis.hunertest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.widget.GridView;

import com.example.artservis.hunertest.Adapter.GridAdapter;

public class Test extends AppCompatActivity {

    GridView myGridView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        int[] images = {
                R.drawable.en,
                R.drawable.f3,
                R.drawable.f4,
                R.drawable.o1,
                R.drawable.o2,
                R.drawable.o3,
                R.drawable.o4,
                R.drawable.o5,
                R.drawable.o6,
                R.drawable.ru,
                R.drawable.tr,
                R.drawable.user1
        };
        myGridView = (GridView) findViewById(R.id.gridView);



        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int width = displayMetrics.widthPixels;

        // Ekranin enini 5 beraber hisseye bolur.

        myGridView.setColumnWidth(width /5);

        GridAdapter adapter = new GridAdapter(this, images);

        myGridView.setAdapter(adapter);

            }
}
