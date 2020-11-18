package com.chk.pdms.fpd.dao.extmapper;

import com.chk.pdms.fpd.vo.FpdMapVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ExtFpdMapMapper {
    public List<FpdMapVo> list(@Param("fmId") Long fmId);

}
