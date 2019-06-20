package org.starichkov.java.graphql;

import java.util.Collection;
import java.util.LinkedList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.starichkov.java.graphql.repository.LinkRepository;
import org.starichkov.java.graphql.type.Link;

/**
 * @author Vadim Starichkov
 * @since 19.06.2019 20:14
 */
@Component
public class ApplicationStartup implements ApplicationListener<ApplicationReadyEvent> {

  private final LinkRepository linkRepository;

  @Autowired
  public ApplicationStartup(LinkRepository linkRepository) {
    this.linkRepository = linkRepository;
  }

  @Override
  public void onApplicationEvent(ApplicationReadyEvent event) {
    linkRepository.deleteAll();

    Collection<Link> links = new LinkedList<>();
    links.add(new Link("http://howtographql.com", "Your favorite GraphQL page"));
    links.add(new Link("http://graphql.org/learn/", "The official docks"));
    linkRepository.save(links);
  }
}
