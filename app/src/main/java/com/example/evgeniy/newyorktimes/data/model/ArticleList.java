package com.example.evgeniy.newyorktimes.data.model;


import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ArticleList {

    @SerializedName("status")
    private String status;

    @SerializedName("copyright")
    private String copyright;

    @SerializedName("num_results")
    private int numResults;

    @SerializedName("results")
    private List<Article> results = null;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public int getNumResults() {
        return numResults;
    }

    public void setNumResults(int numResults) {
        this.numResults = numResults;
    }

    public List<Article> getResults() {
        return results;
    }

    public void setResults(List<Article> results) {
        this.results = results;
    }
}
