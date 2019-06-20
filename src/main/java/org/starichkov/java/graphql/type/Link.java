package org.starichkov.java.graphql.type;

import java.time.LocalDateTime;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Vadim Starichkov
 * @since 19.06.2019 18:07
 */
@Data
@Document
public class Link {

  @Id
  private String id;

  private String url;
  private String description;
  private LocalDateTime createdAt;

  public Link() {
  }

  public Link(String url, String description) {
    this.url = url;
    this.description = description;
    this.createdAt = LocalDateTime.now();
  }
}
