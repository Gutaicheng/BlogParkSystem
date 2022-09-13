package com.gutaicheng.dao;

import com.gutaicheng.model.ArticleTag;
import com.gutaicheng.model.Tag;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository("articleTagMapper")
public interface ArticleTagMapper {
    List<ArticleTag> selectTagByAid(int aid);

    List<ArticleTag> selectAllTag();

    void addArticleTags(@Param("aid") int aid, @Param("tid") int tid);

    List<Tag> getAllTags();

    void addTag(Tag tag);

    void updateTag(Tag tag);

    void deleteTagByTid(int tid);

    void deleteArticleTagByAid(int aid);

    @Select("select * from tag")
    List<Tag> findExcel();


    void insertCategory(Tag tag);
}
