package com.chk.pdms.order.vo;

public enum OrderStatus {
    handel(1, "处理中"),
    finish(9, "完成");

    private Integer value;

    private String title;

    OrderStatus(Integer value,String title) {
        this.value = value;
        this.title = title;
    }

    public Integer value() {
        return value;
    }

    public String title() {
        return title;
    }
}


