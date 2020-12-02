package com.chk.pdms.data;

import com.chk.pdms.pd.vo.SelRsp;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ExportPdDetailReq {
    private Long id;

    private String capacity;

    private String tolerance;

    private String outlet;
    private String capacityCode;
    private String wireMa ;

    private String wireSiz;

    private String pin ;



}
