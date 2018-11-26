package com.beautifulsoup.shiro.ssmdemo.test;

import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

public class TestJm {
	public static void main(String[] args) {
		System.out.println(ByteSource.Util.bytes("1997password"));


			int hashIterations = 3;//加密的次数
			Object salt = ByteSource.Util.bytes("1997password");//盐值
			Object credentials = "123456";//密码
			String hashAlgorithmName = "MD5";//加密方式
			Object simpleHash = new SimpleHash(hashAlgorithmName, credentials,
					salt, hashIterations);
			System.out.println("加密后的值----->" + simpleHash);

	}
}
