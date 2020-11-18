package com.chk.pdms.fpd.domain;

import java.io.Serializable;

public class FpdMap implements Serializable {
    private Long id;

    private Long fpdModelId;

    private String paramType;

    private String fcode;

    private String code;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFpdModelId() {
        return fpdModelId;
    }

    public void setFpdModelId(Long fpdModelId) {
        this.fpdModelId = fpdModelId;
    }

    public String getParamType() {
        return paramType;
    }

    public void setParamType(String paramType) {
        this.paramType = paramType == null ? null : paramType.trim();
    }

    public String getFcode() {
        return fcode;
    }

    public void setFcode(String fcode) {
        this.fcode = fcode == null ? null : fcode.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", fpdModelId=").append(fpdModelId);
        sb.append(", paramType=").append(paramType);
        sb.append(", fcode=").append(fcode);
        sb.append(", code=").append(code);
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
        FpdMap other = (FpdMap) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getFpdModelId() == null ? other.getFpdModelId() == null : this.getFpdModelId().equals(other.getFpdModelId()))
            && (this.getParamType() == null ? other.getParamType() == null : this.getParamType().equals(other.getParamType()))
            && (this.getFcode() == null ? other.getFcode() == null : this.getFcode().equals(other.getFcode()))
            && (this.getCode() == null ? other.getCode() == null : this.getCode().equals(other.getCode()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getFpdModelId() == null) ? 0 : getFpdModelId().hashCode());
        result = prime * result + ((getParamType() == null) ? 0 : getParamType().hashCode());
        result = prime * result + ((getFcode() == null) ? 0 : getFcode().hashCode());
        result = prime * result + ((getCode() == null) ? 0 : getCode().hashCode());
        return result;
    }
}