package ru.job4j.forum.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;
import ru.job4j.forum.model.Post;

public interface PostRepository extends CrudRepository<Post, Integer> {

    @Transactional
    @Modifying
    @Query("update Post p set p.name = ?1 where p.id = ?2")
    void updatePost(String name, int id);
}
