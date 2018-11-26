package com.beautifulsoup.shiro.ssmdemo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.beautifulsoup.shiro.ssmdemo.entity.PermissionRole;
import com.beautifulsoup.shiro.ssmdemo.entity.PermissionRoleExample;

public interface PermissionRoleMapper {
    int countByExample(PermissionRoleExample example);

    int deleteByExample(PermissionRoleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PermissionRole record);

    int insertSelective(PermissionRole record);

    List<PermissionRole> selectByExample(PermissionRoleExample example);

    PermissionRole selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PermissionRole record, @Param("example") PermissionRoleExample example);

    int updateByExample(@Param("record") PermissionRole record, @Param("example") PermissionRoleExample example);

    int updateByPrimaryKeySelective(PermissionRole record);

    int updateByPrimaryKey(PermissionRole record);
}