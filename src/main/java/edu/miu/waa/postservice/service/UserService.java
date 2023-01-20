package edu.miu.waa.postservice.service;

import edu.miu.waa.postservice.domain.dto.PostDetailsDto;
import edu.miu.waa.postservice.domain.dto.UserCreateDto;
import edu.miu.waa.postservice.domain.dto.UserDetailsDto;

import java.util.List;

public interface UserService {

    List<UserDetailsDto> findAllUsers();

    UserDetailsDto findUserDetailsById(long userId);

    void createUsers(UserCreateDto userCreateDto);

    List<PostDetailsDto> findUserPosts(long userId);

    List<UserDetailsDto> findUsersPostGreaterThan();

}
