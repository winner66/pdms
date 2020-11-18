package com.chk.pdms.fpd.dao.mapper;

import com.chk.pdms.fpd.domain.FpdModel;
import com.chk.pdms.fpd.domain.FpdModelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface FpdModelMapper {
    long countByExample(FpdModelExample example);

    int deleteByExample(FpdModelExample example);

    int deleteByPrimaryKey(Long id);

    int insert(FpdModel record);

    int insertSelective(FpdModel record);

    List<FpdModel> selectByExampleWithRowbounds(FpdModelExample example, RowBounds rowBounds);

    List<FpdModel> selectByExample(FpdModelExample example);

    FpdModel selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") FpdModel record, @Param("example") FpdModelExample example);

    int updateByExample(@Param("record") FpdModel record, @Param("example") FpdModelExample example);

    int updateByPrimaryKeySelective(FpdModel record);

    int updateByPrimaryKey(FpdModel record);
}