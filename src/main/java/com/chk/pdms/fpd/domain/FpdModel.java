package com.chk.pdms.fpd.domain;

import java.io.Serializable;

public class FpdModel implements Serializable {
    private Long id;

    private String name;

    private String code;

    private String orderRule;

    private Integer idx;

    private String orderRulePos;

    private String orderRuleBit;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getOrderRule() {
        return orderRule;
    }

    public void setOrderRule(String orderRule) {
        this.orderRule = orderRule == null ? null : orderRule.trim();
    }

    public Integer getIdx() {
        return idx;
    }

    public void setIdx(Integer idx) {
        this.idx = idx;
    }

    public String getOrderRulePos() {
        return orderRulePos;
    }

    public void setOrderRulePos(String orderRulePos) {
        this.orderRulePos = orderRulePos == null ? null : orderRulePos.trim();
    }

    public String getOrderRuleBit() {
        return orderRuleBit;
    }

    public void setOrderRuleBit(String orderRuleBit) {
        this.orderRuleBit = orderRuleBit == null ? null : orderRuleBit.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", code=").append(code);
        sb.append(", orderRule=").append(orderRule);
        sb.append(", idx=").append(idx);
        sb.append(", orderRulePos=").append(orderRulePos);
        sb.append(", orderRuleBit=").append(orderRuleBit);
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
        FpdModel other = (FpdModel) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getCode() == null ? other.getCode() == null : this.getCode().equals(other.getCode()))
            && (this.getOrderRule() == null ? other.getOrderRule() == null : this.getOrderRule().equals(other.getOrderRule()))
            && (this.getIdx() == null ? other.getIdx() == null : this.getIdx().equals(other.getIdx()))
            && (this.getOrderRulePos() == null ? other.getOrderRulePos() == null : this.getOrderRulePos().equals(other.getOrderRulePos()))
            && (this.getOrderRuleBit() == null ? other.getOrderRuleBit() == null : this.getOrderRuleBit().equals(other.getOrderRuleBit()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getCode() == null) ? 0 : getCode().hashCode());
        result = prime * result + ((getOrderRule() == null) ? 0 : getOrderRule().hashCode());
        result = prime * result + ((getIdx() == null) ? 0 : getIdx().hashCode());
        result = prime * result + ((getOrderRulePos() == null) ? 0 : getOrderRulePos().hashCode());
        result = prime * result + ((getOrderRuleBit() == null) ? 0 : getOrderRuleBit().hashCode());
        return result;
    }
}