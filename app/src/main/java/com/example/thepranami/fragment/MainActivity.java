package com.example.thepranami.fragment;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        WindowManager windowManager = (WindowManager)getSystemService(WINDOW_SERVICE);
        Display display = windowManager.getDefaultDisplay();
        LinearLayout linearLayout = findViewById(R.id.mainLinear);

        int H = display.getHeight();
        int W = display.getWidth();

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        if (H>W){
            ft.replace(R.id.mainLinear, new FragmentOne());
            linearLayout.setVisibility(View.GONE);
        }
        else if (W>H){
            ft.replace(R.id.mainLinear, new FragmentTwo());
            linearLayout.setVisibility(View.GONE);
        }
        ft.commit();
    }
}
