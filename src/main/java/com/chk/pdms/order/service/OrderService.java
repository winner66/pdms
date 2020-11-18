package com.chk.pdms.order.service;

import com.chk.pdms.common.utils.SnowflakeIdWorker;
import com.chk.pdms.common.vo.Page;
import com.chk.pdms.common.vo.PageReq;
import com.chk.pdms.order.dao.OrderDao;
import com.chk.pdms.order.domain.OrderFlow;
import com.chk.pdms.order.domain.OrderItem;
import com.chk.pdms.order.domain.OrderTmp;
import com.chk.pdms.order.domain.Orders;
import com.chk.pdms.order.vo.OrderFlowExportVo;
import com.chk.pdms.order.vo.OrderFlowVo;
import com.chk.pdms.order.vo.OrderStatus;
import com.github.pagehelper.PageHelper;
import lombok.SneakyThrows;
import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderDao orderDao;

    public Page<Orders> listOrders(Date startDate, Date endDate, Integer status, PageReq pageReq) {
        PageHelper.startPage(pageReq.getPageNum(), pageReq.getPageSize());
        List<Orders> orders = orderDao.listOrders(startDate, endDate, status);
        return new Page(orders);
    }

    public Page<OrderItem> listOrderItem(Long orderId, PageReq pageReq) {
        PageHelper.startPage(pageReq.getPageNum(), pageReq.getPageSize());
        List<OrderItem> items = orderDao.listOrderItem(orderId);
        return new Page(items);
    }

    public Page<OrderTmp> listOrderTmp(Date startDate, Date endDate, PageReq pageReq) {
        PageHelper.startPage(pageReq.getPageNum(), pageReq.getPageSize());
        List<OrderTmp> orderTmps = orderDao.listOrderTmp(startDate, endDate);
        return new Page(orderTmps);
    }

    public Page<OrderFlow> listOrderFlow(Long orderId, PageReq pageReq) {
        PageHelper.startPage(pageReq.getPageNum(), pageReq.getPageSize());
        List<OrderFlow> flows = orderDao.listOrderFlow(orderId);
        if (pageReq.getPageNum() == 1) {
            Orders orders = orderDao.getOrdersMapper().selectByPrimaryKey(orderId);
            if (OrderStatus.handel.value().equals(orders.getStatus())) {
                OrderFlow flow = new OrderFlow();
                flow.setIdx(1);
                if (flows.size() > 0 && flows.get(0).getIdx() != null) {
                    flow.setIdx(flows.get(0).getIdx() + 1);
                }
                flow.setOpUser(orders.getOpUser());
                flows.add(0, flow);
            }
        }
        return new Page<>(flows);

    }

    public Page<Orders> listOpOrders(Long opUserId, PageReq pageReq) {
        PageHelper.startPage(pageReq.getPageNum(), pageReq.getPageSize());
        List<Orders> orders = orderDao.listOpOrders(opUserId);
        return new Page<>(orders);
    }

    @SneakyThrows
    @Transactional
    public void saveOrderFlow(OrderFlowVo vo) {
        OrderFlow orderFlow = new OrderFlow();
        PropertyUtils.copyProperties(orderFlow, vo);
        orderFlow.setId(SnowflakeIdWorker.nextID());
        orderFlow.setOpDatetime(new Date());
        orderFlow.setIdx(1);
        OrderFlow last = orderDao.getLastOrderFlow(vo.getOrderId());
        if (last != null && last.getIdx() != null) {
            orderFlow.setIdx(last.getIdx() + 1);
        }
        orderDao.getOrderFlowMapper().insert(orderFlow);
        //清单处理完成
        if (OrderStatus.finish.value().equals(vo.getStatus())) {
            Orders orders = orderDao.getOrdersMapper().selectByPrimaryKey(vo.getOrderId());
            orders.setOpUser(null);
            orders.setOpUserId(null);
            orders.setStatus(vo.getStatus());
            orders.setUpdateTime(new Date());
            orderDao.getOrdersMapper().updateByPrimaryKey(orders);
        } else {
            //指定下一个处理清单的人
            Orders orders = new Orders();
            orders.setId(vo.getOrderId());
            orders.setOpUserId(vo.getNextOpUserId());
            orders.setOpUser(vo.getNextOpUser());
            orders.setUpdateTime(new Date());
            orderDao.getOrdersMapper().updateByPrimaryKeySelective(orders);
        }
    }

    @SneakyThrows
    public List<OrderFlowExportVo> listExportOrderFlow(Date startDate, Date endDate, Integer status) {
        List<OrderFlowExportVo> vos = orderDao.getExtOrderMapper().listExportVo(startDate, endDate, status);
        List<OrderFlowExportVo> result = new ArrayList<>();
        //补充当前操作人到flow
        for (int i = 0; i < vos.size(); i++) {
            OrderFlowExportVo cv = vos.get(i);
            if (i > 0) {
                OrderFlowExportVo prev = vos.get(i - 1);
                if (!cv.getId().equals(prev.getId()) && OrderStatus.handel.title().equals(prev.getOrderStatus())) {
                    OrderFlowExportVo v = new OrderFlowExportVo();
                    v.setId(prev.getId());
                    v.setIdx(prev.getIdx() == null ? 1 : prev.getIdx() + 1);
                    v.setFlowOpUser(prev.getOrderOpUser());
                    result.add(v);
                }
            }
            result.add(cv);

            //补充最后一条记录
            if (i == vos.size() - 1 && OrderStatus.handel.title().equals(cv.getOrderStatus())){
                OrderFlowExportVo v = new OrderFlowExportVo();
                v.setId(cv.getId());
                v.setIdx(cv.getIdx() == null ? 1 : cv.getIdx() + 1);
                v.setFlowOpUser(cv.getOrderOpUser());
                result.add(v);
            }
        }

        //订单只留一行信息
        String id = null;
        for (OrderFlowExportVo vo : result) {
            if (vo.getId().equals(id)) {
                vo.emptyOrders();
            } else {
                id = vo.getId();
            }
        }
        return result;
    }
}
