package com.example.androidacademy.entity;

import java.util.Date;

public class NewsItem {

    private final String title;
    private final String imageUrl;
    private final Category category;
    private final Date publishDate;
    private final String formattedPublishDate;
    private final String previewText;
    private final String fullText;

    public NewsItem(String title, String imageUrl, Category category, Date publishDate, String formattedPublishDate, String previewText, String fullText) {
        this.title = title;
        this.imageUrl = imageUrl;
        this.category = category;
        this.publishDate = publishDate;
        this.formattedPublishDate = formattedPublishDate;
        this.previewText = previewText;
        this.fullText = fullText;
    }

    public String getTitle() {
        return title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public Category getCategory() {
        return category;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public String getFormattedPublishDate() {
        return formattedPublishDate;
    }

    public String getPreviewText() {
        return previewText;
    }

    public String getFullText() {
        return fullText;
    }

    public static class Category {

        private final int id;
        private final String name;

        public Category(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }
    }

    @Override
    public String toString() {
        return "NewsItem{" +
                "title='" + title + '\'' +
                ", category=" + category +
                ", publishDate=" + publishDate +
                ", previewText='" + previewText + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NewsItem newsItem = (NewsItem) o;

        if (!title.equals(newsItem.title)) return false;
        if (imageUrl != null ? !imageUrl.equals(newsItem.imageUrl) : newsItem.imageUrl != null)
            return false;
        if (!category.equals(newsItem.category)) return false;
        if (!publishDate.equals(newsItem.publishDate)) return false;
        if (!previewText.equals(newsItem.previewText)) return false;
        return fullText != null ? fullText.equals(newsItem.fullText) : newsItem.fullText == null;
    }

    @Override
    public int hashCode() {
        int result = title.hashCode();
        result = 31 * result + (imageUrl != null ? imageUrl.hashCode() : 0);
        result = 31 * result + category.hashCode();
        result = 31 * result + publishDate.hashCode();
        result = 31 * result + previewText.hashCode();
        result = 31 * result + (fullText != null ? fullText.hashCode() : 0);
        return result;
    }
}


