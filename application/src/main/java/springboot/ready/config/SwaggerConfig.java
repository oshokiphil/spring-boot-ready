package springboot.ready.config;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Autowired
    private MavenInfo mavenInfo;

    @Bean
    public Docket newsApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .paths(regex("/api.*"))
                .build();
    }

    private ApiInfo apiInfo() {
        final MavenInfo.Maven maven = mavenInfo.get();

        return new ApiInfoBuilder()
                .title(maven.getArtifactId())
                .description(maven.getDescription())
                .contact(maven.getDevelopers())
                .termsOfServiceUrl(maven.getUrl())
                .version(maven.getVersion())
                .build();
    }
}
