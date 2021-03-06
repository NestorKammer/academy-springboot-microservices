package academy.nestorkammer.microservices.core.docs;

import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

public class BaseSwaggerConfig {
    private final String basePackage;

    public BaseSwaggerConfig(String basePackage){
        this.basePackage = basePackage;
    }

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage(basePackage))
                .build()
                .apiInfo(metaData());
    }

    private ApiInfo metaData(){
        return new ApiInfoBuilder()
                .title("Spring Boot Microservices - By Nestor Kammer")
                .description("Implementation of microservices modules auth, discovery, gateway and course api, using Spring Boot.")
                .version("1.0")
                .contact(new Contact("Nestor Kammer ", "https://www.linkedin.com/in/nestor-kammer-05841061/", "nestor.kammer@gmail.com"))
                .license("Many thanks to DevDojo")
                .licenseUrl("http://devdojo.academy")
                .build();

    }
}
