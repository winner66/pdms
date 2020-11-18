package com.chk.pdms.cm.service;

import com.chk.pdms.cm.dao.CmDao;
import com.chk.pdms.cm.domain.UserAccount;
import com.chk.pdms.common.vo.Page;
import com.chk.pdms.common.vo.PageReq;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CmUserService {
    @Autowired
    private CmDao cmDao;

    public Page<UserAccount> list(Date startDate, Date endDate, PageReq pageReq) {
        PageHelper.startPage(pageReq.getPageNum(), pageReq.getPageSize());
        List<UserAccount> users = cmDao.listUser(startDate, endDate);
        return new Page(users);
    }
}
