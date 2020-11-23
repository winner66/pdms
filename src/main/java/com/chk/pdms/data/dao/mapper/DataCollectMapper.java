package com.chk.pdms.data.dao.mapper;

import com.chk.pdms.data.domain.DataCollect;
import com.chk.pdms.data.vo.DataCollectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface DataCollectMapper {
    long countByExample(DataCollectExample example);

    int deleteByExample(DataCollectExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DataCollect record);

    int insertSelective(DataCollect record);

    List<DataCollect> selectByExampleWithRowbounds(DataCollectExample example, RowBounds rowBounds);

    List<DataCollect> selectByExample(DataCollectExample example);

    DataCollect selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DataCollect record, @Param("example") DataCollectExample example);

    int updateByExample(@Param("record") DataCollect record, @Param("example") DataCollectExample example);

    int updateByPrimaryKeySelective(DataCollect record);

    int updateByPrimaryKey(DataCollect record);
}