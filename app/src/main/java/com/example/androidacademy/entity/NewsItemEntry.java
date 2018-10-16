package com.example.androidacademy.entity;

public class NewsItemEntry {

    final int position;
    final NewsItem newsItem;

    public NewsItemEntry(int position, NewsItem newsItem) {
        this.position = position;
        this.newsItem = newsItem;
    }

    public int getPosition() {
        return position;
    }

    public NewsItem getNewsItem() {
        return newsItem;
    }
}
