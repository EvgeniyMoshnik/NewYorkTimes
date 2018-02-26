package com.example.evgeniy.newyorktimes.data.model;

import com.google.gson.annotations.SerializedName;

public class MediaMetaData {

    @SerializedName("url")
    private String url;

    @SerializedName("height")
    private int height;

    @SerializedName("width")
    private int width;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }
}
