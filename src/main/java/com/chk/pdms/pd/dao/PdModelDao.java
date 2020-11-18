package com.chk.pdms.pd.dao;

import com.chk.pdms.pd.dao.extmapper.ExtPdModelMapper;
import com.chk.pdms.pd.dao.mapper.PdModelMapper;
import com.chk.pdms.pd.domain.PdModel;
import com.chk.pdms.pd.domain.PdModelExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PdModelDao {

    @Autowired
    private PdModelMapper modelMapper;

    @Autowired
    private ExtPdModelMapper extModelMapper;

    public PdModelMapper getModelMapper() {
        return modelMapper;
    }

    public ExtPdModelMapper getExtModelMapper() {
        return extModelMapper;
    }

    public List<PdModel> list(){
        PdModelExample exp = new PdModelExample();
        exp.setOrderByClause("id asc");
        return modelMapper.selectByExample(exp);
    }

    public boolean exist(Long id, String code, String qa){
        PdModelExample exp = new PdModelExample();
        PdModelExample.Criteria criteria = exp.createCriteria();
        criteria.andIdNotEqualTo(id);
        criteria.andCodeEqualTo(code);
        criteria.andQaCodeEqualTo(qa);
        exp.setOrderByClause("id asc limit 1");
        List<PdModel> models = modelMapper.selectByExample(exp);
        return models.size() > 0 ? true : false;
    }
}
