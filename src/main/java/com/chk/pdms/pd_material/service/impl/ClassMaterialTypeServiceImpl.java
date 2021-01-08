package com.chk.pdms.pd_material.service.impl;

//import com.chk.pdms.common.exception.BusinessException;
import com.chk.pdms.common.exception.BusinessException;
import com.chk.pdms.pd_material.service.ClassMaterialTypeService;
import com.chk.pdms.pd_material.dao.ClassMaterialTypeDao;
import com.chk.pdms.pd_material.domain.ClassMaterialType;
import com.chk.pdms.pd_material.domain.ClassMaterialTypeExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
//
@Service("ClassMaterialTypeService")
public class ClassMaterialTypeServiceImpl implements ClassMaterialTypeService {
    @Autowired
    private ClassMaterialTypeDao classMaterialTypeDao;

    public List<ClassMaterialType> get(){

        List<ClassMaterialType> res=classMaterialTypeDao.getExClassMaterialmapper().List();
        return  res;
    }
    public Map<String,List<ClassMaterialType>> getcla(){

        List<ClassMaterialType> CMS=classMaterialTypeDao.getExClassMaterialmapper().List();
        Set<String> set=new HashSet<>();
        for(ClassMaterialType r1: CMS){
            set.add(r1.getClassName());
        }
        Map<String,List<ClassMaterialType>> res= new HashMap<>();
        for(ClassMaterialType r1: CMS){
           if(set.contains(r1.getClassName())){
               if(res.containsKey(r1.getClassName())){
                   List<ClassMaterialType> tem=res.get(r1.getClassName());
                   tem.add(r1);
               }else{
                   List<ClassMaterialType> tem= new ArrayList<>();
                   tem.add(r1);
                   res.put(r1.getClassName(),tem);
               }
           }
        }
        return  res;
    }

    public String getMatrialtypeByclassId(Integer classId){

        ClassMaterialTypeExample example= new ClassMaterialTypeExample();
        example.createCriteria().andClassIdEqualTo(classId);
        List<ClassMaterialType> types=classMaterialTypeDao.getClassMaterialmapper().selectByExample(example);
        if(types.size()<=0){
          throw  new BusinessException("材料器件表没有对应的class——id");
        }
        Set<Integer> typeset= new HashSet<>() ;
        for(ClassMaterialType type:types){
            typeset.add(type.getMaterialType());

        }
        if(typeset.size()>1){
            throw  new BusinessException("材料器件表class——id对应的type数据出错（有多个）");
        }
        String res=types.get(0).getMaterialType()+"_"+types.get(0).getMaterialType2();
        return res;
    }


}
