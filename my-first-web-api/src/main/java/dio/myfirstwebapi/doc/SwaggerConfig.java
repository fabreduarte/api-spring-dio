package dio.myfirstwebapi.doc;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	private Contact contato() {
		return new Contact(
				"Seu Nome",
				"http://www.site.com.br",
				"email@email.com.br");
	}

	private ApiInfoBuilder informacoesApi() {
		ApiInfoBuilder apiInfobuilder = new ApiInfoBuilder();

		apiInfobuilder.title("Title - Rest Api");
		apiInfobuilder.description("Exemplo de api em SpringBoot - REST API");
		apiInfobuilder.version("1.0");
		apiInfobuilder.termsOfServiceUrl("Open Source");
		apiInfobuilder.license("Minha licença");
		apiInfobuilder.licenseUrl("http://site.com.br");
		apiInfobuilder.contact(this.contato());

		return apiInfobuilder;
	}

	@Bean
	public Docket detalheApi() {
		Docket docket = new Docket(DocumentationType.SWAGGER_2);

		docket
				.select()
				.apis(RequestHandlerSelectors.basePackage("dio.myfirstwebapi.controller"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(this.informacoesApi().build())
				.consumes(new HashSet<String>(Arrays.asList("application/json")))
				.produces(new HashSet<String>(Arrays.asList("application/json")));

		return docket;
	}

}
