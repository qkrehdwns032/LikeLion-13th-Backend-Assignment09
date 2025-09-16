package com.likelion.likelionSwagger.global.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//@OpenAPIDefinition(info = @Info(title = "Swagger Test App", description = "description", version = "7.7")) info객체를 생성하는게 더 많은 정보 + 가독성.
public class SwaggerConfiguration {

    @Bean
    public OpenAPI swaggerConfig(){

        Info info = new Info()
            .title("Swagger Test App")
            .description("description : 스프링 스웨거 설명을 위한 앱 입니다.")
            .version("7.7");

        //Components는 Swagger api에서 공통으로 재사용되는 구성요소들을 담는 객체
        //Components → 인증 방식을 정의 (JWT, Basic 등)
        Components components = new Components()
            .addSecuritySchemes("Authorization",
                new SecurityScheme()
                    .type(SecurityScheme.Type.HTTP)
                    .scheme("bearer")
                    .bearerFormat("JWT"));

        return new OpenAPI()
            .info(info)
            .components(components)
            .addSecurityItem(
                new SecurityRequirement().addList("Authorization"));
        //SecurityRequirement → API가 이 인증 방식을 요구한다고 명시
    }
}

