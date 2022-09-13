package com.gutaicheng.service;

import com.gutaicheng.model.ArticleTag;
import com.gutaicheng.model.Tag;

import java.util.List;

public interface ArticleTagService {
    List<ArticleTag> selectTagByAid(int aid);
    List<ArticleTag> selectAllTag();

    void addArticleTags(int aid, int tid);

    List<Tag> getAllTags();

    void addTag(Tag tag);

    void updateTag(Tag tag);

    void deleteTagByTid(int tid);

    void deleteArticleTagByAid(int aid);

    List<Tag> findExcel();

    void insertCategory(Tag tag);
}
