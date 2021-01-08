package com.chk.pdms.pd_material.dao.extmapper;


import com.chk.pdms.pd.vo.PdSkVo;
import com.chk.pdms.pd_material.Dto.PdFtMaterialVo;
import com.chk.pdms.pd_material.vo.PdMaterialVo;

import java.util.List;

public interface ExPdInfoMaterialMapper {

    void updateSearchKey(List<PdSkVo> pdsks);
    List<PdFtMaterialVo> ListFt();

    List<PdMaterialVo> list(String key);
}