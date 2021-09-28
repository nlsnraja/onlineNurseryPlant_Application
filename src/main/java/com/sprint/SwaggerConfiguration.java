package com.sprint;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.BasicAuth;
import springfox.documentation.service.Contact;
import springfox.documentation.service.HttpAuthenticationScheme;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.service.SecurityScheme;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * Indicates that this is a "Swagger Configuration ", developed for the sprint
 * project "Online Plant Nursery Application" This class is developed for
 * configuring swagger in spring boot in order to test the API documentations
 * and also implement spring security techniques.
 * 
 * @Date 26.09.2021
 * @authors Manju Bashini,Lydia Oswald,Nelson Raja,Kirthika
 **/

//SWAGGER CONFIGURATON FOR API DOCUMENTATION
@Configuration
//@EnableSwagger2
public class SwaggerConfiguration {
	private static final String BASIC_AUTH = "basicAuth";

	// CREATING BEAN OF DOCKET
	@Bean
	public Docket api() {
		HttpAuthenticationScheme authenticationScheme = HttpAuthenticationScheme.BASIC_AUTH_BUILDER
				.name("Basic Authentication").build();

		// RETURNS DOCKET
		return new Docket(DocumentationType.OAS_30).select().apis(RequestHandlerSelectors.basePackage("com.sprint"))
				.paths(PathSelectors.any()).build().apiInfo(apiEndPointInfo())
				.securitySchemes(Collections.singletonList(authenticationScheme)).securitySchemes(securitySchemes())
				.securityContexts(List.of(securityContext()));
	}

	// API INFORMATION
	public ApiInfo apiEndPointInfo() {
		return new ApiInfoBuilder().title("ONLINE NURSERY PLANT APPLICATION").description("Customer API")
				.contact(new Contact("NurseryPlant", "https://nurseryplant.com", "plant@gmail.com"))
				.license("Apache 2.0").licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
				.version("0.0.1-SNAPSHOT").build();
	}

	// RETURNS LIST OF SECURITY SCHEME
	private List<SecurityScheme> securitySchemes() {
		return List.of(new BasicAuth(BASIC_AUTH));
	}

	// RETURNS SECURITY CONTEXT
	private SecurityContext securityContext() {
		return SecurityContext.builder().securityReferences(Arrays.asList(basicAuthReference())).build();
	}

	// RETURNS SECURITY REFERENCE
	private SecurityReference basicAuthReference() {
		return new SecurityReference(BASIC_AUTH, new AuthorizationScope[0]);
	}
}
