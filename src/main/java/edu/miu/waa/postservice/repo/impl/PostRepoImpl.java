package edu.miu.waa.postservice.repo.impl;

import edu.miu.waa.postservice.domain.entity.Post;
import edu.miu.waa.postservice.repo.PostRepo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PostRepoImpl implements PostRepo {
    private static final List<Post> posts;
    private static int postId = 103;

    static {
        posts = new ArrayList<>();
        Post p1 = new Post(101, "The Era of Tech", "Coding is the new era...", "The Great Author");
        Post p2 = new Post(102, "Galaxy World", "Something big is coming soon...", "The Legendary Author");
        posts.add(p1);
        posts.add(p2);
    }

    @Override
    public List<Post> findAll() {
        return posts;
    }

    @Override
    public Post findById(long id) {
        return posts
                .stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void save(Post post) {
        post.setId(postId); // We are auto generating the id for DEMO purposes, (Normally, do not change your parameters)
        postId++;
        posts.add(post);
    }
}
