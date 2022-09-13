package com.gutaicheng.service;

import com.gutaicheng.model.Article;
import com.gutaicheng.model.ArticleAndAuthor;

import java.util.List;

public interface ArticleService {
    public void addArticle(Article article);
    public String selectMostViewArticle();
    public Article selectArticleByAid(int aid);
    List<ArticleAndAuthor> selectTopTenArticles();
    public String readUserArticle(int aid);
    String readUserColumn(int cid);
    public List<ArticleAndAuthor> selectNewTenArticles();
    public void viewsAddOne(int aid);
    public List<Article> selectUserTopFiveArticlesByUid(int uid, int aid);
    List<Article> selectAllArticlesByUid(int uid);
    List<ArticleAndAuthor> selectAllArticles();
    void deleteArticleByAid(int aid);
    List<ArticleAndAuthor> selectArticlesPending();
    void updateArticleState(int aid, int state);
    void updateArticleByAid(Article article);
}
