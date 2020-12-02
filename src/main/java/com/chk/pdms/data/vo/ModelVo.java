package com.chk.pdms.data.vo;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class ModelVo {
    @ExcelIgnore
    public static String sheet = "产品系列";

    @ExcelProperty(value = "产品名称")
    private String name;
    @ExcelProperty(value = "质量等级")
    private String qaCode;
    @ExcelProperty(value = "产品系列型号")
    private String code;
    @ExcelProperty(value = "一级分类")
    private String clz1;
    @ExcelProperty(value = "二级分类")
    private String clz2;
    @ExcelProperty(value = "三级分类")
    private String clz3;
    @ExcelProperty(value = "四级分类")
    private String clz4;
    @ExcelProperty(value = "介质耐电压")
    private String voltage;
    @ExcelProperty(value = "绝缘电阻")
    private String ohm;
    @ExcelProperty(value = "损耗角正切")
    private String tan;
    @ExcelProperty(value = "是否新品")
    private String isNew;
    @ExcelProperty(value = "其他参数")
    private String otherParam;
    ;
    @ExcelProperty(value = "用途")
    private String purpose;
    @ExcelProperty(value = "产品特点")
    private String feature;
    @ExcelProperty(value = "技术联系人")
    private String contact;
    @ExcelProperty(value = "联系方式")
    private String phone;
    @ExcelProperty(value = "备注")
    private String remark;
    @ExcelProperty(value = "总规范")
    private String norm;

    @ExcelIgnore
    private String orderRule;
}
