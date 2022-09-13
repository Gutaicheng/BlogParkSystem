package com.gutaicheng.service;

import com.gutaicheng.dao.ColumnMapper;
import com.gutaicheng.model.ArticleAndAuthor;
import com.gutaicheng.model.Column;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("ColumnService")
public class ColumnServiceImpl implements ColumnService{
    @Resource
    private ColumnMapper columnMapper;


    /**
     * 根据 uid 查询该用户 创建的专栏 Column
     */
    @Override
    public List<Column> selectColumnByUid(int uid) {
        return columnMapper.selectColumnByUid(uid);
    }

    /**
     * 根据 aid 将该文章 添加至专栏
     */
    @Override
    public void addToColumnByAid(int cid, int aid, int uid) {
        columnMapper.addToColumnByAid(cid, aid, uid);
    }

    /**
     * 根据 aid 更新该文章专栏
     */
    @Override
    public void updateToColumnByAid(int cid, int aid, int uid) {
        columnMapper.updateToColumnByAid(cid,aid,uid);
    }

    /**
     * 根据 cid 查询该专栏下有几篇文章
     */
    @Override
    public int selectArticleAmountByCid(int cid) {
        return columnMapper.selectArticleAmountByCid(cid);
    }

    /**
     * 查询所有创建的专栏 Column
     */
    @Override
    public List<Column> selectAllColumns() {
        return columnMapper.selectAllColumns();
    }

    /**
     * 通过 cid  更新专栏名称
     */
    @Override
    public void updateColumnNameByCid(Column column) {
        columnMapper.updateColumnNameByCid(column);
    }

    /**
     * 通过 cid  删除专栏名称
     */
    @Override
    public void deleteColumnByCid(int cid) {
        columnMapper.deleteColumnByCid(cid);
    }

    /**
     * 新增专栏
     */
    @Override
    public void addNewColumn(Column column) {
        columnMapper.addNewColumn(column);
    }

    /**
     * 根据 cid 查询该专栏下的所有文章
     */
    @Override
    public List<ArticleAndAuthor> selectArticleByCid(int cid) {
        return columnMapper.selectArticleByCid(cid);
    }
}
