package com.chk.pdms.common.dao.mapper;

import com.chk.pdms.common.domain.DictDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 字典表
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2017-10-03 15:45:42
 */
@Mapper
public interface DictMapper {

	DictDO get(Long id);

	List<DictDO> list(Map<String, Object> map);
	List<DictDO> listAll();

	List<DictDO> hasNext(Long id);
	List<DictDO> Next(Long id);
	int count(Map<String, Object> map);

	int save(DictDO dict);

	int update(DictDO dict);

	int remove(Long id);

	int batchRemove(Long[] ids);

	List<DictDO> listType();


}
