package com.dharanaditya.pragatiapp;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.dharanaditya.pragatiapp.Adapter.FragmentPagerViewAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    DatabaseReference feedReference = firebaseDatabase.getReference("feeds");
    DatabaseReference examsReference = firebaseDatabase.getReference("Exams");

    public static final String TAG = "DEBUG_TAG";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle(R.string.college_name);

        FragmentManager fragmentManager = getSupportFragmentManager();

        ViewPager viewPager = (ViewPager) findViewById(R.id.frag_view_pager);
        viewPager.setAdapter(new FragmentPagerViewAdapter(fragmentManager));

    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
