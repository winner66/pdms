package com.chk.pdms.common.service;

import com.chk.pdms.common.utils.StringUtils;
import com.chk.pdms.system.domain.UserDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import com.chk.pdms.common.dao.mapper.DictMapper;
import com.chk.pdms.common.domain.DictDO;
import com.chk.pdms.common.service.DictService;


@Service
public class DictService {
    @Autowired
    private DictMapper dictMapper;

    public DictDO get(Long id) {
        return dictMapper.get(id);
    }


    public List<DictDO> list(Map<String, Object> map) {
        return dictMapper.list(map);
    }


    public int count(Map<String, Object> map) {
        return dictMapper.count(map);
    }


    public int save(DictDO dict) {
        return dictMapper.save(dict);
    }


    public int update(DictDO dict) {
        return dictMapper.update(dict);
    }


    public int remove(Long id) {
        return dictMapper.remove(id);
    }


    public int batchRemove(Long[] ids) {
        return dictMapper.batchRemove(ids);
    }


    public List<DictDO> listType() {
        return dictMapper.listType();
    }


    public String getName(String type, String value) {
        Map<String, Object> param = new HashMap<String, Object>(16);
        param.put("type", type);
        param.put("value", value);
        String rString = dictMapper.list(param).get(0).getName();
        return rString;
    }


    public List<DictDO> getHobbyList(UserDO userDO) {
        Map<String, Object> param = new HashMap<>(16);
        param.put("type", "hobby");
        List<DictDO> hobbyList = dictMapper.list(param);

        if (StringUtils.isNotEmpty(userDO.getHobby())) {
            String userHobbys[] = userDO.getHobby().split(";");
            for (String userHobby : userHobbys) {
                for (DictDO hobby : hobbyList) {
                    if (!Objects.equals(userHobby, hobby.getId().toString())) {
                        continue;
                    }
                    hobby.setRemarks("true");
                    break;
                }
            }
        }

        return hobbyList;
    }


    public List<DictDO> getSexList() {
        Map<String, Object> param = new HashMap<>(16);
        param.put("type", "sex");
        return dictMapper.list(param);
    }


    public List<DictDO> listByType(String type) {
        Map<String, Object> param = new HashMap<>(16);
        param.put("type", type);
        param.put("orderSort", "sort");
        param.put("order", "asc");
        return dictMapper.list(param);
    }

}
