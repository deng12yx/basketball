package com.example.basketballteam.model;

public class Article {
    private int articleId;
    private String articleTitle;
    private String articleAuthor;
    private String articleInfo;
    private String articleFeaturedImage;
    private String articlePublicationTime;
    private int articleAuthorId;
    public Article(){

    }

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public String getArticleAuthor() {
        return articleAuthor;
    }

    public void setArticleAuthor(String articleAuthor) {
        this.articleAuthor = articleAuthor;
    }

    public String getArticleInfo() {
        return articleInfo;
    }

    public void setArticleInfo(String articleInfo) {
        this.articleInfo = articleInfo;
    }

    public String getArticleFeaturedImage() {
        return articleFeaturedImage;
    }

    public void setArticleFeaturedImage(String articleFeaturedImage) {
        this.articleFeaturedImage = articleFeaturedImage;
    }

    public String getArticlePublicationTime() {
        return articlePublicationTime;
    }

    public void setArticlePublicationTime(String articlePublicationTime) {
        this.articlePublicationTime = articlePublicationTime;
    }

    public int getArticleAuthorId() {
        return articleAuthorId;
    }

    public void setArticleAuthorId(int articleAuthorId) {
        this.articleAuthorId = articleAuthorId;
    }

    public Article(int articleId, String articleTitle, String articleAuthor, String articleInfo, String articleFeaturedImage, String articlePublicationTime, int articleAuthorId) {
        this.articleId = articleId;
        this.articleTitle = articleTitle;
        this.articleAuthor = articleAuthor;
        this.articleInfo = articleInfo;
        this.articleFeaturedImage = articleFeaturedImage;
        this.articlePublicationTime = articlePublicationTime;
        this.articleAuthorId = articleAuthorId;
    }
}
