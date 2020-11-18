package com.chk.pdms.pd.vo;

import lombok.Data;

@Data
public class PdSkVo {
    private Long id;

    private String searchKey;

    public PdSkVo(Long id, String searchKey) {
        this.id = id;
        this.searchKey = searchKey;
    }

}
