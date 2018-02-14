package com.example.evgeniy.newyorktimes.data.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class Article {

    @SerializedName("url")
    private String url;

    @SerializedName("count_type")
    private String countType;

    @SerializedName("column")
    private String column;

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

    @SerializedName("source")
    private String source;

    @SerializedName("des_facet")
    private List<String> desFacet = null;

    @SerializedName("org_facet")
    private List<String> orgFacet = null;

    @SerializedName("per_facet")
    private List<String> perFacet = null;

    @SerializedName("geo_facet")
    private String geoFacet;

    @SerializedName("media")
    private List<Media> media = null;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCountType() {
        return countType;
    }

    public void setCountType(String countType) {
        this.countType = countType;
    }

    public Object getColumn() {
        return column;
    }

    public void setColumn(String column) {
        this.column = column;
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

    public String get_abstract() {
        return abstractText;
    }

    public void set_abstract(String _abstract) {
        this.abstractText = _abstract;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public List<String> getDesFacet() {
        return desFacet;
    }

    public void setDesFacet(List<String> desFacet) {
        this.desFacet = desFacet;
    }

    public List<String> getOrgFacet() {
        return orgFacet;
    }

    public void setOrgFacet(List<String> orgFacet) {
        this.orgFacet = orgFacet;
    }

    public List<String> getPerFacet() {
        return perFacet;
    }

    public void setPerFacet(List<String> perFacet) {
        this.perFacet = perFacet;
    }

    public String getGeoFacet() {
        return geoFacet;
    }

    public void setGeoFacet(String geoFacet) {
        this.geoFacet = geoFacet;
    }

    public List<Media> getMedia() {
        return media;
    }

    public void setMedia(List<Media> media) {
        this.media = media;
    }
}
