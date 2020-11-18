package com.chk.pdms.pd.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class ImportDataVo {

    @JsonIgnore
    private MultipartFile data;

    private String code;

    private String msg;
}
