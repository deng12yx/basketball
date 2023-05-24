package com.example.basketballteam.service;

import com.example.basketballteam.model.Article;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ArticleService {
    List<Article> findAll();
    int add(Article article);
    List<Article> findByArticleTitle(String keyword);
    int updateArticle(int id,String title,String Author,String info);
    int delete(int id);
    int updateArticleImage(int id,String title,String author,String info,String newImage);
    List<Article> findLatestFiveArticles();
    Article findArticleById(int id);
    List<Article> findArticlesPage(int offset);
    int countAllArticles();//查询记录个数
}
