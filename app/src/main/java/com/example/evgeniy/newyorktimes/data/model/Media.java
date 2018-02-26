package com.example.evgeniy.newyorktimes.data.model;


import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Media {


    @SerializedName("media-metadata")
    private List<MediaMetaData> mediaMetadata;


    public List<MediaMetaData> getMediaMetadatas() {
        return mediaMetadata;
    }

    public void setMediaMetadatas(List<MediaMetaData> mediaMetadatas) {
        this.mediaMetadata = mediaMetadatas;
    }
}
