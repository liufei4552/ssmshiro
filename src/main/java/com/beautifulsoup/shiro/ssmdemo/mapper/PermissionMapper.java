package com.beautifulsoup.shiro.ssmdemo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.beautifulsoup.shiro.ssmdemo.entity.Permission;
import com.beautifulsoup.shiro.ssmdemo.entity.PermissionExample;

public interface PermissionMapper {
    int countByExample(PermissionExample example);

    int deleteByExample(PermissionExample example);

    int deleteByPrimaryKey(Integer pid);

    int insert(Permission record);

    int insertSelective(Permission record);

    List<Permission> selectByExample(PermissionExample example);

    Permission selectByPrimaryKey(Integer pid);

    int updateByExampleSelective(@Param("record") Permission record, @Param("example") PermissionExample example);

    int updateByExample(@Param("record") Permission record, @Param("example") PermissionExample example);

    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKey(Permission record);
}