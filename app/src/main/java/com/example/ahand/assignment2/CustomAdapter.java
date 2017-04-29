package com.example.ahand.assignment2;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ahand on 4/28/17.
 */

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {


    private List<Automobile> automobiles;
    private Context mContext;

    public CustomAdapter(ArrayList<Automobile> automobiles, Context mContext) {
        this.automobiles = automobiles;
        this.mContext = mContext;
    }

    private Context getContext() {
        return mContext;
    }

    @Override
    public CustomAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View automobileView = inflater.inflate(R.layout.item_list, parent, false);

        ViewHolder viewHolder = new ViewHolder(automobileView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CustomAdapter.ViewHolder holder, int position) {
        Automobile auto = automobiles.get(position);

        TextView make_id = holder.list_item_make_id;
        TextView make = holder.list_item_make;

        make_id.setText(String.valueOf(auto.getMake_id()));
        make.setText(auto.getMake());

    }

    @Override
    public int getItemCount() {
        return automobiles.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public TextView list_item_make_id;
        public TextView list_item_make;

        public ViewHolder(View itemView){
            super(itemView);
            list_item_make_id = (TextView) itemView.findViewById(R.id.make_id);
            list_item_make = (TextView) itemView.findViewById(R.id.make_name);
        }
    }
}
