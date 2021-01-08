package com.chk.pdms.pd_material.vo;

import com.chk.pdms.common.vo.TableRsp;
import com.chk.pdms.common.vo.TreeRsp;
import com.chk.pdms.pd.vo.CasRsp;
import com.chk.pdms.pd.vo.SelRsp;
import com.chk.pdms.pd_material.domain.PdInfoMaterial;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class PdMaterialVo extends PdInfoMaterial implements Serializable {
    private String pmName;

    private String pmCode;

    private Long pdClassId;
//    /**
//     * tag 表示 材料的类型，例如： 低通滤波器，1_1
//     */
//    private String tag;

    private List<TableRsp> tag = new ArrayList<>();

    private List<TreeRsp> tag2 = new ArrayList<>();


    public List<TableRsp> getTag() {
        return tag;
    }
    public List<TreeRsp> getTag2() {
        return tag2;
    }
    public void setTag(List<TableRsp> tag) {
        this.tag = tag;
    }
    public void setTag2(List<TreeRsp> tag2) {
        this.tag2 = tag2;
    }
}
