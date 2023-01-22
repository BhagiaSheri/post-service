package edu.miu.waa.postservice.controller;

import edu.miu.waa.postservice.domain.dto.request.CommentCreateDto;
import edu.miu.waa.postservice.domain.dto.response.CommentDetailsDto;
import edu.miu.waa.postservice.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/api/v1/comments")
public class CommentController {

    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @ResponseStatus(CREATED)
    @PostMapping
    public void createPost(@RequestBody CommentCreateDto requestDto) {
        commentService.createComment(requestDto);
    }

    @GetMapping
    public List<CommentDetailsDto> getAllCommentsDetails() {
        return commentService.findAllComments();
    }
}
