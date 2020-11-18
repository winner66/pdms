package com.chk.pdms.pd.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class PdInfoExcel {

    @ExcelProperty(value = "执行标准")
    private String std;

    @ExcelProperty(value = "质量等级")
    private String quality;

    @ExcelProperty(value = "型号")
    private String modelName;

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

    @ExcelProperty(value = "引出端形式")
    private String outlet;

    @ExcelProperty(value = "备注")
    private String remark;
}
