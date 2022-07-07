package com.aks.commons.graphql;

import com.coxautodev.graphql.tools.SchemaParserOptions;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import graphql.kickstart.servlet.apollo.ApolloScalars;
import graphql.schema.GraphQLScalarType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(GraphQLScalars.class)
public class SchemaFieldConfiguration {

    @Bean
    public JavaTimeModule jsr310Module() {
        return new JavaTimeModule();
    }

    @Bean
    public SchemaParserOptions schemaParserOptions() {
        return SchemaParserOptions.newOptions().objectMapperConfigurer((mapper, context) -> {
            mapper.registerModule(new JavaTimeModule());
            mapper.enable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        }).build();
    }

    @Bean
    GraphQLScalarType uploadScalarType() {
        return ApolloScalars.Upload;
    }
}
