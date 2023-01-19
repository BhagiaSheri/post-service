package edu.miu.waa.postservice.service.impl;

import edu.miu.waa.postservice.domain.dto.PostCreateDto;
import edu.miu.waa.postservice.domain.dto.PostDetailsDto;
import edu.miu.waa.postservice.domain.entity.Post;
import edu.miu.waa.postservice.repo.PostRepo;
import edu.miu.waa.postservice.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static edu.miu.waa.postservice.mapper.Mapper.convertPostCreateDtoToPost;
import static edu.miu.waa.postservice.mapper.Mapper.convertPostListToPostDetailsDtoList;
import static edu.miu.waa.postservice.mapper.Mapper.convertPostToPostDetailsDto;

@Service
public class PostServiceImpl implements PostService {
    private final PostRepo postRepo;

    @Autowired
    public PostServiceImpl(PostRepo postRepo) {
        this.postRepo = postRepo;
    }

    @Override
    public List<PostDetailsDto> findAllPosts() {
        List<Post> posts = postRepo.findAll();
        return convertPostListToPostDetailsDtoList(posts);
    }

    @Override
    public PostDetailsDto findPostDetailsById(long postId) {
        Post post = postRepo.findById(postId);
        return convertPostToPostDetailsDto(post);
    }

    @Override
    public void createPost(PostCreateDto postCreateDto) {
        Post post = convertPostCreateDtoToPost(postCreateDto);
        postRepo.save(post);
    }
}
