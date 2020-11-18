package com.chk.pdms.cm.dao.mapper;

import com.chk.pdms.cm.domain.UserAccount;
import com.chk.pdms.cm.domain.UserAccountExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface UserAccountMapper {
    long countByExample(UserAccountExample example);

    int deleteByExample(UserAccountExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserAccount record);

    int insertSelective(UserAccount record);

    List<UserAccount> selectByExampleWithRowbounds(UserAccountExample example, RowBounds rowBounds);

    List<UserAccount> selectByExample(UserAccountExample example);

    UserAccount selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UserAccount record, @Param("example") UserAccountExample example);

    int updateByExample(@Param("record") UserAccount record, @Param("example") UserAccountExample example);

    int updateByPrimaryKeySelective(UserAccount record);

    int updateByPrimaryKey(UserAccount record);
}