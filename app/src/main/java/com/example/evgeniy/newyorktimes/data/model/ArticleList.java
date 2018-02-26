package com.example.evgeniy.newyorktimes.data.model;


import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ArticleList {

    @SerializedName("results")
    private List<Article> results;

    public List<Article> getResults() {
        return results;
    }

    public void setResults(List<Article> results) {
        this.results = results;
    }
}
