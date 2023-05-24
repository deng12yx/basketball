package com.example.basketballteam.mapper;

import com.example.basketballteam.model.Photo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PhotoMapper {
    @Select("SELECT * FROM cyberspacesecuritybasketballteam.photo ORDER BY photoTime DESC")
    List<Photo> findAllPhoto();
    @Insert("Insert into cyberspacesecuritybasketballteam.photo (photoUrl,photoTime) " +
            "values(#{photoUrl},#{photoTime}")
    @Options(useGeneratedKeys = true, keyProperty = "photoId", keyColumn = "photoId")
    int addPhoto(Photo photo);
}
