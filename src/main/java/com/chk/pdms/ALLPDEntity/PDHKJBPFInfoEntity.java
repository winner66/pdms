package com.chk.pdms.ALLPDEntity;

import lombok.Data;

import java.io.Serializable;

@Data
public class PDHKJBPFInfoEntity implements Serializable {
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
