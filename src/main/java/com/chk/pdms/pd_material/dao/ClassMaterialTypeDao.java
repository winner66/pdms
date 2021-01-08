package com.chk.pdms.pd_material.dao;



import com.chk.pdms.pd_material.dao.extmapper.ExClassMaterialTypeMapper;
import com.chk.pdms.pd_material.dao.mapper.ClassMaterialTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
//@SuppressWarnings("all")
public class ClassMaterialTypeDao {
    @Autowired
    private ExClassMaterialTypeMapper exClassMaterialmapper;
    @Autowired
    private ClassMaterialTypeMapper  ClassMaterialmapper;

    public ClassMaterialTypeMapper getClassMaterialmapper() {
        return ClassMaterialmapper;
    }

    public ExClassMaterialTypeMapper getExClassMaterialmapper() {
        return exClassMaterialmapper;
    }
}
