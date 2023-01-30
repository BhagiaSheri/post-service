package edu.miu.waa.postservice.service.impl;

import edu.miu.waa.postservice.domain.dto.request.CriteriaRequestDto;
import edu.miu.waa.postservice.domain.dto.request.PostCreateDto;
import edu.miu.waa.postservice.domain.dto.response.PostDetailsDto;
import edu.miu.waa.postservice.domain.entity.Post;
import edu.miu.waa.postservice.domain.entity.User;
import edu.miu.waa.postservice.mapper.Mapper;
import edu.miu.waa.postservice.repository.PostRepository;
import edu.miu.waa.postservice.repository.ProductSearchDao;
import edu.miu.waa.postservice.repository.UserRepository;
import edu.miu.waa.postservice.service.PostService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static edu.miu.waa.postservice.mapper.Mapper.convertPostListToPostDetailsDtoList;

@Service
@Transactional
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    private final ProductSearchDao productSearchDao;

    @Autowired
    public PostServiceImpl(PostRepository postRepository, UserRepository userRepository, ProductSearchDao productSearchDao) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
        this.productSearchDao = productSearchDao;
    }

    @Override
    public void createPost(long userId, PostCreateDto postCreateDto) {
        User user = userRepository.findById(userId).orElseThrow();
        Post newPost = new Post(
                postCreateDto.getId(),
                postCreateDto.getTitle(),
                postCreateDto.getContent(),
                postCreateDto.getAuthor(),
                user,
                null
        );
        postRepository.save(newPost);
    }

    @Override
    public List<PostDetailsDto> findAllPosts() {
        List<Post> posts = new ArrayList<>();
        postRepository.findAll().forEach(posts::add);
        return convertPostListToPostDetailsDtoList(posts);
    }

    @Override
    public PostDetailsDto findPostDetailsById(long postId) {
        Optional<Post> post = postRepository.findById(postId);
        return post.map(Mapper::convertPostToPostDetailsDto).orElse(new PostDetailsDto());
    }

    @Override
    public List<PostDetailsDto> findAllPostsByCriteria(String title) {
        List<Post> posts = productSearchDao.findAllByCriteria(new CriteriaRequestDto(title));
        return convertPostListToPostDetailsDtoList(posts);
    }

}
