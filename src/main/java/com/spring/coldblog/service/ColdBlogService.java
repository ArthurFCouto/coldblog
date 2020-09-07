package com.spring.coldblog.service;

import com.spring.coldblog.model.Post;
import java.util.List;

public interface ColdBlogService {
    List<Post> findAll();
    Post findbyid(long id);
    Post save(Post post);
}
