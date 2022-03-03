package ru.job4j.forum.service;

import org.springframework.stereotype.Service;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.repository.ForumMem;
import ru.job4j.forum.repository.PostRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.List;

@Service
public class PostService {

    private final PostRepository posts;

    public PostService(PostRepository posts) {
        this.posts = posts;
    }

    public List<Post> getAll() {
        List<Post> rsl = new ArrayList<>();
        posts.findAll().forEach(rsl::add);
        return rsl;
    }

    public void addPost(Post post) {
        post.setCreated(new GregorianCalendar());
        posts.save(post);
    }

    public Post findById(int id) {
        return getAll().stream().filter(post -> post.getId() == id).findFirst().get();
    }

    public void updatePost(int id, Post post) {
        posts.updatePost(post.getName(), id);
    }


    /**
     * public Collection<Post> getAll() {
     *         return forumMem.getAllPosts();
     *     }
     *
     *     public void addPost(Post post) {
     *         forumMem.addPost(post);
     *     }
     *
     *     public Post findById(int id) {
     *         return forumMem.findById(id);
     *     }
     *
     *     public void updatePost(int id, Post post) {
     *         forumMem.updatePost(id, post);
     *     }
     */


}