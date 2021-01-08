package com.chk.pdms.ALLPDEntity;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class PDHKLHPFInfoEntity implements Serializable {
    private static final long serialVersionUID = 1L;
//    LHPF


    private String pdname;
//    执行标准
    private String std;
//质量等级
    private String quality;
    //    通带损耗 <=1.3dB
    private String passBandInsertionLossLow1_3;
    //    通带损耗 =2.0dB Typ
    private String passBandInsertionLossOn2_0;
    //3dB截止频率
    private String cutOffFrequency;
    //    阻带(>=40dB)
    private  String stopBandUp40;
    //    阻带(>=20dB)
    private  String stopBandUp20;
    //    电压驻波比 通带1.5:1
    private  String  vswrPassBand;
    //    电压驻波比    阻带
    private String vswrStopBand;
    //封装类型
    private  String size;
}
