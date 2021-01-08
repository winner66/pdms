package com.chk.pdms.data.vo;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.io.Serializable;

//HKLLPE产品类型
@Data
public class PDHKLLPFInfoVo {

    @ExcelIgnore
    public static String sheet = "低通滤波器";
    @ExcelIgnore
    private String orderRule = "质量等级| |产品型号|-|封装及外形尺寸|-|温度特性/系数|-|电压|-|电容||精度/容量偏差|-|电极材料代码|-|执行标准";

    @ExcelProperty(value = "产品型号")
    private String model;
    @ExcelProperty(value = "执行标准")
    private String std;
    @ExcelProperty(value = "质量等级")
    private String quality;
    //    通带范围
    @ExcelProperty(value = "通带范围（MHz）")
    private String frequencyRange;

    //封装格式
    @ExcelProperty(value = "封装格式")
    private String size;
    //    插入损耗
    @ExcelProperty(value = "插入损耗（dB）")
    private String insertionLoss;
    //3dB截止频率
    @ExcelProperty(value = "3dB截止频率（MHz）")
    private String cutOffFrequency;
    //    阻带(>=20dB)

    @ExcelProperty(value = "带外抑制1 （dB）")
    private String outOfBandRejection1;
    @ExcelProperty(value = "带外抑制2（dB）")
    private String outOfBandRejection2;
    @ExcelProperty(value = "带外抑制3（dB）")
    private String outOfBandRejection3;
//    //    阻带(=30dB)
//    @ExcelProperty(value = "阻带(=30dB)")
//    private String stopBandON30;
//    //    阻带(=40dB)
//    @ExcelProperty(value = "阻带(=40dB)")
//    private String stopBandOn40;
//    //    阻带(20dB*)
//    @ExcelProperty(value = "阻带(20dB*)")
//    private String stopBandOn20;
    //    电压驻波比
    @ExcelProperty(value = "带内电压驻波比（：1）Typ")
    private String vswr;
    //    功率容量
    @ExcelProperty(value = "功率容量（W）")
    private String powerCapacity;
    //    功率容量
    @ExcelProperty(value = "额定电流（mA）")
    private String ratedCurrent;

    //    定制类低通
////    带内纹波
//    @ExcelProperty(value = "带内纹波")
//    private String ripple;
    //    带外抑制
//    @ExcelProperty(value = "带外抑制")
//    private String outOfBandRejection;
    //    其他要求
//    @ExcelProperty(value = "其他要求")
//    private String other;

}
