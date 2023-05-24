package com.example.basketballteam.model;

public class Photo {
    private int photoId;
    private String photoUrl;
    private String photoTime;
    public Photo(){

    }

    public int getPhotoId() {
        return photoId;
    }

    public void setPhotoId(int photoId) {
        this.photoId = photoId;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getPhotoTime() {
        return photoTime;
    }

    public void setPhotoTime(String photoTime) {
        this.photoTime = photoTime;
    }

    public Photo(int photoId, String photoUrl, String photoTime) {
        this.photoId = photoId;
        this.photoUrl = photoUrl;
        this.photoTime = photoTime;
    }
}
