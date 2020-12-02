package com.chk.pdms.pd.vo;

import lombok.Data;

@Data
public class SelRsp {
    private String title;

    private String value;

    public SelRsp(String title, String value) {
        this.title = title;
        this.value = value;
    }
}
