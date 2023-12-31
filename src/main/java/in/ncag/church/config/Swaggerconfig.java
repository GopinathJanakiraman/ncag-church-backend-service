package in.ncag.church.config;


import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swaggerconfig 
{
	@Bean
	public Docket api() {
		List<springfox.documentation.service.Parameter> parameters = new ArrayList<>();
		parameters.add(new ParameterBuilder()
            .name("Authorization")
            .description("Access token")
            .modelRef(new ModelRef("string"))
            .parameterType("header")
            .required(false)
            .build());
		
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("in.ncag.church.controller")).paths(PathSelectors.any())
				.build().apiInfo(apiInfo())
				.globalOperationParameters(parameters);
	}
	
	public ApiInfo apiInfo()
	{
		return new ApiInfoBuilder()
				.title("NCAG Church")
				.version("1.0")
	            .description("NCAG Church Admin Services")
	            .build();
				
	}
	
}
