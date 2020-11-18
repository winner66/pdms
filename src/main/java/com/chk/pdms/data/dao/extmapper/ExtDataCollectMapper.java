package com.chk.pdms.data.dao.extmapper;

import com.chk.pdms.data.vo.DcVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ExtDataCollectMapper {
    public List<DcVo> list(@Param("dc") DcVo dc);

    public List<DcVo> listDate(@Param("dc") DcVo dc);
}
