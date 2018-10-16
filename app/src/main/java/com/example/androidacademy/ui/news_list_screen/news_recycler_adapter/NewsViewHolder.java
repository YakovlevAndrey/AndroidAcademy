package com.example.androidacademy.ui.news_list_screen.news_recycler_adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.RequestManager;
import com.example.androidacademy.R;
import com.example.androidacademy.entity.NewsItem;
import com.example.androidacademy.entity.NewsItemEntry;
import com.example.androidacademy.ui.base.adapter.BaseViewHolder;

import java.util.List;

public class NewsViewHolder extends BaseViewHolder<NewsItem> {

    private final RequestManager newsImageLoader;
    private final View itemView;
    private TextView newsTitle;
    private TextView newsCategory;
    private TextView newsContent;
    private TextView newsPublishDate;
    private ImageView newsImage;
    private View newsItemRoot;
    private final OnClickItem<NewsItemEntry> newsItemOnClickItem;

    public NewsViewHolder(@NonNull final View itemView, final List<NewsItem> newsItems, @NonNull final RequestManager newsImageLoader,
                          @NonNull final OnClickItem<NewsItemEntry> newsItemOnClickItem) {
        super(itemView, newsItems);
        this.itemView = itemView;
        this.newsImageLoader = newsImageLoader;
        this.newsTitle = itemView.findViewById(R.id.newsTitle);
        this.newsCategory = itemView.findViewById(R.id.newsCategory);
        this.newsContent = itemView.findViewById(R.id.newsContent);
        this.newsImage = itemView.findViewById(R.id.newsImage);
        this.newsItemRoot = itemView.findViewById(R.id.newsItemRoot);
        this.newsPublishDate = itemView.findViewById(R.id.newsPublishDate);
        this.newsItemOnClickItem = newsItemOnClickItem;
        newsItemRoot.setOnClickListener(view -> {
            int position = getAdapterPosition();
            if (this.newsItemOnClickItem != null && position != RecyclerView.NO_POSITION) {
                this.newsItemOnClickItem.onClick(new NewsItemEntry(position, getDataByPosition(position)));
            }
        });
    }

    @Override
    public void bind(NewsItem news) {
        newsCategory.setText(news.getCategory().getName());
        newsTitle.setText(news.getTitle());
        newsContent.setText(news.getPreviewText());
        newsPublishDate.setText(news.getFormattedPublishDate());
        newsImageLoader.load(news.getImageUrl()).into(newsImage);
    }
}