package com.spring.coldblog.controller;

import com.spring.coldblog.model.Post;
import com.spring.coldblog.service.ColdBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ColdBlogController {
    @Autowired
    ColdBlogService coldBlogService;

    @RequestMapping(value = "/posts", method = RequestMethod.GET)
    public ModelAndView getPosts(){
        ModelAndView mv = new ModelAndView("posts");
        List<Post> posts = coldBlogService.findAll();
        mv.addObject("posts",posts); //Temos acesso aos Post do banco de dados
        return mv;
    }
}
