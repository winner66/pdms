package com.chk.pdms.order.dao.mapper;

import com.chk.pdms.order.domain.OrderFlow;
import com.chk.pdms.order.domain.OrderFlowExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface OrderFlowMapper {
    long countByExample(OrderFlowExample example);

    int deleteByExample(OrderFlowExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OrderFlow record);

    int insertSelective(OrderFlow record);

    List<OrderFlow> selectByExampleWithRowbounds(OrderFlowExample example, RowBounds rowBounds);

    List<OrderFlow> selectByExample(OrderFlowExample example);

    OrderFlow selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OrderFlow record, @Param("example") OrderFlowExample example);

    int updateByExample(@Param("record") OrderFlow record, @Param("example") OrderFlowExample example);

    int updateByPrimaryKeySelective(OrderFlow record);

    int updateByPrimaryKey(OrderFlow record);
}