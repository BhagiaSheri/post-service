package edu.miu.waa.postservice.repository;

import edu.miu.waa.postservice.domain.entity.Comment;
import edu.miu.waa.postservice.domain.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername(String username);

    @Query(value = "SELECT u FROM User u WHERE size(u.posts) > :criteria")
    List<User> findAllPostGreaterThan(Integer criteria);

    @Query(value = "SELECT u FROM User u INNER JOIN Post p ON u.id = p.user.id WHERE p.title IN :titles")
    List<User> findAllByPostsTitles(List<String> titles);

    @Query(value = "SELECT c FROM User u INNER JOIN Post p ON u.id = p.user.id INNER JOIN Comment c ON p.id = c.post.id " +
            "WHERE u.id = :userId AND p.id = :postId AND c.id = :commentId")
    Optional<Comment> findUserPostComment(long userId, long postId, long commentId);

}
