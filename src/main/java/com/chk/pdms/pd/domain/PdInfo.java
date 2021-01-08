package com.chk.pdms.pd.domain;

import com.chk.pdms.pd.vo.CasRsp;
import com.chk.pdms.pd.vo.SelRsp;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PdInfo implements Serializable {
    private Long id;

    private Long pdModelId;

    private String std;

    private String quality;

    private String model;

    private String size;

    private String temperature;

    private String voltage;

    private String capacityMin;

    private String capacityMax;

    private Integer capacityMinIdx;

    private Integer capacityMaxIdx;

    private String tolerance;

    private String outlet;

    private String elecCode;

    private String capNum;

    private String elecType;

    private String temperRange;

    private String wireMa;

    private String wireSize;

    private String elecSer;

    private String socStr;

    private String packType;

    private String pin;

    private String searchKey;

    private Boolean del;
    private String capacity ;



    private List<CasRsp> capacities = new ArrayList<>();

    private List<SelRsp> tolerances = new ArrayList<>();

    private List<SelRsp> outlets = new ArrayList<>();

    private List<SelRsp> wireMas = new ArrayList<>();

    private List<SelRsp> wireSizes = new ArrayList<>();
    private static final long serialVersionUID = 1L;
    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }
    public List<CasRsp> getCapacities() {
        return capacities;
    }

    public void setCapacities(List<CasRsp> capacities) {
        this.capacities = capacities;
    }

    public List<SelRsp> getTolerances() {
        return tolerances;
    }

    public void setTolerances(List<SelRsp> tolerances) {
        this.tolerances = tolerances;
    }

    public List<SelRsp> getOutlets() {
        return outlets;
    }

    public void setOutlets(List<SelRsp> outlets) {
        this.outlets = outlets;
    }

    public List<SelRsp> getWireMas() {
        return wireMas;
    }

    public void setWireMas(List<SelRsp> wireMas) {
        this.wireMas = wireMas;
    }

    public List<SelRsp> getWireSizes() {
        return wireSizes;
    }

    public void setWireSizes(List<SelRsp> wireSizes) {
        this.wireSizes = wireSizes;
    }

    public List<SelRsp> getPins() {
        return pins;
    }

    public void setPins(List<SelRsp> pins) {
        this.pins = pins;
    }

    private List<SelRsp> pins = new ArrayList<>();



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPdModelId() {
        return pdModelId;
    }

    public void setPdModelId(Long pdModelId) {
        this.pdModelId = pdModelId;
    }

    public String getStd() {
        return std;
    }

    public void setStd(String std) {
        this.std = std == null ? null : std.trim();
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality == null ? null : quality.trim();
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model == null ? null : model.trim();
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

    public String getCapacityMin() {
        return capacityMin;
    }

    public void setCapacityMin(String capacityMin) {
        this.capacityMin = capacityMin == null ? null : capacityMin.trim();
    }

    public String getCapacityMax() {
        return capacityMax;
    }

    public void setCapacityMax(String capacityMax) {
        this.capacityMax = capacityMax == null ? null : capacityMax.trim();
    }

    public Integer getCapacityMinIdx() {
        return capacityMinIdx;
    }

    public void setCapacityMinIdx(Integer capacityMinIdx) {
        this.capacityMinIdx = capacityMinIdx;
    }

    public Integer getCapacityMaxIdx() {
        return capacityMaxIdx;
    }

    public void setCapacityMaxIdx(Integer capacityMaxIdx) {
        this.capacityMaxIdx = capacityMaxIdx;
    }

    public String getTolerance() {
        return tolerance;
    }

    public void setTolerance(String tolerance) {
        this.tolerance = tolerance == null ? null : tolerance.trim();
    }

    public String getOutlet() {
        return outlet;
    }

    public void setOutlet(String outlet) {
        this.outlet = outlet == null ? null : outlet.trim();
    }

    public String getElecCode() {
        return elecCode;
    }

    public void setElecCode(String elecCode) {
        this.elecCode = elecCode == null ? null : elecCode.trim();
    }

    public String getCapNum() {
        return capNum;
    }

    public void setCapNum(String capNum) {
        this.capNum = capNum == null ? null : capNum.trim();
    }

    public String getElecType() {
        return elecType;
    }

    public void setElecType(String elecType) {
        this.elecType = elecType == null ? null : elecType.trim();
    }

    public String getTemperRange() {
        return temperRange;
    }

    public void setTemperRange(String temperRange) {
        this.temperRange = temperRange == null ? null : temperRange.trim();
    }

    public String getWireMa() {
        return wireMa;
    }

    public void setWireMa(String wireMa) {
        this.wireMa = wireMa == null ? null : wireMa.trim();
    }

    public String getWireSize() {
        return wireSize;
    }

    public void setWireSize(String wireSize) {
        this.wireSize = wireSize == null ? null : wireSize.trim();
    }

    public String getElecSer() {
        return elecSer;
    }

    public void setElecSer(String elecSer) {
        this.elecSer = elecSer == null ? null : elecSer.trim();
    }

    public String getSocStr() {
        return socStr;
    }

    public void setSocStr(String socStr) {
        this.socStr = socStr == null ? null : socStr.trim();
    }

    public String getPackType() {
        return packType;
    }

    public void setPackType(String packType) {
        this.packType = packType == null ? null : packType.trim();
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin == null ? null : pin.trim();
    }

    public String getSearchKey() {
        return searchKey;
    }

    public void setSearchKey(String searchKey) {
        this.searchKey = searchKey == null ? null : searchKey.trim();
    }

    public Boolean getDel() {
        return del;
    }

    public void setDel(Boolean del) {
        this.del = del;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", pdModelId=").append(pdModelId);
        sb.append(", std=").append(std);
        sb.append(", quality=").append(quality);
        sb.append(", model=").append(model);
        sb.append(", size=").append(size);
        sb.append(", temperature=").append(temperature);
        sb.append(", voltage=").append(voltage);
        sb.append(", capacityMin=").append(capacityMin);
        sb.append(", capacityMax=").append(capacityMax);
        sb.append(", capacityMinIdx=").append(capacityMinIdx);
        sb.append(", capacityMaxIdx=").append(capacityMaxIdx);
        sb.append(", tolerance=").append(tolerance);
        sb.append(", outlet=").append(outlet);
        sb.append(", elecCode=").append(elecCode);
        sb.append(", capNum=").append(capNum);
        sb.append(", elecType=").append(elecType);
        sb.append(", temperRange=").append(temperRange);
        sb.append(", wireMa=").append(wireMa);
        sb.append(", wireSize=").append(wireSize);
        sb.append(", elecSer=").append(elecSer);
        sb.append(", socStr=").append(socStr);
        sb.append(", packType=").append(packType);
        sb.append(", pin=").append(pin);
        sb.append(", searchKey=").append(searchKey);
        sb.append(", del=").append(del);
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
        PdInfo other = (PdInfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPdModelId() == null ? other.getPdModelId() == null : this.getPdModelId().equals(other.getPdModelId()))
            && (this.getStd() == null ? other.getStd() == null : this.getStd().equals(other.getStd()))
            && (this.getQuality() == null ? other.getQuality() == null : this.getQuality().equals(other.getQuality()))
            && (this.getModel() == null ? other.getModel() == null : this.getModel().equals(other.getModel()))
            && (this.getSize() == null ? other.getSize() == null : this.getSize().equals(other.getSize()))
            && (this.getTemperature() == null ? other.getTemperature() == null : this.getTemperature().equals(other.getTemperature()))
            && (this.getVoltage() == null ? other.getVoltage() == null : this.getVoltage().equals(other.getVoltage()))
            && (this.getCapacityMin() == null ? other.getCapacityMin() == null : this.getCapacityMin().equals(other.getCapacityMin()))
            && (this.getCapacityMax() == null ? other.getCapacityMax() == null : this.getCapacityMax().equals(other.getCapacityMax()))
            && (this.getCapacityMinIdx() == null ? other.getCapacityMinIdx() == null : this.getCapacityMinIdx().equals(other.getCapacityMinIdx()))
            && (this.getCapacityMaxIdx() == null ? other.getCapacityMaxIdx() == null : this.getCapacityMaxIdx().equals(other.getCapacityMaxIdx()))
            && (this.getTolerance() == null ? other.getTolerance() == null : this.getTolerance().equals(other.getTolerance()))
            && (this.getOutlet() == null ? other.getOutlet() == null : this.getOutlet().equals(other.getOutlet()))
            && (this.getElecCode() == null ? other.getElecCode() == null : this.getElecCode().equals(other.getElecCode()))
            && (this.getCapNum() == null ? other.getCapNum() == null : this.getCapNum().equals(other.getCapNum()))
            && (this.getElecType() == null ? other.getElecType() == null : this.getElecType().equals(other.getElecType()))
            && (this.getTemperRange() == null ? other.getTemperRange() == null : this.getTemperRange().equals(other.getTemperRange()))
            && (this.getWireMa() == null ? other.getWireMa() == null : this.getWireMa().equals(other.getWireMa()))
            && (this.getWireSize() == null ? other.getWireSize() == null : this.getWireSize().equals(other.getWireSize()))
            && (this.getElecSer() == null ? other.getElecSer() == null : this.getElecSer().equals(other.getElecSer()))
            && (this.getSocStr() == null ? other.getSocStr() == null : this.getSocStr().equals(other.getSocStr()))
            && (this.getPackType() == null ? other.getPackType() == null : this.getPackType().equals(other.getPackType()))
            && (this.getPin() == null ? other.getPin() == null : this.getPin().equals(other.getPin()))
            && (this.getSearchKey() == null ? other.getSearchKey() == null : this.getSearchKey().equals(other.getSearchKey()))
            && (this.getDel() == null ? other.getDel() == null : this.getDel().equals(other.getDel()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPdModelId() == null) ? 0 : getPdModelId().hashCode());
        result = prime * result + ((getStd() == null) ? 0 : getStd().hashCode());
        result = prime * result + ((getQuality() == null) ? 0 : getQuality().hashCode());
        result = prime * result + ((getModel() == null) ? 0 : getModel().hashCode());
        result = prime * result + ((getSize() == null) ? 0 : getSize().hashCode());
        result = prime * result + ((getTemperature() == null) ? 0 : getTemperature().hashCode());
        result = prime * result + ((getVoltage() == null) ? 0 : getVoltage().hashCode());
        result = prime * result + ((getCapacityMin() == null) ? 0 : getCapacityMin().hashCode());
        result = prime * result + ((getCapacityMax() == null) ? 0 : getCapacityMax().hashCode());
        result = prime * result + ((getCapacityMinIdx() == null) ? 0 : getCapacityMinIdx().hashCode());
        result = prime * result + ((getCapacityMaxIdx() == null) ? 0 : getCapacityMaxIdx().hashCode());
        result = prime * result + ((getTolerance() == null) ? 0 : getTolerance().hashCode());
        result = prime * result + ((getOutlet() == null) ? 0 : getOutlet().hashCode());
        result = prime * result + ((getElecCode() == null) ? 0 : getElecCode().hashCode());
        result = prime * result + ((getCapNum() == null) ? 0 : getCapNum().hashCode());
        result = prime * result + ((getElecType() == null) ? 0 : getElecType().hashCode());
        result = prime * result + ((getTemperRange() == null) ? 0 : getTemperRange().hashCode());
        result = prime * result + ((getWireMa() == null) ? 0 : getWireMa().hashCode());
        result = prime * result + ((getWireSize() == null) ? 0 : getWireSize().hashCode());
        result = prime * result + ((getElecSer() == null) ? 0 : getElecSer().hashCode());
        result = prime * result + ((getSocStr() == null) ? 0 : getSocStr().hashCode());
        result = prime * result + ((getPackType() == null) ? 0 : getPackType().hashCode());
        result = prime * result + ((getPin() == null) ? 0 : getPin().hashCode());
        result = prime * result + ((getSearchKey() == null) ? 0 : getSearchKey().hashCode());
        result = prime * result + ((getDel() == null) ? 0 : getDel().hashCode());
        return result;
    }
}