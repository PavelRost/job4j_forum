package ru.job4j.forum.service;

import org.springframework.stereotype.Service;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.repository.ForumMem;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class PostService {

    private ForumMem forumMem;

    public PostService(ForumMem forumMem) {
        this.forumMem = forumMem;
    }

    public Collection<Post> getAll() {
        return forumMem.getAllPosts();
    }

    public void addPost(Post post) {
        forumMem.addPost(post);
    }

    public Post findById(int id) {
        return forumMem.findById(id);
    }

    public void updatePost(int id, Post post) {
        forumMem.updatePost(id, post);
    }
}