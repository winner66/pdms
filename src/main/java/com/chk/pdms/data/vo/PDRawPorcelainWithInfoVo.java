package com.chk.pdms.data.vo;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 *生瓷带
 */
@Data
public class PDRawPorcelainWithInfoVo  {

    @ExcelIgnore
    public static String sheet = "生瓷带";
    @ExcelIgnore
    private String orderRule = "质量等级| |产品型号|-|封装及外形尺寸|-|温度特性/系数|-|电压|-|电容||精度/容量偏差|-|电极材料代码|-|执行标准";

    @ExcelProperty(value = "产品型号")
    private String pdname;

//    介电常数 @1.9G
    @ExcelProperty(value = "介电常数 @1.9G")
    private String permittivityBy1_9G;
//    介电常数 @15G
    @ExcelProperty(value = "介电常数 @15G")
    private String permittivityBy15G;
//    介电损耗@1.9G
    @ExcelProperty(value = "介电损耗@1.9G")
    private String dielectricLossBy1_9G;
//    介电常数 @15G
    @ExcelProperty(value = "介电常数 @15G")
    private String dielectricLossBy20G;
//    抗弯强度
    @ExcelProperty(value = "抗弯强度")
    private String flexureStrength;
//    绝缘电阻
    @ExcelProperty(value = "绝缘电阻")
    private String insulationResistance;
//    击穿电压
    @ExcelProperty(value = "击穿电压")
    private String breakdownVoltage;

}
