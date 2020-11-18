package com.chk.pdms.data.vo;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.lang.reflect.Field;

@Data
public class ClassVo {
    @ExcelProperty(value = "新一级分类")
    private String lev1;
    @ExcelProperty(value = "新二级分类")
    private String lev21;
    @ExcelProperty(value = "并列二级分类")
    private String lev22;
    //    @ExcelProperty(value = "原三级分类")
//    private String oldLev3;
    @ExcelProperty(value = "新三级分类")
    private String lev3;
    @ExcelProperty(value = "产品序列")
    private String qa;

    @ExcelIgnore
    private Long id;
}
