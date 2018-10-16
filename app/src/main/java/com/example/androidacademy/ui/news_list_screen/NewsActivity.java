package com.example.androidacademy.ui.news_list_screen;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.RequestOptions;
import com.example.androidacademy.R;
import com.example.androidacademy.data.DataUtils;
import com.example.androidacademy.entity.NewsItemEntry;
import com.example.androidacademy.ui.about_screen.AboutActivity;
import com.example.androidacademy.ui.base.activity.BaseActivity;
import com.example.androidacademy.ui.base.adapter.BaseViewHolder.OnClickItem;
import com.example.androidacademy.ui.news_item_screen.NewsItemActivity;
import com.example.androidacademy.ui.news_list_screen.news_recycler_adapter.NewsItemDecoration;
import com.example.androidacademy.ui.news_list_screen.news_recycler_adapter.NewsRecyclerAdapter;
import com.example.androidacademy.utils.StringResWrapper;
import com.example.androidacademy.utils.SystemConfiguration.Orientation;

import static com.example.androidacademy.utils.DisplayMetricsConverter.convertDpToPixel;
import static com.example.androidacademy.utils.SystemConfiguration.Orientation.LANDSCAPE;

public class NewsActivity extends BaseActivity {

    private RecyclerView newsRecyclerView;
    private NewsRecyclerAdapter newsRecyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        newsRecyclerView = findViewById(R.id.newsRecyclerView);
        initToolbar(R.id.toolbar);
        toolbarSetTitle("News");
        initNewsRecyclerView();
    }

    private void initNewsRecyclerView() {
        RequestOptions newsImageOption = new RequestOptions()
                .placeholder(R.drawable.ic_newspaper)
                .fallback(R.drawable.ic_newspaper)
                .centerCrop();
        Orientation orientation = getScreenOrientation();

        RequestManager newsImageLoader = Glide.with(this).applyDefaultRequestOptions(newsImageOption);
        newsRecyclerAdapter = new NewsRecyclerAdapter(DataUtils.generateNews(StringResWrapper.getInstance()), LayoutInflater.from(this), newsImageLoader, newsItemOnClickListener, orientation);
        newsRecyclerView.setAdapter(newsRecyclerAdapter);
        newsRecyclerView.addItemDecoration(new NewsItemDecoration((int) convertDpToPixel(getDimension(R.dimen.news_item_margin), this)));

        if (orientation == LANDSCAPE) {
            newsRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        } else {
            newsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        }
    }

    private final OnClickItem<NewsItemEntry> newsItemOnClickListener = data -> NewsItemActivity.start(this, data.getPosition());

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.actionAbout) {
            AboutActivity.start(this);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}