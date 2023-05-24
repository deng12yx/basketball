package com.example.basketballteam.service.impl;

import com.example.basketballteam.mapper.ArticleMapper;
import com.example.basketballteam.model.Article;
import com.example.basketballteam.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleMapper articleMapper;
    @Override
    public List<Article> findAll() {
        return this.articleMapper.findAll();
    }

    @Override
    public int add(Article article) {
        return this.articleMapper.add(article);
    }

    @Override
    public List<Article> findByArticleTitle(String keyword) {
        return this.articleMapper.findByArticleTitle(keyword);
    }

    @Override
    public int updateArticle(int id, String title, String author, String info) {
        return this.articleMapper.updateArticle(id,title,author,info);
    }

    @Override
    public int delete(int id) {
        return this.articleMapper.delete(id);
    }

    @Override
    public int updateArticleImage(int id, String title, String author, String info, String newImage) {
        return this.articleMapper.updateArticleImage(id,title,author,info,newImage);
    }

    @Override
    public List<Article> findLatestFiveArticles() {
        return this.articleMapper.findLatestFiveArticles();
    }

    @Override
    public Article findArticleById(int id) {
        return this.articleMapper.findArticleById(id);
    }

    @Override
    public List<Article> findArticlesPage(int offset) {
        return this.articleMapper.findArticlesPage(offset);
    }

    @Override
    public int countAllArticles() {
        return this.articleMapper.countAllArticles();
    }
}
