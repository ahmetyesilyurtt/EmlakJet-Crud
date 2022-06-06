package com.ysl.postapi.controller;

import com.ysl.postapi.dto.request.CreatePostRequest;
import com.ysl.postapi.dto.request.UpdatePostRequest;
import com.ysl.postapi.dto.response.CreatePostResponse;
import com.ysl.postapi.model.Category;
import com.ysl.postapi.model.Post;
import com.ysl.postapi.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PostController {
    @Autowired
    private PostService postService;



    @PostMapping
    public Post createPost(@RequestBody CreatePostRequest request) {
        return postService.createPost(request);
    }

    @GetMapping("/findAllPosts")
    public List<Post> findAllPost() {
        return postService.findAllPost();
    }

    @GetMapping("/getLastT3Post")
    public Collection<CreatePostResponse> getLast3Post() {
        return postService.getLast3Post();

    }

    @GetMapping("/{postId}")
    public ResponseEntity getPosts(@PathVariable Long postId) {
        Post post = postService.getPostById(postId);
        if (post == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(post);
    }

    @PutMapping(value = "{postID}")
    public Post updatePost(@PathVariable Long postID, @RequestBody UpdatePostRequest postRequest) {
        return postService.updatePost(postRequest, postID);
    }

    @GetMapping("/createdBy")
    public Collection<CreatePostResponse> findPostByCreatedBy(@RequestParam(value = "createdBy") String createdBy) {
        return postService.findPostByCreatedBy(createdBy);
    }

    @GetMapping("/category")
    public Collection<CreatePostResponse> findPostByCategory(@RequestParam(name = "category") Category category) {
        return postService.findPostByCategory(category);
    }


}
