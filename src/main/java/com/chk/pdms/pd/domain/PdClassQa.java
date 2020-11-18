package com.chk.pdms.pd.domain;

import java.io.Serializable;

public class PdClassQa implements Serializable {
    private Long id;

    private Long pdClassId;

    private String qaCode;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPdClassId() {
        return pdClassId;
    }

    public void setPdClassId(Long pdClassId) {
        this.pdClassId = pdClassId;
    }

    public String getQaCode() {
        return qaCode;
    }

    public void setQaCode(String qaCode) {
        this.qaCode = qaCode == null ? null : qaCode.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", pdClassId=").append(pdClassId);
        sb.append(", qaCode=").append(qaCode);
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
        PdClassQa other = (PdClassQa) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPdClassId() == null ? other.getPdClassId() == null : this.getPdClassId().equals(other.getPdClassId()))
            && (this.getQaCode() == null ? other.getQaCode() == null : this.getQaCode().equals(other.getQaCode()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPdClassId() == null) ? 0 : getPdClassId().hashCode());
        result = prime * result + ((getQaCode() == null) ? 0 : getQaCode().hashCode());
        return result;
    }
}