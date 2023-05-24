package com.example.basketballteam.controller;

import com.example.basketballteam.model.Article;
import com.example.basketballteam.model.BaseResult;
import com.example.basketballteam.model.Manager;
import com.example.basketballteam.service.ArticleService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
public class ArticleController {
    @Autowired
    private ArticleService articleService;
    private static Logger logger = LoggerFactory.getLogger(ArticleController.class);
    @RequestMapping("/article/updateArticle={articleId}")
    public String articleById(@PathVariable("articleId") int articleId, ModelMap map) {
        Article article = articleService.findArticleById(articleId);
        map.addAttribute("article", article);
        return "updateArticle";
    }

    @RequestMapping("/article/addArticle")
    public String addArticle() {
        return "addNewArticle";
    }

    @RequestMapping(value = "/updateArticleIn", method = RequestMethod.POST)
    @ResponseBody
    public BaseResult updateIn(String articleIdS, String articleTitle, String articleAuthor, String articleInfo,MultipartFile newImage,ModelMap map) {
        int articleId=Integer.parseInt(articleIdS);
        BaseResult result = new BaseResult();
        Article article=articleService.findArticleById(articleId);
        int code = 0;
        if(newImage==null){
            code = articleService.updateArticle(articleId, articleTitle, articleAuthor, articleInfo);
        }else {
            String savePath = "D:\\开摆\\数据库\\basketballTeam\\src\\main\\resources\\static\\image";
            String SelfieImage = null;
            if (newImage != null && !newImage.isEmpty()) {
                try {
                    // 生成唯一的文件名
                    String originalFilename = newImage.getOriginalFilename();
                    String extension = StringUtils.getFilenameExtension(originalFilename);
                    String fileName = System.currentTimeMillis() + "." + extension;

                    // 拼接文件保存的完整路径
                    savePath = savePath + File.separator + fileName;
                    // 保存图片文件到服务器
                    File saveFile = new File(savePath);
                    newImage.transferTo(saveFile);
                    SelfieImage = "/static/image/" + fileName;

                } catch (IOException e) {
                    e.printStackTrace();
                    // 图片保存出现异常
                    result.setCode(-1);
                    return result;
                }
            }
            code = articleService.updateArticleImage(articleId, articleTitle, articleAuthor, articleInfo, SelfieImage);
        }
        result.setCode(code);
        if (code == 1) {
            result.setMsg("add successfully");
        } else {
            result.setMsg("error!");
        }
        return result;
    }
    @RequestMapping(value = "/updateNewArticleIn",method = RequestMethod.POST)
    @ResponseBody
    public BaseResult updateNewIn(String articleTitle, String articleAuthor, String articleInfo,MultipartFile articleFeaturedImage,ModelMap map) {
        Subject subject = SecurityUtils.getSubject();
        Manager manager = (Manager) subject.getSession().getAttribute("manager");
        BaseResult result = new BaseResult();
        String savePath = "D:\\开摆\\数据库\\basketballTeam\\src\\main\\resources\\static\\image";
        String SelfieImage = null;
        if (articleFeaturedImage != null && !articleFeaturedImage.isEmpty()) {
            try {
                // 生成唯一的文件名
                String originalFilename = articleFeaturedImage.getOriginalFilename();
                String extension = StringUtils.getFilenameExtension(originalFilename);
                String fileName = System.currentTimeMillis() + "." + extension;

                // 拼接文件保存的完整路径
                savePath = savePath + File.separator + fileName;
                // 保存图片文件到服务器
                File saveFile = new File(savePath);
                articleFeaturedImage.transferTo(saveFile);
                SelfieImage = "/static/image/" + fileName;

            } catch (IOException e) {
                e.printStackTrace();
                // 图片保存出现异常
                result.setCode(-1);
                return result;
            }
        }
        Article article=new Article();
        article.setArticleAuthor(articleAuthor);
        article.setArticleAuthorId(manager.getManagerId());
        article.setArticleInfo(articleInfo);
        article.setArticleTitle(articleTitle);

        article.setArticleFeaturedImage(SelfieImage);
        int code = articleService.add(article);
        result.setCode(code);
        if (code == 1) {
            result.setMsg("add successfully");
        } else {
            result.setMsg("error!");
        }
        return result;
    }
}
