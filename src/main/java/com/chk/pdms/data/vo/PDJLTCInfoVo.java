package com.chk.pdms.data.vo;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.io.Serializable;

//LTCC  一路功分器 二路功分器 三路功分器
@Data
public class PDJLTCInfoVo  {
    @ExcelIgnore
    public static String sheet = "JLTC";
    @ExcelIgnore
    private String orderRule = "质量等级| |产品型号|-|封装及外形尺寸|-|温度特性/系数|-|电压|-|电容||精度/容量偏差|-|电极材料代码|-|执行标准";

    @ExcelProperty(value = "产品型号")
    private String pdname;
    @ExcelProperty(value = "执行标准")
    private String std;
    @ExcelProperty(value = "质量等级")
    private String quality;

//    频率范围
    @ExcelProperty(value = "频率范围")
    private String frequencyRange;
//    隔离度 *
    @ExcelProperty(value = " 隔离度 *")
    private String isolation;

//    插入损耗
    @ExcelProperty(value = "插入损耗")
    private  String insertionLoss;
//    相位平衡度
    @ExcelProperty(value = "相位平衡度")
    private String PhaseBalance;
//    幅度平衡度
    @ExcelProperty(value = "幅度平衡度")
    private String  amplitudeBalance;
//   驻波*
    @ExcelProperty(value = "驻波*")
    private  String  vswr;
//    功率容量
    @ExcelProperty(value = "功率容量")
    private  String powerCapacity;
}
