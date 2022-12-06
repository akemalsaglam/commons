package com.aks.commons.graphql;

import graphql.scalars.ExtendedScalars;
import graphql.schema.GraphQLScalarType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class GraphQLScalars {

    @Bean
    public GraphQLScalarType uuid() {
        return ExtendedScalars.UUID;
    }

    @Bean
    public GraphQLScalarType graphQLLong() {
        return ExtendedScalars.GraphQLLong;
    }

    @Bean
    public GraphQLScalarType graphQLBigInteger() {
        return ExtendedScalars.GraphQLBigInteger;
    }

    @Bean
    public GraphQLScalarType graphQLShort() {
        return ExtendedScalars.GraphQLShort;
    }

    @Bean
    public GraphQLScalarType date() {
        return ExtendedScalars.Date;
    }

    @Bean
    public GraphQLScalarType dateTime() {
        return ExtendedScalars.DateTime;
    }

    @Bean
    public GraphQLScalarType localTime() {
        return ExtendedScalars.LocalTime;
    }

    @Bean
    public GraphQLScalarType time() {
        return ExtendedScalars.Time;
    }

    @Bean
    public GraphQLScalarType url() {
        return ExtendedScalars.Url;
    }

    @Bean
    public GraphQLScalarType json() {
        return ExtendedScalars.Json;
    }
}
