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
import com.google.firebase.database.FirebaseDatabase;


public class NotificationFragment extends Fragment {

    public interface notificationItemOnClick{
        void onNotificationItemClick(Notification model, int position);
    }


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
            reference.push().setValue(new Notification("ECE","1-1","Winter Vaccations","Winter Vaccations 5-12-16 to 15-12-16","HOD ECE",null));
            reference.push().setValue(new Notification("CSE","4-1","Projects Last Data","Last date to submit project is 20-12-16","HOD CSE",null));

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
                        viewHolder.setItemOnClick(new MainActivity());
                        viewHolder.bindData(model.getBranch(),model.getSem(),model.getTimestamp(),model.getHead(),model,position);
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
        TextView branch,sem,date,title;
        Notification model;
        int pos;
        notificationItemOnClick itemOnClick;

        public NotificationViewHolder(View itemView) {
            super(itemView);
            branch = (TextView) itemView.findViewById(R.id.exam_branch);
            sem = (TextView) itemView.findViewById(R.id.exam_sem);
            date = (TextView) itemView.findViewById(R.id.exam_date);
            title = (TextView) itemView.findViewById(R.id.exam_head);
            itemView.setOnClickListener(this);
        }

        public void bindData(String branch,String sem,String date,String head,Notification model,int pos) {
            this.date.setText(date);
            this.branch.setText(branch);
            this.sem.setText(sem);
            this.title.setText(head);
            this.model = model;
            this.pos = pos;
        }

        public void setItemOnClick(notificationItemOnClick itemOnClick) {
            this.itemOnClick = itemOnClick;
        }

        @Override
        public void onClick(View view) {
            itemOnClick.onNotificationItemClick(model,pos);
        }
    }

}
