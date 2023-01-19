package edu.miu.waa.postservice.mapper;

import edu.miu.waa.postservice.domain.dto.PostCreateDto;
import edu.miu.waa.postservice.domain.dto.PostDetailsDto;
import edu.miu.waa.postservice.domain.entity.Post;

import java.util.List;

public class Mapper {
    public static PostDetailsDto convertPostToPostDetailsDto(Post post) {
        return new PostDetailsDto(post.getTitle(), post.getContent(), post.getAuthor());
    }

    public static List<PostDetailsDto> convertPostListToPostDetailsDtoList(List<Post> posts) {
        return posts.stream().map(Mapper::convertPostToPostDetailsDto).toList();
    }

    public static Post convertPostCreateDtoToPost(PostCreateDto postCreateDto) {
        return new Post(postCreateDto.getId(), postCreateDto.getTitle(), postCreateDto.getContent(), postCreateDto.getAuthor());
    }
}
