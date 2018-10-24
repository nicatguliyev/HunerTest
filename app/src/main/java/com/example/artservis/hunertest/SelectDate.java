package com.example.artservis.hunertest;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.PersistableBundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.artservis.hunertest.Adapter.GridAdapter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class SelectDate extends AppCompatActivity {

    GridView myGridView;
    View selectedItemView;  // secilmis tarixe uygun view-nu gosterir.
    int selectedItemIndex = -1;  // Secilmis tarixin indexini gosterir.
    Map<String, String> months = new HashMap<String, String>();
    ArrayList<String> monthWithNames = new ArrayList<>();
    ArrayList<String> days = new ArrayList<>();
    ArrayList<String> fullDate = new ArrayList<>();

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_date);


        RelativeLayout nextBtn = (RelativeLayout) findViewById(R.id.nextBtn);

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        ActionBar mActionBar = getSupportActionBar();

        mActionBar.hide();


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

            for (int i = 1; i <= 30; i++) {
                if (i == 1) {
                    c.add(Calendar.DATE, 0);
                } else {
                    c.add(Calendar.DATE, 1);
                }


                sdf = new SimpleDateFormat("MM/dd/yyyy");

                Date resultDate = new Date(c.getTimeInMillis());
                dateInString = sdf.format(resultDate);

                String dayWithNumber = String.valueOf(Integer.parseInt(dateInString.substring(3, 5)));
                monthWithNames.add(months.get(dateInString.substring(0, 2)).substring(0, 3));
                days.add(dayWithNumber);

                fullDate.add(dateInString.substring(3, 5) + " " + months.get(dateInString.substring(0, 2)).substring(0, 3) + ", " + dateInString.substring(6,10));
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }

        GradientDrawable background = (GradientDrawable) getResources().getDrawable(R.drawable.date_column_border);
        background.setColor(Color.parseColor("#4b4b4d"));

        myGridView = (GridView) findViewById(R.id.gridView);

        // Ekranin enini piksellerle  oyrenmek ucun.
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int width = displayMetrics.widthPixels;

        // Ekranin enini 5 beraber hisseye bolub
        myGridView.setColumnWidth(width / 5);

        final GridAdapter adapter = new GridAdapter(this, monthWithNames, days);

        // App-in orientaionu deyisen zaman.
        if(savedInstanceState != null)
        {
            // Eger her hansi bir tarix secib orientation deyisdikde
            if( savedInstanceState.getInt("selectedIndex") != -1)
            {
                selectedItemIndex = savedInstanceState.getInt("selectedIndex");
                selectedItemView = adapter.getView(selectedItemIndex, null, myGridView);

                myGridView.setAdapter(new GridAdapter(this, monthWithNames, days)
                {
                    @Override
                    public View getView(int i, View view, ViewGroup viewGroup) {
                        View itemView = super.getView(i, view, viewGroup);
                        GradientDrawable background = (GradientDrawable) itemView.getBackground();
                        ImageView doneIcon = itemView.findViewById(R.id.doneIcon);

                        if(i == selectedItemIndex)
                        {

                            doneIcon.setVisibility(View.VISIBLE);
                            background.setColor(Color.parseColor("#f5ab30"));
                            selectedItemView = itemView;
                        }
                        else
                        {
                            doneIcon.setVisibility(View.INVISIBLE);
                            background.setColor(Color.parseColor("#4b4b4d"));
                        }
                        return itemView;
                    }
                });
            }


            // Eger Hec bir tarix Secilmeyib orientation deyisdiyi zaman
            else
            {

                myGridView.setAdapter(new GridAdapter(this, monthWithNames, days)
                {
                    @Override
                    public View getView(int i, View view, ViewGroup viewGroup) {
                        View itemView = super.getView(i, view, viewGroup);
                        GradientDrawable background = (GradientDrawable) itemView.getBackground();
                        ImageView doneIcon = itemView.findViewById(R.id.doneIcon);

                        if(i == selectedItemIndex)
                        {

                            doneIcon.setVisibility(View.VISIBLE);
                            background.setColor(Color.parseColor("#f5ab30"));
                            selectedItemView = itemView;
                        }
                        else
                        {
                            doneIcon.setVisibility(View.INVISIBLE);
                            background.setColor(Color.parseColor("#4b4b4d"));
                        }
                        return itemView;
                    }
                });
            }

        }

        // Program ilk acildiginda
        else
        {
            myGridView.setAdapter(adapter);
        }

        myGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                ImageView doneIcon = view.findViewById(R.id.doneIcon);
                doneIcon.setVisibility(View.VISIBLE);

                GradientDrawable background = (GradientDrawable) view.getBackground();
                background.setColor(Color.parseColor("#f5ab30"));

                // En birinci tarix secilende hemin tarixin indexini selectedItemIndex - e menimsedir.
                if (selectedItemIndex == -1) {
                    selectedItemIndex = i;
                }


                if (selectedItemView != null) {
                    if (i != selectedItemIndex) {
                        selectedItemView.findViewById(R.id.doneIcon).setVisibility(View.INVISIBLE);
                        GradientDrawable oldItemBackground = (GradientDrawable) selectedItemView.getBackground();
                        oldItemBackground.setColor(Color.parseColor("#4b4b4d"));
                        selectedItemView = view;
                        selectedItemIndex = i;
                    }

                } else {
                    selectedItemView = view;
                }


            }
        });


        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (selectedItemIndex == -1) {
                    Toast.makeText(getApplicationContext(), "Zəhmət olmasa tarixi seçin.", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intentToServices = new Intent(getApplicationContext(), Services.class);
                    intentToServices.putExtra("fullDate", fullDate.get(selectedItemIndex));
                    startActivity(intentToServices);
                    overridePendingTransition(R.anim.come_from_right, R.anim.exit_from_left);

                }
            }
        });

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt("selectedIndex", selectedItemIndex);
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onBackPressed()  {
        finish();
    }
}
