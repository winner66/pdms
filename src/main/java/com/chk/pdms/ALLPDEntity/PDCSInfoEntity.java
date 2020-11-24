package com.chk.pdms.ALLPDEntity;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class PDCSInfoEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    private  static  String pix="CS";


    //    产品型号(材料-长宽-厚度-表面)

    private String pdname;

    private String materialCode;

    private String lengthWidthCode;

    private String thicknessCode;

    private String surfaceCode;

}
