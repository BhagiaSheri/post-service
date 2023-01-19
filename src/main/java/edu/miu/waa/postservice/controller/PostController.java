package edu.miu.waa.postservice.controller;

import edu.miu.waa.postservice.domain.dto.PostCreateDto;
import edu.miu.waa.postservice.domain.dto.PostDetailsDto;
import edu.miu.waa.postservice.service.PostService;
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
@RequestMapping("/api/v1/posts")
public class PostController {

    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public List<PostDetailsDto> getAllPostsDetails() {
        return postService.findAllPosts();
    }

    @GetMapping("/{id}")
    public PostDetailsDto getPostById(@PathVariable long id) {
        return postService.findPostDetailsById(id);
    }

    @ResponseStatus(CREATED)
    @PostMapping
    public void createPost(@RequestBody PostCreateDto requestDto) {
        postService.createPost(requestDto);
    }

}
