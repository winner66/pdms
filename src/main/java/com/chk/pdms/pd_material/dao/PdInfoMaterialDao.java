package com.chk.pdms.pd_material.dao;


import com.chk.pdms.pd_material.dao.extmapper.ExPdInfoMaterialMapper;
import com.chk.pdms.pd_material.dao.mapper.PdInfoMaterialMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@SuppressWarnings("all")
public class PdInfoMaterialDao {

    @Autowired
    private ExPdInfoMaterialMapper exPdInfoMaterialMapper;

    @Autowired
    private PdInfoMaterialMapper PdInfoMaterialMapper;

    public ExPdInfoMaterialMapper getExPdInfoMaterialMapper() {
        return exPdInfoMaterialMapper;
    }

    public PdInfoMaterialMapper getPdInfoMaterialMapper() {
        return PdInfoMaterialMapper;
    }
}
