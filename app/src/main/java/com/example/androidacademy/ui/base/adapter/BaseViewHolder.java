package com.example.androidacademy.ui.base.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.List;

public abstract class BaseViewHolder<T> extends RecyclerView.ViewHolder {

    private final List<T> dataLis;

    public BaseViewHolder(@NonNull View itemView, List<T> dataLis) {
        super(itemView);
        this.dataLis = dataLis;
    }

    public abstract void bind(T data);

    public interface OnClickItem<T> {
        void onClick(T data);
    }

    public T getDataByPosition(int pos) {
        return dataLis.get(pos);
    }

}