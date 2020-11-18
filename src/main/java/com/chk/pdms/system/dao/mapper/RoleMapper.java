package com.chk.pdms.system.dao.mapper;

import com.chk.pdms.system.domain.RoleDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 角色
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2017-10-02 20:24:47
 */
@Mapper
public interface RoleMapper {

	RoleDO get(Long roleId);
	
	List<RoleDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(RoleDO role);
	
	int update(RoleDO role);
	
	int remove(Long roleId);
	
	int batchRemove(Long[] roleIds);
}
