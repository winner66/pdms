package com.chk.pdms.order.vo;

import com.chk.pdms.order.domain.OrderFlow;
import lombok.Data;

@Data
public class OrderFlowVo extends OrderFlow {
    private Long nextOpUserId;

    private String nextOpUser;

    private Integer status;
}
