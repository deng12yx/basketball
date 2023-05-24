package com.example.basketballteam.service;

import com.example.basketballteam.model.Photo;

import java.util.List;

public interface PhotoService {
    List<Photo> findAllPhoto();
    int addPhoto(Photo photo);
}
