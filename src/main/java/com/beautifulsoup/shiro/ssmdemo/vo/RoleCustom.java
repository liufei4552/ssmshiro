package com.beautifulsoup.shiro.ssmdemo.vo;

import java.util.HashSet;
import java.util.Set;

import com.beautifulsoup.shiro.ssmdemo.entity.Permission;
import com.beautifulsoup.shiro.ssmdemo.entity.Role;

/**
 * @Name: RoleCustom.java
 * @Description: 自定义的扩展类
 * @Author: BeautifulSoup
 * @Date: 2017年12月16日 下午2:20:38
 */
public class RoleCustom extends Role{
	private Set<Permission> permissionSet=new HashSet<Permission>();
	public Set<Permission> getPermissionSet() {
		return permissionSet;
	}

	public void setPermissionSet(Set<Permission> permissionSet) {
		this.permissionSet = permissionSet;
	}
}
