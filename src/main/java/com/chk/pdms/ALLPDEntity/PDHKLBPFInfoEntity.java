package com.chk.pdms.ALLPDEntity;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.io.Serializable;
//LBPF


@Data
public class PDHKLBPFInfoEntity implements Serializable {
//   LBPF
     private static final long serialVersionUID = 1L;


    private String pdname;

    private String std;

    private String quality;


    private  String centerFrequency;


    private  String bandwidth;


    private  String size;
    //    插入损耗

    private  String insertionLoss;
    //    带内纹波

    private  String ripple;
    //    带外抑制

    private  String  outOfBandRejection;
    //    电压驻波比
    private  String  vswr;
}
