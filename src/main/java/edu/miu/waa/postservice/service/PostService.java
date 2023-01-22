package edu.miu.waa.postservice.service;

import edu.miu.waa.postservice.domain.dto.request.PostCreateDto;
import edu.miu.waa.postservice.domain.dto.response.PostDetailsDto;

import java.util.List;

public interface PostService {
    void createPost(PostCreateDto postCreateDto);

    List<PostDetailsDto> findAllPosts();

    PostDetailsDto findPostDetailsById(long postId);

    List<PostDetailsDto> findAllPostsByCriteria(String title);
}
