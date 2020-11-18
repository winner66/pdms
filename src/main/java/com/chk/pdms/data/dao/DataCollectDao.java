package com.chk.pdms.data.dao;

import com.chk.pdms.data.dao.extmapper.ExtDataCollectMapper;
import com.chk.pdms.data.dao.mapper.DataCollectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DataCollectDao {
    @Autowired
    private DataCollectMapper collectMapper;

    @Autowired
    private ExtDataCollectMapper extCollectMapper;

    public DataCollectMapper getCollectMapper() {
        return collectMapper;
    }

    public ExtDataCollectMapper getExtCollectMapper() {
        return extCollectMapper;
    }
}
