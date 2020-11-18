package com.chk.pdms.pd.vo;

import com.chk.pdms.pd.domain.PdInfo;
import lombok.Data;

@Data
public class PdFtVo extends PdInfo {
    private String pcName;

    private String pmName;

    private String pmCode;

    private String pmPurpose;

    private String pmFeature;

    private String capacity;

}
