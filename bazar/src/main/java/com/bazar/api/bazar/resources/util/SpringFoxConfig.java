package com.bazar.api.bazar.resources.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class SpringFoxConfig {

    @Bean
    public Docket api () {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.bazar.api.bazar"))
                .build()
                .apiInfo(infoApi());
    }

    public ApiInfo infoApi () {
        return new ApiInfoBuilder()
                .title("Bazar de Produtos")
                .description("Bazar que comercializa diversos produtos.")
                .build();
    }
}