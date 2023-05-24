package com.example.basketballteam.controller;

import com.example.basketballteam.model.BaseResult;
import com.example.basketballteam.model.Photo;
import com.example.basketballteam.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
public class PhotoController {
    @Autowired
    private PhotoService photoService;
    @RequestMapping("/addNewPhoto")
    public String addNewPhoto(){
        return "/addNewPhoto";
    }
    @RequestMapping(value = "addPhotoIn",method = RequestMethod.POST)
    public BaseResult addPhoto(MultipartFile photoUrl, String photoTime){
        BaseResult result=new BaseResult();
        String savePath = "D:\\开摆\\数据库\\basketballTeam\\src\\main\\resources\\static\\image";
        Photo photo=new Photo();
        if (photoUrl != null && !photoUrl.isEmpty()) {
            try {
                // 生成唯一的文件名
                String originalFilename = photoUrl.getOriginalFilename();
                String extension = StringUtils.getFilenameExtension(originalFilename);
                String fileName = System.currentTimeMillis() + "." + extension;

                // 拼接文件保存的完整路径
                savePath = savePath + File.separator + fileName;
                // 保存图片文件到服务器
                File saveFile = new File(savePath);
                photoUrl.transferTo(saveFile);
                String SelfieImage="/static/image/"+fileName;
                // 设置Player对象的图片路径
                photo.setPhotoUrl(SelfieImage);
            } catch (IOException e) {
                e.printStackTrace();
                // 图片保存出现异常
                result.setCode(-1);
                return result;
            }
        }
        photo.setPhotoTime(photoTime);
        result.setCode(photoService.addPhoto(photo));
        return result;
    }

}
