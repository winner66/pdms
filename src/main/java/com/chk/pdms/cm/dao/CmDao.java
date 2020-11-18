package com.chk.pdms.cm.dao;

import com.chk.pdms.cm.dao.mapper.CmContactMapper;
import com.chk.pdms.cm.dao.mapper.UserAccountMapper;
import com.chk.pdms.cm.domain.CmContact;
import com.chk.pdms.cm.domain.CmContactExample;
import com.chk.pdms.cm.domain.UserAccount;
import com.chk.pdms.cm.domain.UserAccountExample;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class CmDao {
    @Autowired
    private CmContactMapper contactMapper;

    @Autowired
    private UserAccountMapper userMapper;

    public CmContactMapper getContactMapper() {
        return contactMapper;
    }

    public UserAccountMapper getUserMapper() {
        return userMapper;
    }

    public List<CmContact> listContact(){
        CmContactExample exp = new CmContactExample();
        exp.setOrderByClause("idx asc");
        return contactMapper.selectByExample(exp);
    }

    public List<CmContact> listContactByType(String type){
        CmContactExample exp = new CmContactExample();
        exp.createCriteria().andTypeEqualTo(type);
        exp.setOrderByClause("idx asc");
        return contactMapper.selectByExample(exp);
    }

    public List<UserAccount> listUser(Date startDate, Date endDate){
        UserAccountExample exp = new UserAccountExample();
        UserAccountExample.Criteria cri = exp.createCriteria();
        if (startDate != null){
            startDate = new DateTime(startDate).withTime(0,0,0,0).toDate();
            cri.andCreateTimeGreaterThanOrEqualTo(startDate);
        }
        if (endDate != null){
            endDate = new DateTime(endDate).withTime(23,59,59,999).toDate();
            cri.andCreateTimeLessThanOrEqualTo(endDate);
        }
        exp.setOrderByClause("id desc");
        return userMapper.selectByExample(exp);
    }
}
