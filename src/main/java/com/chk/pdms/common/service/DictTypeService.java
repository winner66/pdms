package com.chk.pdms.common.service;

import com.chk.pdms.common.dao.mapper.DictMapper;
import com.chk.pdms.common.dao.mapper.SysDictTypeMapper;
import com.chk.pdms.common.domain.DictDO;
import com.chk.pdms.common.domain.SysDictType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DictTypeService {
    @Autowired
    private SysDictTypeMapper sysDictTypeMapper;
    public int save(SysDictType dict) {
        return sysDictTypeMapper.insertSelective(dict);
    }
    public int update(SysDictType dict) {
        return sysDictTypeMapper.updateByPrimaryKey(dict);    }

    public int remove(Long id) {
        return sysDictTypeMapper.deleteByPrimaryKey(id);
    }

    public int batchRemove(Long[] ids) {
        return sysDictTypeMapper.batchRemove(ids);
    }

    public List<SysDictType> list() {
        return sysDictTypeMapper.list();
    }

}
