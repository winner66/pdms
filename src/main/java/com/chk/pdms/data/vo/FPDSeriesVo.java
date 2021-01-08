package com.chk.pdms.data.vo;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentRowHeight;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ContentRowHeight(value = 20)
@HeadRowHeight(30)
@ColumnWidth(25)
public class FPDSeriesVo {
    @ExcelIgnore
    public static String sheet = "sheet1";

    @ExcelProperty(value = "国内/外厂家")
    private String fFactorys;
    @ExcelProperty(value = "国内/外系列")
    private String fSeries;
    @ExcelProperty(value = "宏科系列")
    private String hkSeries;
    @ExcelProperty(value = "尺寸")
    private String size;
    @ExcelProperty(value = "温度特性")
    private String temperature;
    @ExcelProperty(value = "电压")
    private String voltage;
    @ExcelProperty(value = "引出端形式")
    private String outlet;
    @ExcelProperty(value = "精度偏差")
    private String tolerance;
    @ExcelProperty(value = "结构")
    private String socStr;
    @ExcelProperty(value = "电极外形代码")
    private String elecCode;


}
