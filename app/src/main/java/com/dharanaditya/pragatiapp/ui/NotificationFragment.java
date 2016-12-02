package com.dharanaditya.pragatiapp.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dharanaditya.pragatiapp.MainActivity;
import com.dharanaditya.pragatiapp.Model.Notification;
import com.dharanaditya.pragatiapp.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;


public class NotificationFragment extends Fragment{
    RecyclerView recyclerView;
    DatabaseReference databaseReference = MainActivity.firebaseDatabase.getReference("notifications");
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        for (int i=0;i<5;i++){
            databaseReference.push().setValue(new Notification("ECE","Hello World"));

        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_notification,container,false);
        recyclerView = (RecyclerView) v.findViewById(R.id.notificationRCV);

        FirebaseRecyclerAdapter<Notification,NotificationViewHolder> recyclerAdapter =
                new FirebaseRecyclerAdapter<Notification, NotificationViewHolder>(Notification.class,R.layout.notif_item,NotificationViewHolder.class,databaseReference) {
                    @Override
                    protected void populateViewHolder(NotificationViewHolder viewHolder, Notification model, int position) {
                        viewHolder.bindData(model.getTimeStamp(),model.getBranch(),model.getTitle());
                    }
                };

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(recyclerAdapter);
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    public static class NotificationViewHolder extends RecyclerView.ViewHolder{
        TextView date,branch,title;
        public NotificationViewHolder(View itemView) {
            super(itemView);
            date = (TextView) itemView.findViewById(R.id.notif_date);
            branch = (TextView) itemView.findViewById(R.id.notif_branch);
            title = (TextView) itemView.findViewById(R.id.notif_title);
        }
        public void bindData(String date,String branch,String title){
            this.date.setText(date);
            this.branch.setText(branch);
            this.title.setText(title);
        }
    }

}
