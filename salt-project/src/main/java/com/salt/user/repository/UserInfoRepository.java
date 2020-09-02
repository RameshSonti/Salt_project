package com.salt.user.repository;

import org.springframework.data.repository.CrudRepository;

import com.salt.core.entity.UserInfo;

public interface UserInfoRepository extends CrudRepository<UserInfo, Long> {

}
