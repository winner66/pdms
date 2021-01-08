package com.chk.pdms.fpd.domain;

import com.chk.pdms.pd.vo.ImportDataVo;

import java.io.Serializable;

public class FpdSeries implements Serializable {
    private Integer id;

    private String fFactorys;

    private String fSeries;

    private String hkSeries;

    private String size;

    private String temperature;

    private String voltage;

    private String outlet;

    private String tolerance;

    private String socStr;

    private String elecCode;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getfFactorys() {
        return fFactorys;
    }

    public void setfFactorys(String fFactorys) {
        this.fFactorys = fFactorys == null ? null : fFactorys.trim();
    }

    public String getfSeries() {
        return fSeries;
    }

    public void setfSeries(String fSeries) {
        this.fSeries = fSeries == null ? null : fSeries.trim();
    }

    public String getHkSeries() {
        return hkSeries;
    }

    public void setHkSeries(String hkSeries) {
        this.hkSeries = hkSeries == null ? null : hkSeries.trim();
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size == null ? null : size.trim();
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature == null ? null : temperature.trim();
    }

    public String getVoltage() {
        return voltage;
    }

    public void setVoltage(String voltage) {
        this.voltage = voltage == null ? null : voltage.trim();
    }

    public String getOutlet() {
        return outlet;
    }

    public void setOutlet(String outlet) {
        this.outlet = outlet == null ? null : outlet.trim();
    }

    public String getTolerance() {
        return tolerance;
    }

    public void setTolerance(String tolerance) {
        this.tolerance = tolerance == null ? null : tolerance.trim();
    }

    public String getSocStr() {
        return socStr;
    }

    public void setSocStr(String socStr) {
        this.socStr = socStr == null ? null : socStr.trim();
    }

    public String getElecCode() {
        return elecCode;
    }

    public void setElecCode(String elecCode) {
        this.elecCode = elecCode == null ? null : elecCode.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", fFactorys=").append(fFactorys);
        sb.append(", fSeries=").append(fSeries);
        sb.append(", hkSeries=").append(hkSeries);
        sb.append(", size=").append(size);
        sb.append(", temperature=").append(temperature);
        sb.append(", voltage=").append(voltage);
        sb.append(", outlet=").append(outlet);
        sb.append(", tolerance=").append(tolerance);
        sb.append(", socStr=").append(socStr);
        sb.append(", elecCode=").append(elecCode);
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
        FpdSeries other = (FpdSeries) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getfFactorys() == null ? other.getfFactorys() == null : this.getfFactorys().equals(other.getfFactorys()))
            && (this.getfSeries() == null ? other.getfSeries() == null : this.getfSeries().equals(other.getfSeries()))
            && (this.getHkSeries() == null ? other.getHkSeries() == null : this.getHkSeries().equals(other.getHkSeries()))
            && (this.getSize() == null ? other.getSize() == null : this.getSize().equals(other.getSize()))
            && (this.getTemperature() == null ? other.getTemperature() == null : this.getTemperature().equals(other.getTemperature()))
            && (this.getVoltage() == null ? other.getVoltage() == null : this.getVoltage().equals(other.getVoltage()))
            && (this.getOutlet() == null ? other.getOutlet() == null : this.getOutlet().equals(other.getOutlet()))
            && (this.getTolerance() == null ? other.getTolerance() == null : this.getTolerance().equals(other.getTolerance()))
            && (this.getSocStr() == null ? other.getSocStr() == null : this.getSocStr().equals(other.getSocStr()))
            && (this.getElecCode() == null ? other.getElecCode() == null : this.getElecCode().equals(other.getElecCode()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getfFactorys() == null) ? 0 : getfFactorys().hashCode());
        result = prime * result + ((getfSeries() == null) ? 0 : getfSeries().hashCode());
        result = prime * result + ((getHkSeries() == null) ? 0 : getHkSeries().hashCode());
        result = prime * result + ((getSize() == null) ? 0 : getSize().hashCode());
        result = prime * result + ((getTemperature() == null) ? 0 : getTemperature().hashCode());
        result = prime * result + ((getVoltage() == null) ? 0 : getVoltage().hashCode());
        result = prime * result + ((getOutlet() == null) ? 0 : getOutlet().hashCode());
        result = prime * result + ((getTolerance() == null) ? 0 : getTolerance().hashCode());
        result = prime * result + ((getSocStr() == null) ? 0 : getSocStr().hashCode());
        result = prime * result + ((getElecCode() == null) ? 0 : getElecCode().hashCode());
        return result;
    }


}