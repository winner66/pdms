package com.chk.pdms.fpd.dao;

import com.chk.pdms.fpd.dao.extmapper.ExtFpdSeriesMapper;
import com.chk.pdms.fpd.dao.mapper.FpdMapMapper;
import com.chk.pdms.fpd.dao.mapper.FpdModelMapper;
import com.chk.pdms.fpd.dao.mapper.FpdSeriesMapper;
import com.chk.pdms.pd.dao.extmapper.ExtPdInfoMapper;
import com.chk.pdms.pd.dao.mapper.PdInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class FpdSeriesDao {
    @Autowired
    private FpdSeriesMapper fpdSeriesMapper;
    @Autowired
    private ExtFpdSeriesMapper  extFpdSeriesMapper;

    public  FpdSeriesMapper getSeriesMapper() {
        return fpdSeriesMapper;
    }

    public ExtFpdSeriesMapper getExtFpdSeriesMapper() {
        return extFpdSeriesMapper;
    }
}
