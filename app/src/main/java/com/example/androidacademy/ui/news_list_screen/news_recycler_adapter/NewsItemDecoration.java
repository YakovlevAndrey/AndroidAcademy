package com.example.androidacademy.ui.news_list_screen.news_recycler_adapter;

import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class NewsItemDecoration extends RecyclerView.ItemDecoration {

    private final int space;

    public NewsItemDecoration(int space) {
        this.space = space;
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        outRect.top = space;
        outRect.left = space;
        outRect.right = space;
        outRect.bottom = space;
    }
}