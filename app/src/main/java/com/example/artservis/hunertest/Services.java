package com.example.artservis.hunertest;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;

public class Services extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);



        ActionBar mActionBar = getSupportActionBar();

        mActionBar.setDisplayShowHomeEnabled(false);
        mActionBar.setDisplayShowTitleEnabled(false);
        mActionBar.setDisplayShowCustomEnabled(true);
        mActionBar.setElevation(0);
        mActionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.gradient_actionbar));
        ViewGroup actionBarLayout = (ViewGroup) getLayoutInflater().inflate(R.layout.select_date_actionbar, null);
        mActionBar.setCustomView(actionBarLayout);

        ImageView backImage = mActionBar.getCustomView().findViewById(R.id.menuIcon);

        backImage.setImageResource(R.drawable.big_back_arrow);


    }
}
