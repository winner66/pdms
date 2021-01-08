package com.chk.pdms.fpd.dao.mapper;

import com.chk.pdms.fpd.domain.FpdSeries;
import com.chk.pdms.fpd.domain.FpdSeriesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface FpdSeriesMapper {
    long countByExample(FpdSeriesExample example);

    int deleteByExample(FpdSeriesExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FpdSeries record);

    int insertSelective(FpdSeries record);

    List<FpdSeries> selectByExampleWithRowbounds(FpdSeriesExample example, RowBounds rowBounds);

    List<FpdSeries> selectByExample(FpdSeriesExample example);

    FpdSeries selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FpdSeries record, @Param("example") FpdSeriesExample example);

    int updateByExample(@Param("record") FpdSeries record, @Param("example") FpdSeriesExample example);

    int updateByPrimaryKeySelective(FpdSeries record);

    int updateByPrimaryKey(FpdSeries record);

    List<FpdSeries> getList ();

}