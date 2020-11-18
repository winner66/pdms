package com.chk.pdms.fpd.service;


import com.chk.pdms.common.vo.Page;
import com.chk.pdms.common.vo.PageReq;
import com.chk.pdms.common.vo.ParamType;
import com.chk.pdms.fpd.dao.FpdModelDao;
import com.chk.pdms.fpd.domain.FpdModel;
import com.chk.pdms.fpd.vo.FpdModelVo;
import com.github.pagehelper.PageHelper;
import lombok.SneakyThrows;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FpdModelService {

    @Autowired
    private FpdModelDao modelDao;

    @SneakyThrows
    public Page<FpdModel> list(String name, PageReq pageReq) {
        PageHelper.startPage(pageReq.getPageNum(), pageReq.getPageSize());
        List<FpdModel> models = modelDao.list(name);
        for (FpdModel model : models) {
            String orderRule = model.getOrderRule();
            orderRule = StringUtils.replace(orderRule, "|", "");
            for (ParamType value : ParamType.values()) {
                orderRule = StringUtils.replace(orderRule, value.value(), value.title());
            }
            model.setOrderRule(orderRule);
        }
        Page<FpdModel> page = new Page(models);
        return page;
    }

    @SneakyThrows
    public FpdModel get(Long id) {
        FpdModel model = modelDao.getModelMapper().selectByPrimaryKey(id);
        FpdModelVo vo = new FpdModelVo();
        BeanUtils.copyProperties(vo, model);
        vo.arrayOR();
        return vo;
    }

    @SneakyThrows
    @Transactional
    public void save(FpdModel model) {
        if (model.getId() == null) {
            modelDao.getModelMapper().insert(model);
        } else {
            modelDao.getModelMapper().updateByPrimaryKey(model);
        }
    }

    @Transactional
    public void delete(Long id) {
        modelDao.getModelMapper().deleteByPrimaryKey(id);
    }

    public void formatOrderRule() {
        List<FpdModel> models = this.modelDao.list(null);
        for (FpdModel model : models) {
            String rule = model.getOrderRule();
            String format = formatOR(rule);
            FpdModel pm = new FpdModel();
            pm.setId(model.getId());
            pm.setOrderRule(format);
            this.modelDao.getModelMapper().updateByPrimaryKeySelective(pm);
        }
    }

    private static String formatOR(String rule){
        for (ParamType type : ParamType.values()) {
            rule = StringUtils.replace(rule, type.value(), type.value() + "||");
        }
        if (StringUtils.endsWith(rule, "||")){
            rule = StringUtils.substringBeforeLast(rule,"||");
        }
        rule = StringUtils.replace(rule, "||-", "|-|");
        rule = StringUtils.replace(rule, "|| ", "| |");
        return rule;
    }
}
