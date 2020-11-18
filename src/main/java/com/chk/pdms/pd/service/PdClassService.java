package com.chk.pdms.pd.service;

import com.chk.pdms.common.domain.Tree;
import com.chk.pdms.common.utils.FileUtil;
import com.chk.pdms.pd.dao.PdClassDao;
import com.chk.pdms.pd.domain.PdClass;
import com.chk.pdms.pd.vo.PdClassVo;
import lombok.SneakyThrows;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class PdClassService {
    @Autowired
    private PdClassDao pdClassDao;

    @Value("${virtual.filePath}")
    private String filePath;

    public List<PdClass> list() {
        List<PdClass> pdClasses = pdClassDao.list();
        return pdClasses;
    }

    public List<Tree<PdClass>> tree() {
        List<PdClass> pdClasses = pdClassDao.list();
//        Map<String, Tree<PdClass>> lev1 = new LinkedHashMap<>();
//        for (PdClass pdClass : pdClasses) {
//            if (pdClass.getLevel() == 1){
//                Tree<PdClass> tree = new Tree<>();
//                tree.setId(pdClass.getId().toString());
//                tree.setParentId("0");
//                tree.setText(pdClass.getName());
//                tree.getState().put("opened", true);
//                lev1.put(tree.getId(), tree);
//            }
//        }
        Map<String, Tree<PdClass>> lev2 = new LinkedHashMap<>();
        for (PdClass pdClass : pdClasses) {
            if (pdClass.getLevel() == 2) {
                Tree<PdClass> tree = new Tree<>();
                tree.setId(pdClass.getId().toString());
                tree.setParentId(pdClass.getpId().toString());
                tree.setText(pdClass.getName());
//                if (lev1.containsKey(tree.getParentId())) {
//                    lev1.get(tree.getParentId()).getChildren().add(tree);
//                    lev2.put(tree.getId(), tree);
//                }
                lev2.put(tree.getId(), tree);
            }
        }
        for (PdClass pdClass : pdClasses) {
            if (pdClass.getLevel() == 3) {
                Tree<PdClass> tree = new Tree<>();
                tree.setId(pdClass.getId().toString());
                tree.setParentId(pdClass.getpId().toString());
                tree.setText(pdClass.getQaGp() + " - " + pdClass.getName());
                if (lev2.containsKey(tree.getParentId())) {
                    lev2.get(tree.getParentId()).getChildren().add(tree);
                }
            }
        }

        return new ArrayList<>(lev2.values());
    }

    @SneakyThrows
    public PdClassVo get(Long id) {
        PdClass pdClass = pdClassDao.getClassMapper().selectByPrimaryKey(id);
        PdClassVo vo = new PdClassVo();
        BeanUtils.copyProperties(vo, pdClass);
        return vo;
    }

    @SneakyThrows
    @Transactional
    public void save(PdClassVo clz) {
        String url = FileUtil.transferTo(clz.getIconImg(), filePath,"images/pd-class");
        if (url != null) {
            clz.setIconUrl(url);
        }

        PdClass pdClass = new PdClass();
        PropertyUtils.copyProperties(pdClass, clz);
        if (StringUtils.isBlank(pdClass.getIconUrl()) && pdClass.getpId() != null && !Long.valueOf(0).equals(pdClass.getpId())){
            PdClass parent = pdClassDao.getClassMapper().selectByPrimaryKey(pdClass.getpId());
            if (parent != null){
                pdClass.setIconUrl(parent.getIconUrl());
            }
        }
        if (pdClass.getId() == null) {
            pdClassDao.getClassMapper().insert(pdClass);
        } else {
            pdClassDao.getClassMapper().updateByPrimaryKey(pdClass);
        }
    }

    @Transactional
    public Boolean delete(Long id) {
        if (pdClassDao.hasClass(id)) {
            return false;
        }
        pdClassDao.getClassMapper().deleteByPrimaryKey(id);
        return true;
    }
}
