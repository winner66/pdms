package com.chk.pdms.pd.dao;

import com.chk.pdms.common.vo.ParamType;
import com.chk.pdms.pd.dao.extmapper.ExtPdParamMapper;
import com.chk.pdms.pd.dao.mapper.PdParamMapper;
import com.chk.pdms.pd.domain.PdParam;
import com.chk.pdms.pd.domain.PdParamExample;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
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
        if( minIdx!=null&&maxIdx!=null){
            exp.createCriteria().andTypeEqualTo(ParamType.capacity.value()).andIdxBetween(minIdx, maxIdx);
        }else{

        }
        List<PdParam> pdParams = paramMapper.selectByExample(exp);
        return pdParams;


    }
    public PdParam getSize(String std, String code){
        if (StringUtils.isBlank(std) || StringUtils.isBlank(code)){
            return null;
        }
        PdParamExample exp = new PdParamExample();
        exp.createCriteria().andRelEqualTo(std).andCodeEqualTo(code);
        List<PdParam> params = paramMapper.selectByExample(exp);
        return params.size() > 0 ? params.get(0) : null;
    }
    public PdParam getPdParam(String type, String code){
        if (code  == null){
            return null;
        }
        PdParamExample exp = new PdParamExample();
        exp.createCriteria().andTypeEqualTo(type).andCodeEqualTo(code);
        List<PdParam> param = paramMapper.selectByExample(exp);
        return param.size() > 0 ? param.get(0) : null;
    }

    public List<PdParam> getPdPrams(String type) {
        PdParamExample exp = new PdParamExample();
        exp.createCriteria().andTypeEqualTo(type);
//        exp.setOrderByClause("idx asc");
        List<PdParam> pdParams = paramMapper.selectByExample(exp);
//        exp.setOrderByClause("idx asc limit 0, 5000");
        return pdParams;
    }

    public List<PdParam> getPdParam(String type, List<String> codes){
        if (CollectionUtils.isEmpty(codes)){
            return Collections.emptyList();
        }
        PdParamExample exp = new PdParamExample();
        exp.createCriteria().andTypeEqualTo(type).andCodeIn(codes);
//        exp.setOrderByClause("idx asc");
        return paramMapper.selectByExample(exp);
    }
}
