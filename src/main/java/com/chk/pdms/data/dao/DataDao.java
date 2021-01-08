package com.chk.pdms.data.dao;

import com.chk.pdms.data.dao.extmapper.DataMapper;
import com.chk.pdms.pd.dao.mapper.*;
import com.chk.pdms.pd.domain.*;
import com.chk.pdms.pd_material.dao.mapper.PdInfoMaterialMapper;
import com.chk.pdms.pd_material.domain.PdInfoMaterialExample;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DataDao {

    @Autowired
    private PdInfoMapper infoMapper;

    @Autowired
    private PdInfoMaterialMapper infoMaterialMapper;

    @Autowired
    private PdModelMapper modelMapper;

    @Autowired
    private PdParamMapper paramMapper;

    @Autowired
    private PdClassMapper classMapper;

    @Autowired
    private PdClassQaMapper classQaMapper;

    @Autowired
    private DataMapper dataMapper;



    public DataMapper getDataMapper() {
        return dataMapper;
    }

    public PdInfoMapper getInfoMapper() {
        return infoMapper;
    }

    public PdModelMapper getModelMapper() {
        return modelMapper;
    }

    public PdParamMapper getParamMapper() {
        return paramMapper;
    }

    public PdClassMapper getClassMapper() {
        return classMapper;
    }

    public PdClassQaMapper getClassQaMapper() {
        return classQaMapper;
    }

    public void deleteInfo(){
        PdInfoExample exp = new PdInfoExample();
        infoMapper.deleteByExample(exp);
    }

    public void deleteModel(){
        PdModelExample exp = new PdModelExample();
        modelMapper.deleteByExample(exp);
    }

    public void deleteParam(String type){
        PdParamExample exp = new PdParamExample();
        PdParamExample.Criteria cri = exp.createCriteria();
        cri.andTypeEqualTo(type);
        paramMapper.deleteByExample(exp);
    }

    public void deleteInfoMaterial(){
        PdInfoMaterialExample example=new PdInfoMaterialExample();
        PdInfoMaterialExample.Criteria cri= example.createCriteria();
//        cri.andIdEqualTo()
        infoMaterialMapper.deleteByExample(example);
    }

    public List<PdParam> listParam(String type){
        PdParamExample exp = new PdParamExample();
        PdParamExample.Criteria cri = exp.createCriteria();
        cri.andTypeEqualTo(type);
        return paramMapper.selectByExample(exp);
    }

    public List<PdParam> list(String type, List<String> codes){
        if (CollectionUtils.isEmpty(codes)){
            return new ArrayList<>();
        }
        PdParamExample exp = new PdParamExample();
        PdParamExample.Criteria cri = exp.createCriteria();
        cri.andTypeEqualTo(type);
        cri.andCodeIn(codes);
        return paramMapper.selectByExample(exp);
    }

    public void deleteClass(){
        PdClassExample exp = new PdClassExample();
        classMapper.deleteByExample(exp);
    }

    public void deleteClassQa(){
        PdClassQaExample exp = new PdClassQaExample();
        classQaMapper.deleteByExample(exp);
    }

    public Integer getNextIdxOfSize(){
        Integer result = 1;
        PdParamExample exp = new PdParamExample();
        PdParamExample.Criteria cri = exp.createCriteria();
        cri.andTypeEqualTo("封装及外形尺寸");
        exp.setOrderByClause("idx desc limit 1");
        List<PdParam> size = paramMapper.selectByExample(exp);
        if (size.size() > 0){
            Integer idx = size.get(0).getIdx();
            if (idx != null){
                result = idx + 1;
            }
        }
        return result;
    }
}