package com.chk.pdms.fpd.dao;

import com.chk.pdms.fpd.dao.mapper.FpdModelMapper;
import com.chk.pdms.fpd.domain.FpdModel;
import com.chk.pdms.fpd.domain.FpdModelExample;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FpdModelDao {

    @Autowired
    private FpdModelMapper modelMapper;

    public FpdModelMapper getModelMapper() {
        return modelMapper;
    }

    public List<FpdModel> list(String name){
        FpdModelExample exp = new FpdModelExample();
        if (StringUtils.isNotBlank(name)) {
            exp.createCriteria().andCodeLike("%" + name + "%");
        }
        exp.setOrderByClause("idx asc");
        return modelMapper.selectByExample(exp);
    }
}
