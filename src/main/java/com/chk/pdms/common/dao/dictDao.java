package com.chk.pdms.common.dao;

import com.chk.pdms.common.dao.mapper.DictMapper;
import com.chk.pdms.common.domain.DictDO;
import com.chk.pdms.common.domain.DictExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class dictDao {
    @Autowired
    DictMapper dictMapper;

    Boolean hasNext(Long id){
        List<DictDO>  lists= dictMapper.hasNext(id);
        if(lists.size()<1){
            return false;

        }
        return  true;

    }
    List<DictDO>  hasAllNext(Long id){
        List<DictDO>  lists= dictMapper.hasNext(id);
        return lists;
    }
    public List<DictDO> listByType(String type){
        DictExample exp = new DictExample();
        exp.createCriteria().andTypeEqualTo(type);
        exp.setOrderByClause("sort asc");
        return dictMapper.selectByExample(exp);
    }

}
