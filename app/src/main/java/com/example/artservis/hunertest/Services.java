package com.example.artservis.hunertest;

import android.graphics.Color;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.example.artservis.hunertest.Adapter.ServiceListAdapter;

import java.util.ArrayList;
import java.util.logging.Handler;

public class Services extends AppCompatActivity {

    ListView serviceList;
    ArrayList<String> servicenames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);

        serviceList = (ListView) findViewById(R.id.serviceList);

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        ActionBar mActionBar = getSupportActionBar();
        mActionBar.hide();

        ImageView backBtn = (ImageView) findViewById(R.id.bacBtn);

        servicenames  = new ArrayList<>();

        servicenames.add("Play Station");
        servicenames.add("Football");
        servicenames.add("Play Station");
        servicenames.add("Football");



        ServiceListAdapter adapter = new ServiceListAdapter(this, servicenames);

        serviceList.setAdapter(adapter);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                overridePendingTransition(R.anim.come_from_left, R.anim.exit_from_right);
            }
        });

        serviceList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                final RelativeLayout background = view.findViewById(R.id.listItemLyt);

                background.setBackgroundColor(Color.parseColor("#ABFFFFFF"));

                android.os.Handler handler = new android.os.Handler();

                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        background.setBackgroundColor(Color.parseColor("#4b4b4d"));
                    }
                }, 100);

            }
        });

    }

    @Override
    public void onBackPressed() {
        finish();
        overridePendingTransition(R.anim.come_from_left, R.anim.exit_from_right);
    }
}
