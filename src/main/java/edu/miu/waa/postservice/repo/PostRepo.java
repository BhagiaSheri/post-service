package edu.miu.waa.postservice.repo;

import edu.miu.waa.postservice.domain.entity.Post;

import java.util.List;

public interface PostRepo {

    List<Post> findAll();

    Post findById(long id);

    void save(Post post);
}
