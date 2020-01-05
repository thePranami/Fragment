package com.example.thepranami.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.support.v7.app.AppCompatActivity;

public class TestFragActivity extends AppCompatActivity {
    private Button fragOne;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_frag);

        fragOne=findViewById(R.id.addfrag1);

        fragOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.test_container, new FragmentOne()).commit();
            }
        });
    }
}
