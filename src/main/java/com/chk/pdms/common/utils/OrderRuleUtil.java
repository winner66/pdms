package com.chk.pdms.common.utils;

import com.chk.pdms.common.vo.ParamType;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

public class OrderRuleUtil {

    public static Map<Integer, String> ruleIdxMap = new HashMap<>();

    static {
        //①②③④⑤⑥⑦⑧⑨⑩⑪⑫⑬⑭⑮
        ruleIdxMap.put(1, "①");
        ruleIdxMap.put(2, "②");
        ruleIdxMap.put(3, "③");
        ruleIdxMap.put(4, "④");
        ruleIdxMap.put(5, "⑤");
        ruleIdxMap.put(6, "⑥");
        ruleIdxMap.put(7, "⑦");
        ruleIdxMap.put(8, "⑧");
        ruleIdxMap.put(9, "⑨");
        ruleIdxMap.put(10, "⑩");
        ruleIdxMap.put(11, "⑪");
        ruleIdxMap.put(12, "⑫");
        ruleIdxMap.put(13, "⑬");
        ruleIdxMap.put(14, "⑭");
        ruleIdxMap.put(15, "⑮");
    }

//    public static String[] getRules(String orderRule) {
//        String rule = orderRule;
//        rule = StringUtils.replace(rule, "执行标准", "执行标准" + "||");
//        rule = StringUtils.replace(rule, "质量等级", "质量等级" + "||");
//        rule = StringUtils.replace(rule, "产品型号", "产品型号" + "||");
//        rule = StringUtils.replace(rule, "封装及外形尺寸", "封装及外形尺寸" + "||");
//        rule = StringUtils.replace(rule, "温度特性/系数", "温度特性/系数" + "||");
//        rule = StringUtils.replace(rule, "电压", "电压" + "||");
//        rule = StringUtils.replace(rule, "电容", "电容" + "||");
//        rule = StringUtils.replace(rule, "精度/容量偏差", "精度/容量偏差" + "||");
//        rule = StringUtils.replace(rule, "引出端形式", "引出端形式" + "||");
//        String[] ss = StringUtils.split(rule, "||");
//        return ss;
//    }

    public static String[] getRules(String orderRule) {
        String rule = StringUtils.replace(orderRule, "|", "");
        for (ParamType type : ParamType.values()) {
            rule = StringUtils.replace(rule, type.value(), type.value() + "||", 1);
        }
        String[] ss = StringUtils.split(rule, "||");
        return ss;
    }

    public static String[] getRuleDesc(String orderRule) {
        String rule = StringUtils.replace(orderRule, "|", "");
        for (ParamType type : ParamType.values()) {
            rule = StringUtils.replace(rule, type.value(), type.title() + "||", 1);
            rule = StringUtils.replace(rule, "-", "");
        }
        String[] ss = StringUtils.split(rule, "||");
        for (int i =0; i < ss.length; i++){
            ss[i] = ruleIdxMap.get(i+1) + "：" + ss[i];
        }
        return ss;
    }

    public static String replace(final String text, final String searchString, final String replacement) {
        String replace = replacement == null ? "" : replacement;
        return StringUtils.replace(text, searchString, replace);
    }

    //处理单层芯片, 将 -SC- 变成 -SC
    public static String resetSingleModel(String rule, String model) {
        if (StringUtils.isNotBlank(model)) {
            String flag[] = {"-SC", "-EC", "-MC", };
            for (String s : flag) {
                String str = s + "-";
                if (StringUtils.contains(model, s) && StringUtils.contains(rule, str)) {
                    rule = replace(rule, str, s);
                }
            }
        }
        return rule;
    }

    public static String resetSingleModelExp(String rule, String model) {
        if (StringUtils.isNotBlank(model)) {
//            ？
            String flag[] = {"-SC", "-EC", "-MC"};
            for (String s : flag) {
                String str = s + "||-";
                if (StringUtils.contains(model, s) && StringUtils.contains(rule, str)) {
                    rule = replace(rule, str, s + "||");
                }
            }
        }
        return rule;
    }

    public static String getQa(String qa){
        if ("GJB".equals(qa)){
            return "国军标";
        }else{
            return qa;
        }
    }
}
