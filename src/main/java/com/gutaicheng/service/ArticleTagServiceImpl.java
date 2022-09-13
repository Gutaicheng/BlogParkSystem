package com.gutaicheng.service;

import com.gutaicheng.dao.ArticleTagMapper;
import com.gutaicheng.model.ArticleTag;
import com.gutaicheng.model.Tag;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("TagService")
public class ArticleTagServiceImpl implements ArticleTagService {
    @Resource
    private ArticleTagMapper articleTagMapper;

    /**
     * 根据 文章id 查询该文章的 标签tag
     */
    @Override
    public List<ArticleTag> selectTagByAid(int aid) {
        return articleTagMapper.selectTagByAid(aid);
    }

    /**
     * 获取所有标签
     */
    @Override
    public List<ArticleTag> selectAllTag() {
        return articleTagMapper.selectAllTag();
    }

    /**
     * 批量新增文章的标签
     */
    @Override
    public void addArticleTags(int aid, int tid) {
        articleTagMapper.addArticleTags(aid, tid);
    }

    /**
     * 获取所有标签
     */
    @Override
    public List<Tag> getAllTags() {
        return articleTagMapper.getAllTags();
    }

    /**
     * 新增 标签
     */
    @Override
    public void addTag(Tag tag) {
        articleTagMapper.addTag(tag);
    }

    /**
     * 编辑标签信息
     */
    @Override
    public void updateTag(Tag tag) {
        articleTagMapper.updateTag(tag);
    }

    /**
     * 根据 tid 删除标签信息
     */
    @Override
    public void deleteTagByTid(int tid) {
        articleTagMapper.deleteTagByTid(tid);
    }

    /**
     * 根据 aid 删除该文章的标签
     */
    @Override
    public void deleteArticleTagByAid(int aid) {
        articleTagMapper.deleteArticleTagByAid(aid);
    }

    @Override
    public List<Tag> findExcel() {
        List<Tag> list = articleTagMapper.findExcel();
        return list;
    }

    @Override
    public void insertCategory(Tag tag) {
        articleTagMapper.insertCategory(tag);
    }
}
