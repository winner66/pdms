package com.chk.pdms.data.vo;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;
//LBPF
import java.io.Serializable;
@Data
public class PDHKLBPFInfoVo   {
    @ExcelIgnore
    public static String sheet = "LBPF";
    @ExcelIgnore
    private String orderRule = "质量等级| |产品型号|-|封装及外形尺寸|-|温度特性/系数|-|电压|-|电容||精度/容量偏差|-|电极材料代码|-|执行标准";

    @ExcelProperty(value = "产品型号")
    private String pdname;
    @ExcelProperty(value = "执行标准")
    private String std;
    @ExcelProperty(value = "质量等级")
    private String quality;

    @ExcelProperty(value = "中心频率")
    private  String centerFrequency;

    @ExcelProperty(value = "带宽")
    private  String bandwidth;

    @ExcelProperty(value = "封装格式(尺寸代码)")
    private  String size;
    //    插入损耗
    @ExcelProperty(value = "插入损耗")
    private  String insertionLoss;
    //    带内纹波
    @ExcelProperty(value = "带内纹波")
    private  String ripple;
    //    带外抑制
    @ExcelProperty(value = "带外抑制")
    private  String  outOfBandRejection;
    //    电压驻波比
    @ExcelProperty(value = "电压驻波比")
    private  String  vswr;
}
