package com.dharanaditya.pragatiapp;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.dharanaditya.pragatiapp.Adapter.FragmentPagerViewAdapter;
import com.dharanaditya.pragatiapp.Model.Examination;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    DatabaseReference feedReference = firebaseDatabase.getReference("feeds");
    DatabaseReference examsReference = firebaseDatabase.getReference("exams");

    public static final String TAG = "DEBUG_TAG";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle(R.string.college_name);

        fragmentUI();
//        rcvTest();

    }

    private void rcvTest() {
        RecyclerView recyclerView = null;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        FirebaseRecyclerAdapter<Examination,ViewHolder> adapter = new FirebaseRecyclerAdapter<Examination, ViewHolder>(Examination.class,R.layout.exam_item,ViewHolder.class,examsReference) {
            @Override
            protected void populateViewHolder(ViewHolder viewHolder, Examination model, int position) {
                viewHolder.branch.setText(model.getBranch());
                viewHolder.title.setText(model.getTitle());
            }
        };
        recyclerView.setAdapter(adapter);
    }

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

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView title,branch;
        public ViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.exam_title);
            branch = (TextView) itemView.findViewById(R.id.exam_branch);
        }
    }
}
