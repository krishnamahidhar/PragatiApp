package com.dharanaditya.pragatiapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.dharanaditya.pragatiapp.Model.Examination;
import com.dharanaditya.pragatiapp.Model.Notification;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import org.parceler.Parcels;

public class DetailsActivity extends AppCompatActivity {

    TextView branch,sem,date,head,body,author,link;
    AdView adView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        initUI();

        Intent data = getIntent();

        getSupportActionBar().setTitle(data.getStringExtra("title"));

        Object o = Parcels.unwrap(data.getParcelableExtra("parcel"));

        if (o instanceof Examination){
            updateExamUI((Examination) o);
        }else if (o instanceof Notification){
            updateNotifUI((Notification) o);
        }else {
            return;
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
    protected void updateNotifUI(Notification model){
        branch.setText(model.getBranch());
        sem.setText(model.getSem());
        date.setText(model.getTimestamp());
        head.setText(model.getHead());
        body.setText(model.getBody());
        author.setText(model.getAuthor());
        link.setText(model.getLink()+"");
    }
    protected void updateExamUI(Examination model){
        branch.setText(model.getBranch());
        sem.setText(model.getSem());
        date.setText(model.getTimestamp());
        head.setText(model.getHead());
        body.setText(model.getBody());
        author.setText(model.getAuthor());
        link.setText(model.getLink()+"");
    }

    protected void initUI(){
        branch = (TextView) findViewById(R.id.details_branch);
        sem = (TextView) findViewById(R.id.details_sem);
        date = (TextView) findViewById(R.id.details_date);
        head = (TextView) findViewById(R.id.details_head);
        body = (TextView) findViewById(R.id.details_body);
        author = (TextView) findViewById(R.id.details_author);
        link = (TextView) findViewById(R.id.details_links);

        adView = (AdView) findViewById(R.id.deatils_adView);
    }
}
