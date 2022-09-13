package com.gutaicheng.controller;

import com.gutaicheng.model.ArticleAndAuthor;
import com.gutaicheng.model.Column;
import com.gutaicheng.service.ColumnService;
import com.gutaicheng.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ColumnController {
    @Autowired
    private ColumnService columnService;
    @Autowired
    private UserService userService;

    /**
     * 根据 uid 查询该用户 创建的专栏 Column
     */
    @RequestMapping("/selectColumnByUid")
    @ResponseBody
    public List<Column> selectColumnByUid(int uid){
        List<Column> columnList = columnService.selectColumnByUid(uid);
        for (Column column : columnList) {
            column.setAmount(columnService.selectArticleAmountByCid(column.getCid()));
            column.setUsername(userService.selectUserByUid(column.getUid()).getUsername());
        }
        return columnList;
    }

    /**
     * 根据 aid 将该文章 添加至专栏
     */
    @RequestMapping("/addToColumnByAid")
    @ResponseBody
    public void addToColumnByAid(int cid, int aid, int uid){
        columnService.addToColumnByAid(cid, aid, uid);
    }

    /**
     * 根据 aid 更新该文章专栏
     */
    @RequestMapping("/updateToColumnByAid")
    @ResponseBody
    public void updateToColumnByAid(int cid, int aid, int uid){
        columnService.updateToColumnByAid(cid, aid, uid);
    }

    /**
     * 根据 cid 查询该专栏下有几篇文章
     */
    @RequestMapping("/selectArticleAmountByCid")
    @ResponseBody
    public int selectArticleAmountByCid(int cid){
        return columnService.selectArticleAmountByCid(cid);
    }

    /**
     * 查询所有创建的专栏 Column
     */
    @RequestMapping("/selectAllColumns")
    @ResponseBody
    public List<Column> selectAllColumns(){
        List<Column> columnList = columnService.selectAllColumns();
        for (Column column : columnList) {
            column.setAmount(columnService.selectArticleAmountByCid(column.getCid()));
            column.setUsername(userService.selectUserByUid(column.getUid()).getUsername());
        }
        return columnList;
    }

    /**
     * 通过 cid  更新专栏名称
     */
    @RequestMapping(value = "/updateColumnNameByCid", method = RequestMethod.POST)
    @ResponseBody
    public void updateColumnNameByCid(@RequestBody Column column){
        columnService.updateColumnNameByCid(column);
    }

    /**
     * 通过 cid  删除专栏
     */
    @RequestMapping("/deleteColumnByCid")
    @ResponseBody
    public void deleteColumnByCid(int cid){
        columnService.deleteColumnByCid(cid);
    }

    /**
     * 新增专栏
     */
    @RequestMapping(value = "/addNewColumn", method = RequestMethod.POST)
    @ResponseBody
    public void addNewColumn(@RequestBody Column column){
        columnService.addNewColumn(column);
    }

    /**
     * 根据 cid 查询该专栏下的所有文章
     */
    @RequestMapping(value = "/selectArticleByCid")
    @ResponseBody
    public List<ArticleAndAuthor> selectArticleByCid(int cid){
        return columnService.selectArticleByCid(cid);
    }
}
