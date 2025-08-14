package com.wipro.service;

import com.wipro.entity.Post;
import com.wipro.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;
import java.util.List;

@Service
public class JsonPlaceholderService {
    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/posts";

    @Autowired
    private RestTemplate restTemplate;

    // GET all posts
    public List<Post> getAllPosts() {
        try {
            ResponseEntity<Post[]> response = restTemplate.getForEntity(BASE_URL, Post[].class);
            return Arrays.asList(response.getBody());
        } catch (HttpStatusCodeException ex) {
            throw new ResourceNotFoundException("Failed to fetch posts: " + ex.getStatusCode());
        }
    }

    // GET single post by id
    public Post getPostById(Long id) {
        try {
            return restTemplate.getForObject(BASE_URL + "/" + id, Post.class);
        } catch (HttpStatusCodeException ex) {
            throw new ResourceNotFoundException("Post not found with id " + id);
        }
    }

    // CREATE a new post
    public Post createPost(Post post) {
        try {
            return restTemplate.postForObject(BASE_URL, post, Post.class);
        } catch (HttpStatusCodeException ex) {
            throw new RuntimeException("Failed to create post: " + ex.getResponseBodyAsString());
        }
    }

    // UPDATE a post
    public Post updatePost(Long id, Post post) {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<Post> entity = new HttpEntity<>(post, headers);

            ResponseEntity<Post> response = restTemplate.exchange(
                    BASE_URL + "/" + id,
                    HttpMethod.PUT,
                    entity,
                    Post.class
            );
            return response.getBody();
        } catch (HttpStatusCodeException ex) {
            throw new ResourceNotFoundException("Failed to update post: " + ex.getStatusCode());
        }
    }

    // DELETE a post
    public void deletePost(Long id) {
        try {
            restTemplate.delete(BASE_URL + "/" + id);
        } catch (HttpStatusCodeException ex) {
            throw new ResourceNotFoundException("Failed to delete post: " + ex.getStatusCode());
        }
    }
}
