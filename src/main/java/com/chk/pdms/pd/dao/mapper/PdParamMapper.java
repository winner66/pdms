package com.chk.pdms.pd.dao.mapper;

import com.chk.pdms.pd.domain.PdParam;
import com.chk.pdms.pd.domain.PdParamExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface PdParamMapper {
    long countByExample(PdParamExample example);

    int deleteByExample(PdParamExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PdParam record);

    int insertSelective(PdParam record);

    List<PdParam> selectByExampleWithRowbounds(PdParamExample example, RowBounds rowBounds);

    List<PdParam> selectByExample(PdParamExample example);

    PdParam selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PdParam record, @Param("example") PdParamExample example);

    int updateByExample(@Param("record") PdParam record, @Param("example") PdParamExample example);

    int updateByPrimaryKeySelective(PdParam record);

    int updateByPrimaryKey(PdParam record);
}