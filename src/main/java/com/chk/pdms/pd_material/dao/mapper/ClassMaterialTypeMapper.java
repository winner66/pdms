package com.chk.pdms.pd_material.dao.mapper;


import java.util.List;

import com.chk.pdms.pd_material.domain.ClassMaterialType;
import com.chk.pdms.pd_material.domain.ClassMaterialTypeExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface ClassMaterialTypeMapper {
    long countByExample(ClassMaterialTypeExample example);

    int deleteByExample(ClassMaterialTypeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ClassMaterialType record);

    int insertSelective(ClassMaterialType record);

    List<ClassMaterialType> selectByExampleWithRowbounds(ClassMaterialTypeExample example, RowBounds rowBounds);

    List<ClassMaterialType> selectByExample(ClassMaterialTypeExample example);

    ClassMaterialType selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ClassMaterialType record, @Param("example") ClassMaterialTypeExample example);

    int updateByExample(@Param("record") ClassMaterialType record, @Param("example") ClassMaterialTypeExample example);

    int updateByPrimaryKeySelective(ClassMaterialType record);

    int updateByPrimaryKey(ClassMaterialType record);
}