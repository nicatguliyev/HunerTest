package com.example.artservis.hunertest;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.artservis.hunertest.Adapter.DetailListAdapter;
import com.example.artservis.hunertest.Model.DetailModel;

import java.util.ArrayList;

public class Details extends AppCompatActivity {

    ArrayList<DetailModel> models = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        ActionBar mActionBar = getSupportActionBar();
        mActionBar.hide();

        ImageView backBtn = (ImageView) findViewById(R.id.bacBtn);
        ListView detailList = (ListView) findViewById(R.id.detailList);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        int image = 0;

        if(bundle != null)
        {
            image = bundle.getInt("selectedService");
        }



        DetailModel model1 = new DetailModel("Stol 1", "20 azn", image );


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

    }

    @Override
    public void onBackPressed() {
        finish();
        overridePendingTransition(R.anim.come_from_left, R.anim.exit_from_right);
    }
}
