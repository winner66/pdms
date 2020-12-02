package com.chk.pdms.data.vo;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class HKIVo {
    @ExcelIgnore
    public static String sheet = "HKI";

    @ExcelIgnore
    public String orderRule = "质量等级| |产品型号|-|封装及外形尺寸||电压||电路形式|-|电容||精度/容量偏差|-|工作温度范围|-|引线材质||引线长短|-|执行标准";

    @ExcelProperty(value = "执行标准")
    private String std;
    @ExcelProperty(value = "质量等级")
    private String quality;
    @ExcelProperty(value = "型号")
    private String model;
    @ExcelProperty(value = "尺寸")
    private String size;
    @ExcelProperty(value = "电压（0表示50V;1表示100V）")
    private String voltage;
    @ExcelProperty(value = "电路形式（0表示C型电路）")
    private String elecType;
    @ExcelProperty(value = "容量起")
    private String capacityMin;
    @ExcelProperty(value = "容量止")
    private String capacityMax;
    @ExcelProperty(value = "精度")
    private String tolerance;
    @ExcelProperty(value = "工作温度范围")
    private String temperRange;
    @ExcelProperty(value = "引线材质")
    private String wireMa;
    @ExcelProperty(value = "引线长短或其它特殊要求")
    private String wireSize;
}
