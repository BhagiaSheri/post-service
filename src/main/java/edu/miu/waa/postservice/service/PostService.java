package edu.miu.waa.postservice.service;

import edu.miu.waa.postservice.domain.dto.request.PostCreateDto;
import edu.miu.waa.postservice.domain.dto.response.CommentDetailsDto;
import edu.miu.waa.postservice.domain.dto.response.PostDetailsDto;

import java.util.List;

public interface PostService {
    void createPost(long userId, PostCreateDto postCreateDto);

    List<PostDetailsDto> findAllPosts();

    PostDetailsDto findPostDetailsById(long postId);

    List<PostDetailsDto> findAllPostsByCriteria(String title);

    void deletePostById(long postId);

    List<CommentDetailsDto> findCommentsByPostId(long postId);
}
