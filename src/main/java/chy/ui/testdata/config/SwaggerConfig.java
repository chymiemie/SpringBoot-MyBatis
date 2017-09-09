package chy.ui.testdata.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
				.apis(RequestHandlerSelectors.basePackage("chy.ui.testdata.controller")).paths(PathSelectors.any())
				.build();
	}

	@Bean
	public ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("MySQL RESTFUL APIS").description("UI界面测试数据的 APIS操作").version("0.0.1")
				.build();
	}
}
