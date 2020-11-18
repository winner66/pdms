package com.chk.pdms.order.dao.mapper;

import com.chk.pdms.order.domain.OrderTmp;
import com.chk.pdms.order.domain.OrderTmpExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface OrderTmpMapper {
    long countByExample(OrderTmpExample example);

    int deleteByExample(OrderTmpExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OrderTmp record);

    int insertSelective(OrderTmp record);

    List<OrderTmp> selectByExampleWithRowbounds(OrderTmpExample example, RowBounds rowBounds);

    List<OrderTmp> selectByExample(OrderTmpExample example);

    OrderTmp selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OrderTmp record, @Param("example") OrderTmpExample example);

    int updateByExample(@Param("record") OrderTmp record, @Param("example") OrderTmpExample example);

    int updateByPrimaryKeySelective(OrderTmp record);

    int updateByPrimaryKey(OrderTmp record);
}