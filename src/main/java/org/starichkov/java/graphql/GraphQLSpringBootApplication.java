package org.starichkov.java.graphql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * @author Vadim Starichkov
 * @since 19.06.2019 15:45
 */
@SpringBootApplication
@ServletComponentScan
public class GraphQLSpringBootApplication {

  public static void main(String[] args) {
    SpringApplication.run(GraphQLSpringBootApplication.class, args);
  }
}
