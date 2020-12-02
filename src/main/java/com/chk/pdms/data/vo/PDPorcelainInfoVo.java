package com.chk.pdms.data.vo;


import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.io.Serializable;

//瓷料
@Data
public class PDPorcelainInfoVo {

    @ExcelIgnore
    public static String sheet = "瓷料";
    @ExcelIgnore
    private String orderRule = "质量等级| |产品型号|-|封装及外形尺寸|-|温度特性/系数|-|电压|-|电容||精度/容量偏差|-|电极材料代码|-|执行标准";

    @ExcelProperty(value = "产品型号")
    private String pdname;
    //    产品性能
    @ExcelProperty(value = "产品性能")
    private String performance;


    //保温时间
    @ExcelProperty(value = "保温时间")
    private String soakingTime;
    // 烧结温度
    @ExcelProperty(value = "烧结温度")
    private String sinteringTemperature;
    // 粒度分布D10
    @ExcelProperty(value = "粒度分布D10")
    private String D10;
    // 粒度分布D50
    @ExcelProperty(value = "粒度分布D50")
    private String D50;
    // 粒度分布D90
    @ExcelProperty(value = "粒度分布D90")
    private String D90;
    // 比表面积
    @ExcelProperty(value = "比表面积")
    private String specificSurfaceArea;
    // 粉体密度
    @ExcelProperty(value = "粉体密度")
    private String powderDensity;

    // 介电常数
    @ExcelProperty(value = "介电常数")
    private String permittivity;
    // 介电损耗@1MHZ
    @ExcelProperty(value = "介电损耗@1MHZ")
    private String dielectricLossBy1MHz;
    // 温度变化率
    @ExcelProperty(value = "温度变化率")
    private String temperatureAlterationRatio;
    // 绝缘电阻@25
    @ExcelProperty(value = "绝缘电阻@25")
    private String insulationResistanceBy25;
    // 绝缘电阻@125
    @ExcelProperty(value = "绝缘电阻@125")
    private String insulationResistanceBy125;
    // 绝缘强度
    @ExcelProperty(value = "绝缘强度")
    private String dielectricStrength;

}
