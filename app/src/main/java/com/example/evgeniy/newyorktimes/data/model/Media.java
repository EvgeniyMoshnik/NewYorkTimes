package com.example.evgeniy.newyorktimes.data.model;


import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Media {

    @SerializedName("type")
    private String type;

    @SerializedName("subtype")
    private String subtype;

    @SerializedName("caption")
    private String caption;

    @SerializedName("copyright")
    private String copyright;

    @SerializedName("media-metadata")
    private List<MediaMetaData> mediaMetadata;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSubtype() {
        return subtype;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public List<MediaMetaData> getMediaMetadatas() {
        return mediaMetadata;
    }

    public void setMediaMetadatas(List<MediaMetaData> mediaMetadatas) {
        this.mediaMetadata = mediaMetadatas;
    }
}
