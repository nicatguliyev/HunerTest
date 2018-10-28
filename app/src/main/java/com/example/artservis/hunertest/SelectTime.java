package com.example.artservis.hunertest;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.artservis.hunertest.Adapter.GridAdapter;
import com.example.artservis.hunertest.Adapter.SelectTimeAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class SelectTime extends AppCompatActivity {

    GridView timeGrid;
    ArrayList<String> times = new ArrayList<>();
    Button nextBtn;
    HashMap<Integer, String> selectedTimes = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_time);

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        ActionBar mActionBar = getSupportActionBar();

        mActionBar.hide();

        ImageView backBtn = (ImageView) findViewById(R.id.backBtn);
        nextBtn = (Button) findViewById(R.id.nextBtn);

        timeGrid = (GridView) findViewById(R.id.timeGrid);


        times.add("07:00 - 08:00");
        times.add("07:00 - 08:00");
        times.add("07:00 - 08:00");
        times.add("07:00 - 08:00");
        times.add("07:00 - 08:00");
        times.add("07:00 - 08:00");
        times.add("07:00 - 08:00");
        times.add("07:00 - 08:00");
        times.add("07:00 - 08:00");
        times.add("07:00 - 08:00");
        times.add("07:00 - 08:00");
        times.add("07:00 - 08:00");

        SelectTimeAdapter adapter = new SelectTimeAdapter(getApplicationContext(), times);

        timeGrid.setAdapter(new SelectTimeAdapter(getApplicationContext(), times){

            @Override
            public View getView(int i, View view, ViewGroup viewGroup) {

                View itemView = super.getView(i, view, viewGroup);
                GradientDrawable background = (GradientDrawable) itemView.getBackground();
                ImageView doneIcon = itemView.findViewById(R.id.doneIcon);

                background.setColor(Color.parseColor("#4b4b4d"));


                return itemView;
            }
        });


        timeGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ImageView doneIcon = view.findViewById(R.id.doneIcon);
                TextView timeTxt = view.findViewById(R.id.timeTxt);
                //doneIcon.setVisibility(View.VISIBLE);

                GradientDrawable background = (GradientDrawable) view.getBackground();

                if(doneIcon.getVisibility() == View.INVISIBLE){
                    doneIcon.setVisibility(View.VISIBLE);
                    background.setColor(Color.parseColor("#f5ab30"));
                    selectedTimes.put(i, timeTxt.getText().toString());
                }
                else
                {
                    doneIcon.setVisibility(View.INVISIBLE);
                    background.setColor(Color.parseColor("#4b4b4d"));
                    selectedTimes.remove(i);
                }


            }
        });

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                overridePendingTransition(R.anim.come_from_left, R.anim.exit_from_right);

            }
        });

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(selectedTimes.size() == 0)
                {
                    Toast.makeText(getApplicationContext(), "Zəhmət olmasa saatı seçin", Toast.LENGTH_SHORT).show();

                }
                else
                {
                    Log.i("OOOOO", "OOOOOOO");
                }
            }
        });

    }

    @Override
    public void onBackPressed() {
        finish();
        overridePendingTransition(R.anim.come_from_left, R.anim.exit_from_right);
    }
}
