package edu.miu.waa.postservice.controller;

import edu.miu.waa.postservice.domain.dto.request.UserCreateDto;
import edu.miu.waa.postservice.domain.dto.response.CommentDetailsDto;
import edu.miu.waa.postservice.domain.dto.response.PostDetailsDto;
import edu.miu.waa.postservice.domain.dto.response.UserDetailsDto;
import edu.miu.waa.postservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.util.Objects.requireNonNullElse;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ResponseStatus(CREATED)
    @PostMapping
    public void createUser(@RequestBody UserCreateDto requestDto) {
        userService.createUsers(requestDto);
    }

    @GetMapping
    public List<UserDetailsDto> getAllUsersDetails() {
        return userService.findAllUsers();
    }

    @GetMapping("/{id}")
    public UserDetailsDto getUserById(@PathVariable long id) {
        return userService.findUserDetailsById(id);
    }

    @GetMapping("/{id}/posts")
    public List<PostDetailsDto> getUserPosts(@PathVariable long id) {
        return userService.findUserPosts(id);
    }

    @GetMapping("/filter")
    public List<UserDetailsDto> getUsersPostGreaterThan(@RequestParam(required = false) Integer numOfPosts) {
        return userService.findUsersPostGreaterThan(requireNonNullElse(numOfPosts, 1));
    }

    @ResponseStatus(OK)
    @PostMapping("/posts/filter")
    public List<UserDetailsDto> getUsersByPostTitles(@RequestBody List<String> titles) {
        return userService.findUsersByPostTitles(titles);
    }

    @GetMapping("/{id}/posts/{postId}/comments/{commentId}")
    public CommentDetailsDto getUserPostComment(
            @PathVariable long id,
            @PathVariable long postId,
            @PathVariable long commentId
    ){
        return userService.findUserPostComment(id, postId, commentId);
    }

}
