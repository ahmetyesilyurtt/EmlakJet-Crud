package com.ysl.postapi.repository;

import com.ysl.postapi.model.Category;
import com.ysl.postapi.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface PostRepo extends JpaRepository<Post, Long> {

    Collection<Post> findPostsByCreatedBy(String createdBy);

    Collection<Post> findPostsByCategory(Category category);
}
