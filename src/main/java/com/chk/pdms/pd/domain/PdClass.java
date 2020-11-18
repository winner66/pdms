package com.chk.pdms.pd.domain;

import java.io.Serializable;

public class PdClass implements Serializable {
    private Long id;

    private Long pId;

    private String name;

    private String showName;

    private Integer idx;

    private String iconUrl;

    private Integer level;

    private String qaGp;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getpId() {
        return pId;
    }

    public void setpId(Long pId) {
        this.pId = pId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getShowName() {
        return showName;
    }

    public void setShowName(String showName) {
        this.showName = showName == null ? null : showName.trim();
    }

    public Integer getIdx() {
        return idx;
    }

    public void setIdx(Integer idx) {
        this.idx = idx;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl == null ? null : iconUrl.trim();
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getQaGp() {
        return qaGp;
    }

    public void setQaGp(String qaGp) {
        this.qaGp = qaGp == null ? null : qaGp.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", pId=").append(pId);
        sb.append(", name=").append(name);
        sb.append(", showName=").append(showName);
        sb.append(", idx=").append(idx);
        sb.append(", iconUrl=").append(iconUrl);
        sb.append(", level=").append(level);
        sb.append(", qaGp=").append(qaGp);
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
        PdClass other = (PdClass) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getpId() == null ? other.getpId() == null : this.getpId().equals(other.getpId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getShowName() == null ? other.getShowName() == null : this.getShowName().equals(other.getShowName()))
            && (this.getIdx() == null ? other.getIdx() == null : this.getIdx().equals(other.getIdx()))
            && (this.getIconUrl() == null ? other.getIconUrl() == null : this.getIconUrl().equals(other.getIconUrl()))
            && (this.getLevel() == null ? other.getLevel() == null : this.getLevel().equals(other.getLevel()))
            && (this.getQaGp() == null ? other.getQaGp() == null : this.getQaGp().equals(other.getQaGp()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getpId() == null) ? 0 : getpId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getShowName() == null) ? 0 : getShowName().hashCode());
        result = prime * result + ((getIdx() == null) ? 0 : getIdx().hashCode());
        result = prime * result + ((getIconUrl() == null) ? 0 : getIconUrl().hashCode());
        result = prime * result + ((getLevel() == null) ? 0 : getLevel().hashCode());
        result = prime * result + ((getQaGp() == null) ? 0 : getQaGp().hashCode());
        return result;
    }
}