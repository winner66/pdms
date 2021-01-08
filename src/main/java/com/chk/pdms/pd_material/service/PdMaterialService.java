package com.chk.pdms.pd_material.service;

import com.chk.pdms.common.vo.Page;
import com.chk.pdms.common.vo.PageReq;
import com.chk.pdms.common.vo.TableRsp;
import com.chk.pdms.common.vo.TreeRsp;
import com.chk.pdms.pd.domain.PdParam;
import com.chk.pdms.pd.vo.ImportDataVo;
import com.chk.pdms.pd.vo.PdInfoVo;
import com.chk.pdms.pd_material.domain.PdInfoMaterial;
import com.chk.pdms.pd_material.vo.PdMaterialVo;

import java.util.List;

public interface PdMaterialService {

    ImportDataVo importData(ImportDataVo vo);

    Page<PdMaterialVo> list(String key, PageReq pageReq);
    void delete(Long id);
    void save(PdInfoMaterial info);
    void buildFtIndex();
    PdMaterialVo get(Long id);
    String buildFtIndex(PdInfoMaterial info);
    List<TreeRsp> getclz();

    List<TableRsp> getclzLevel1();
}
