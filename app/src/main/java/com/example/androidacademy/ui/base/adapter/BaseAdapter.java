package com.example.androidacademy.ui.base.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

public abstract class BaseAdapter<T, ViewHolder extends BaseViewHolder<T>> extends RecyclerView.Adapter<ViewHolder> {

    @NonNull
    protected final List<T> dataList;
    protected final LayoutInflater layoutInflater;

    public BaseAdapter(@NonNull final List<T> initData, @NonNull final LayoutInflater layoutInflater) {
        this.dataList = initData;
        this.layoutInflater = layoutInflater;
    }

    @NonNull
    @Override
    public abstract ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType);

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(dataList.get(position));
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public void addData(final T data) {
        dataList.add(data);
        notifyItemInserted(dataList.size() - 1);
    }

}