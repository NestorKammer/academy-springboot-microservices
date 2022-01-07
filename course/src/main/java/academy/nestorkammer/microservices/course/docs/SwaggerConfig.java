package academy.nestorkammer.microservices.course.docs;

import academy.nestorkammer.microservices.core.docs.BaseSwaggerConfig;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig extends BaseSwaggerConfig {
    public SwaggerConfig() {
        super("academy.nestorkammer.microservices.course.endpoint.controller");
    }
}
