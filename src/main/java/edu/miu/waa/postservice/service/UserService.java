package edu.miu.waa.postservice.service;

import edu.miu.waa.postservice.domain.dto.request.UserCreateDto;
import edu.miu.waa.postservice.domain.dto.response.CommentDetailsDto;
import edu.miu.waa.postservice.domain.dto.response.PostDetailsDto;
import edu.miu.waa.postservice.domain.dto.response.UserDetailsDto;

import java.util.List;

public interface UserService {

    void createUsers(UserCreateDto userCreateDto);

    List<UserDetailsDto> findAllUsers();

    UserDetailsDto findUserDetailsById(long userId);


    List<PostDetailsDto> findUserPosts(long userId);

    List<UserDetailsDto> findUsersPostGreaterThan(Integer criteria);

    List<UserDetailsDto> findUsersByPostTitles(List<String> titles);

    CommentDetailsDto findUserPostComment(long userId, long posId, long commentId);
}
