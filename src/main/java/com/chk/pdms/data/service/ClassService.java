package com.chk.pdms.data.service;

import com.chk.pdms.data.dao.DataDao;
import com.chk.pdms.data.vo.ClassVo;
import com.chk.pdms.pd.domain.PdClass;
import com.chk.pdms.pd.domain.PdClassQa;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class ClassService {

    @Autowired
    private DataDao dataDao;

    @Transactional
    public void importClz(List<ClassVo> classVos) {
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
            String lev2Key = vo.getLev1() + "__" + vo.getLev21();
            String lev3Key = vo.getLev1() + "__" + vo.getLev21() + "__" + vo.getLev22() + "__" + vo.getLev3();
            if (!lev1Map.containsKey(lev1Key)) {
                PdClass clz = new PdClass();
                clz.setName(vo.getLev1());
                clz.setShowName(clz.getName());
                clz.setLevel(1);
                lev1Map.put(lev1Key, clz);
            }

            if (!lev2Map.containsKey(lev2Key)) {
                PdClass clz = new PdClass();
                clz.setName(vo.getLev21());
                clz.setShowName(clz.getName());
                clz.setLevel(2);
                lev2Map.put(lev2Key, clz);
            }

            if (!lev3Map.containsKey(lev3Key)) {
                if (StringUtils.isBlank(vo.getLev3())){
                    continue;
                }
                PdClass clz = new PdClass();
                clz.setName(vo.getLev3());
                clz.setShowName(clz.getName());
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

        dataDao.deleteClass();
        dataDao.deleteClassQa();

        int i = 0;
        for (PdClass clz : lev1Map.values()) {
            clz.setIdx(++i);
            clz.setpId(0L);
            dataDao.getClassMapper().insert(clz);
        }

        i = 0;
        for (String lev2Key : lev2Map.keySet()) {
            String lev1Key = StringUtils.split(lev2Key, "__")[0];
            PdClass lev1 = lev1Map.get(lev1Key);
            PdClass lev2 = lev2Map.get(lev2Key);
            lev2.setIdx(++i);
            lev2.setpId(lev1.getId());
            dataDao.getClassMapper().insert(lev2);
        }

        i = 0;
        for (String lev3Key : lev3Map.keySet()) {
            String[] s = StringUtils.split(lev3Key, "__");
            String lev2Key = s[0] + "__" + s[1];
            PdClass lev2 = lev2Map.get(lev2Key);
            PdClass lev3 = lev3Map.get(lev3Key);
            lev3.setIdx(++i);
            lev3.setpId(lev2.getId());
            dataDao.getClassMapper().insert(lev3);
        }

        for (String qaKey : qaMap.keySet()) {
            PdClass lev3 = lev3Map.get(qaKey);
            List<PdClassQa> qas = qaMap.get(qaKey);
            for (PdClassQa qa : qas) {
                qa.setPdClassId(lev3.getId());
                dataDao.getClassQaMapper().insert(qa);
            }
        }
    }
}
