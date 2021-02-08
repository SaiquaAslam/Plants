package com.sprint.plant.configuration;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Saiqua Aslam
 *
 */
@Configuration
@EnableSwagger2
public class ApplicationConfigurationPlant extends WebMvcConfigurationSupport {
	@Bean
	public Docket version1() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.sprint.plant.controller")).paths(regex(".*" + ".*"))
				.build().enable(true).groupName("PLANTS")
				.apiInfo(new ApiInfoBuilder().description("<---PLANTS DETAILS--->")
						.title("******WELCOME TO PLANTS MANAGEMENT SYSTEM*******").build());
	}

	@Override
	protected void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
	}
}
