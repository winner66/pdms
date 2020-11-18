package com.chk.pdms.data.vo;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class SizeVo {
    @ExcelIgnore
    public static String sheet = "尺寸";

    @ExcelProperty(value = "代码")
    private String code;
    @ExcelProperty(value = "执行标准号")
    private String std;
    @ExcelProperty(value = "描述")
    private String desc;
    @ExcelProperty(value = "排序码")
    private Integer idx;
    @ExcelProperty(value = "备注")
    private String remark;
}
