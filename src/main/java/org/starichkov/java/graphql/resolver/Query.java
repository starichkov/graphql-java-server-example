package org.starichkov.java.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLRootResolver;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.starichkov.java.graphql.repository.LinkRepository;
import org.starichkov.java.graphql.type.Link;

/**
 * @author Vadim Starichkov
 * @since 19.06.2019 18:11
 */
@Component
public class Query implements GraphQLRootResolver {

  private final LinkRepository linkRepository;

  @Autowired
  public Query(LinkRepository linkRepository) {
    this.linkRepository = linkRepository;
  }

  public List<Link> allLinks() {
    return linkRepository.findAll();
  }
}
