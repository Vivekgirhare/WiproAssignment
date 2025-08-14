package com.wipro.controller;

import com.wipro.entity.Post;
import com.wipro.service.JsonPlaceholderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class JsonPlaceholderController {

    @Autowired
    private JsonPlaceholderService jsonPlaceholderService;

    // GET all posts
    @GetMapping
    public List<Post> getAllPosts() {
        return jsonPlaceholderService.getAllPosts();
    }

    // GET single post by ID
    @GetMapping("/{id}")
    public Post getPostById(@PathVariable Long id) {
        return jsonPlaceholderService.getPostById(id);
    }

    // CREATE a new post
    @PostMapping
    public Post createPost(@RequestBody Post post) {
        return jsonPlaceholderService.createPost(post);
    }

    // UPDATE an existing post
    @PutMapping("/{id}")
    public Post updatePost(@PathVariable Long id, @RequestBody Post post) {
        return jsonPlaceholderService.updatePost(id, post);
    }

    // DELETE a post by ID
    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable Long id) {
        jsonPlaceholderService.deletePost(id);
    }
}
