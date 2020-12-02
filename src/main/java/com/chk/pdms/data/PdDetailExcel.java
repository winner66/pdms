package com.chk.pdms.data;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class PdDetailExcel  implements Serializable {
    @ExcelProperty(value = "名称" ,index = 0)
    private  String name;
//    型号  ruleExp  //"①QJB(M)/K+  ②CCK4L - ③5 - ④CG - ⑤1KV - ⑥101 ⑦G - ⑧Q/RQ26032-2012 "
@ExcelProperty(value = "型号")
    private  String code;
    @ExcelProperty(value = "外形尺寸及封装")
    private  String size;
    @ExcelProperty(value = "质量等级")
    private  String  quality;
//    /总规范
@ExcelProperty(value = "总规范")
private  String allStd;
    //    执行标准--详细规则
    @ExcelProperty(value = "详细规范")
    private  String std;

    //    标准分类名称
    @ExcelProperty(value = " 标准分类名称")
    private  String className;


//    PDF编号
@ExcelProperty(value = "PDF编号")
    private  String pdf;
//    图片编号
@ExcelProperty(value = "图片编号")
//class的图片
    private  String image;

    @ExcelProperty(value = "HKclassId")
    private  String HKclass;
    @ExcelProperty(value = "HKmodel")
    private  String HKmodel;
    @ExcelProperty(value = "HKpd")
    private  String HKpd;

}
