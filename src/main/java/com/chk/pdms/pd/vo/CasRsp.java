package com.chk.pdms.pd.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class CasRsp {
    private String label;

    private String value;

    @JsonIgnore
    public static String OPERA_WX = "wx";
    @JsonIgnore
    public static String OPERA_FILE = "file";

    private String opera;

    private String fileUrl;

    private List<CasRsp> children;

    public CasRsp(String label, String value, boolean createList) {
        this.label = label;
        this.value = value;
        this.opera = OPERA_WX;
        if (createList) {
            this.children = new ArrayList<>();
        }
    }

    public CasRsp(String label, String value, boolean createList, String fileUrl) {
        this.label = label;
        this.value = value;
        this.opera = OPERA_FILE;
        this.fileUrl = fileUrl;
        if (createList) {
            this.children = new ArrayList<>();
        }
    }


}
