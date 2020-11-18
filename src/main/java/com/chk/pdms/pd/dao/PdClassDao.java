package com.chk.pdms.pd.dao;

import com.chk.pdms.pd.dao.mapper.PdClassMapper;
import com.chk.pdms.pd.dao.mapper.PdClassQaMapper;
import com.chk.pdms.pd.domain.PdClass;
import com.chk.pdms.pd.domain.PdClassExample;
import com.chk.pdms.pd.domain.PdClassQa;
import com.chk.pdms.pd.domain.PdClassQaExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PdClassDao {
    @Autowired
    private PdClassMapper classMapper;

    @Autowired
    private PdClassQaMapper qaMapper;

    public PdClassMapper getClassMapper() {
        return classMapper;
    }

    public List<PdClass> list() {
        PdClassExample exp = new PdClassExample();
        exp.setOrderByClause("idx limit 0, 1000");
        List<PdClass> pdClasses = classMapper.selectByExample(exp);
        return pdClasses;
    }

    public boolean hasClass(Long id) {
        PdClassExample exp = new PdClassExample();
        exp.createCriteria().andPIdEqualTo(id);
        exp.setOrderByClause("id limit 1");
        List<PdClass> list = classMapper.selectByExample(exp);
        return list.size() == 0 ? false : true;
    }

    public List<PdClassQa> listQa(Long clzId){
        PdClassQaExample exp = new PdClassQaExample();
        exp.createCriteria().andPdClassIdEqualTo(clzId);
        exp.setOrderByClause("id asc");
        return qaMapper.selectByExample(exp);
    }
}