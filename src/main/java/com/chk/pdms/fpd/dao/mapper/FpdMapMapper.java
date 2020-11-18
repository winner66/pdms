package com.chk.pdms.fpd.dao.mapper;

import com.chk.pdms.fpd.domain.FpdMap;
import com.chk.pdms.fpd.domain.FpdMapExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface FpdMapMapper {
    long countByExample(FpdMapExample example);

    int deleteByExample(FpdMapExample example);

    int deleteByPrimaryKey(Long id);

    int insert(FpdMap record);

    int insertSelective(FpdMap record);

    List<FpdMap> selectByExampleWithRowbounds(FpdMapExample example, RowBounds rowBounds);

    List<FpdMap> selectByExample(FpdMapExample example);

    FpdMap selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") FpdMap record, @Param("example") FpdMapExample example);

    int updateByExample(@Param("record") FpdMap record, @Param("example") FpdMapExample example);

    int updateByPrimaryKeySelective(FpdMap record);

    int updateByPrimaryKey(FpdMap record);
}