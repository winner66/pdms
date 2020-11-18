package com.chk.pdms.pd.service;

import com.chk.pdms.common.domain.Tree;
import com.chk.pdms.common.vo.Page;
import com.chk.pdms.common.vo.PageReq;
import com.chk.pdms.common.vo.ParamType;
import com.chk.pdms.pd.dao.PdParamDao;
import com.chk.pdms.pd.domain.PdClass;
import com.chk.pdms.pd.domain.PdParam;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class PdParamService {

    @Autowired
    private PdParamDao paramDao;

    public Page<PdParam> list(PdParam param, PageReq pageReq) {
        if (pageReq != null && pageReq.getPageNum() != 0 && pageReq.getPageSize() != 0) {
            PageHelper.startPage(pageReq.getPageNum(), pageReq.getPageSize());
        }
        List<PdParam> params;
        if ("other".equals(param.getType())){
            List<String> types = new ArrayList<>();
            types.add(ParamType.elecCode.value());
            types.add(ParamType.capNum.value());
            types.add(ParamType.elecType.value());
            types.add(ParamType.temperRange.value());
            types.add(ParamType.wireMa.value());
            types.add(ParamType.wireSize.value());
            types.add(ParamType.elecSer.value());
            types.add(ParamType.socStr.value());
            types.add(ParamType.packType.value());
            types.add(ParamType.pin.value());
            params = paramDao.getExtParamMapper().listByType(param, types);
        }else {
            params = paramDao.getExtParamMapper().list(param);
        }

        return new Page(params);
    }

    public List<Tree<PdParam>> gpTree(String type){
        List<Tree<PdParam>> trees = new ArrayList<>();
        List<PdParam> list = paramDao.getExtParamMapper().listGp(type);
        for (PdParam p : list) {
            Tree<PdParam> tree = new Tree<>();
            tree.setId(p.getId().toString());
            tree.setText(p.getGp());
            trees.add(tree);
        }
        return trees;
    }

    public List<PdParam> list4Info(){
        return paramDao.getExtParamMapper().list4Info();
    }

    public List<PdParam> listByType(String type){
        return paramDao.getPdPrams(type);
    }

    public PdParam get(Long id) {
        PdParam info = paramDao.getParamMapper().selectByPrimaryKey(id);
        return info;
    }

    @Transactional
    public void save(PdParam param) {
        if (param.getId() == null) {
            paramDao.getParamMapper().insert(param);
        } else {
            paramDao.getParamMapper().updateByPrimaryKey(param);
        }
    }

    @Transactional
    public void delete(Long id) {
        paramDao.getParamMapper().deleteByPrimaryKey(id);
    }
}
