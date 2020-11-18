package com.chk.pdms.fpd.service;


import com.chk.pdms.common.vo.Page;
import com.chk.pdms.common.vo.PageReq;
import com.chk.pdms.common.vo.ParamType;
import com.chk.pdms.fpd.dao.FpdMapDao;
import com.chk.pdms.fpd.dao.FpdModelDao;
import com.chk.pdms.fpd.domain.FpdMap;
import com.chk.pdms.fpd.domain.FpdModel;
import com.chk.pdms.fpd.vo.FpdMapVo;
import com.chk.pdms.fpd.vo.FpdModelVo;
import com.github.pagehelper.PageHelper;
import lombok.SneakyThrows;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class FpdMapService {

    @Autowired
    private FpdMapDao mapDao;

    @SneakyThrows
    public Page<FpdMapVo> list(Long fmId, PageReq pageReq) {
        PageHelper.startPage(pageReq.getPageNum(), pageReq.getPageSize());
        List<FpdMapVo> maps = mapDao.listVo(fmId);
        for (FpdMapVo map : maps) {
            for (ParamType value : ParamType.values()) {
                if (value.value().equals(map.getParamType())){
                    map.setParamType(value.title());
                }
            }
        }
        Page<FpdMapVo> page = new Page(maps);
        return page;
    }

    @SneakyThrows
    public FpdMap get(Long id) {
        FpdMap map = mapDao.getMapMapper().selectByPrimaryKey(id);
        return map;
    }

    @SneakyThrows
    @Transactional
    public boolean save(FpdMap map) {
        FpdMap exist = this.mapDao.get(map.getFpdModelId(), map.getParamType(), map.getFcode());
        if (exist != null && !exist.getId().equals(map.getId())){
            return false;
        }
        if (map.getId() == null) {
            mapDao.getMapMapper().insert(map);
        } else {
            mapDao.getMapMapper().updateByPrimaryKey(map);
        }
        return true;
    }

    @Transactional
    public void delete(Long id) {
        mapDao.getMapMapper().deleteByPrimaryKey(id);
    }
}
