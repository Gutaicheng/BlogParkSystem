package com.gutaicheng.controller;

import com.gutaicheng.model.ArticleTag;
import com.gutaicheng.model.Tag;
import com.gutaicheng.service.ArticleTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ArticleTagController {
    @Autowired
    private ArticleTagService articleTagService;

    /**
     * 根据 文章id 查询该文章的 标签tag
     */
    @RequestMapping("/selectTagByAid")
    @ResponseBody
    public List<ArticleTag> selectTagByAid(int aid){
        return articleTagService.selectTagByAid(aid);
    }

    /**
     * 获取所有标签
     */
    @RequestMapping("/selectAllTag")
    @ResponseBody
    public List<ArticleTag> selectAllTag(){
        return articleTagService.selectAllTag();
    }

    /**
     * 获取所有标签
     */
    @RequestMapping("/getAllTags")
    @ResponseBody
    public List<Tag> getAllTags(){
        return articleTagService.getAllTags();
    }

    /**
     * 新增 标签
     */
    @RequestMapping(value = "/addTag", method = RequestMethod.POST)
    @ResponseBody
    public void addTag(@RequestBody Tag tag){
        articleTagService.addTag(tag);
    }

    /**
     * 批量新增文章的标签
     */
    @RequestMapping(value = "/addArticleTags", method = RequestMethod.POST)
    @ResponseBody
    public void selectAllTag(int aid, int tid){
        articleTagService.addArticleTags(aid,tid);
    }

    /**
     * 编辑标签信息
     */
    @RequestMapping(value = "/updateTag", method = RequestMethod.POST)
    @ResponseBody
    public void updateTag(@RequestBody Tag tag){
        articleTagService.updateTag(tag);
    }

    /**
     * 根据 tid 删除标签信息
     */
    @RequestMapping(value = "/deleteTagByTid")
    @ResponseBody
    public void deleteTagByTid(int tid){
        articleTagService.deleteTagByTid(tid);
    }

    /**
     * 根据 aid 删除该文章的标签
     */
    @RequestMapping(value = "/deleteArticleTagByAid")
    @ResponseBody
    public void deleteArticleTagByAid(int aid){
        articleTagService.deleteArticleTagByAid(aid);
    }
}
