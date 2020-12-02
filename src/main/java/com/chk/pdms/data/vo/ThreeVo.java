package com.chk.pdms.data.vo;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class ThreeVo {
    @ExcelIgnore
    public static String sheet = "三端";

    @ExcelIgnore
    public String orderRule = "质量等级| |产品型号|-|封装及外形尺寸|-|温度特性/系数|-|电压|-|电容||精度/容量偏差|-|电流系列||端头结构||包装方式|-|执行标准";

    @ExcelProperty(value = "执行标准")
    private String std;
    @ExcelProperty(value = "质量等级")
    private String quality;
    @ExcelProperty(value = "型号")
    private String model;
    @ExcelProperty(value = "尺寸")
    private String size;
    @ExcelProperty(value = "特性")
    private String temperature;
    @ExcelProperty(value = "电压")
    private String voltage;
    @ExcelProperty(value = "容量起")
    private String capacityMin;
    @ExcelProperty(value = "容量止")
    private String capacityMax;
    @ExcelProperty(value = "精度")
    private String tolerance;
    @ExcelProperty(value = "电流系列")
    private String elecSer;
    @ExcelProperty(value = "端头结构")
    private String socStr;
    @ExcelProperty(value = "包装方式")
    private String packType;
}
