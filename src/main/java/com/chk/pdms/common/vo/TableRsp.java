package com.chk.pdms.common.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class TableRsp  implements Serializable {
    private static final long serialVersionUID = 1L;
     private  String title;
    private   String value;

    public TableRsp(String title, String value) {
        this.title = title;
        this.value = value;
    }
}
