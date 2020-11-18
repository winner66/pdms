package com.chk.pdms.pd.vo;

import com.chk.pdms.pd.domain.PdInfo;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;


@Data
public class PdInfoVo extends PdInfo {
    private String pmName;

    private String pmCode;

    private Long pdClassId;

    public String getTolerance() {
        String s = StringUtils.substringAfter(super.getTolerance(), ";");
        s = (StringUtils.substringBeforeLast(s, ";"));
        return StringUtils.replace(s, ";", ",");
    }

    public String getOutlet() {
        String s = StringUtils.substringAfter(super.getOutlet(), ";");
        s = (StringUtils.substringBeforeLast(s, ";"));
        return StringUtils.replace(s, ";", ",");
    }

    public String getWireMa() {
        String s = StringUtils.substringAfter(super.getWireMa(), ";");
        s = (StringUtils.substringBeforeLast(s, ";"));
        return StringUtils.replace(s, ";", ",");
    }

    public String getWireSize() {
        String s = StringUtils.substringAfter(super.getWireSize(), ";");
        s = (StringUtils.substringBeforeLast(s, ";"));
        return StringUtils.replace(s, ";", ",");
    }

    public String getPin() {
        String s = StringUtils.substringAfter(super.getPin(), ";");
        s = (StringUtils.substringBeforeLast(s, ";"));
        return StringUtils.replace(s, ";", ",");
    }

    public String getCapacity(){
        if(StringUtils.isNotBlank(this.getCapacityMin())) {
            return this.getCapacityMin() + "~" + this.getCapacityMax();
        }
        else{
            return "";
        }
    }

}
