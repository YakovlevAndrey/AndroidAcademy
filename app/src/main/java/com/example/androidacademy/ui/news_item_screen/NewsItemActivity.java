package com.example.androidacademy.ui.news_item_screen;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.androidacademy.R;
import com.example.androidacademy.data.DataUtils;
import com.example.androidacademy.entity.NewsItem;
import com.example.androidacademy.ui.base.activity.BaseActivity;

public class NewsItemActivity extends BaseActivity {

    private static final String EXTRA_NEWS_POS = "NEWS_POS";
    private ImageView newsImage;
    private TextView newsTitleTextView;
    private TextView newsContentTextView;
    private TextView newsPublishDate;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_item);
        initToolbar();
        newsImage = findViewById(R.id.newsImage);
        newsTitleTextView = findViewById(R.id.newsTitle);
        newsContentTextView = findViewById(R.id.newsFullContent);
        newsPublishDate = findViewById(R.id.newsPublishDate);

        int newsPosition = getIntent().getIntExtra(EXTRA_NEWS_POS, EXTRA_INT_DEFAULT);
        if (intExtraIsSet(newsPosition)) {
            NewsItem newsItem = DataUtils.getNewsByPosition(newsPosition);
            toolbarSetTitle(newsItem.getCategory().getName());
            newsTitleTextView.setText(newsItem.getTitle());
            newsContentTextView.setText(newsItem.getFullText());
            newsPublishDate.setText(newsItem.getFormattedPublishDate());
            Glide.with(this).load(newsItem.getImageUrl()).into(newsImage);
        }
    }

    private void initToolbar() {
        initToolbar(R.id.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    public static void start(Activity activity, int newsPos) {
        final Intent intent = new Intent(activity, NewsItemActivity.class);
        intent.putExtra(EXTRA_NEWS_POS, newsPos);
        activity.startActivity(intent);
    }

}