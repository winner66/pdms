package com.chk.pdms.pd.domain;

import java.io.Serializable;

public class PdModel implements Serializable {
    private Long id;

    private String name;

    private String code;

    private String qaCode;

    private Long pdClassId;

    private String voltage;

    private String ohm;

    private String tan;

    private String otherParam;

    private String purpose;

    private String feature;

    private String contact;

    private String phone;

    private String orderRule;

    private String manualUrl;

    private String sizeUrl;

    private String orderRuleUrl;

    private String objectUrl;

    private String chartUrl;

    private String company;

    private String generalNorms;

    private String detailNorms;

    private Boolean del;

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

    public String getQaCode() {
        return qaCode;
    }

    public void setQaCode(String qaCode) {
        this.qaCode = qaCode == null ? null : qaCode.trim();
    }

    public Long getPdClassId() {
        return pdClassId;
    }

    public void setPdClassId(Long pdClassId) {
        this.pdClassId = pdClassId;
    }

    public String getVoltage() {
        return voltage;
    }

    public void setVoltage(String voltage) {
        this.voltage = voltage == null ? null : voltage.trim();
    }

    public String getOhm() {
        return ohm;
    }

    public void setOhm(String ohm) {
        this.ohm = ohm == null ? null : ohm.trim();
    }

    public String getTan() {
        return tan;
    }

    public void setTan(String tan) {
        this.tan = tan == null ? null : tan.trim();
    }

    public String getOtherParam() {
        return otherParam;
    }

    public void setOtherParam(String otherParam) {
        this.otherParam = otherParam == null ? null : otherParam.trim();
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose == null ? null : purpose.trim();
    }

    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature == null ? null : feature.trim();
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact == null ? null : contact.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getOrderRule() {
        return orderRule;
    }

    public void setOrderRule(String orderRule) {
        this.orderRule = orderRule == null ? null : orderRule.trim();
    }

    public String getManualUrl() {
        return manualUrl;
    }

    public void setManualUrl(String manualUrl) {
        this.manualUrl = manualUrl == null ? null : manualUrl.trim();
    }

    public String getSizeUrl() {
        return sizeUrl;
    }

    public void setSizeUrl(String sizeUrl) {
        this.sizeUrl = sizeUrl == null ? null : sizeUrl.trim();
    }

    public String getOrderRuleUrl() {
        return orderRuleUrl;
    }

    public void setOrderRuleUrl(String orderRuleUrl) {
        this.orderRuleUrl = orderRuleUrl == null ? null : orderRuleUrl.trim();
    }

    public String getObjectUrl() {
        return objectUrl;
    }

    public void setObjectUrl(String objectUrl) {
        this.objectUrl = objectUrl == null ? null : objectUrl.trim();
    }

    public String getChartUrl() {
        return chartUrl;
    }

    public void setChartUrl(String chartUrl) {
        this.chartUrl = chartUrl == null ? null : chartUrl.trim();
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company == null ? null : company.trim();
    }

    public String getGeneralNorms() {
        return generalNorms;
    }

    public void setGeneralNorms(String generalNorms) {
        this.generalNorms = generalNorms == null ? null : generalNorms.trim();
    }

    public String getDetailNorms() {
        return detailNorms;
    }

    public void setDetailNorms(String detailNorms) {
        this.detailNorms = detailNorms == null ? null : detailNorms.trim();
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
        sb.append(", name=").append(name);
        sb.append(", code=").append(code);
        sb.append(", qaCode=").append(qaCode);
        sb.append(", pdClassId=").append(pdClassId);
        sb.append(", voltage=").append(voltage);
        sb.append(", ohm=").append(ohm);
        sb.append(", tan=").append(tan);
        sb.append(", otherParam=").append(otherParam);
        sb.append(", purpose=").append(purpose);
        sb.append(", feature=").append(feature);
        sb.append(", contact=").append(contact);
        sb.append(", phone=").append(phone);
        sb.append(", orderRule=").append(orderRule);
        sb.append(", manualUrl=").append(manualUrl);
        sb.append(", sizeUrl=").append(sizeUrl);
        sb.append(", orderRuleUrl=").append(orderRuleUrl);
        sb.append(", objectUrl=").append(objectUrl);
        sb.append(", chartUrl=").append(chartUrl);
        sb.append(", company=").append(company);
        sb.append(", generalNorms=").append(generalNorms);
        sb.append(", detailNorms=").append(detailNorms);
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
        PdModel other = (PdModel) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getCode() == null ? other.getCode() == null : this.getCode().equals(other.getCode()))
            && (this.getQaCode() == null ? other.getQaCode() == null : this.getQaCode().equals(other.getQaCode()))
            && (this.getPdClassId() == null ? other.getPdClassId() == null : this.getPdClassId().equals(other.getPdClassId()))
            && (this.getVoltage() == null ? other.getVoltage() == null : this.getVoltage().equals(other.getVoltage()))
            && (this.getOhm() == null ? other.getOhm() == null : this.getOhm().equals(other.getOhm()))
            && (this.getTan() == null ? other.getTan() == null : this.getTan().equals(other.getTan()))
            && (this.getOtherParam() == null ? other.getOtherParam() == null : this.getOtherParam().equals(other.getOtherParam()))
            && (this.getPurpose() == null ? other.getPurpose() == null : this.getPurpose().equals(other.getPurpose()))
            && (this.getFeature() == null ? other.getFeature() == null : this.getFeature().equals(other.getFeature()))
            && (this.getContact() == null ? other.getContact() == null : this.getContact().equals(other.getContact()))
            && (this.getPhone() == null ? other.getPhone() == null : this.getPhone().equals(other.getPhone()))
            && (this.getOrderRule() == null ? other.getOrderRule() == null : this.getOrderRule().equals(other.getOrderRule()))
            && (this.getManualUrl() == null ? other.getManualUrl() == null : this.getManualUrl().equals(other.getManualUrl()))
            && (this.getSizeUrl() == null ? other.getSizeUrl() == null : this.getSizeUrl().equals(other.getSizeUrl()))
            && (this.getOrderRuleUrl() == null ? other.getOrderRuleUrl() == null : this.getOrderRuleUrl().equals(other.getOrderRuleUrl()))
            && (this.getObjectUrl() == null ? other.getObjectUrl() == null : this.getObjectUrl().equals(other.getObjectUrl()))
            && (this.getChartUrl() == null ? other.getChartUrl() == null : this.getChartUrl().equals(other.getChartUrl()))
            && (this.getCompany() == null ? other.getCompany() == null : this.getCompany().equals(other.getCompany()))
            && (this.getGeneralNorms() == null ? other.getGeneralNorms() == null : this.getGeneralNorms().equals(other.getGeneralNorms()))
            && (this.getDetailNorms() == null ? other.getDetailNorms() == null : this.getDetailNorms().equals(other.getDetailNorms()))
            && (this.getDel() == null ? other.getDel() == null : this.getDel().equals(other.getDel()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getCode() == null) ? 0 : getCode().hashCode());
        result = prime * result + ((getQaCode() == null) ? 0 : getQaCode().hashCode());
        result = prime * result + ((getPdClassId() == null) ? 0 : getPdClassId().hashCode());
        result = prime * result + ((getVoltage() == null) ? 0 : getVoltage().hashCode());
        result = prime * result + ((getOhm() == null) ? 0 : getOhm().hashCode());
        result = prime * result + ((getTan() == null) ? 0 : getTan().hashCode());
        result = prime * result + ((getOtherParam() == null) ? 0 : getOtherParam().hashCode());
        result = prime * result + ((getPurpose() == null) ? 0 : getPurpose().hashCode());
        result = prime * result + ((getFeature() == null) ? 0 : getFeature().hashCode());
        result = prime * result + ((getContact() == null) ? 0 : getContact().hashCode());
        result = prime * result + ((getPhone() == null) ? 0 : getPhone().hashCode());
        result = prime * result + ((getOrderRule() == null) ? 0 : getOrderRule().hashCode());
        result = prime * result + ((getManualUrl() == null) ? 0 : getManualUrl().hashCode());
        result = prime * result + ((getSizeUrl() == null) ? 0 : getSizeUrl().hashCode());
        result = prime * result + ((getOrderRuleUrl() == null) ? 0 : getOrderRuleUrl().hashCode());
        result = prime * result + ((getObjectUrl() == null) ? 0 : getObjectUrl().hashCode());
        result = prime * result + ((getChartUrl() == null) ? 0 : getChartUrl().hashCode());
        result = prime * result + ((getCompany() == null) ? 0 : getCompany().hashCode());
        result = prime * result + ((getGeneralNorms() == null) ? 0 : getGeneralNorms().hashCode());
        result = prime * result + ((getDetailNorms() == null) ? 0 : getDetailNorms().hashCode());
        result = prime * result + ((getDel() == null) ? 0 : getDel().hashCode());
        return result;
    }
}