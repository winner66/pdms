package com.chk.pdms.fpd.vo;

import com.chk.pdms.fpd.domain.FpdMap;
import lombok.Data;

@Data
public class FpdMapVo extends FpdMap {
    private String fmName;

    private String fmCode;
}
