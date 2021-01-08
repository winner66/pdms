package com.chk.pdms.pd_material.Dto;

import com.chk.pdms.pd_material.domain.PdInfoMaterial;
import lombok.Data;

@Data
public class PdFtMaterialVo extends PdInfoMaterial {
    private String pcName;

    private String pmName;

    private String pmCode;

    private String pmPurpose;

    private String pmFeature;

    private String capacity;
}
