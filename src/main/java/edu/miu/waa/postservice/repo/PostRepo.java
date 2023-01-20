package edu.miu.waa.postservice.repo;

import edu.miu.waa.postservice.domain.entity.Post;
import edu.miu.waa.postservice.domain.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepo extends CrudRepository<Post, Long> {
    List<Post> findPostByUser(User user);

}
