package com.chk.pdms.data.service;

import com.chk.pdms.data.dao.DataDao;
import com.chk.pdms.pd.dao.PdInfoDao;
import com.chk.pdms.pd.domain.*;
import lombok.SneakyThrows;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class UpdateJunjiService {
    @Autowired
    private DataDao dataDao;

    @SneakyThrows
    @Transactional
    public void update(){
        List<PdClass> classes = dataDao.getClassMapper().selectByExample(new PdClassExample());
        List<PdModel> models = dataDao.getModelMapper().selectByExample(new PdModelExample());
        List<PdInfo> infos = dataDao.getInfoMapper().selectByExample(new PdInfoExample());

        Map<String, PdClass> clzMap = new LinkedHashMap<>();
        List<PdClass>  insertCls = new ArrayList<>();
        for (PdClass clz : classes) {
            if ("军级".equals(clz.getQaGp())){
                PdClass c1 = new PdClass();
                PdClass c2 = new PdClass();
                PdClass c3 = new PdClass();
                PdClass c4 = new PdClass();
                BeanUtils.copyProperties(c1, clz);
                BeanUtils.copyProperties(c2, clz);
                BeanUtils.copyProperties(c3, clz);
                BeanUtils.copyProperties(c4, clz);
                c1.setId(null);
                c2.setId(null);
                c3.setId(null);
                c4.setId(null);
                c1.setIdx(c1.getIdx() + 1);
                c2.setIdx(c1.getIdx() + 2);
                c3.setIdx(c1.getIdx() + 3);
                c4.setIdx(c1.getIdx() + 4);
                c1.setQaGp("国军标");
                c2.setQaGp("企军标");
                c3.setQaGp("七专");
                c4.setQaGp("普军");
                insertCls.add(c1);
                insertCls.add(c2);
                insertCls.add(c3);
                insertCls.add(c4);
                clzMap.put(clz.getId() + "_" + c1.getQaGp(), c1);
                clzMap.put(clz.getId() + "_" + c2.getQaGp(), c2);
                clzMap.put(clz.getId() + "_" + c3.getQaGp(), c3);
                clzMap.put(clz.getId() + "_" + c4.getQaGp(), c4);
            }
        }

        for (PdClass insertCl : insertCls) {
            dataDao.getClassMapper().insert(insertCl);
        }

        Map<Long, PdModel> modelMap = new LinkedHashMap<>();
        Map<Long, PdModel> updateModel = new LinkedHashMap<>();
        for (PdModel model : models) {
            modelMap.put(model.getId(), model);
        }

        for (PdInfo info : infos) {
            if (updateModel.containsKey(info.getPdModelId())){
                continue;
            }
            PdModel pdModel = modelMap.get(info.getPdModelId());
            if (info.getQuality().equals("GJB")
            ||info.getQuality().equals("G") || info.getQuality().equals("J")){
                pdModel.setQaCode(info.getQuality());
                updateModel.put(pdModel.getId(), pdModel);
                String key = pdModel.getPdClassId() + "_";
                if (info.getQuality().equals("GJB")){
                    key += "国军标";
                }
                if (info.getQuality().equals("G")){
                    key += "七专";
                }
                if (info.getQuality().equals("J")){
                    key += "普军";
                }
                PdClass pdClass = clzMap.get(key);
                if (pdClass == null){
                    System.out.println(key);
                }
                pdModel.setPdClassId(pdClass.getId());
            }else if (info.getQuality().equals("QJ") || info.getQuality().equals("CASS C")){
                pdModel.setQaCode("QJ;CASS C");
                updateModel.put(pdModel.getId(), pdModel);
                String key = pdModel.getPdClassId() + "_" + "企军标";
                PdClass pdClass = clzMap.get(key);
                if (pdClass == null){
                    System.out.println(key);
                }
                pdModel.setPdClassId(pdClass.getId());
            }
        }

        List<PdModel> modelList = new ArrayList<>();
        for (PdModel value : updateModel.values()) {
            PdModel model = new PdModel();
            model.setId(value.getId());
            model.setPdClassId(value.getPdClassId());
            model.setQaCode(value.getQaCode());
            modelList.add(model);
        }

        for (PdModel model : modelList) {
            dataDao.getModelMapper().updateByPrimaryKeySelective(model);
        }

        System.out.println("123");

    }
//    update pd_class set idx = idx+1000 where qg_gp = '工业级'
    //删除原有的军级
//    update pd_class set p_id = 0 - p_id where qa_gp = '军级'
    //删除没有info的model
//    update pd_class set p_id = 0 - p_id where id not in (select pd_class_id from pd_model) and level = 3 and qa_gp in (
//    '国军标',
//    '企军标',
//    '七专',
//    '普军'
//    )

    //删除没有class的model
//    delete from pd_model where pd_class_id not in (
//            select id from pd_class
//    )

}
