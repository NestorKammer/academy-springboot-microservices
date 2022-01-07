package academy.nestorkammer.microservices.course;

import academy.nestorkammer.microservices.core.property.JwtConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan({"academy.nestorkammer.microservices.core.model"})
@EnableJpaRepositories({"academy.nestorkammer.microservices.core.repository"})
@EnableConfigurationProperties(value = JwtConfiguration.class)
@ComponentScan("academy.nestorkammer.microservices")
public class CourseApplication {
    public static void main(String[] args) {
        SpringApplication.run(CourseApplication.class, args);
    }

}
