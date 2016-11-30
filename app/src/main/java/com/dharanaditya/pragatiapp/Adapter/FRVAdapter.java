package com.dharanaditya.pragatiapp.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.dharanaditya.pragatiapp.Model.Exams;
import com.dharanaditya.pragatiapp.Model.Feed;
import com.dharanaditya.pragatiapp.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.Query;

/**
 * Created by dharan1011 on 29/11/16.
 */

public class FRVAdapter extends FirebaseRecyclerAdapter<Object,RecyclerView.ViewHolder>{

    /**
     * @param modelClass      Firebase will marshall the data at a location into an instance of a class that you provide
     * @param modelLayout     This is the layout used to represent a single item in the list. You will be responsible for populating an
     *                        instance of the corresponding view with the data from an instance of modelClass.
     * @param viewHolderClass The class that hold references to all sub-views in an instance modelLayout.
     * @param ref             The Firebase location to watch for data changes. Can also be a slice of a location, using some
     *                        combination of {@code limit()}, {@code startAt()}, and {@code endAt()}.
     */
    private Context context;
    public FRVAdapter(Class<Object> modelClass, int modelLayout, Class<RecyclerView.ViewHolder> viewHolderClass, Query ref, Context context) {
        super(modelClass, modelLayout, viewHolderClass, ref);
        this.context = context;
    }

    @Override
    protected void populateViewHolder(RecyclerView.ViewHolder viewHolder, Object model, int position) {
        if (model instanceof Feed){
//            View v = LayoutInflater.from(this).inflate()
        }else if(model instanceof Exams){

        }
    }

    public static class FeedViewHolder extends RecyclerView.ViewHolder{
        public FeedViewHolder(View itemView) {
            super(itemView);
        }
    }
    public static class ExamsViewHolder extends RecyclerView.ViewHolder {
        TextView branch,title;
        public ExamsViewHolder(View itemView) {
            super(itemView);
            branch = (TextView) itemView.findViewById(R.id.exam_branch);
            title = (TextView) itemView.findViewById(R.id.exam_title);
        }
    }
    public static class DefaultViewHolder extends RecyclerView.ViewHolder{
        public DefaultViewHolder(View itemView) {
            super(itemView);
        }
    }
}
