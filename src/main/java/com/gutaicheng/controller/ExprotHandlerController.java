package com.gutaicheng.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.excel.ExcelReader;
import com.gutaicheng.model.ArticleTag;
import com.gutaicheng.model.Tag;
import com.gutaicheng.service.ArticleTagService;
import com.gutaicheng.util.ExcelListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


/**
 * Eexel导出
 * @author Administrator
 *
 */
@RestController
public class ExprotHandlerController {

    @Autowired
    private ArticleTagService sysLogService;

    @RequestMapping("/exportExcel")
    @ResponseBody
    public void export(HttpServletResponse response) throws IOException {
        List<Tag> list = sysLogService.findExcel();
        ServletOutputStream out = response.getOutputStream();
        ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLSX, true);
        String fileName = "标签表";
        Sheet sheet = new Sheet(1, 0, Tag.class);
        //设置自适应宽度
        sheet.setAutoWidth(Boolean.TRUE);
        // 第一个 sheet 名称
        sheet.setSheetName("文章标签表");
        writer.write(list, sheet);
        //通知浏览器以附件的形式下载处理，设置返回头要注意文件名有中文
        response.setHeader("Content-disposition", "attachment;filename=" + new String( fileName.getBytes("gb2312"), "ISO8859-1" ) + ".xlsx");
        writer.finish();
        response.setContentType("multipart/form-data");
        response.setCharacterEncoding("utf-8");
        out.flush();
        out.close();
    }
    @RequestMapping(value = "/import" , method = RequestMethod.POST)
    @ResponseBody
    public void importExcel(@RequestParam("file") MultipartFile file,HttpServletRequest request) throws IOException {


        InputStream inputStream = file.getInputStream();

        //实例化实现了AnalysisEventListener接口的类
        ExcelListener listener = new ExcelListener();
        //传入参数
        ExcelReader excelReader = new ExcelReader(inputStream, ExcelTypeEnum.XLSX, null, listener);
        //读取信息
        excelReader.read(new Sheet(1, 1, Tag.class));

        //获取数据
        List<Object> list = listener.getDatas();

        List<Tag> catagoryList = new ArrayList<Tag>();
        Tag tag = new Tag();

        //转换数据类型,并插入到数据库
        for (int i = 0; i < list.size(); i++) {
            tag = (Tag) list.get(i);
            sysLogService.insertCategory(tag);
        }
    }
}

