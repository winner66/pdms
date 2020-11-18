package com.chk.pdms.cm.service;


import com.chk.pdms.cm.dao.CmDao;
import com.chk.pdms.cm.domain.CmContact;
import com.chk.pdms.common.vo.Page;
import com.chk.pdms.common.vo.PageReq;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CmContactService {

    @Autowired
    private CmDao cmDao;

    public Page<CmContact> list(PageReq pageReq){
        PageHelper.startPage(pageReq.getPageNum(), pageReq.getPageSize());
        List<CmContact> contacts = cmDao.listContact();
        return new Page(contacts);
    }

    public CmContact get(Long id){
        return cmDao.getContactMapper().selectByPrimaryKey(id);
    }

    @Transactional
    public void save(CmContact contact){
        if (contact.getId() == null){
            cmDao.getContactMapper().insert(contact);
        }else{
            cmDao.getContactMapper().updateByPrimaryKey(contact);
        }
    }

    @Transactional
    public void delete(Long id){
        cmDao.getContactMapper().deleteByPrimaryKey(id);
    }

    public List<CmContact> listContactByType(String type){
        return cmDao.listContactByType(type);
    }
}
