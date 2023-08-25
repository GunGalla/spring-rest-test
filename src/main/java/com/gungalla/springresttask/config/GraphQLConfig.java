package com.gungalla.springresttask.config;

import graphql.schema.GraphQLScalarType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.graphql.execution.RuntimeWiringConfigurer;

@Configuration
public class GraphQLConfig {

    @Bean
    public GraphQLScalarType localDateTimeScalar() {
        return GraphQLScalarType.newScalar()
                .name("LocalDateTime")
                .description("LocalDateTime scalar")
                .coercing(new LocalDateTimeCoercing())
                .build();
    }

    @Bean
    public RuntimeWiringConfigurer runtimeWiringConfigurer() {
        return writingBuilder -> writingBuilder
                .scalar(localDateTimeScalar())
                .build();
    }

}
