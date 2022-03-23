package com.jay.ue4_login.dao;

import com.jay.ue4_login.entity.UeUser;
import com.jay.ue4_login.entity.UeUserExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UeUserMapper {
    long countByExample(UeUserExample example);

    int deleteByExample(UeUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UeUser record);

    int insertSelective(UeUser record);

    List<UeUser> selectByExample(UeUserExample example);

    UeUser selectByPrimaryKey(Integer id);

    UeUser selectByAccount(String account);

    int updateByExampleSelective(@Param("record") UeUser record, @Param("example") UeUserExample example);

    int updateByExample(@Param("record") UeUser record, @Param("example") UeUserExample example);

    int updateByPrimaryKeySelective(UeUser record);

    int updateByAccountSelective(UeUser record);

    int updateByPrimaryKey(UeUser record);
}