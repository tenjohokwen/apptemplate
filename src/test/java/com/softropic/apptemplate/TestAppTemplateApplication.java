package com.softropic.apptemplate;

import com.softropic.apptemplate.config.TestConfig;

import org.springframework.boot.SpringApplication;

public class TestAppTemplateApplication {

	public static void main(String[] args) {
		SpringApplication.from(AppTemplateApplication::main).with(TestConfig.class).run(args);
	}

}
