package com.chk.pdms.data.dao.extmapper;

import com.chk.pdms.data.vo.ClassVo;
import com.chk.pdms.pd.domain.PdInfo;
import com.chk.pdms.pd.domain.PdModel;
import com.chk.pdms.pd.domain.PdParam;
import com.chk.pdms.pd.vo.PdInfoVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DataMapper {
    public void insertInfo(@Param("infos") List<PdInfo> infos);
    public void insertModel(@Param("models") List<PdModel> models);
    public void insertParam(@Param("params") List<PdParam> params);
    public List<ClassVo> listClz();
    public void updateModelOR(@Param("models") List<PdModel> models);

    public List<PdInfoVo> get(@Param("info") PdInfo info);
}
