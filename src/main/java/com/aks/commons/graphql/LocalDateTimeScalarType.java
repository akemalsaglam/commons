package com.aks.commons.graphql;

import graphql.language.StringValue;
import graphql.schema.Coercing;
import graphql.schema.CoercingParseLiteralException;
import graphql.schema.CoercingParseValueException;
import graphql.schema.CoercingSerializeException;
import graphql.schema.GraphQLScalarType;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.stereotype.Component;

@Component
public class LocalDateTimeScalarType extends GraphQLScalarType {

  public LocalDateTimeScalarType() {
    super("LocalDateTime", "LocalDateTime", new Coercing() {
      @Override
      public Object serialize(Object o) throws CoercingSerializeException {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return ((LocalDateTime) o).format(format);
      }

      @Override
      public Object parseValue(Object o) throws CoercingParseValueException {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return ((LocalDateTime) o).format(format);
      }

      @Override
      public Object parseLiteral(Object o) throws CoercingParseLiteralException {
        if (o == null) {
          return null;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return LocalDateTime.parse(((StringValue) o).getValue(), formatter);
      }
    });
  }
}
