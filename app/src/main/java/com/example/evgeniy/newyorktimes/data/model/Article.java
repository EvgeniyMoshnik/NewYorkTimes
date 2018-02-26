package com.example.evgeniy.newyorktimes.data.model;

import com.google.gson.annotations.SerializedName;



public class Article {

    @SerializedName("url")
    private String url;

    @SerializedName("section")
    private String section;

    @SerializedName("byline")
    private String byline;

    @SerializedName("title")
    private String title;

    @SerializedName("abstract")
    private String abstractText;

    @SerializedName("published_date")
    private String publishedDate;

    @SerializedName("media")
    private MediaList media;

    public Article(String title, String abstractText, String byline, String publishedDate, String url) {
        this.url = url;
        this.byline = byline;
        this.title = title;
        this.abstractText = abstractText;
        this.publishedDate = publishedDate;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getByline() {
        return byline;
    }

    public void setByline(String byline) {
        this.byline = byline;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAbstract() {
        return abstractText;
    }

    public void setAbstract(String _abstract) {
        this.abstractText = _abstract;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    public MediaList getMedia() {
        return media;
    }
    public void setMedia(MediaList media) {
        this.media = media;
    }

}
