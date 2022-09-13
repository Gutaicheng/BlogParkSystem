package com.gutaicheng.dao;


import com.gutaicheng.model.Article;
import com.gutaicheng.model.ArticleAndAuthor;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository("articleMapper")
public interface ArticleMapper {
    /**
     * 增加新文章
     */
    void addArticle(Article article);

    /**
     * 查询浏览量最多的文章
     */
    Article selectMostViewArticle();

    /**
     * 根据 aid 加载文章
     */
    Article selectArticleByAid(int aid);

    /**
     * 查询 浏览量前十的 文章
     */
    List<ArticleAndAuthor> selectTopTenArticles();

    /**
     * 查询 最新发布的 十篇文章
     */
    List<ArticleAndAuthor> selectNewTenArticles();

    /**
     * 文章浏览量 +1
     */
    void viewsAddOne(int aid);

    /**
     * 跟 uid 查询该用户的 前5篇 浏览量views 最高的文章 (除去当前文章)
     */
    List<Article> selectUserTopFiveArticlesByUid(@Param("uid") int uid, @Param("aid") int aid);

    /**
     * 根据 uid 查询该用户所有的文章
     */
    List<Article> selectAllArticlesByUid(int uid);

    /**
     * 查询所有文章
     */
    List<ArticleAndAuthor> selectAllArticles();

    /**
     * 根据aid删除文章
     */
    void deleteArticleByAid(int aid);

    /**
     * 查询所有待审核文章
     */
    List<ArticleAndAuthor> selectArticlesPending();

    /**
     * 更改文章状态
     */
    void updateArticleState(@Param("aid") int aid, @Param("state") int state);

    /**
     * 修改文章内容
     */
    void updateArticleByAid(Article article);
}
