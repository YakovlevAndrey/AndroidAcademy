package com.example.androidacademy.ui.news_list_screen.news_recycler_adapter;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.RequestManager;
import com.example.androidacademy.R;
import com.example.androidacademy.entity.NewsItem;
import com.example.androidacademy.entity.NewsItemEntry;
import com.example.androidacademy.ui.base.adapter.BaseAdapter;
import com.example.androidacademy.ui.base.adapter.BaseViewHolder.OnClickItem;
import com.example.androidacademy.utils.SystemConfiguration.Orientation;

import java.util.List;

public class NewsRecyclerAdapter extends BaseAdapter<NewsItem, NewsViewHolder> {

    private final static int FIRST_TYPE = 1;
    private final static int STANDARD_TYPE = 2;
    private final static int NO_IMAGE_TYPE = 3;

    private final RequestManager newsImageLoader;
    private final OnClickItem<NewsItemEntry> itemClick;
    private final Orientation orientation;

    public NewsRecyclerAdapter(final @NonNull List<NewsItem> initData, final @NonNull LayoutInflater layoutInflater,
                               final @NonNull RequestManager newsImageLoader, @NonNull final OnClickItem<NewsItemEntry> itemClick, @NonNull final Orientation orientation) {
        super(initData, layoutInflater);
        this.newsImageLoader = newsImageLoader;
        this.itemClick = itemClick;
        this.orientation = orientation;
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull final ViewGroup parent, final int viewType) {
        int layoutId = R.layout.news_standard_item;
        if (orientation != Orientation.LANDSCAPE) {
            switch (viewType) {
                case FIRST_TYPE:
                    layoutId = R.layout.news_firt_item;
                    break;
                case STANDARD_TYPE:
                    layoutId = R.layout.news_standard_item;
                    break;
            }
        }
        final View itemView = layoutInflater.inflate(layoutId, parent, false);
        return new NewsViewHolder(itemView, dataList, newsImageLoader, itemClick);
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0)
            return FIRST_TYPE;
        String imageUrl = dataList.get(position).getImageUrl();
        if (imageUrl == null || imageUrl.isEmpty())
            return NO_IMAGE_TYPE;
        return STANDARD_TYPE;
    }
}