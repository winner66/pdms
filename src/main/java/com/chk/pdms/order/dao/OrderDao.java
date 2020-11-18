package com.chk.pdms.order.dao;

import com.chk.pdms.order.dao.extmapper.ExtOrderMapper;
import com.chk.pdms.order.dao.mapper.OrderFlowMapper;
import com.chk.pdms.order.dao.mapper.OrderItemMapper;
import com.chk.pdms.order.dao.mapper.OrderTmpMapper;
import com.chk.pdms.order.dao.mapper.OrdersMapper;
import com.chk.pdms.order.domain.*;
import com.chk.pdms.order.vo.OrderStatus;
import com.chk.pdms.system.dao.mapper.UserMapper;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class OrderDao {

    @Autowired
    private OrdersMapper ordersMapper;

    @Autowired
    private OrderItemMapper orderItemMapper;

    @Autowired
    private OrderTmpMapper orderTmpMapper;

    @Autowired
    private OrderFlowMapper orderFlowMapper;

    @Autowired
    private ExtOrderMapper extOrderMapper;

    public OrdersMapper getOrdersMapper() {
        return ordersMapper;
    }

    public OrderItemMapper getOrderItemMapper() {
        return orderItemMapper;
    }

    public OrderTmpMapper getOrderTmpMapper() {
        return orderTmpMapper;
    }

    public OrderFlowMapper getOrderFlowMapper() {
        return orderFlowMapper;
    }

    public ExtOrderMapper getExtOrderMapper() {
        return extOrderMapper;
    }

    public List<Orders> listOrders(Date startDate, Date endDate, Integer status){
        OrdersExample exp = new OrdersExample();
        OrdersExample.Criteria cri = exp.createCriteria();
        if (startDate != null){
            startDate = new DateTime(startDate).withTime(0,0,0,0).toDate();
            cri.andCreateTimeGreaterThanOrEqualTo(startDate);
        }
        if (endDate != null){
            endDate = new DateTime(endDate).withTime(23,59,59,999).toDate();
            cri.andCreateTimeLessThanOrEqualTo(endDate);
        }
        if (status != null){
            cri.andStatusEqualTo(status);
        }
        exp.setOrderByClause("id desc");
        return ordersMapper.selectByExample(exp);
    }

    public List<OrderItem> listOrderItem(Long orderId){
        OrderItemExample exp = new OrderItemExample();
        exp.createCriteria().andOrderIdEqualTo(orderId);
        exp.setOrderByClause("id asc");
        return orderItemMapper.selectByExample(exp);
    }

    public List<OrderTmp> listOrderTmp(Date startDate, Date endDate){
        OrderTmpExample exp = new OrderTmpExample();
        OrderTmpExample.Criteria cri = exp.createCriteria();
        if (startDate != null){
            startDate = new DateTime(startDate).withTime(0,0,0,0).toDate();
            cri.andCreateTimeGreaterThanOrEqualTo(startDate);
        }
        if (endDate != null){
            endDate = new DateTime(endDate).withTime(23,59,59,999).toDate();
            cri.andCreateTimeLessThanOrEqualTo(endDate);
        }
        exp.setOrderByClause("id desc");
        return orderTmpMapper.selectByExample(exp);
    }

    public OrderFlow getLastOrderFlow(Long orderId){
        OrderFlowExample exp = new OrderFlowExample();
        OrderFlowExample.Criteria cri = exp.createCriteria();
        cri.andOrderIdEqualTo(orderId);
        exp.setOrderByClause("id desc limit 1");
        List<OrderFlow> orderFlows = orderFlowMapper.selectByExample(exp);
        return orderFlows.size() > 0 ? orderFlows.get(0) : null;
    }

    public List<OrderFlow> listOrderFlow(Long orderId){
        OrderFlowExample exp = new OrderFlowExample();
        OrderFlowExample.Criteria cri = exp.createCriteria();
        cri.andOrderIdEqualTo(orderId);
        exp.setOrderByClause("id desc");
        List<OrderFlow> orderFlows = orderFlowMapper.selectByExample(exp);
        return orderFlows;
    }

    public List<Orders> listOpOrders(Long opUserId){
        OrdersExample exp = new OrdersExample();
        OrdersExample.Criteria cri = exp.createCriteria();
        if (opUserId != null) {
            cri.andOpUserIdEqualTo(opUserId);
        }
        cri.andStatusEqualTo(OrderStatus.handel.value());
        exp.setOrderByClause("id desc");
        List<Orders> orders = ordersMapper.selectByExample(exp);
        return orders;
    }
}
