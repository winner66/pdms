package com.chk.pdms.pd_material.dao.extmapper;
import com.chk.pdms.pd_material.domain.ClassMaterialType;

import java.util.List;
public interface ExClassMaterialTypeMapper {
    List<ClassMaterialType> List();

    List<Long>getclassIdList();
}
