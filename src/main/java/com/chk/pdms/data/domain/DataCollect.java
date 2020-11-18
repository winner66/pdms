package com.chk.pdms.data.domain;

import java.io.Serializable;
import java.util.Date;

public class DataCollect implements Serializable {
    private Long id;

    private String page;

    private String event;

    private String data;

    private Long uid;

    private Date date;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page == null ? null : page.trim();
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event == null ? null : event.trim();
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data == null ? null : data.trim();
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", page=").append(page);
        sb.append(", event=").append(event);
        sb.append(", data=").append(data);
        sb.append(", uid=").append(uid);
        sb.append(", date=").append(date);
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
        DataCollect other = (DataCollect) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPage() == null ? other.getPage() == null : this.getPage().equals(other.getPage()))
            && (this.getEvent() == null ? other.getEvent() == null : this.getEvent().equals(other.getEvent()))
            && (this.getData() == null ? other.getData() == null : this.getData().equals(other.getData()))
            && (this.getUid() == null ? other.getUid() == null : this.getUid().equals(other.getUid()))
            && (this.getDate() == null ? other.getDate() == null : this.getDate().equals(other.getDate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPage() == null) ? 0 : getPage().hashCode());
        result = prime * result + ((getEvent() == null) ? 0 : getEvent().hashCode());
        result = prime * result + ((getData() == null) ? 0 : getData().hashCode());
        result = prime * result + ((getUid() == null) ? 0 : getUid().hashCode());
        result = prime * result + ((getDate() == null) ? 0 : getDate().hashCode());
        return result;
    }
}