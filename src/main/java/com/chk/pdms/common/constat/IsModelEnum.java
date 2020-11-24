package com.chk.pdms.common.constat;

public enum IsModelEnum {
    hasModel("型号-质量等级-执行标准", 1),
    notModel("型号", 0);
    // 成员变量
    private String name;
    private int value;
    // 构造方法
    private IsModelEnum(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
