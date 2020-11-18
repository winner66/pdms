package com.chk.pdms.data;

import com.alibaba.excel.EasyExcel;
import com.chk.pdms.data.vo.ClassVo;
import com.chk.pdms.pd.domain.PdClass;
import com.chk.pdms.pd.domain.PdClassQa;
import org.apache.commons.lang3.StringUtils;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String path = "C:\\Users\\admin\\Desktop\\新建文件夹 (2)\\旧APP产品分类表-建议新分类对应表20200220(2).xlsx";
        List<ClassVo> classVos = EasyExcel.read(path).head(ClassVo.class).sheet().doReadSync();
        System.out.println(classVos);

        List<PdClass> clzs = new ArrayList<>();

        ClassVo pre = classVos.get(0);
        for (ClassVo vo : classVos) {
           if (StringUtils.isBlank(vo.getLev1())){
               vo.setLev1(pre.getLev1());
           }
            if (StringUtils.isBlank(vo.getLev21())){
                vo.setLev21(pre.getLev21());
            }
            if (StringUtils.isBlank(vo.getLev22())){
                vo.setLev22(pre.getLev22());
            }
            pre = vo;
        }

        Map<String, PdClass> lev1Map = new LinkedHashMap<>();
        Map<String, PdClass> lev2Map = new LinkedHashMap<>();
        Map<String, PdClass> lev3Map = new LinkedHashMap<>();
        Map<String, List<PdClassQa>> qaMap = new LinkedHashMap<>();
        for (ClassVo vo : classVos) {
            String lev1Key = vo.getLev1();
            String lev2Key = vo.getLev1() + "_" + vo.getLev21();
            String lev3Key = vo.getLev1() + "_" + vo.getLev21() + "_" + vo.getLev22() + "_" + vo.getLev3();
            String qaKey = lev3Key;
            if (!lev1Map.containsKey(lev1Key)) {
                PdClass clz = new PdClass();
                clz.setName(vo.getLev1());
                clz.setLevel(1);
                lev1Map.put(lev1Key, clz);
            }

            if (!lev2Map.containsKey(lev2Key)) {
                PdClass clz = new PdClass();
                clz.setName(vo.getLev1());
                clz.setLevel(2);
                lev2Map.put(lev2Key, clz);
            }

            if (!lev3Map.containsKey(lev3Key)) {
                if (StringUtils.isBlank(vo.getLev3())){
                    continue;
                }
                PdClass clz = new PdClass();
                clz.setName(vo.getLev1());
                clz.setLevel(3);
                clz.setQaGp(vo.getLev22());
                lev3Map.put(lev3Key, clz);
            }

            if (!qaMap.containsKey(lev3Key)) {
                if (StringUtils.isBlank(vo.getQa())){
                    continue;
                }
                String[] qas =StringUtils.split(vo.getQa(), "、");
                List<PdClassQa> qaList = new ArrayList<>();
                for (String s : qas) {
                    PdClassQa qa = new PdClassQa();
                    qa.setQaCode(s);
                    qaList.add(qa);
                }
                qaMap.put(lev3Key, qaList);
            }
        }
        System.out.println("123");
    }
}
