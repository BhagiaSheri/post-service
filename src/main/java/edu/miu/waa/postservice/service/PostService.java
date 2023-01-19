package edu.miu.waa.postservice.service;

import edu.miu.waa.postservice.domain.dto.PostCreateDto;
import edu.miu.waa.postservice.domain.dto.PostDetailsDto;
import edu.miu.waa.postservice.domain.entity.Post;

import java.util.List;

public interface PostService {

    List<PostDetailsDto> findAllPosts();

    PostDetailsDto findPostDetailsById(long postId);

    void createPost(PostCreateDto postCreateDto);

}
