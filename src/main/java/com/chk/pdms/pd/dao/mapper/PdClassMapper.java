package com.chk.pdms.pd.dao.mapper;

import com.chk.pdms.pd.domain.PdClass;
import com.chk.pdms.pd.domain.PdClassExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface PdClassMapper {
    long countByExample(PdClassExample example);

    int deleteByExample(PdClassExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PdClass record);

    int insertSelective(PdClass record);

    List<PdClass> selectByExampleWithRowbounds(PdClassExample example, RowBounds rowBounds);

    List<PdClass> selectByExample(PdClassExample example);

    PdClass selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PdClass record, @Param("example") PdClassExample example);

    int updateByExample(@Param("record") PdClass record, @Param("example") PdClassExample example);

    int updateByPrimaryKeySelective(PdClass record);

    int updateByPrimaryKey(PdClass record);
}