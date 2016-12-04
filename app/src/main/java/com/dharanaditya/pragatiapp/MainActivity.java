package com.dharanaditya.pragatiapp;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.dharanaditya.pragatiapp.Adapter.FragmentPagerViewAdapter;
import com.dharanaditya.pragatiapp.Model.Examination;
import com.dharanaditya.pragatiapp.Model.Notification;
import com.dharanaditya.pragatiapp.ui.ExaminationFragment;
import com.dharanaditya.pragatiapp.ui.NotificationFragment;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity implements ExaminationFragment.examinationItemOnClick,NotificationFragment.notificationItemOnClick{
    public static FirebaseDatabase firebaseDatabase;

    public static final String TAG = "DEBUG_TAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle(R.string.college_name);

        if (savedInstanceState == null) {
            FirebaseDatabase.getInstance().setPersistenceEnabled(true);
        }

        firebaseDatabase = FirebaseDatabase.getInstance();


        fragmentUI();

    }

    //    Todo uncomment for PageViwer
    private void fragmentUI() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        TabLayout tabLayout = (TabLayout) findViewById(R.id.frag_tab_lay);
        ViewPager viewPager = (ViewPager) findViewById(R.id.frag_view_pager);
        viewPager.setAdapter(new FragmentPagerViewAdapter(fragmentManager));
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void onExamItemClick(Examination model, int position) {
//        Toast.makeText(this.getApplicationContext(), "Hello World "+position, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNotificationItemClick(Notification model, int position) {
//        Toast.makeText(this, "Hello World "+position, Toast.LENGTH_SHORT).show();
    }
}
