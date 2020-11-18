package com.chk.pdms.order.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.alibaba.excel.write.builder.ExcelWriterBuilder;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.chk.pdms.common.utils.R;
import com.chk.pdms.common.utils.ShiroUtils;
import com.chk.pdms.common.vo.Page;
import com.chk.pdms.common.vo.PageReq;
import com.chk.pdms.order.domain.OrderFlow;
import com.chk.pdms.order.domain.OrderItem;
import com.chk.pdms.order.domain.OrderTmp;
import com.chk.pdms.order.domain.Orders;
import com.chk.pdms.order.service.OrderService;
import com.chk.pdms.order.vo.OrderFlowExportVo;
import com.chk.pdms.order.vo.OrderFlowVo;
import com.chk.pdms.system.domain.UserDO;
import com.chk.pdms.system.service.UserService;
import com.github.pagehelper.PageHelper;
import lombok.SneakyThrows;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {
    private String prefix = "order";

    private Logger log = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

    @Value("${virtual.filePath}")
    private String filePath;

    @GetMapping("/order")
    @RequiresPermissions("order:order:order")
    public String order() {
        return prefix + "/list";
    }

    @GetMapping("/order-item")
    @RequiresPermissions("order:order:order")
    public String orderItem(Model model, Long orderId) {
        model.addAttribute("orderId", orderId);
        return prefix + "/list-item";
    }

    @GetMapping("/order-tmp")
    @RequiresPermissions("order:order:order")
    public String orderTmp() {
        return prefix + "/list-tmp";
    }

    @ResponseBody
    @GetMapping("/list")
    @RequiresPermissions("order:order:order")
    public Page<Orders> listOrders(Date startDate, Date endDate, Integer status, PageReq pageReq) {
        Page<Orders> orders = orderService.listOrders(startDate, endDate, status, pageReq);
        return orders;
    }

    @ResponseBody
    @GetMapping("/list-item")
    @RequiresPermissions("order:order:order")
    public Page<OrderItem> listOrderItem(Long orderId, PageReq pageReq) {
        Page<OrderItem> items = orderService.listOrderItem(orderId, pageReq);
        return items;
    }

    @ResponseBody
    @GetMapping("/list-tmp")
    @RequiresPermissions("order:order:order")
    public Page<OrderTmp> listOrderTmp(Date startDate, Date endDate, PageReq pageReq) {
        Page<OrderTmp> tmps = orderService.listOrderTmp(startDate, endDate, pageReq);
        return tmps;
    }

    @GetMapping("/op-order")
    @RequiresPermissions("order:order:order")
    public String opOrder(Model model) {
        return prefix + "/list-op-order";
    }

    @GetMapping("/op-my-order")
    @RequiresPermissions("order:order:order")
    public String opMyOrder(Model model) {
        Long opUserId = ShiroUtils.getUserId();
        model.addAttribute("opUserId", opUserId);
        return prefix + "/list-op-order";
    }

    @ResponseBody
    @GetMapping("/list-op-order")
    @RequiresPermissions("order:order:order")
    public Page<Orders> listOpOrder(Long opUserId, PageReq pageReq) {
        Page<Orders> orders = orderService.listOpOrders(opUserId, pageReq);
        return orders;
    }

    @GetMapping("/view-order-flow")
    @RequiresPermissions("order:order:order")
    public String viewOrderFlow(Model model, Long orderId) {
        model.addAttribute("orderId", orderId);
        return prefix + "/list-flow";
    }

    @GetMapping("/order-flow")
    @RequiresPermissions("order:order:order")
    public String orderFlow(Model model, Long orderId) {
        OrderFlow flow = new OrderFlow();
        UserDO user = ShiroUtils.getUser();
        flow.setOrderId(orderId);
        flow.setOpUserId(user.getUserId());
        flow.setOpUser(user.getName());
        model.addAttribute("flow", flow);
        model.addAttribute("orderId", orderId);

        List<UserDO> users = userService.list(new HashMap<>());
        model.addAttribute("users", users);
        return prefix + "/edit-flow";
    }

    @ResponseBody
    @GetMapping("/list-order-flow")
    @RequiresPermissions("order:order:order")
    public Page<OrderFlow> listOrderFlow(Long orderId, PageReq pageReq) {
        Page<OrderFlow> vos = orderService.listOrderFlow(orderId, pageReq);
        return vos;
    }

    @ResponseBody
    @PostMapping("/save-order-flow")
    @RequiresPermissions("order:order:order")
    public R saveOrderFlow(OrderFlowVo vo) {
        orderService.saveOrderFlow(vo);
        return R.ok();
    }

//    public static void main(String[] args) {
//        DateTime start = new DateTime(new Date()).withTime(0,0,0,0);
//        DateTime end = new DateTime(new Date()).plusDays(100).withTime(23,59,59,999);
//
//        if (start.plusDays(31).isBefore(end)){
//            end = start.plusDays(30).withTime(23,59,59,999);
//            System.out.println(end);
//        }
//    }

    @SneakyThrows
    @GetMapping("/export-order-flow")
    @RequiresPermissions("order:order:order")
    public void exportOrderFlow(HttpServletResponse response, Date startDate, Date endDate, Integer status) {
        DateTime start = new DateTime(startDate).withTime(0,0,0,0);
        DateTime end = new DateTime(endDate).withTime(23,59,59,999);

        if (start.plusDays(31).isBefore(end)){
            end = start.plusDays(30).withTime(23,59,59,999);
        }

        response.setHeader("Content-disposition", "attachment; filename=" + URLEncoder.encode("产品清单.xlsx","UTF8"));
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);

        List<OrderFlowExportVo> vos = orderService.listExportOrderFlow(start.toDate(), end.toDate(), status);
        ExcelWriterBuilder builder = EasyExcel.write(response.getOutputStream(), OrderFlowExportVo.class);
        File file = new File(filePath + "template/产品清单.xlsx").getAbsoluteFile();
        ExcelWriter excelWriter = builder.withTemplate(file).needHead(false).excelType(ExcelTypeEnum.XLSX).autoCloseStream(true).build();
        WriteSheet writeSheet = EasyExcel.writerSheet("清单").build();
        try {
            excelWriter.write(vos, writeSheet);
        } catch (Exception e) {
            log.error("导出产品清单出错", e);
        } finally {
            excelWriter.finish();
        }
    }
}