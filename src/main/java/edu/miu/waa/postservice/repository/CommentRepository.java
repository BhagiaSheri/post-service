package edu.miu.waa.postservice.repository;

import edu.miu.waa.postservice.domain.entity.Comment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Long> {
}
