package com.chk.pdms.ALLPDEntity;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.io.Serializable;

//LTCC  一路功分器 二路功分器 三路功分器
@Data
public class PDJLTCInfoEntity  implements Serializable {
//    JLTC
    private static final long serialVersionUID = 1L;
    private String pdname;

    private String std;

    private String quality;

//    频率范围
    private String frequencyRange;
//    隔离度 *
    private String isolation;
//    插入损耗
    private  String insertionLoss;
//    相位平衡度
    private String PhaseBalance;
//    幅度平衡度
    private String  amplitudeBalance;
//   驻波*
    private  String  vswr;
//    功率容量
    private  String powerCapacity;
}
