package com.chk.pdms.data.vo;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.io.Serializable;
@Data
public class PDCSInfoVo  {
//    private static final long serialVersionUID = 1L;
    @ExcelIgnore
    public static String sheet = "CS";
    @ExcelIgnore
    private  static  String pix="CS";
    @ExcelIgnore
    private String orderRule = "CS| |材料代码| | 长宽代码";

    //    产品型号(材料-长宽-厚度-表面)
    @ExcelProperty(value = "产品型号")
    private String pdname;
    @ExcelProperty(value = "材料代码")
    private String materialCode;
    @ExcelProperty(value = "长宽代码")
    private String lengthWidthCode;
    @ExcelProperty(value = "厚度代码")
    private String thicknessCode;
    @ExcelProperty(value = "表面代码")
    private String surfaceCode;

}
