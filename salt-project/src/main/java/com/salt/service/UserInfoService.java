package com.salt.service;

import java.util.List;

import com.salt.core.entity.UserInfo;

public interface UserInfoService {

	public UserInfo create(UserInfo userInfo);

	public List<UserInfo> listAll();

	public List<UserInfo> listAllByRole(String role);

}
