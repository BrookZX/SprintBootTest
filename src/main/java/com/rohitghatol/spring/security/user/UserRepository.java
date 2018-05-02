package com.rohitghatol.spring.security.user;

//import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<NUser, String> {
    NUser findByUsername(final String username);
}
