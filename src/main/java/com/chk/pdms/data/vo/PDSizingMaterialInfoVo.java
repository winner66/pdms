package com.chk.pdms.data.vo;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class PDSizingMaterialInfoVo {
    @ExcelIgnore
    public static String sheet = "浆料";
    @ExcelIgnore
    private String orderRule = "质量等级| |产品型号|-|封装及外形尺寸|-|温度特性/系数|-|电压|-|电容||精度/容量偏差|-|电极材料代码|-|执行标准";


    @ExcelProperty(value = "产品型号")
    private String model;

    @ExcelProperty(value = "金属成分")
    private String padMetallurgy;
    //    烧结温度
    @ExcelProperty(value = "烧结温度")
    private String sinteringTemperature;
//    类别
    @ExcelProperty(value = "类别")
    private String clazz;
    @ExcelProperty(value = "系列id")
    private String pdModelId;

    @ExcelProperty(value = "适配基体材料")
    private String basisMaterial;
}
