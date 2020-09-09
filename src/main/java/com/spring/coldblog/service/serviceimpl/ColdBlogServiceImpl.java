package com.spring.coldblog.service.serviceimpl;

import com.spring.coldblog.model.Post;
import com.spring.coldblog.repository.ColdBlogRepository;
import com.spring.coldblog.service.ColdBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColdBlogServiceImpl implements ColdBlogService {
    @Autowired //Fazendo um "ponto de injeção" no repository, para poder utilizar as instancias do repository
    ColdBlogRepository coldBlogRepository;

    @Override
    public List<Post> findAll() { //Retorna lista de post
        return coldBlogRepository.findAll();
    }

    @Override
    public Post findbyid(long id) { //Retorna através da ID
        return coldBlogRepository.findById(id).get();//Temos que colocar o .get() para informar que estamos requisitando o post através da ID
    }

    @Override
    public Post save(Post post) { //Salva o Post
        return coldBlogRepository.save(post);
    }

    @Override
    public void delete(Post post) {
        coldBlogRepository.delete(post);
    }

}
