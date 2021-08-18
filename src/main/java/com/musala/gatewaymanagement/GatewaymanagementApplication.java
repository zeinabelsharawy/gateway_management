package com.musala.gatewaymanagement;

import com.musala.gatewaymanagement.config.JpaAuditingConfiguration;
import io.swagger.annotations.Api;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@Import(JpaAuditingConfiguration.class)
public class GatewaymanagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewaymanagementApplication.class, args);
    }

    @Bean
    public Docket postsApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo()).select()
                .apis(RequestHandlerSelectors.basePackage("com.musala.gatewaymanagement.modules.gateway.rest"))
                .build();
    }

    private ApiInfo apiInfo(){
    	return new ApiInfoBuilder().title("Gateway Management")
				.description("Tool for managing gateways and their associated devices")
				.termsOfServiceUrl("")
				.licenseUrl("")
				.build();
	}

}
