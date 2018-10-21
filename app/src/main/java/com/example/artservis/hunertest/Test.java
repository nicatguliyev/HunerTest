package com.example.artservis.hunertest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.widget.GridView;

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

    Map<String, String> months = new HashMap<String, String>();
    ArrayList<String> monthWithNames = new ArrayList<>();
    ArrayList<String> days = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

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



            }
}
