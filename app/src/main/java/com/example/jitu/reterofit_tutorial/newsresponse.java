package com.example.jitu.reterofit_tutorial;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by jitu on 5/8/2017.
 */

public class newsresponse {
    @SerializedName("articles")
    private List<news> articles;

    public List<news> getArticles() {
        return articles;
    }

    public void setArticles(List<news> articles) {
        this.articles = articles;
    }
}
