package com.dharanaditya.pragatiapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent data = getIntent();
        int pos = data.getIntExtra("pos",0);

        Log.d(MainActivity.TAG,pos+"");
    }
}
