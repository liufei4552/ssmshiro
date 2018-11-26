package com.beautifulsoup.shiro.ssmdemo.mapper;

import com.beautifulsoup.shiro.ssmdemo.vo.UserCustom;

/**
 * @Name: UserCustomMapper
 * @Description: 
 * @Author: BeautifulSoup
 * @Date: 2017年12月16日 下午2:22:46
 */
public interface UserCustomMapper {
	UserCustom findUserCustomByUsername(String username);
}
