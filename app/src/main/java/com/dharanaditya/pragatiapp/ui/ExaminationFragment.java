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
            reference.push().setValue(new Examination("ECE", "2-2", "Hello World"));
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
                        viewHolder.bindDate(model.getBranch(), model.getSem(), model.getTimeStamp(), model.getTitle(), model);
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
        TextView branch, sem, date, title;
        Examination model;

        public ExaminationViewHolder(View itemView) {
            super(itemView);
            branch = (TextView) itemView.findViewById(R.id.exam_branch);
            sem = (TextView) itemView.findViewById(R.id.exam_sem);
            date = (TextView) itemView.findViewById(R.id.exam_date);
            title = (TextView) itemView.findViewById(R.id.exam_title);

            itemView.setOnClickListener(this);
        }

        public void bindDate(String branch, String sem, String date, String title, Examination model) {
            this.branch.setText(branch);
            this.sem.setText(sem);
            this.date.setText(date);
            this.title.setText(title);
            this.model = model;
        }

        @Override
        public void onClick(View view) {
            Log.d(MainActivity.TAG, model.toString());
        }
    }

}

