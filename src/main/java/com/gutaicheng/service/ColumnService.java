package com.gutaicheng.service;

import com.gutaicheng.model.ArticleAndAuthor;
import com.gutaicheng.model.Column;

import java.util.List;

public interface ColumnService {
    List<Column> selectColumnByUid(int uid);

    void addToColumnByAid(int cid, int aid, int uid);
    void updateToColumnByAid(int cid, int aid, int uid);
    int selectArticleAmountByCid(int cid);

    List<Column> selectAllColumns();

    void updateColumnNameByCid(Column column);

    void deleteColumnByCid(int cid);

    void addNewColumn(Column column);

    List<ArticleAndAuthor> selectArticleByCid(int cid);
}
