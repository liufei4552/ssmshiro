package com.beautifulsoup.shiro.ssmdemo.realm;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.beautifulsoup.shiro.ssmdemo.entity.Permission;
import com.beautifulsoup.shiro.ssmdemo.entity.User;
import com.beautifulsoup.shiro.ssmdemo.mapper.ShiroDemoMapper;
import com.beautifulsoup.shiro.ssmdemo.mapper.UserCustomMapper;
import com.beautifulsoup.shiro.ssmdemo.vo.RoleCustom;
import com.beautifulsoup.shiro.ssmdemo.vo.UserCustom;

/**
 * @Name: ShiroDemoRealm.java
 * @Description: 自定义Realm完成用户认证与授权,数据从数据库中获取
 * @Author: BeautifulSoup
 * @Date: 2017年12月16日 上午2:21:58
 */
@Component
public class ShiroDemoRealm extends AuthorizingRealm{
	private static final String TAG= "CUSTOMREALM";
	
	@Autowired
	private UserCustomMapper customMapper;
	@Autowired
	private ShiroDemoMapper mapper;
	/**
	 * 完成授权
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		//得到认证成功之后凭证的身份信息
		String username=((User) principals.getPrimaryPrincipal()).getUsername();
		//查询数据库得到所有的权限列表
		List<String> permissionList=new ArrayList<String>();
		UserCustom userCustom = customMapper.findUserCustomByUsername(username);
		Set<RoleCustom> roles=userCustom.getRoleSet();
		for(RoleCustom role:roles){
			Set<Permission> permissionSet = role.getPermissionSet();
			for (Permission permission:permissionSet) {
				permissionList.add(permission.getPname());
			}
		}
		SimpleAuthorizationInfo authorizationInfo=new SimpleAuthorizationInfo();
		authorizationInfo.addStringPermissions(permissionList);
		return authorizationInfo;
	}
	/**
	 * 完成认证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		String username=(String) token.getPrincipal();
		User user = mapper.findByUsername(username);
		if(null!=user){
			SimpleAuthenticationInfo authenticationInfo=new SimpleAuthenticationInfo(user, user.getPassword(),
					ByteSource.Util.bytes(user.getSalt()),TAG);
			return authenticationInfo;
		}
		return null;
	}
	

}
