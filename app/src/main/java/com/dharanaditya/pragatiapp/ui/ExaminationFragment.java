package com.dharanaditya.pragatiapp.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dharanaditya.pragatiapp.DetailsActivity;
import com.dharanaditya.pragatiapp.Model.Examination;
import com.dharanaditya.pragatiapp.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ExaminationFragment extends Fragment {

    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference reference = firebaseDatabase.getReference("examination");

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
//        addData();
    }

    private void addData() {
        for (int i = 0; i < 5; i++) {
            reference.push().setValue(new Examination("ECE","2-2","Tech Summit","Tech Summit 2016 is being conducted in seminar hall 1","Principal PEC",""));
            reference.push().setValue(new Examination("CSE","2-1","Classes Suspender","Classes are suspended on 5-12-16","HOD CSE",""));
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
        final View v = inflater.inflate(R.layout.fragment_examination, container, false);
        RecyclerView recyclerView = (RecyclerView) v.findViewById(R.id.examinationRCV);
        FirebaseRecyclerAdapter<Examination, ExaminationViewHolder> recyclerAdapter =
                new FirebaseRecyclerAdapter<Examination, ExaminationViewHolder>(Examination.class, R.layout.exam_item, ExaminationViewHolder.class, reference) {
                    @Override
                    protected void populateViewHolder(ExaminationViewHolder viewHolder, Examination model, int position) {
                        viewHolder.bindDate(model.getBranch(),model.getSem(),model.getTimestamp(),model.getHead(),model,position);
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

    public static class ExaminationViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView branch, sem, date, head;
        Examination model;
        int pos;

        public ExaminationViewHolder(View itemView) {
            super(itemView);
            branch = (TextView) itemView.findViewById(R.id.exam_branch);
            sem = (TextView) itemView.findViewById(R.id.exam_sem);
            date = (TextView) itemView.findViewById(R.id.exam_date);
            head = (TextView) itemView.findViewById(R.id.exam_head);
            itemView.setOnClickListener(this);
        }

        public void bindDate(String branch, String sem, String date, String head, Examination model, int pos) {
            this.branch.setText(branch);
            this.sem.setText(sem);
            this.date.setText(date);
            this.head.setText(head);
            this.model = model;
            this.pos = pos;
        }

        @Override
        public void onClick(View view) {
//            Log.d(MainActivity.TAG,pos+"");
            Intent i = new Intent(itemView.getContext(), DetailsActivity.class);
            i.putExtra("pos",pos);
            itemView.getContext().startActivity(i);
        }
    }

}

