package com.dharanaditya.pragatiapp.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dharanaditya.pragatiapp.Model.Exams;
import com.dharanaditya.pragatiapp.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ExamsFragment extends Fragment {
    FirebaseDatabase firebaseDatabase =FirebaseDatabase.getInstance();
    DatabaseReference reference = firebaseDatabase.getReference("exams");
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.fragment_exams,container,false);
        RecyclerView recyclerView = (RecyclerView) v.findViewById(R.id.examsRCV);
        FirebaseRecyclerAdapter<Exams,ViewHolder> adapter = new FirebaseRecyclerAdapter<Exams, ViewHolder>(Exams.class,R.layout.exam_item,ViewHolder.class,reference) {
            @Override
            protected void populateViewHolder(ViewHolder viewHolder, Exams model, int position) {
                viewHolder.branch.setText(model.getBranch());
                viewHolder.title.setText(model.getTitle());
            }
        };
        recyclerView.setAdapter(adapter);
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

    private class ViewHolder extends RecyclerView.ViewHolder{
        TextView title,branch;
        public ViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.exam_title);
            branch = (TextView) itemView.findViewById(R.id.exam_branch);
        }
    }
}

