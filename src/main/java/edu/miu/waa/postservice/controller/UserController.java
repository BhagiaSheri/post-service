package edu.miu.waa.postservice.controller;

import edu.miu.waa.postservice.domain.dto.PostDetailsDto;
import edu.miu.waa.postservice.domain.dto.UserCreateDto;
import edu.miu.waa.postservice.domain.dto.UserDetailsDto;
import edu.miu.waa.postservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

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
    public List<UserDetailsDto> getUsersPostGreaterThanOne(){
        return userService.findUsersPostGreaterThan();
    }
}
