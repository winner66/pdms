package com.chk.pdms.fpd.vo;

import com.chk.pdms.common.vo.ParamType;
import com.chk.pdms.fpd.domain.FpdModel;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Data
public class FpdModelVo extends FpdModel {

    private List<String> ors = new ArrayList<>();

    private List<String> bits = new ArrayList<>();

    private List<String> poses = new ArrayList<>();

    public void arrayOR() {
        int count = 40;

        if (StringUtils.isNotBlank(this.getOrderRuleBit())) {
            String[] b = StringUtils.split(this.getOrderRuleBit(), ",");
            for (String s : b) {
                bits.add(s);
            }
        }
        for (int i = bits.size(); i < count / 4; i++){
            bits.add("");
        }

        if  (StringUtils.isNotBlank(this.getOrderRulePos())){
            String[] b = StringUtils.split(this.getOrderRulePos(), ",");
            for (String s : b) {
                poses.add(s);
            }
        }
        for (int i = poses.size(); i < count / 4; i++){
            poses.add("");
        }

        if (StringUtils.isNotBlank(getOrderRule())) {
            String[] strs = StringUtils.splitPreserveAllTokens(this.getOrderRule(), "|");
            for (String s : strs) {
                ors.add(s);
            }
        }

        for (int i = ors.size(); i < count; i++) {
            ors.add("");
        }

        for (int i = 0; i < poses.size();i++){
            if (StringUtils.isNotBlank(poses.get(i))){
                int index = 3 * i + 2;
                if (index < ors.size()) {
                    ors.add(index, poses.get(i));
                }
            }
        }

        for (int i = 0; i < bits.size();i++){
            if (StringUtils.isNotBlank(bits.get(i))){
                int index = 4 * i + 3;
                if (index < ors.size()) {
                    ors.add(index, bits.get(i));
                }
            }
        }
        ors = this.ors.subList(0, count);
    }

    public String getFormatOR() {
        if (StringUtils.isNotBlank(this.getOrderRule())) {
            String orderRule = this.getOrderRule();
            for (ParamType value : ParamType.values()) {
                orderRule = StringUtils.replace(orderRule, value.value(), value.title());
            }
            return StringUtils.replace(orderRule, "|", "") + " (位置:" + this.getOrderRulePos() + ")" + " (长度:" + this.getOrderRuleBit() + ")";
        }
        return this.getOrderRule();
    }

    public String getRule(){
        if (StringUtils.isNotBlank(this.getOrderRule())){
            return StringUtils.replace(this.getOrderRule(), "|", "");
        }else{
            return "";
        }
    }
}
