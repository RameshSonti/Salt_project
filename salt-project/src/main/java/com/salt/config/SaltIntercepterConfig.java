package com.salt.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.salt.intercepter.UserRegistrationIntercepter;

import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;

@Configuration
@Log4j2
public class SaltIntercepterConfig implements WebMvcConfigurer {

	@Autowired
	private UserRegistrationIntercepter userRegistrationIntercepter;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		WebMvcConfigurer.super.addInterceptors(registry);
		log.debug("Registering userRegistrationIntercepter");
		registry.addInterceptor(userRegistrationIntercepter);
		log.debug("Registered");
	}
}
