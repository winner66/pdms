package com.chk.pdms.order.domain;

import java.io.Serializable;
import java.util.Date;

public class OrderFlow implements Serializable {
    private Long id;

    private Long orderId;

    private Long opUserId;

    private String opUser;

    private String opDesc;

    private Date opDatetime;

    private Integer idx;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getOpUserId() {
        return opUserId;
    }

    public void setOpUserId(Long opUserId) {
        this.opUserId = opUserId;
    }

    public String getOpUser() {
        return opUser;
    }

    public void setOpUser(String opUser) {
        this.opUser = opUser == null ? null : opUser.trim();
    }

    public String getOpDesc() {
        return opDesc;
    }

    public void setOpDesc(String opDesc) {
        this.opDesc = opDesc == null ? null : opDesc.trim();
    }

    public Date getOpDatetime() {
        return opDatetime;
    }

    public void setOpDatetime(Date opDatetime) {
        this.opDatetime = opDatetime;
    }

    public Integer getIdx() {
        return idx;
    }

    public void setIdx(Integer idx) {
        this.idx = idx;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", orderId=").append(orderId);
        sb.append(", opUserId=").append(opUserId);
        sb.append(", opUser=").append(opUser);
        sb.append(", opDesc=").append(opDesc);
        sb.append(", opDatetime=").append(opDatetime);
        sb.append(", idx=").append(idx);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        OrderFlow other = (OrderFlow) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getOrderId() == null ? other.getOrderId() == null : this.getOrderId().equals(other.getOrderId()))
            && (this.getOpUserId() == null ? other.getOpUserId() == null : this.getOpUserId().equals(other.getOpUserId()))
            && (this.getOpUser() == null ? other.getOpUser() == null : this.getOpUser().equals(other.getOpUser()))
            && (this.getOpDesc() == null ? other.getOpDesc() == null : this.getOpDesc().equals(other.getOpDesc()))
            && (this.getOpDatetime() == null ? other.getOpDatetime() == null : this.getOpDatetime().equals(other.getOpDatetime()))
            && (this.getIdx() == null ? other.getIdx() == null : this.getIdx().equals(other.getIdx()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getOrderId() == null) ? 0 : getOrderId().hashCode());
        result = prime * result + ((getOpUserId() == null) ? 0 : getOpUserId().hashCode());
        result = prime * result + ((getOpUser() == null) ? 0 : getOpUser().hashCode());
        result = prime * result + ((getOpDesc() == null) ? 0 : getOpDesc().hashCode());
        result = prime * result + ((getOpDatetime() == null) ? 0 : getOpDatetime().hashCode());
        result = prime * result + ((getIdx() == null) ? 0 : getIdx().hashCode());
        return result;
    }
}