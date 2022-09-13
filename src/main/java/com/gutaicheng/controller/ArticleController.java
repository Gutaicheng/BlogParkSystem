package com.gutaicheng.controller;

import com.gutaicheng.model.Article;
import com.gutaicheng.model.ArticleAndAuthor;
import com.gutaicheng.model.WangEditor;
import com.gutaicheng.service.ArticleService;
import com.gutaicheng.util.PicUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;


@Controller
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    /**
     * 新增文章
     * @param article
     * @throws UnsupportedEncodingException
     */
    @RequestMapping(value = "/addArticle", method = RequestMethod.POST)
    @ResponseBody
    public int addArticle(@RequestBody Article article) throws UnsupportedEncodingException {
        System.out.println(article);
        articleService.addArticle(article);
        return article.getAid();
    }

    /**
     * 加载浏览量最高的文章
     * @return
     */
    @RequestMapping(value = "/mostViewArticle")
    @ResponseBody
    public String mostViewArticle(){
        return articleService.selectMostViewArticle();
    }

    /**
     * 根据 aid 查询文章
     */
    @RequestMapping(value = "/selectArticleByAid")
    @ResponseBody
    public Article selectArticleByAid(int aid){
        System.out.println("查询文章id="+aid);
        return articleService.selectArticleByAid(aid);
    }

    /**
     * 上传文章图片
     */
    @RequestMapping(value = "/uploadArticlePic", method = RequestMethod.POST)
    @ResponseBody
    public WangEditor updateHeadshot(@RequestParam("myFile")MultipartFile ArticlePic, HttpServletRequest request) throws IOException {
        if (ArticlePic != null){
            System.out.println("图片不为空");
        }else System.out.println("图片为空");
        String pic;
        pic = PicUtil.uploadArticle(request, ArticlePic);
        String url = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+"/Blog/"+pic;
        System.out.println(url);
        if (pic != null){
            System.out.println("上传成功");
        }else System.out.println("上传失败");
        String[] str = {url};
        WangEditor we = new WangEditor(str);
        System.out.println(we);
        return we;
    }

    /**
     * 查询 浏览量前十的 文章
     */
    @RequestMapping("/topTenArticle")
    @ResponseBody
    public List<ArticleAndAuthor> selectTopTenArticles(){
        return articleService.selectTopTenArticles();
    }

    /**
     * 查询 最新发布的 十篇文章
     */
    @RequestMapping("/newTenArticle")
    @ResponseBody
    public List<ArticleAndAuthor> selectNewTenArticles(){
        return articleService.selectNewTenArticles();
    }

    /**
     * 阅读用户文章
     */
    @RequestMapping("/{username}/articles/{aid}")
    public String readUserArticle(@PathVariable(value = "aid") int aid, @PathVariable String username){
        return articleService.readUserArticle(aid);
    }

    /**
     * 阅读用户专栏
     */
    @RequestMapping("/{username}/column/{cid}")
    public String readUserColumn(@PathVariable(value = "cid") int cid, @PathVariable String username){
        return articleService.readUserColumn(cid);
    }

    /**
     * 文章浏览量 +1
     */
    @RequestMapping("/viewsAddOne")
    @ResponseBody
    public void viewsAddOne(int aid){
        articleService.viewsAddOne(aid);
    }

    /**
     * 跟 uid 查询该用户的 前5篇 浏览量views 最高的文章 (除去当前文章)
     */
    @RequestMapping("/selectUserTopFiveArticlesByUid")
    @ResponseBody
    public List<Article> selectUserTopFiveArticlesByUid(int uid, int aid){
        return articleService.selectUserTopFiveArticlesByUid(uid, aid);
    }

    /**
     * 根据 uid 查询该用户所有的文章
     */
    @RequestMapping("/selectAllArticlesByUid")
    @ResponseBody
    public List<Article> selectAllArticlesByUid(int uid){
        return articleService.selectAllArticlesByUid(uid);
    }

    /**
     * 查询所有文章
     */
    @RequestMapping("/selectAllArticles")
    @ResponseBody
    public List<ArticleAndAuthor> selectAllArticles(){
        return articleService.selectAllArticles();
    }

    /**
     * 根据aid删除文章
     */
    @RequestMapping("/deleteArticleByAid")
    @ResponseBody
    public void deleteArticleByAid(int aid){
        articleService.deleteArticleByAid(aid);
    }

    /**
     * 查询所有待审核文章
     */
    @RequestMapping("/selectArticlesPending")
    @ResponseBody
    public List<ArticleAndAuthor> selectArticlesPending(){
        return articleService.selectArticlesPending();
    }

    /**
     * 更改文章状态
     */
    @RequestMapping("/updateArticleState")
    @ResponseBody
    public void updateArticleState(int aid, int state){
        articleService.updateArticleState(aid, state);
    }

    /**
     * 修改文章内容
     */
    @RequestMapping(value = "/updateArticleByAid", method = RequestMethod.POST)
    @ResponseBody
    public void updateArticleByAid(@RequestBody Article article){
        System.out.println(article);
        articleService.updateArticleByAid(article);
    }

}