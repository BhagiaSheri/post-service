package edu.miu.waa.postservice.service;

import edu.miu.waa.postservice.domain.dto.request.CommentCreateDto;
import edu.miu.waa.postservice.domain.dto.response.CommentDetailsDto;
import edu.miu.waa.postservice.domain.entity.Comment;

import java.util.List;

public interface CommentService {

    void createComment(CommentCreateDto commentCreateDto);

    List<CommentDetailsDto> findAllComments();

}
