package com.chk.pdms.ALLPDEntity;


import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.io.Serializable;

//瓷料
@Data
public class PDPorcelainInfoEntity implements Serializable {
//瓷料
private static final long serialVersionUID = 1L;
    private String pdname;
    //    产品性能
    private String performance;

//保温时间
private String soakingTime;
// 烧结温度
private String sinteringTemperature;
// 粒度分布D10
private String D10;
// 粒度分布D50
private String D50;
// 粒度分布D90
private String D90;
// 比表面积
private String specificSurfaceArea ;
// 粉体密度
private String powderDensity;
// 介电常数
private String permittivity;
// 介电损耗@1MHZ
private String dielectricLossBy1MHz;
// 温度变化率
private String  temperatureAlterationRatio;
// 绝缘电阻@25
private String insulationResistanceBy25;
// 绝缘电阻@125
private String insulationResistanceBy125;
// 绝缘强度
private String dielectricStrength;
}
