package com.gutaicheng.dao;


import com.gutaicheng.model.ArticleAndAuthor;
import com.gutaicheng.model.Column;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository("columnMapper")
public interface ColumnMapper {
    List<Column> selectColumnByUid(int uid);

    void addToColumnByAid(@Param("cid") int cid, @Param("aid") int aid, @Param("uid") int uid);

    int selectArticleAmountByCid(int cid);

    List<Column> selectAllColumns();

    void updateColumnNameByCid(Column column);

    void deleteColumnByCid(int cid);

    void updateToColumnByAid(@Param("cid") int cid, @Param("aid") int aid, int uid);

    void addNewColumn(Column column);

    List<ArticleAndAuthor> selectArticleByCid(int cid);
}
