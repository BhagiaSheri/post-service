package edu.miu.waa.postservice.mapper;

import edu.miu.waa.postservice.domain.dto.PostDetailsDto;
import edu.miu.waa.postservice.domain.dto.UserDetailsDto;
import edu.miu.waa.postservice.domain.entity.Post;
import edu.miu.waa.postservice.domain.entity.User;

import java.util.List;

public class Mapper {
    public static PostDetailsDto convertPostToPostDetailsDto(Post post) {
        return new PostDetailsDto(post.getId(), post.getTitle(), post.getContent(), post.getAuthor());
    }

    public static List<PostDetailsDto> convertPostListToPostDetailsDtoList(List<Post> posts) {
        return posts.stream().map(Mapper::convertPostToPostDetailsDto).toList();
    }

    public static UserDetailsDto convertUserToUserDetailsDto(User user) {
        return new UserDetailsDto(user.getId(), user.getName());
    }

    public static List<UserDetailsDto> convertUserListToUserDetailsDtoList(List<User> users) {
        return users.stream().map(Mapper::convertUserToUserDetailsDto).toList();
    }

}
