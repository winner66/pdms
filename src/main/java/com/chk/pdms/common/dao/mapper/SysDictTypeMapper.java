package com.chk.pdms.common.dao.mapper;

import com.chk.pdms.common.domain.DictDO;
import com.chk.pdms.common.domain.SysDictType;
import com.chk.pdms.common.domain.SysDictTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface SysDictTypeMapper {
    long countByExample(SysDictTypeExample example);

    int deleteByExample(SysDictTypeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SysDictType record);

    int insertSelective(SysDictType record);

    List<SysDictType> selectByExampleWithRowbounds(SysDictTypeExample example, RowBounds rowBounds);

    List<SysDictType> selectByExample(SysDictTypeExample example);

    SysDictType selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SysDictType record, @Param("example") SysDictTypeExample example);

    int updateByExample(@Param("record") SysDictType record, @Param("example") SysDictTypeExample example);

    int updateByPrimaryKeySelective(SysDictType record);

    int updateByPrimaryKey(SysDictType record);

    int batchRemove(Long[] ids);

    List<SysDictType> listType();
}