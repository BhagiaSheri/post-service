package edu.miu.waa.postservice.service.impl;

import edu.miu.waa.postservice.domain.dto.PostDetailsDto;
import edu.miu.waa.postservice.domain.dto.UserCreateDto;
import edu.miu.waa.postservice.domain.dto.UserDetailsDto;
import edu.miu.waa.postservice.domain.entity.Post;
import edu.miu.waa.postservice.domain.entity.User;
import edu.miu.waa.postservice.mapper.Mapper;
import edu.miu.waa.postservice.repo.PostRepo;
import edu.miu.waa.postservice.repo.UserRepo;
import edu.miu.waa.postservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static edu.miu.waa.postservice.mapper.Mapper.convertPostListToPostDetailsDtoList;
import static edu.miu.waa.postservice.mapper.Mapper.convertUserListToUserDetailsDtoList;
import static java.util.Collections.emptyList;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;
    private final PostRepo postRepo;

    @Autowired
    public UserServiceImpl(UserRepo userRepo, PostRepo postRepo) {
        this.userRepo = userRepo;
        this.postRepo = postRepo;
    }

    @Override
    public void createUsers(UserCreateDto userCreateDto) {
        User user = new User(userCreateDto.getId(), userCreateDto.getName(), null);
        userRepo.save(user);
    }


    @Override
    public List<UserDetailsDto> findAllUsers() {
        List<User> users = new ArrayList<>();
        userRepo.findAll().forEach(users::add);
        return convertUserListToUserDetailsDtoList(users);
    }

    @Override
    public UserDetailsDto findUserDetailsById(long userId) {
        Optional<User> user = userRepo.findById(userId);
        return user.map(Mapper::convertUserToUserDetailsDto).orElse(new UserDetailsDto());
    }

    @Override
    public List<PostDetailsDto> findUserPosts(long userId) {
        Optional<User> user = userRepo.findById(userId);
        if (user.isPresent()) {
            List<Post> posts = postRepo.findPostByUser(user.get());
            return convertPostListToPostDetailsDtoList(posts);
        } else return emptyList();
    }

    @Override
    public List<UserDetailsDto> findUsersPostGreaterThan() {
        List<User> users = userRepo.findAllPostGreaterThanOne();
        return convertUserListToUserDetailsDtoList(users);
    }
}
