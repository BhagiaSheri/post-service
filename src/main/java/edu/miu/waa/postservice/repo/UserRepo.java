package edu.miu.waa.postservice.repo;

import edu.miu.waa.postservice.domain.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends CrudRepository<User, Long> {

    @Query(value = "SELECT u FROM User u WHERE size(u.posts) > 1")
    List<User> findAllPostGreaterThanOne();

}
