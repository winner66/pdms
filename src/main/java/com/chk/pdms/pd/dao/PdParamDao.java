package com.chk.pdms.pd.dao;

import com.chk.pdms.common.vo.ParamType;
import com.chk.pdms.pd.dao.extmapper.ExtPdParamMapper;
import com.chk.pdms.pd.dao.mapper.PdParamMapper;
import com.chk.pdms.pd.domain.PdParam;
import com.chk.pdms.pd.domain.PdParamExample;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public class PdParamDao {
    @Autowired
    private PdParamMapper paramMapper;

    @Autowired
    private ExtPdParamMapper extParamMapper;

    public PdParamMapper getParamMapper() {
        return paramMapper;
    }

    public ExtPdParamMapper getExtParamMapper() {
        return extParamMapper;
    }

    public List<PdParam> getCapacities(Integer minIdx, Integer maxIdx) {
        PdParamExample exp = new PdParamExample();
        exp.createCriteria().andTypeEqualTo(ParamType.capacity.value()).andIdxBetween(minIdx, maxIdx);
        exp.setOrderByClause("idx asc");
        List<PdParam> pdParams = paramMapper.selectByExample(exp);
        return pdParams;
    }

    public List<PdParam> getPdPrams(String type) {
        PdParamExample exp = new PdParamExample();
        exp.createCriteria().andTypeEqualTo(type);
        exp.setOrderByClause("idx asc");
        List<PdParam> pdParams = paramMapper.selectByExample(exp);
        exp.setOrderByClause("idx asc limit 0, 5000");
        return pdParams;
    }
}
