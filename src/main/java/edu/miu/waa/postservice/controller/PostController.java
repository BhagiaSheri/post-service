package edu.miu.waa.postservice.controller;

import edu.miu.waa.postservice.domain.dto.request.PostCreateDto;
import edu.miu.waa.postservice.domain.dto.response.PostDetailsDto;
import edu.miu.waa.postservice.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/posts")
public class PostController {
    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    public void createPost(@RequestBody PostCreateDto requestDto) {
        postService.createPost(requestDto);
    }

    @GetMapping
    public List<PostDetailsDto> getAllPostsDetails() {
        return postService.findAllPosts();
    }

    @GetMapping("/{id}")
    public PostDetailsDto getPostById(@PathVariable long id) {
        return postService.findPostDetailsById(id);
    }

    @GetMapping("/filter")
    public List<PostDetailsDto> getPostsByCriteria(@RequestParam(required = false) String title) {
        return postService.findAllPostsByCriteria(title);
    }

}
