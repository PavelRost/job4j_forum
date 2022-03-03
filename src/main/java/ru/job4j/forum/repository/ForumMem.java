package ru.job4j.forum.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.forum.model.Post;

import java.util.Collection;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
@Repository
*/
public class ForumMem {

    private final HashMap<Integer, Post> posts = new HashMap<>();

    private AtomicInteger id = new AtomicInteger(1);

    public ForumMem() {
        posts.putIfAbsent(id.getAndAdd(1), new Post(1, "Продаю Волгу"));
    }

    public Collection<Post> getAllPosts() {
        return posts.values();
    }

    public void addPost(Post post) {
        post.setId(id.get());
        posts.putIfAbsent(id.getAndAdd(1), post);
    }

    public Post findById(int id) {
        return posts.get(id);
    }

    public void updatePost(int id, Post post) {
        posts.replace(id, post);
    }
}
