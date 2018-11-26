package com.beautifulsoup.shiro.ssmdemo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.beautifulsoup.shiro.ssmdemo.entity.User;
import com.beautifulsoup.shiro.ssmdemo.entity.UserExample;

public interface UserMapper {
    int countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Integer uid);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);
    User selectByPrimaryKey(Integer uid);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}