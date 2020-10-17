package com.example.thepranami.fragment;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class TestCmnActivity extends AppCompatActivity implements SendTextListener{

    FragmentTwo frtTwo;
    FragmentOne frtOne;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_cmn);
        frtOne = new FragmentOne();
        frtTwo = new FragmentTwo();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frame1, frtOne)
                .replace(R.id.frame2, frtTwo)
                .commit();
    }

    @Override
    public void sendText(String text) {
        frtTwo.getFromFirst(text);
        frtOne.getFromSecond(text);

    }

    @Override
    public void changeButtonColor(int color) {
        frtOne.getColor(color);
    }
}
