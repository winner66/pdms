package com.chk.pdms.data.vo;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.io.Serializable;
@Data
public class PDLHPFInfoVo {

    @ExcelIgnore
    public static String sheet = "LHPF";
    @ExcelIgnore
    private String orderRule = "质量等级| |产品型号|-|封装及外形尺寸|-|温度特性/系数|-|电压|-|电容||精度/容量偏差|-|电极材料代码|-|执行标准";

    @ExcelProperty(value = "产品型号")
    private String pdname;
    @ExcelProperty(value = "执行标准")
    private String std;
    @ExcelProperty(value = "质量等级")

    private String quality;
    //    通带损耗 <=1.3dB
    @ExcelProperty(value = "通带损耗 <=1.3dB")
    private String passBandInsertionLossLow1_3;
    //    通带损耗 =2.0dB Typ
    @ExcelProperty(value = "通带损耗 =2.0dB Typ")
    private String passBandInsertionLossOn2_0;
    //3dB截止频率
    @ExcelProperty(value = "3dB截止频率")
    private String cutOffFrequency;
    //    阻带(>=40dB)
    @ExcelProperty(value = "阻带(>=40dB)")
    private  String stopBandUp40;
    //    阻带(>=20dB)
    @ExcelProperty(value = "阻带(>=20dB)")
    private  String stopBandUp20;
    //    电压驻波比 通带1.5:1
    @ExcelProperty(value = "电压驻波比 通带1.5:1")
    private  String  vswrPassBand;
    //    电压驻波比    阻带
    @ExcelProperty(value = "电压驻波比    阻带")
    private String vswrStopBand;
    //封装类型
    @ExcelProperty(value = "封装类型")
    private  String size;
}
