package com.chk.pdms.cm.domain;

import java.io.Serializable;

public class CmContact implements Serializable {
    private Long id;

    private String name;

    private String address;

    private String postCode;

    private String phoneTitle1;

    private String phone1;

    private String phoneTitle2;

    private String phone2;

    private String faxTitle;

    private String fax;

    private String website;

    private String email;

    private String contactTitle;

    private String contactName;

    private String contactPhone;

    private String type;

    private Integer idx;

    private String area;

    private String lat;

    private String lng;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode == null ? null : postCode.trim();
    }

    public String getPhoneTitle1() {
        return phoneTitle1;
    }

    public void setPhoneTitle1(String phoneTitle1) {
        this.phoneTitle1 = phoneTitle1 == null ? null : phoneTitle1.trim();
    }

    public String getPhone1() {
        return phone1;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1 == null ? null : phone1.trim();
    }

    public String getPhoneTitle2() {
        return phoneTitle2;
    }

    public void setPhoneTitle2(String phoneTitle2) {
        this.phoneTitle2 = phoneTitle2 == null ? null : phoneTitle2.trim();
    }

    public String getPhone2() {
        return phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2 == null ? null : phone2.trim();
    }

    public String getFaxTitle() {
        return faxTitle;
    }

    public void setFaxTitle(String faxTitle) {
        this.faxTitle = faxTitle == null ? null : faxTitle.trim();
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax == null ? null : fax.trim();
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website == null ? null : website.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getContactTitle() {
        return contactTitle;
    }

    public void setContactTitle(String contactTitle) {
        this.contactTitle = contactTitle == null ? null : contactTitle.trim();
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName == null ? null : contactName.trim();
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone == null ? null : contactPhone.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Integer getIdx() {
        return idx;
    }

    public void setIdx(Integer idx) {
        this.idx = idx;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat == null ? null : lat.trim();
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng == null ? null : lng.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", address=").append(address);
        sb.append(", postCode=").append(postCode);
        sb.append(", phoneTitle1=").append(phoneTitle1);
        sb.append(", phone1=").append(phone1);
        sb.append(", phoneTitle2=").append(phoneTitle2);
        sb.append(", phone2=").append(phone2);
        sb.append(", faxTitle=").append(faxTitle);
        sb.append(", fax=").append(fax);
        sb.append(", website=").append(website);
        sb.append(", email=").append(email);
        sb.append(", contactTitle=").append(contactTitle);
        sb.append(", contactName=").append(contactName);
        sb.append(", contactPhone=").append(contactPhone);
        sb.append(", type=").append(type);
        sb.append(", idx=").append(idx);
        sb.append(", area=").append(area);
        sb.append(", lat=").append(lat);
        sb.append(", lng=").append(lng);
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
        CmContact other = (CmContact) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getAddress() == null ? other.getAddress() == null : this.getAddress().equals(other.getAddress()))
            && (this.getPostCode() == null ? other.getPostCode() == null : this.getPostCode().equals(other.getPostCode()))
            && (this.getPhoneTitle1() == null ? other.getPhoneTitle1() == null : this.getPhoneTitle1().equals(other.getPhoneTitle1()))
            && (this.getPhone1() == null ? other.getPhone1() == null : this.getPhone1().equals(other.getPhone1()))
            && (this.getPhoneTitle2() == null ? other.getPhoneTitle2() == null : this.getPhoneTitle2().equals(other.getPhoneTitle2()))
            && (this.getPhone2() == null ? other.getPhone2() == null : this.getPhone2().equals(other.getPhone2()))
            && (this.getFaxTitle() == null ? other.getFaxTitle() == null : this.getFaxTitle().equals(other.getFaxTitle()))
            && (this.getFax() == null ? other.getFax() == null : this.getFax().equals(other.getFax()))
            && (this.getWebsite() == null ? other.getWebsite() == null : this.getWebsite().equals(other.getWebsite()))
            && (this.getEmail() == null ? other.getEmail() == null : this.getEmail().equals(other.getEmail()))
            && (this.getContactTitle() == null ? other.getContactTitle() == null : this.getContactTitle().equals(other.getContactTitle()))
            && (this.getContactName() == null ? other.getContactName() == null : this.getContactName().equals(other.getContactName()))
            && (this.getContactPhone() == null ? other.getContactPhone() == null : this.getContactPhone().equals(other.getContactPhone()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getIdx() == null ? other.getIdx() == null : this.getIdx().equals(other.getIdx()))
            && (this.getArea() == null ? other.getArea() == null : this.getArea().equals(other.getArea()))
            && (this.getLat() == null ? other.getLat() == null : this.getLat().equals(other.getLat()))
            && (this.getLng() == null ? other.getLng() == null : this.getLng().equals(other.getLng()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());
        result = prime * result + ((getPostCode() == null) ? 0 : getPostCode().hashCode());
        result = prime * result + ((getPhoneTitle1() == null) ? 0 : getPhoneTitle1().hashCode());
        result = prime * result + ((getPhone1() == null) ? 0 : getPhone1().hashCode());
        result = prime * result + ((getPhoneTitle2() == null) ? 0 : getPhoneTitle2().hashCode());
        result = prime * result + ((getPhone2() == null) ? 0 : getPhone2().hashCode());
        result = prime * result + ((getFaxTitle() == null) ? 0 : getFaxTitle().hashCode());
        result = prime * result + ((getFax() == null) ? 0 : getFax().hashCode());
        result = prime * result + ((getWebsite() == null) ? 0 : getWebsite().hashCode());
        result = prime * result + ((getEmail() == null) ? 0 : getEmail().hashCode());
        result = prime * result + ((getContactTitle() == null) ? 0 : getContactTitle().hashCode());
        result = prime * result + ((getContactName() == null) ? 0 : getContactName().hashCode());
        result = prime * result + ((getContactPhone() == null) ? 0 : getContactPhone().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getIdx() == null) ? 0 : getIdx().hashCode());
        result = prime * result + ((getArea() == null) ? 0 : getArea().hashCode());
        result = prime * result + ((getLat() == null) ? 0 : getLat().hashCode());
        result = prime * result + ((getLng() == null) ? 0 : getLng().hashCode());
        return result;
    }
}