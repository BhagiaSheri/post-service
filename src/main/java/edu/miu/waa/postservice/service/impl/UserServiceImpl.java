package edu.miu.waa.postservice.service.impl;

import edu.miu.waa.postservice.domain.dto.request.UserCreateDto;
import edu.miu.waa.postservice.domain.dto.response.CommentDetailsDto;
import edu.miu.waa.postservice.domain.dto.response.PostDetailsDto;
import edu.miu.waa.postservice.domain.dto.response.UserDetailsDto;
import edu.miu.waa.postservice.domain.entity.Comment;
import edu.miu.waa.postservice.domain.entity.Post;
import edu.miu.waa.postservice.domain.entity.User;
import edu.miu.waa.postservice.mapper.Mapper;
import edu.miu.waa.postservice.repository.PostRepository;
import edu.miu.waa.postservice.repository.UserRepository;
import edu.miu.waa.postservice.service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static edu.miu.waa.postservice.mapper.Mapper.convertPostListToPostDetailsDtoList;
import static edu.miu.waa.postservice.mapper.Mapper.convertUserListToUserDetailsDtoList;
import static edu.miu.waa.postservice.mapper.Mapper.convertUserToUserDetailsDto;
import static edu.miu.waa.postservice.util.Util.getEncodedPassword;
import static java.util.Collections.emptyList;

@Transactional
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PostRepository postRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PostRepository postRepository) {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }

    @Override
    public void createUsers(UserCreateDto userCreateDto) {
        Optional<User> user = userRepository.findByUsername(userCreateDto.getUsername());
        if (user.isEmpty()) {
            User newUser = new User(
                    userCreateDto.getId(),
                    userCreateDto.getName(),
                    userCreateDto.getUsername(),
                    getEncodedPassword(userCreateDto.getPassword()),
                    null,
                    userCreateDto.getRoles()
            );
            userRepository.save(newUser);
        } else {
            throw new RuntimeException("Username already exists!");
        }
    }


    @Override
    public List<UserDetailsDto> findAllUsers() {
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return convertUserListToUserDetailsDtoList(users);
    }

    @Override
    public UserDetailsDto findUserDetailsById(long userId) {
        User user = userRepository.findById(userId).orElseThrow();
        return convertUserToUserDetailsDto(user);
    }

    @Override
    public List<PostDetailsDto> findUserPosts(long userId) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            List<Post> posts = postRepository.findPostByUser(user.get());
            return convertPostListToPostDetailsDtoList(posts);
        } else return emptyList();
    }

    @Override
    public List<UserDetailsDto> findUsersPostGreaterThan(Integer criteria) {
        List<User> users = userRepository.findAllPostGreaterThan(criteria);
        return convertUserListToUserDetailsDtoList(users);
    }

    @Override
    public List<UserDetailsDto> findUsersByPostTitles(List<String> titles) {
        List<User> users = userRepository.findAllByPostsTitles(titles);
        return convertUserListToUserDetailsDtoList(users);
    }

    @Override
    public CommentDetailsDto findUserPostComment(long userId, long posId, long commentId) {
        Optional<Comment> comment = userRepository.findUserPostComment(userId, posId, commentId);
        return comment.map(Mapper::convertCommentToCommentDetailsDto).orElseGet(CommentDetailsDto::new);
    }
}
