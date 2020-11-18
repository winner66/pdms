package com.chk.pdms.order.dao.extmapper;

import com.chk.pdms.order.vo.OrderFlowExportVo;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface ExtOrderMapper {
    public List<OrderFlowExportVo> listExportVo(@Param("startDate")Date startDate, @Param("endDate")Date endDate, @Param("status")Integer status);
}
