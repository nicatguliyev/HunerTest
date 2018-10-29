package com.example.artservis.hunertest;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AccelerateDecelerateInterpolator;
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

import static android.text.Spanned.SPAN_INCLUSIVE_INCLUSIVE;

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
        times.add("08:00 - 09:00");
        times.add("09:00 - 10:00");
        times.add("10:00 - 11:00");
        times.add("11:00 - 12:00");
        times.add("12:00 - 13:00");
        times.add("13:00 - 14:00");
        times.add("14:00 - 15:00");
        times.add("15:00 - 16:00");
        times.add("16:00 - 17:00");
        times.add("17:00 - 18:00");
        times.add("18:00 - 19:00");
        times.add("19:00 - 20:00");
        times.add("20:00 - 21:00");
        times.add("21:00 - 22:00");
        times.add("22:00 - 23:00");
        times.add("23:00 - 00:00");


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
                   showDialog();
                }
            }
        });

    }

    public  void showDialog(){

        final Dialog dialog = new Dialog(SelectTime.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setContentView(R.layout.custom_popup);
        dialog.show();


        final TextView messageTxt = dialog.findViewById(R.id.messageTxt);
        final Button cancelBtn = dialog.findViewById(R.id.cancelBtn);
        final Button okBtn = dialog.findViewById(R.id.okBtn);
        final Button closeBtn = dialog.findViewById(R.id.closeBtn);
        final RelativeLayout mainLyt = dialog.findViewById(R.id.parentLyt);

        String message = "Siz " + "<b>NOY - 11</b>"  + " tarixində" + "<b> 12:00-13:00; 16:00-17:00; 13:00-14:00; 17:00-18:00</b>"+" saatlarda"
                + "<b> PlayStation - [ Kabinet #2 ]</b> xidməti sifariş verirsiniz Xidmətin qiyməti " + "<b>100-AZN</b>";

        messageTxt.setText(Html.fromHtml(message));


        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final Handler handler = new Handler();

                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        dialog.dismiss();
                    }
                }, 300);

                mainLyt.animate().scaleY(0).setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(250);


            }
        });

        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                messageTxt.setText("SIFARISINIZ QEBUL OLUNDU");
                okBtn.setVisibility(View.INVISIBLE);
                cancelBtn.setVisibility(View.INVISIBLE);
                closeBtn.setVisibility(View.VISIBLE);
            }
        });

        closeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Handler handler = new Handler();

                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        dialog.dismiss();
                    }
                }, 300);

                mainLyt.animate().scaleY(0).setInterpolator(new AccelerateDecelerateInterpolator()).setDuration(250);
            }
        });

        DisplayMetrics metrics = getResources().getDisplayMetrics();
        int width = metrics.widthPixels;
        dialog.getWindow().setLayout(width, ViewGroup.LayoutParams.WRAP_CONTENT);


    }

    @Override
    public void onBackPressed() {
        finish();
        overridePendingTransition(R.anim.come_from_left, R.anim.exit_from_right);
    }
}
