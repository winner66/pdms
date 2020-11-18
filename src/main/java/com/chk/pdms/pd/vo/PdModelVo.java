package com.chk.pdms.pd.vo;

import com.chk.pdms.common.utils.FileUtil;
import com.chk.pdms.common.vo.ParamType;
import com.chk.pdms.pd.domain.PdModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Data
public class PdModelVo extends PdModel {

    private String orderRule2;

    private String pcName;

    @JsonIgnore
    private MultipartFile manual;

    @JsonIgnore
    private MultipartFile orderRuleImg;

    @JsonIgnore
    private MultipartFile orderRuleImg2;

    private String orderRuleUrl2;

    @JsonIgnore
    private MultipartFile objectImg1;
    @JsonIgnore
    private MultipartFile objectImg2;
    @JsonIgnore
    private MultipartFile objectImg3;

    private String objectUrl1;

    private String objectUrl2;

    private String objectUrl3;

    private List<String> ors = new ArrayList<>();

    private List<String> ors2 = new ArrayList<>();

    public String getSuperQaCode(){
        return super.getQaCode();
    }

    public String getQaCode() {
//        String s = StringUtils.substringAfter(super.getQaCode(), ";");
//        s = (StringUtils.substringBeforeLast(s, ";"));
        return StringUtils.replace(super.getQaCode(), ";", ",");
    }

    public void trySpliltRule() {
        String orderRule = this.getOrderRule();
        if (StringUtils.isNotBlank(orderRule)) {
            String[] s = StringUtils.split(orderRule, "__");
            if (s.length == 2) {
                super.setOrderRule(s[0]);
                this.orderRule2 = s[1];
            }
        }
        String url = this.getOrderRuleUrl();
        if (StringUtils.isNotBlank(url)){
            String[] s = StringUtils.split(url, ",");
            if (s.length == 2) {
                super.setOrderRuleUrl(s[0]);
                this.orderRuleUrl2 = s[1];
            }
        }
    }

    public void tryMergeRule() {
        String orderRule1 = this.getOrderRule();
        String orderRule2 = this.getOrderRule2();
        if (StringUtils.isNotBlank(orderRule2) && StringUtils.isNotBlank(orderRule2)) {
            String orderRule = orderRule1 + "__" + orderRule2;
            this.setOrderRule(orderRule);
        }
        String url1 = this.getOrderRuleUrl();
        String url2 = this.getOrderRuleUrl2();
        if (StringUtils.isNotBlank(url1) && StringUtils.isNotBlank(url2)) {
            String url = url1 + "," + url2;
            this.setOrderRuleUrl(url);
        }
    }

    private String trans(final String orderRule){
        String rule = orderRule;
        for (ParamType type : ParamType.values()) {
            rule = StringUtils.replace(rule, type.value(), type.title(), 1);
        }
        return rule;
    }

    public String getFormatOR() {
        if (StringUtils.isNotBlank(this.getOrderRule())) {
            return trans(StringUtils.replace(this.getOrderRule(), "|", ""));
        }
        return this.getOrderRule();
    }

    public String getFormatOR2() {
        if (StringUtils.isNotBlank(this.getOrderRule2())) {
            return trans(StringUtils.replace(this.getOrderRule2(), "|", ""));
        }
        return this.getOrderRule2();
    }

    public List<String> arrayOR() {
        if (StringUtils.isNotBlank(this.getOrderRule())) {
            String[] ss = StringUtils.splitPreserveAllTokens(this.getOrderRule(), "|");
            for (String s : ss) {
                ors.add(s);
            }
        }
        for (int i = ors.size(); i < 24; i++) {
            ors.add("");
        }

        arrayOR2();
        return ors;
    }

    private void arrayOR2(){
        if (!StringUtils.contains(pcName, "单层芯片")){
            return;
        }
        if (StringUtils.isNotBlank(this.getOrderRule2())) {
            String[] ss = StringUtils.splitPreserveAllTokens(this.getOrderRule2(), "|");
            for (String s : ss) {
                ors2.add(s);
            }
        }
        for (int i = ors2.size(); i < 24; i++) {
            ors2.add("");
        }
    }

    public String getShowOrderRuleImg() {
        return FileUtil.unRenameUploadFile(this.getOrderRuleUrl());
    }

    public String getShowOrderRuleImg2() {
        return FileUtil.unRenameUploadFile(this.getOrderRuleUrl2());
    }



    public String getShowManual() {
        return FileUtil.unRenameUploadFile(this.getManualUrl());
    }

    public String getObjectUrl1() {
        if (StringUtils.isNotBlank(this.getObjectUrl())) {
            String[] urls = StringUtils.split(this.getObjectUrl(), ",");
            if (urls.length > 0) {
                return urls[0];
            }
        }
        return null;
    }

    public String getShowObjectImg1() {
        return FileUtil.unRenameUploadFile(this.getObjectUrl1());
    }

    public String getObjectUrl2() {
        if (StringUtils.isNotBlank(this.getObjectUrl())) {
            String[] urls = StringUtils.split(this.getObjectUrl(), ",");
            if (urls.length > 1) {
                return urls[1];
            }
        }
        return null;
    }

    public String getShowObjectImg2() {
        return FileUtil.unRenameUploadFile(this.getObjectUrl2());
    }

    public String getObjectUrl3() {
        if (StringUtils.isNotBlank(this.getObjectUrl())) {
            String[] urls = StringUtils.split(this.getObjectUrl(), ",");
            if (urls.length > 2) {
                return urls[2];
            }
        }
        return null;
    }

    public String getShowObjectImg3() {
        return FileUtil.unRenameUploadFile(this.getObjectUrl3());
    }

    public String buildObjectUrl() {
        StringBuilder sb = new StringBuilder();
        if (StringUtils.isNotBlank(this.objectUrl1)) {
            sb.append(this.objectUrl1).append(",");
        }
        if (StringUtils.isNotBlank(this.objectUrl2)) {
            sb.append(this.objectUrl2).append(",");
        }
        if (StringUtils.isNotBlank(this.objectUrl3)) {
            sb.append(this.objectUrl3).append(",");
        }
        String s = sb.toString();
        if (StringUtils.endsWith(s, ",")) {
            s = StringUtils.substringBeforeLast(s, ",");
        }
        return s;
    }
}
