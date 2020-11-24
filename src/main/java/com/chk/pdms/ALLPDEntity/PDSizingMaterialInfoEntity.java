package com.chk.pdms.ALLPDEntity;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class PDSizingMaterialInfoEntity  implements Serializable {
 //    浆料
 private static final long serialVersionUID = 1L;
//    产品型号
    private String pdname;
//    金属成分
    private String padMetallurgy;
    //    烧结温度
    private String sinteringTemperature;



}
