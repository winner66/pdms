package com.chk.pdms.pd.dao.mapper;

import com.chk.pdms.pd.domain.PdClassQa;
import com.chk.pdms.pd.domain.PdClassQaExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface PdClassQaMapper {
    long countByExample(PdClassQaExample example);

    int deleteByExample(PdClassQaExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PdClassQa record);

    int insertSelective(PdClassQa record);

    List<PdClassQa> selectByExampleWithRowbounds(PdClassQaExample example, RowBounds rowBounds);

    List<PdClassQa> selectByExample(PdClassQaExample example);

    PdClassQa selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PdClassQa record, @Param("example") PdClassQaExample example);

    int updateByExample(@Param("record") PdClassQa record, @Param("example") PdClassQaExample example);

    int updateByPrimaryKeySelective(PdClassQa record);

    int updateByPrimaryKey(PdClassQa record);
}