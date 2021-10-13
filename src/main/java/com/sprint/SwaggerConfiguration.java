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
	  @Bean
    public Docket api() {
        return new Docket(DocumentationType.OAS_30)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.sprint"))
                .paths(PathSelectors.any())
                .build().apiInfo(apiEndPointInfo());
        
    }
    public ApiInfo apiEndPointInfo() {
        return new ApiInfoBuilder().title("Online Nursery Plant Application")
                .description("Plant Nursery")
                .licenseUrl("http://www.apache.org/licenses/LICENCE-2.0.html")
                .version("0.0.1-SNAPSHOT")
                .build();
    }
}
