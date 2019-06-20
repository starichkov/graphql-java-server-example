package org.starichkov.java.graphql.type;

import graphql.language.StringValue;
import graphql.schema.Coercing;
import graphql.schema.GraphQLScalarType;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author Vadim Starichkov
 * @since 20.06.2019 13:21
 */
public class Scalars {

  public static GraphQLScalarType dateTime = new GraphQLScalarType("DateTime", "DataTime scalar",
      new Coercing<LocalDateTime, String>() {

        @Override
        public String serialize(Object input) {
          if (input == null) {
            return "";
          }
          return ((LocalDateTime) input).format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        }

        @Override
        public LocalDateTime parseValue(Object input) {
          return LocalDateTime.parse((String) input, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        }

        @Override
        public LocalDateTime parseLiteral(Object input) {
          //parse the string values coming in
          if (input instanceof StringValue) {
            return LocalDateTime.parse(((StringValue) input).getValue());
          } else {
            return null;
          }
        }
      }
  );
}
