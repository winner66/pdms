package com.chk.pdms.pd.dao.extmapper;

import com.chk.pdms.pd.vo.PdModelVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ExtPdModelMapper {
    public List<PdModelVo> list(@Param("pcId") Long pcId, @Param("name") String name);
}
