package com.chk.pdms.data.vo;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class TerVo {
    @ExcelIgnore
    public static String sheet = "接线端子";

    @ExcelIgnore
    public  String orderRule = "质量等级| |产品型号||电压|-|封装及外形尺寸|-|执行标准";

    @ExcelProperty(value = "执行标准")
    private String std;
    @ExcelProperty(value = "质量等级")
    private String quality;
    @ExcelProperty(value = "型号")
    private String model;
    @ExcelProperty(value = "电压（10表示100V）")
    private String voltage;
    @ExcelProperty(value = "产品尺寸代号")
    private String size;
}
