package com.dharanaditya.pragatiapp.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dharanaditya.pragatiapp.MainActivity;
import com.dharanaditya.pragatiapp.Model.Notification;
import com.dharanaditya.pragatiapp.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class NotificationFragment extends Fragment {


    //Firebase
    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference reference = firebaseDatabase.getReference("notifications");
    //UI
    RecyclerView recyclerView;
    FirebaseRecyclerAdapter<Notification, NotificationViewHolder> recyclerAdapter;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
//        addData();
    }

    private void addData() {
        for (int i = 0; i < 5; i++) {
            reference.push().setValue(new Notification("ECE", "Hello World"));

        }
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        reference.keepSynced(true);

    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.fragment_notification, container, false);
        recyclerView = (RecyclerView) v.findViewById(R.id.notificationRCV);

        recyclerAdapter =
                new FirebaseRecyclerAdapter<Notification, NotificationViewHolder>(Notification.class, R.layout.notif_item, NotificationViewHolder.class, reference) {
                    @Override
                    protected void populateViewHolder(NotificationViewHolder viewHolder, Notification model, final int position) {
                        viewHolder.bindData(model.getTimeStamp(), model.getBranch(), model.getTitle(), model);
                    }
                };
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(recyclerAdapter);

        return v;
    }


    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    public static class NotificationViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView date, branch, title;
        Notification model;

        public NotificationViewHolder(View itemView) {
            super(itemView);
            date = (TextView) itemView.findViewById(R.id.notif_date);
            branch = (TextView) itemView.findViewById(R.id.notif_branch);
            title = (TextView) itemView.findViewById(R.id.notif_title);
            itemView.setOnClickListener(this);
        }

        public void bindData(String date, String branch, String title, Notification model) {
            this.date.setText(date);
            this.branch.setText(branch);
            this.title.setText(title);
            this.model = model;
        }

        @Override
        public void onClick(View view) {
            Log.d(MainActivity.TAG, model.toString());
        }
    }

}
