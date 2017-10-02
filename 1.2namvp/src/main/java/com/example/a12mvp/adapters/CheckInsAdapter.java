package com.example.a12mvp.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.a12mvp.R;
import com.example.a12mvp.screens.check_ins.CheckIn;

import java.util.ArrayList;

/**
 * Created by ADMIN on 9/29/2017.
 */

public class CheckInsAdapter extends RecyclerView.Adapter<CheckInVH> {

    private ArrayList<CheckIn> data = new ArrayList<>();

    @Override
    public CheckInVH onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new CheckInVH(inflater.inflate(R.layout.list_item_check_in, parent, false));
    }

    @Override
    public void onBindViewHolder(CheckInVH holder, int position) {
        //  holder.bindData(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setData(ArrayList<CheckIn> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    public void clearData() {
        data.clear();
        notifyDataSetChanged();
    }
}
