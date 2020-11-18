package com.chk.pdms.pd.dao.extmapper;

import com.chk.pdms.pd.domain.PdParam;
import com.chk.pdms.pd.vo.PdInfoVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ExtPdParamMapper {
    public List<PdParam> list(@Param("param") PdParam param);

    public List<PdParam> listByType(@Param("param") PdParam param, List<String> types);

    public List<PdParam> listGp(String type);

    public List<PdParam> list4Info();

}
