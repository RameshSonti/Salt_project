package com.salt.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.salt.core.entity.UserInfo;
import com.salt.user.repository.UserInfoRepository;

public class UserServiceImpl implements UserService {

	@Autowired
	private UserInfoRepository userInfoRepository;

	@Override
	public UserInfo create(UserInfo userInfo) {
		UserInfo user = userInfoRepository.save(userInfo);
		return user;
	}
}
