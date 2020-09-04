package com.salt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.salt.core.entity.UserInfo;
import com.salt.core.util.Constant;
import com.salt.core.vo.ServiceResponse;
import com.salt.service.UserInfoService;

@SuppressWarnings("rawtypes")
@RestController
@RequestMapping("admin")
public class UserController implements IRestController {

	@Autowired
	private UserInfoService userInfoService;

	@SuppressWarnings("unchecked")
	@PostMapping("/register")
	public ResponseEntity<ServiceResponse<UserInfo>> register(@RequestParam UserInfo userInfo) {
		return buildResponse(userInfoService.create(userInfo));
	}

	@SuppressWarnings("unchecked")
	@GetMapping("/employees")
	public ResponseEntity<ServiceResponse<List<UserInfo>>> getAllEmployee() {
		List<UserInfo> list = userInfoService.listAllByRole(Constant.ROLE_EMPLOYEE);
		return buildResponse(list);
	}

	@SuppressWarnings("unchecked")
	@GetMapping("/customers")
	public ResponseEntity<ServiceResponse<List<UserInfo>>> getAllCustomers() {
		return buildResponse(userInfoService.listAllByRole(Constant.ROLE_CUSTOMER));
	}

}
