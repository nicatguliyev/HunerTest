package com.example.artservis.hunertest;

import android.app.Activity;
import android.graphics.Color;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Login extends AppCompatActivity {

    ImageView userImage, passImage;
    EditText userNameEdt, passwordEdt;
    View userNameView, passView;
    RelativeLayout rootView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        ActionBar mActionBar = getSupportActionBar();

        mActionBar.hide();

        rootView = (RelativeLayout) findViewById(R.id.rootLyt);

        userImage = (ImageView) findViewById(R.id.user_icon);
        passImage = (ImageView) findViewById(R.id.password_icon);

        userNameEdt = (EditText) findViewById(R.id.userNameEdt);
        passwordEdt = (EditText) findViewById(R.id.passwordEdt);


        userNameView = findViewById(R.id.userEdtView);
        passView = findViewById(R.id.passEdtViev);

        userNameEdt.clearFocus();

        userNameEdt.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(b)
                {
                    userNameView.setBackgroundColor(Color.parseColor("#faa831"));
                    userImage.setImageResource(R.drawable.user_icon_gold);

                }
                else
                {
                    userNameView.setBackgroundColor(Color.parseColor("#FF556677"));
                    userImage.setImageResource(R.drawable.user_edt_icon);
                      InputMethodManager imm = (InputMethodManager) getApplicationContext().getSystemService(Activity.INPUT_METHOD_SERVICE);
                      imm.hideSoftInputFromWindow(rootView.getWindowToken(), 0);
                }
            }
        });

        passwordEdt.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(b)
                {
                    passView.setBackgroundColor(Color.parseColor("#faa831"));
                    passImage.setImageResource(R.drawable.pass_icon_gold);
                }
                else
                {
                    passView.setBackgroundColor(Color.parseColor("#FF556677"));
                    passImage.setImageResource(R.drawable.pass_icon2);
                      InputMethodManager imm = (InputMethodManager) getApplicationContext().getSystemService(Activity.INPUT_METHOD_SERVICE);
                      imm.hideSoftInputFromWindow(rootView.getWindowToken(), 0);
                }
            }
        });

   passwordEdt.setOnEditorActionListener(new TextView.OnEditorActionListener() {
       @Override
       public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
           if(i== EditorInfo.IME_ACTION_DONE){
               passwordEdt.clearFocus();
               InputMethodManager imm = (InputMethodManager) getApplicationContext().getSystemService(Activity.INPUT_METHOD_SERVICE);
               imm.hideSoftInputFromWindow(rootView.getWindowToken(), 0);

           }
           return false;
       }
   });


        rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userNameEdt.clearFocus();
                passwordEdt.clearFocus();
                InputMethodManager imm = (InputMethodManager) getApplicationContext().getSystemService(Activity.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
            }
        });
    }
}
