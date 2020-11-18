package com.chk.pdms.order.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import lombok.Data;

import java.util.Date;

@Data
public class OrderFlowExportVo {
    @ExcelProperty(value = "编号", index = 0)
    private String id;

    @ExcelProperty(value = "类型", index = 1)
    private String type;

    @ExcelProperty(value = "公司", index = 2)
    private String company;

    @ExcelProperty(value = "联系人", index = 3)
    private String contact;

    @ExcelProperty(value = "联系电话", index = 4)
    private String phone;

    @ExcelProperty(value = "备注", index = 5)
    private String descr;

    @DateTimeFormat("yyyy-MM-dd")
    @ExcelProperty(value = "提交日期", index = 6)
    private Date createTime;

    @ExcelProperty(value = "状态", index = 7)
    private String orderStatus;

    @ExcelProperty(value = "当前处理人", index = 8)
    private String orderOpUser;

    @ExcelProperty(value = "处理序号", index = 9)
    private Integer idx;

    @ExcelProperty(value = "处理人", index = 10)
    private String flowOpUser;

    @ExcelProperty(value = "处理时间", index = 11)
    private Date opDatetime;

    @ExcelProperty(value = "处理结果", index = 12)
    private String opDesc;

    public void emptyOrders(){
        id = null;
        type = null;
        company = null;
        contact = null;
        phone = null;
        descr = null;
        createTime = null;
        orderStatus = null;
        orderOpUser = null;
    }
}