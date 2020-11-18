package com.chk.pdms.pd.dao.extmapper;

import com.chk.pdms.pd.domain.PdInfo;
import com.chk.pdms.pd.vo.PdFtVo;
import com.chk.pdms.pd.vo.PdInfoVo;
import com.chk.pdms.pd.vo.PdSkVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ExtPdInfoMapper {
    public List<PdInfoVo> list(@Param("key") String key);

    public void updateSearchKey(@Param("pdsks") List<PdSkVo> pdsks);

    public List<PdFtVo> listFt();

    @Deprecated
    public void insert(@Param("infos")List<PdInfo> pdInfos);

}
