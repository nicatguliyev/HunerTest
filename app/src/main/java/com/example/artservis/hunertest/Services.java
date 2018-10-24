package com.example.artservis.hunertest;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.artservis.hunertest.Adapter.ServiceListAdapter;

import java.util.ArrayList;

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
        servicenames.add("Play Station");
        servicenames.add("Football");
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

    }

    @Override
    public void onBackPressed() {
        finish();
        overridePendingTransition(R.anim.come_from_left, R.anim.exit_from_right);
    }
}
