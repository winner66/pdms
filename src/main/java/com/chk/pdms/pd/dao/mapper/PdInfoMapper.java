package com.chk.pdms.pd.dao.mapper;

import com.chk.pdms.pd.domain.PdInfo;
import com.chk.pdms.pd.domain.PdInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface PdInfoMapper {
    long countByExample(PdInfoExample example);

    int deleteByExample(PdInfoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PdInfo record);

    int insertSelective(PdInfo record);

    List<PdInfo> selectByExampleWithRowbounds(PdInfoExample example, RowBounds rowBounds);

    List<PdInfo> selectByExample(PdInfoExample example);

    PdInfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PdInfo record, @Param("example") PdInfoExample example);

    int updateByExample(@Param("record") PdInfo record, @Param("example") PdInfoExample example);

    int updateByPrimaryKeySelective(PdInfo record);

    int updateByPrimaryKey(PdInfo record);
}