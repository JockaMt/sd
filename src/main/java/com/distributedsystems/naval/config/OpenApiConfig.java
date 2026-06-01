package com.distributedsystems.naval.config;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "Naval Import/Export System",
                version = "1.0.0",
                description = "Sistema de registros de importações e exportações por vias navais"
        )
)
public class OpenApiConfig {
}