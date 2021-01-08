package com.chk.pdms.common.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class TreeRsp  implements Serializable {

    private static final long serialVersionUID = 1L;
    private   String value;
    private String label;


    private  List<TreeRsp> children;
    private  boolean hasChildren;


    public TreeRsp(String title, String value) {
        this.label = title;
        this.value = value;
        this.hasChildren=false;
    }
    public TreeRsp(String title, String value, Boolean hasChildren) {
        this.label = title;
        this.value = value;
        this.hasChildren=hasChildren;
        if(hasChildren){
            children= new ArrayList<>();
        }
    }
    public  void setChild(Boolean is){
        if(is){
            if(this.children==null){
                children= new ArrayList<>();
                this.hasChildren=is;
            }
        }else{
//           删除子类
            if(this.children!=null){
                    children=null;
                this.hasChildren=is;
            }
        }
    }

}
