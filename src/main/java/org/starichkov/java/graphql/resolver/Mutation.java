package org.starichkov.java.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLRootResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.starichkov.java.graphql.repository.LinkRepository;
import org.starichkov.java.graphql.type.Link;

/**
 * @author Vadim Starichkov
 * @since 19.06.2019 18:26
 */
@Component
public class Mutation implements GraphQLRootResolver {

  private final LinkRepository linkRepository;

  @Autowired
  public Mutation(LinkRepository linkRepository) {
    this.linkRepository = linkRepository;
  }

  public Link createLink(String url, String description) {
    Link link = new Link(url, description);
    return linkRepository.save(link);
  }
}
