package edu.miu.waa.postservice.service.impl;

import edu.miu.waa.postservice.domain.dto.PostCreateDto;
import edu.miu.waa.postservice.domain.dto.PostDetailsDto;
import edu.miu.waa.postservice.domain.entity.Post;
import edu.miu.waa.postservice.domain.entity.User;
import edu.miu.waa.postservice.mapper.Mapper;
import edu.miu.waa.postservice.repo.PostRepo;
import edu.miu.waa.postservice.repo.UserRepo;
import edu.miu.waa.postservice.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static edu.miu.waa.postservice.mapper.Mapper.convertPostListToPostDetailsDtoList;

@Service
public class PostServiceImpl implements PostService {
    private final PostRepo postRepo;
    private final UserRepo userRepo;

    @Autowired
    public PostServiceImpl(PostRepo postRepo, UserRepo userRepo) {
        this.postRepo = postRepo;
        this.userRepo = userRepo;
    }

    @Override
    public void createPost(PostCreateDto postCreateDto) {
        Optional<User> user = userRepo.findById(postCreateDto.getUserId());
        if (user.isPresent()) {
            Post newPost = new Post(
                    postCreateDto.getId(),
                    postCreateDto.getTitle(),
                    postCreateDto.getContent(),
                    postCreateDto.getAuthor(),
                    user.get()
            );
            postRepo.save(newPost);
        }
    }

    @Override
    public List<PostDetailsDto> findAllPosts() {
        List<Post> posts = new ArrayList<>();
        postRepo.findAll().forEach(posts::add);
        return convertPostListToPostDetailsDtoList(posts);
    }

    @Override
    public PostDetailsDto findPostDetailsById(long postId) {
        Optional<Post> post = postRepo.findById(postId);
        return post.map(Mapper::convertPostToPostDetailsDto).orElse(new PostDetailsDto());
    }

}
