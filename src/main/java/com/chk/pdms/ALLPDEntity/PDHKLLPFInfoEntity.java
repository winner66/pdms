package com.chk.pdms.ALLPDEntity;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.io.Serializable;

//HKLLPE产品类型
@Data
public class PDHKLLPFInfoEntity implements Serializable {

  private static final long serialVersionUID = 1L;

    private String pdname;

    private String std;

    private String quality;
//    通带范围

    private  String passBandRange;

//封装格式

    private  String size;
//    插入损耗

    private  String insertionLoss;
//3dB截止频率

    private  String cutOffFrequency;
//    阻带(>=20dB)

    private  String stopBandUP20;
//    阻带(=30dB)

    private  String stopBandON30;
//    阻带(=40dB)

    private  String stopBandOn40;
//    阻带(20dB*)

    private  String stopBandOn20;
//    电压驻波比

    private  String  vswr;
//    功率容量

    private  String  powerCapacity;

//    定制类低通
//    带内纹波

    private  String ripple;
//    带外抑制

    private  String  outOfBandRejection;
//    其他要求

    private  String other;

}
