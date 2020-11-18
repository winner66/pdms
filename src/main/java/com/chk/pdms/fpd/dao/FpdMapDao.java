package com.chk.pdms.fpd.dao;

import com.chk.pdms.fpd.dao.extmapper.ExtFpdMapMapper;
import com.chk.pdms.fpd.dao.mapper.FpdMapMapper;
import com.chk.pdms.fpd.dao.mapper.FpdModelMapper;
import com.chk.pdms.fpd.domain.FpdMap;
import com.chk.pdms.fpd.domain.FpdMapExample;
import com.chk.pdms.fpd.vo.FpdMapVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FpdMapDao {

    @Autowired
    private FpdMapMapper mapMapper;

    @Autowired
    private ExtFpdMapMapper extMapMapper;

    public FpdMapMapper getMapMapper() {
        return mapMapper;
    }

    public List<FpdMap> list(Long fmId){
        FpdMapExample exp = new FpdMapExample();
        if(fmId != null){
            exp.createCriteria().andFpdModelIdEqualTo(fmId);
        }
        exp.setOrderByClause("id desc");
        return mapMapper.selectByExample(exp);
    }

    public List<FpdMapVo> listVo(Long fmId){
        return extMapMapper.list(fmId);
    }

    public FpdMap get(Long fmId, String type, String fcode){
        FpdMapExample exp = new FpdMapExample();
        exp.createCriteria().andFpdModelIdEqualTo(fmId).andParamTypeEqualTo(type).andFcodeEqualTo(fcode);
        exp.setOrderByClause("id asc limit 1");
        List<FpdMap> fpdMaps = mapMapper.selectByExample(exp);
        if (fpdMaps.size() >= 1){
            return fpdMaps.get(0);
        }else{
            return null;
        }
    }
}
