package com.ysl.postapi.service;

import com.ysl.postapi.dto.request.CreatePostRequest;
import com.ysl.postapi.dto.request.UpdatePostRequest;
import com.ysl.postapi.dto.response.CreatePostResponse;
import com.ysl.postapi.model.Category;
import com.ysl.postapi.model.Post;
import com.ysl.postapi.repository.PostRepo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService {
    @Autowired
    private PostRepo postRepo;
    private ModelMapper modelMapper;

    public Post createPost(CreatePostRequest postRequest) {
        Post createdPost = null;
        Optional<Post> optionalPost = postRepo.findById(postRequest.getPostId());
        if (optionalPost.isPresent()) {
            createdPost = optionalPost.get();
            createdPost.setText(postRequest.getText());
            createdPost.setTitle(postRequest.getTitle());
            createdPost.setCreatedBy(postRequest.getCreatedBy());
            createdPost.setCategory(postRequest.getCategory());
            postRepo.save(createdPost);
        } else {
            return new Post();
        }
        return createdPost;


    }

    public List<Post> findAllPost() {
        return postRepo.findAll();
    }

    public Post getPostById(Long postId) {
        return postRepo.findById(postId).orElse(null);
    }

    public Post updatePost(UpdatePostRequest post,Long id) {
        Post oldPost = null;
        Optional<Post> optionalPost = postRepo.findById(id);
        if (optionalPost.isPresent()) {

            oldPost = optionalPost.get();
            oldPost.setText(post.getText());
            oldPost.setTitle(post.getTitle());
            oldPost.setCategory(post.getCategory());

            postRepo.save(oldPost);

        } else {
            return new Post();
        }
        return oldPost;
    }


    public List<CreatePostResponse> findPostByCreatedBy(String createdBy) {
        return postRepo.findPostsByCreatedBy(createdBy).stream()
                .map(post -> modelMapper.map(post, CreatePostResponse.class))
                .toList();
    }


    public List<CreatePostResponse> findPostByCategory(Category category) {
        return postRepo.findPostsByCategory(category).stream()
                .map(post -> modelMapper.map(post, CreatePostResponse.class))
                .toList();
    }

    public Collection<CreatePostResponse> getLast3Post() {
        return postRepo.findAll()
                .stream()
                .map(post -> modelMapper.map(post, CreatePostResponse.class))
                .sorted(Comparator.comparing(CreatePostResponse::getCreatedAt).reversed())
                .limit(3)
                .toList();

    }



}
