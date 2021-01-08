package com.chk.pdms.data.vo;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class PDCSInfoVo {
    //    private static final long serialVersionUID = 1L;
    @ExcelIgnore
    public static String sheet = "陶瓷介质";
    @ExcelIgnore
    private static String pix = "CS";
    @ExcelIgnore
    private String orderRule = "陶瓷基片||材料牌号||长宽代码||厚度代码||表面特性";

    //    产品型号(材料-长宽-厚度-表面)
    @ExcelProperty(value = "产品型号")
    private String model;
    @ExcelProperty(value = "材料代码")
    private String materialCode;
    @ExcelProperty(value = "长宽代码")
    private String lengthWidthCode;
    @ExcelProperty(value = "厚度代码")
    private String thicknessCode;
    @ExcelProperty(value = "表面特征")
    private String surfaceCode;
    @ExcelProperty(value = "系列id")
    private String pdModelId;
    @ExcelProperty(value = "类型")
    private String other;


}
