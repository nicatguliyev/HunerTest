package com.example.artservis.hunertest;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.artservis.hunertest.Adapter.GridAdapter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Test extends AppCompatActivity {

    GridView myGridView;
    View selectedItemView;  // secilmis tarixe uygun view-nu gosterir.
    int selectedItemIndex = -1;  // Secilmis tarixin indexini gosterir.
    Map<String, String> months = new HashMap<String, String>();
    ArrayList<String> monthWithNames = new ArrayList<>();
    ArrayList<String> days = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);



        ActionBar mActionBar = getSupportActionBar();

        mActionBar.setDisplayShowHomeEnabled(false);
        mActionBar.setDisplayShowTitleEnabled(false);
        mActionBar.setDisplayShowCustomEnabled(true);
        mActionBar.setElevation(0);
        mActionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#898989")));

        ViewGroup actionBarLayout = (ViewGroup) getLayoutInflater().inflate(R.layout.select_date_actionbar, null);
        mActionBar.setCustomView(actionBarLayout);


        months.put("01", "Yanvar");
        months.put("02", "Fevral");
        months.put("03", "Mart");
        months.put("04", "Aprel");
        months.put("05", "May");
        months.put("06", "Iyun");
        months.put("07", "Iyul");
        months.put("08", "Avqust");
        months.put("09", "Sentyabr");
        months.put("10", "Oktyabr");
        months.put("11", "Noyabr");
        months.put("12", "Dekabr");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        Date currentDate = Calendar.getInstance().getTime();
        String dateInString = sdf.format(currentDate);
        try {

            c.setTime(sdf.parse(dateInString));

            for(int i = 1; i <= 30 ; i++)
            {
                if(i == 1)
                {
                    c.add(Calendar.DATE, 0);
                }

                else
                {
                    c.add(Calendar.DATE, 1);
                }


                sdf = new SimpleDateFormat("MM/dd/yyyy");

                Date resultDate = new Date(c.getTimeInMillis());
                dateInString = sdf.format(resultDate);

                String dayWithNumber = String.valueOf(Integer.parseInt(dateInString.substring(3,5)));
                monthWithNames.add(months.get(dateInString.substring(0,2)).substring(0,3));
                days.add(dayWithNumber);

            }

        } catch (ParseException e) {
            e.printStackTrace();
        }

        myGridView = (GridView) findViewById(R.id.gridView);



        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int width = displayMetrics.widthPixels;

        // Ekranin enini 5 beraber hisseye bolub

        myGridView.setColumnWidth(width /5);

        GridAdapter adapter = new GridAdapter(this, monthWithNames, days);

        myGridView.setAdapter(adapter);

        myGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                ImageView doneIcon = view.findViewById(R.id.doneIcon);
                doneIcon.setVisibility(View.VISIBLE);

                GradientDrawable background = (GradientDrawable) view.getBackground();
                background.setColor(Color.parseColor("#f5ab30"));

                // En birinci tarix secilende hemin tarixin indexini selectedItemIndex - e menimsedir.
                if(selectedItemIndex == -1)
                {
                    selectedItemIndex = i;
                }


                if(selectedItemView != null)
                {
                    if(i != selectedItemIndex)
                    {
                        selectedItemView.findViewById(R.id.doneIcon).setVisibility(View.INVISIBLE);
                        GradientDrawable oldItemBackground = (GradientDrawable) selectedItemView.getBackground();
                        oldItemBackground.setColor(Color.parseColor("#4b4b4d"));
                        selectedItemView = view;
                        selectedItemIndex = i;
                    }

                }
                else
                {
                    selectedItemView = view;
                }

            }
        });


    }
}
