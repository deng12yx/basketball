package com.example.basketballteam.service.impl;

import com.example.basketballteam.mapper.PhotoMapper;
import com.example.basketballteam.model.Photo;
import com.example.basketballteam.service.PhotoService;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhotoServiceImpl implements PhotoService {
    @Autowired
    private PhotoMapper photoMapper;
    @Override
    public List<Photo> findAllPhoto() {
        return this.photoMapper.findAllPhoto();
    }

    @Override
    public int addPhoto(Photo photo) {
        return this.photoMapper.addPhoto(photo);
    }
}
