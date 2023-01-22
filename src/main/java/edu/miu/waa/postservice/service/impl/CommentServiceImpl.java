package edu.miu.waa.postservice.service.impl;

import edu.miu.waa.postservice.domain.dto.request.CommentCreateDto;
import edu.miu.waa.postservice.domain.dto.response.CommentDetailsDto;
import edu.miu.waa.postservice.domain.entity.Comment;
import edu.miu.waa.postservice.domain.entity.Post;
import edu.miu.waa.postservice.repository.CommentRepository;
import edu.miu.waa.postservice.repository.PostRepository;
import edu.miu.waa.postservice.service.CommentService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static edu.miu.waa.postservice.mapper.Mapper.convertCommentListToCommentDetailsDtoList;

@Service
@Transactional
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository, PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }

    @Override
    public void createComment(CommentCreateDto commentCreateDto) {
        Optional<Post> post = postRepository.findById(commentCreateDto.getPostId());
        if (post.isPresent()) {
            Comment newComment = new Comment(
                    commentCreateDto.getId(),
                    commentCreateDto.getName(),
                    post.get()
            );
            commentRepository.save(newComment);
        }
    }

    @Override
    public List<CommentDetailsDto> findAllComments() {
        List<Comment> comments = new ArrayList<>();
        commentRepository.findAll().forEach(comments::add);
        return convertCommentListToCommentDetailsDtoList(comments);
    }

}
