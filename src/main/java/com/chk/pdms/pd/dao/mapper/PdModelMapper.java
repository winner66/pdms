package com.chk.pdms.pd.dao.mapper;

import com.chk.pdms.pd.domain.PdModel;
import com.chk.pdms.pd.domain.PdModelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface PdModelMapper {
    long countByExample(PdModelExample example);

    int deleteByExample(PdModelExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PdModel record);

    int insertSelective(PdModel record);

    List<PdModel> selectByExampleWithRowbounds(PdModelExample example, RowBounds rowBounds);

    List<PdModel> selectByExample(PdModelExample example);

    PdModel selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PdModel record, @Param("example") PdModelExample example);

    int updateByExample(@Param("record") PdModel record, @Param("example") PdModelExample example);

    int updateByPrimaryKeySelective(PdModel record);

    int updateByPrimaryKey(PdModel record);
}