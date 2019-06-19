package org.starichkov.java.graphql;

import graphql.schema.GraphQLSchema;
import graphql.servlet.SimpleGraphQLServlet;
import javax.servlet.annotation.WebServlet;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Vadim Starichkov
 * @since 19.06.2019 17:58
 */
@WebServlet(urlPatterns = "/graphql")
public class GraphQLEndpoint extends SimpleGraphQLServlet {

  @Autowired
  public GraphQLEndpoint(GraphQLSchema graphQLSchema) {
    super(graphQLSchema);
  }
}
