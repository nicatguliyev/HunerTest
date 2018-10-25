package com.example.artservis.hunertest;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.artservis.hunertest.Adapter.DetailListAdapter;
import com.example.artservis.hunertest.Model.DetailModel;

import java.util.ArrayList;

public class Details extends AppCompatActivity {

    ArrayList<DetailModel> models = new ArrayList<>();
    TextView activityNameTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        ActionBar mActionBar = getSupportActionBar();
        mActionBar.hide();

        ImageView backBtn = (ImageView) findViewById(R.id.bacBtn);
        ListView detailList = (ListView) findViewById(R.id.detailList);

        activityNameTxt = (TextView) findViewById(R.id.activityNameTxt);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        int image = 0;

        if (bundle != null) {
            image = bundle.getInt("selectedService");
            activityNameTxt.setText(bundle.getString("selectedServiceName"));
        }

        DetailModel model1 = new DetailModel("Stol 1", "20 AZN", image);


        models.add(model1);
        models.add(model1);
        models.add(model1);
        models.add(model1);
        models.add(model1);
        models.add(model1);
        models.add(model1);
        models.add(model1);

        DetailListAdapter adapter = new DetailListAdapter(getApplicationContext(), models);

        detailList.setAdapter(adapter);


        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                overridePendingTransition(R.anim.come_from_left, R.anim.exit_from_right);

            }
        });

        detailList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                /*finish();
                Services.serviceActivity.finish();
                overridePendingTransition(R.anim.come_from_left, R.anim.exit_from_right);*/

                final RelativeLayout background = view.findViewById(R.id.listItemLyt);

                background.setBackgroundColor(Color.parseColor("#7EFFFFFF"));

                android.os.Handler handler = new android.os.Handler();

                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        background.setBackgroundColor(Color.parseColor("#32383e"));
                    }
                }, 50);

            }
        });

    }

    @Override
    public void onBackPressed() {
        finish();
        overridePendingTransition(R.anim.come_from_left, R.anim.exit_from_right);
    }
}
