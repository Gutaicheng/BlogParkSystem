package com.gutaicheng.service;

import com.gutaicheng.dao.ArticleMapper;
import com.gutaicheng.model.Article;
import com.gutaicheng.model.ArticleAndAuthor;
import org.junit.Test;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("ArticleService")
public class ArticleServiceImpl implements ArticleService{

    //
    @Resource
    private ArticleMapper articleMapper;

    /**
     * 添加文章
     * @param article
     */
    @Override
    public void addArticle(Article article) {
        articleMapper.addArticle(article);
        System.out.println(article.getContent());
    }

    /**
     * 查询浏览量最多的文章i
     * @return
     */
    @Override
    public String selectMostViewArticle() {
        Article article = articleMapper.selectMostViewArticle();
        System.out.println(article.ArticleAndUser());
        return article.ArticleAndUser();
    }

    /**
     * 根据 aid 查询文章
     * @param aid
     */
    @Override
    public Article selectArticleByAid(int aid) {
        return articleMapper.selectArticleByAid(aid);
    }

    /**
     * 查询 浏览量前十的 文章
     */
    @Override
    public List<ArticleAndAuthor> selectTopTenArticles() {
        return articleMapper.selectTopTenArticles();
    }

    /**
     *跳转至文章阅读界面
     */
    @Override
    public String readUserArticle(int aid) {
        return "/user/read.html";
    }

    /**
     * 阅读用户专栏
     */
    @Override
    public String readUserColumn(int cid) {
        return "/user/column.html";
    }

    /**
     * 查询 最新发布的 十篇文章
     */
    @Override
    public List<ArticleAndAuthor> selectNewTenArticles() {
        return articleMapper.selectNewTenArticles();
    }

    /**
     * 文章浏览量 +1
     */
    @Override
    public void viewsAddOne(int aid) {
        articleMapper.viewsAddOne(aid);
    }

    /**
     * 跟 uid 查询该用户的 前5篇 浏览量views 最高的文章
     */
    @Override
    public List<Article> selectUserTopFiveArticlesByUid(int uid, int aid) {
        return articleMapper.selectUserTopFiveArticlesByUid(uid, aid);
    }

    /**
     * 根据 uid 查询该用户所有的文章
     */
    @Override
    public List<Article> selectAllArticlesByUid(int uid) {
        return articleMapper.selectAllArticlesByUid(uid);
    }

    /**
     * 查询所有文章
     */
    @Override
    public List<ArticleAndAuthor> selectAllArticles() {
        return articleMapper.selectAllArticles();
    }

    /**
     * 根据aid删除文章
     */
    @Override
    public void deleteArticleByAid(int aid) {
        articleMapper.deleteArticleByAid(aid);
    }

    /**
     * 查询所有待审核文章
     */
    @Override
    public List<ArticleAndAuthor> selectArticlesPending() {
        return articleMapper.selectArticlesPending();
    }

    /**
     * 更改文章状态
     */
    @Override
    public void updateArticleState(int aid, int state) {
        articleMapper.updateArticleState(aid, state);
    }

    /**
     * 修改文章内容
     */
    @Override
    public void updateArticleByAid(Article article) {
        articleMapper.updateArticleByAid(article);
    }

}
