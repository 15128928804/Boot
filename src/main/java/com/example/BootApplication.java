package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@RequestMapping
@RestController
@Configuration
@EnableSwagger2
public class BootApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootApplication.class, args);
	}

	@RequestMapping("/")
	public String init() {
		return "Spring Boot";
	}

	/**
	 * @Author：zhuangfei
	 * @Description：启用 swagger2 自动构建API文档
	 * PS : 如果不想写在启动类的话，另写的类必须与启动类平级
	 * @Date：15:15 2017/11/8
	 */
	@Bean
	public Docket createApi() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
					.apis(RequestHandlerSelectors.basePackage("com.example"))
					.paths(PathSelectors.any()).build();
	}

	public ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("API文档")
				.description("API参数定义")
				.termsOfServiceUrl("http://blog.csdn.net/qq_31001665")
				.contact("SpringBoot")
				.version("1.0")
				.build();
	}

}
