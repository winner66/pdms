package com.chk.pdms.data.service;

import com.chk.pdms.common.vo.Page;
import com.chk.pdms.common.vo.PageReq;
import com.chk.pdms.data.dao.DataCollectDao;
import com.chk.pdms.data.vo.DcVo;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataCollectService {

    @Autowired
    private DataCollectDao collectDao;

    public Page<DcVo> list(DcVo dc, PageReq pageReq){
        PageHelper.startPage(pageReq.getPageNum(), pageReq.getPageSize());
        dc.setPage("产品列表页");
        dc.setEvent("查看产品");
        List<DcVo> list = collectDao.getExtCollectMapper().list(dc);
        return new Page(list);
    }

    public Page<DcVo> listDate(DcVo dc, PageReq pageReq){
        PageHelper.startPage(pageReq.getPageNum(), pageReq.getPageSize());
        dc.setPage("产品列表页");
        dc.setEvent("查看产品");
        List<DcVo> list = collectDao.getExtCollectMapper().listDate(dc);
        return new Page(list);
    }
}
