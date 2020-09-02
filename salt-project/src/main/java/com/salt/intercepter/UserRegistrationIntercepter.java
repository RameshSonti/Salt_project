package com.salt.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.salt.core.util.Constant;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class UserRegistrationIntercepter implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		Object obj = request.getAttribute("role");
		log.debug("role:", obj);
		if (obj == null) {
			request.setAttribute("role", Constant.ROLE_CUSTOMER);
			log.debug(Constant.ROLE_CUSTOMER + " role added to request");
		}
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}
}
