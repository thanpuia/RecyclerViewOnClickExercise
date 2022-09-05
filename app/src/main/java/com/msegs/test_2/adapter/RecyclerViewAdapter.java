package com.msegs.test_2.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.msegs.test_2.R;
import com.msegs.test_2.entity.Test;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    ArrayList<Test> tests;
    Context context;

    public RecyclerViewAdapter( ArrayList<Test> mTests, Context mContext) {
        this.tests = mTests;
        this.context = mContext;

    }

    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View frame =  layoutInflater.inflate(R.layout.frame_test,parent,false);
        ViewHolder viewHolder = new ViewHolder(frame);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder holder, int position) {
        holder.textView.setText(tests.get(position).getName());
        int[] myBgResources = new int[]{R.drawable.bg1,R.drawable.bg2,R.drawable.bg3,R.drawable.bg4,
                R.drawable.bg5,R.drawable.bg6,R.drawable.bg7,R.drawable.bg8};
        holder.cardView.setBackgroundResource(myBgResources[position]);
    }

    @Override
    public int getItemCount() {
        return tests.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView textView;
        CardView cardView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            this.textView = itemView.findViewById(R.id.frame_text_tv);
            this.cardView = itemView.findViewById(R.id.card_view);

        }
    }
}
