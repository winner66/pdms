package com.chk.pdms.common.vo;

import lombok.Data;

@Data
public class PageReq {
    private int pageNum = 1;

    private int pageSize = 10;

    public void setPageNum(int pageNum) {
        this.pageNum =  pageNum < 1 ? 1 : pageNum;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize > 500 ? 500 : pageSize;
    }
}
