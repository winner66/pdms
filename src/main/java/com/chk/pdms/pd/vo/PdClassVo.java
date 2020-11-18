package com.chk.pdms.pd.vo;

import com.chk.pdms.common.utils.FileUtil;
import com.chk.pdms.pd.domain.PdClass;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class PdClassVo extends PdClass {
    @JsonIgnore
    private MultipartFile iconImg;

    public String getShowIcon(){
        return FileUtil.unRenameUploadFile(this.getIconUrl());
    }
}
