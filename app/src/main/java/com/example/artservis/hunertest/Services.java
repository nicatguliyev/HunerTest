package com.example.artservis.hunertest;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.artservis.hunertest.Adapter.ServiceListAdapter;

import java.util.ArrayList;
import java.util.logging.Handler;

public class Services extends AppCompatActivity {

    ListView serviceList;
    ArrayList<String> servicenames;
    ArrayList<Integer> serviceImages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);

        serviceList = (ListView) findViewById(R.id.serviceList);

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        ActionBar mActionBar = getSupportActionBar();
        mActionBar.hide();

        ImageView backBtn = (ImageView) findViewById(R.id.bacBtn);
        TextView activityNameTxt = (TextView) findViewById(R.id.activityNameTxt);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        if(bundle != null)
        {
           // Log.i("TATA",  bundle.getString("fullDate"));
            activityNameTxt.setText("Xidmetler(" + bundle.getString("fullDate") + ")");
        }

        servicenames  = new ArrayList<>();

        servicenames.add("Play Station");
        servicenames.add("Football");
        servicenames.add("Pivə");

        serviceImages = new ArrayList<>();

        serviceImages.add(R.drawable.game_icon);
        serviceImages.add(R.drawable.ball);
        serviceImages.add(R.drawable.beer_icon);

        ServiceListAdapter adapter = new ServiceListAdapter(this, servicenames, serviceImages);

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

                background.setBackgroundColor(Color.parseColor("#7EFFFFFF"));

                android.os.Handler handler = new android.os.Handler();

                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        background.setBackgroundColor(Color.parseColor("#32383e"));
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
