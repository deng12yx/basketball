package com.example.basketballteam.mapper;

import com.example.basketballteam.model.Article;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ArticleMapper {
    @Select("select * from cyberspacesecuritybasketballteam.article  ORDER BY articlePublicationTime DESC")
    List<Article> findAll();//找出所有文章

    @Select("SELECT * FROM cyberspacesecuritybasketballteam.article ORDER BY articlePublicationTime DESC LIMIT 5")
    List<Article> findLatestFiveArticles();

    @Select("SELECT * FROM cyberspacesecuritybasketballteam.article ORDER BY articlePublicationTime DESC LIMIT 15 offset #{offset}")
    List<Article> findArticlesPage(int offset);

    @Insert("INSERT INTO cyberspacesecuritybasketballteam.article (articleTitle, articleAuthor, articleInfo, articleFeaturedImage, articlePublicationTime,articleAuthorId) " +
            "VALUES (#{articleTitle}, #{articleAuthor}, #{articleInfo}, #{articleFeaturedImage},CURRENT_TIMESTAMP(),#{articleAuthorId} )")
    @Options(useGeneratedKeys = true, keyProperty = "articleId", keyColumn = "articleId")
    int add(Article article);

    @Select("select * from cyberspacesecuritybasketballteam.article " +
            "where articleTitle like CONCAT('%', #{keywordOrAuthor}, '%') " +
            "or articleAuthor = #{keywordOrAuthor}")
    List<Article> findByArticleTitle(String keywordOrAuthor);//根据关键字或者作者搜索文章

    @Update("UPDATE cyberspacesecuritybasketballteam.article " +
            "SET articleTitle = #{title}, " +
            "articleAuthor = #{author}, " +
            "articleInfo = #{info} " +
            "WHERE articleId = #{id}")
    int updateArticle(@Param("id") int id,
                      @Param("title") String title,
                      @Param("author") String author,
                      @Param("info") String info);

    @Update("UPDATE cyberspacesecuritybasketballteam.article " +
            "SET articleTitle = #{title}, " +
            "articleAuthor = #{author}, " +
            "articleInfo = #{info}," +
            "articleFeaturedImage=#{newImage}" +
            "WHERE articleId = #{id}")
    int updateArticleImage(@Param("id") int id,
                           @Param("title") String title,
                           @Param("author") String author,
                           @Param("info") String info,
                           @Param("newImage") String newImage);


    @Delete("DELETE FROM cyberspacesecuritybasketballteam.article WHERE articleId = #{id}")
    int delete(int id);//删除文章信息

    @Select("SELECT * FROM cyberspacesecuritybasketballteam.article where articleId=#{id}")
    Article findArticleById(int id);//根据id找文章

    @Select("SELECT COUNT(*) FROM cyberspacesecuritybasketballteam.article")
    int countAllArticles();//查询记录个数
}
