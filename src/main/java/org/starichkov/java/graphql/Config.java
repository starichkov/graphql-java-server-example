package org.starichkov.java.graphql;

import com.coxautodev.graphql.tools.SchemaParser;
import graphql.schema.GraphQLSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.starichkov.java.graphql.resolver.Mutation;
import org.starichkov.java.graphql.resolver.Query;
import org.starichkov.java.graphql.type.Scalars;

/**
 * @author Vadim Starichkov
 * @since 19.06.2019 16:40
 */
@Configuration
public class Config {

  private final Query query;
  private final Mutation mutation;

  @Autowired
  public Config(Query query, Mutation mutation) {
    this.query = query;
    this.mutation = mutation;
  }

  @Bean
  public GraphQLSchema graphQLSchema() {
    return SchemaParser.newParser()
        .file("schema.graphqls")
        .resolvers(query, mutation)
        .scalars(Scalars.dateTime)
        .build()
        .makeExecutableSchema();
  }
}
