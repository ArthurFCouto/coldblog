package com.spring.coldblog.repository;

import com.spring.coldblog.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ColdBlogRepository extends JpaRepository<Post, Long> {
}
