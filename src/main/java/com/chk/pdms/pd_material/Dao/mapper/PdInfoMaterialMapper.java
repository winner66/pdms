package com.chk.pdms.pd_material.Dao.mapper;

import com.chk.pdms.dao.Info.domain.PdInfoMaterial;
import com.chk.pdms.dao.Info.domain.PdInfoMaterialExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface PdInfoMaterialMapper {
    long countByExample(PdInfoMaterialExample example);

    int deleteByExample(PdInfoMaterialExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PdInfoMaterial record);

    int insertSelective(PdInfoMaterial record);

    List<PdInfoMaterial> selectByExampleWithRowbounds(PdInfoMaterialExample example, RowBounds rowBounds);

    List<PdInfoMaterial> selectByExample(PdInfoMaterialExample example);

    PdInfoMaterial selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PdInfoMaterial record, @Param("example") PdInfoMaterialExample example);

    int updateByExample(@Param("record") PdInfoMaterial record, @Param("example") PdInfoMaterialExample example);

    int updateByPrimaryKeySelective(PdInfoMaterial record);

    int updateByPrimaryKey(PdInfoMaterial record);
}