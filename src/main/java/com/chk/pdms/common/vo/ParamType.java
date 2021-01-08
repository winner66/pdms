package com.chk.pdms.common.vo;

public enum ParamType {
    quality("质量等级", "质量等级"),
    std("执行标准","执行标准"),
    size("封装及外形尺寸","尺寸"),
    temperature("温度特性/系数","温度特性"),
    voltage("电压","电压"),
    model("产品型号","型号"),

    capacity("电容","容量"),

    tolerance("精度/容量偏差","精度"),
    outlet("引出端形式","引出端形式"),
    elecCode("电极材料代码","电极材料代码"),
    capNum("电容数量","电容数量"),
    elecType("电路形式","电路形式"),
    temperRange("工作温度范围","工作温度范围"),

    elecSer("电流系列","电流系列"),
    socStr("端头结构","端头结构"),
    packType("包装方式","包装方式"),

    wireMa("引线材质","引线材质"),
    wireSize("引线长短","引线长短"),
    pin("引脚形状","引脚形状"),


    surfaceCode("陶瓷基片的表面代码","表面类型"),
    thicknessCode("陶瓷基片的厚度代码","厚度代码"),
    lengthWidthCode("陶瓷基片的长宽代码","长宽代码"),
    materialCode("陶瓷基片的材料代码","材料代码"),
    centerFrequency("中心频率","中心频率"),
    cutOffFrequency("3dB截止频率","3dB截止频率"),
    passBandRange("通带范围","通带范围"),
    frequencyRange("频率范围","频率范围"),
    bandwidth("带宽","带宽"),
    basisMaterial("适配基体材料","适配基体材料");
    private String value;

    private String title;

    ParamType(String value,String title) {
        this.value = value;
        this.title = title;
    }

    public String title(){
        return title;
    }

    public String value(){
        return value;
    }
}


