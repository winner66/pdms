package com.chk.pdms.pd.dao;

import com.chk.pdms.pd.dao.extmapper.ExtPdInfoMapper;
import com.chk.pdms.pd.dao.mapper.PdInfoMapper;
import com.chk.pdms.pd.vo.PdSkVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PdInfoDao {

    @Autowired
    private PdInfoMapper infoMapper;

    @Autowired
    private ExtPdInfoMapper extInfoMapper;

    public PdInfoMapper getInfoMapper() {
        return infoMapper;
    }

    public ExtPdInfoMapper getExtInfoMapper() {
        return extInfoMapper;
    }
}
