package com.product;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.*;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.annotations.servers.ServerVariable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(
        info = @Info(
                title = "PRODUCT_SERVICE",
                version = "1.0",
                description = "Spring Boot demo project for spring_batch,",
                termsOfService = "http://terms.example.com",
                contact = @Contact(
                        name = "Naveen K Wodeyar",
                        email = "naveen.wodeyar@yahoo.com",
                        url = "http://naveenwodeyar.com"
                ),
                license = @License(
                        name = "Apache 2.0",
                        url = "http://www.apache.org/licenses/LICENSE-2.0.html"
                )
        ),
        servers = {
                @Server(
                        url = "http://localhost:1234",
                        description = "Testing server",
                        variables = {
                                @ServerVariable(
                                        name = "port",
                                        description = "Port number",
                                        defaultValue = "1234"
                                )
                        }
                ),
                @Server(
                        url = "http://production-server.com",
                        description = "Production server"
                )
        },
        externalDocs = @ExternalDocumentation(
                description = "Find more info here",
                url = "http://example.com/docs"
        )
//        security = @SecurityRequirement(name = "bearerAuth")
//)
//@SecurityScheme(
//        name = "bearerAuth",
//        type = SecuritySchemeType.HTTP,
//        type = SecuritySchemeType.HTTP,
//        scheme = "bearer",
//        bearerFormat = "JWT"
)
@SpringBootApplication
public class ProductServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductServiceApplication.class, args);
        System.out.println("**\nProduct     \n  Service\n**");
    }

}
