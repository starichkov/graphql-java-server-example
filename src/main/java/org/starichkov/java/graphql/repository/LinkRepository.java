package org.starichkov.java.graphql.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.starichkov.java.graphql.type.Link;

/**
 * @author Vadim Starichkov
 * @since 19.06.2019 18:09
 */
@Repository
public interface LinkRepository extends MongoRepository<Link, String> {

}
