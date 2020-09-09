package com.spring.coldblog.controller;

import com.spring.coldblog.model.Post;
import com.spring.coldblog.service.ColdBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@Controller
public class ColdBlogController {
    @Autowired
    ColdBlogService coldBlogService;

    @RequestMapping(value = "/posts", method = RequestMethod.GET)
    public ModelAndView getPosts() {
        ModelAndView mv = new ModelAndView("posts");
        List<Post> posts = coldBlogService.findAll();
        mv.addObject("posts", posts); //Temos acesso aos Post do banco de dados
        return mv;
    }

    @RequestMapping(value = "/posts/{id}", method = RequestMethod.GET)
    public ModelAndView getPostDetails(@PathVariable("id") long id) {
        ModelAndView mv = new ModelAndView("postDetails");
        Post post = coldBlogService.findbyid(id);
        mv.addObject("post", post); //Temos acesso aos Post do banco de dados
        return mv;
    }

    @RequestMapping(value = "/postdel", method = RequestMethod.GET)
    public ModelAndView getPostDel() {
        ModelAndView mv = new ModelAndView("postDel");
        List<Post> posts = coldBlogService.findAll();
        mv.addObject("posts", posts); //Temos acesso aos Post do banco de dados
        return mv;
    }

    @RequestMapping("/postdel/{id}")
    public String postDel(long id, RedirectAttributes attributes){
        Post post = coldBlogService.findbyid(id);
        coldBlogService.delete(post);
        attributes.addFlashAttribute("mensagem","Post excluído com sucesso!");
        return "redirect:/postdel";
    }

    @RequestMapping(value = "/newpost", method = RequestMethod.GET)
    public String getPostForm() {
        return "postform";
    }

    @RequestMapping(value = "/newpost", method = RequestMethod.POST)
    public String savePost(@Valid Post post, BindingResult result, RedirectAttributes attributes) //@Valid vai verificar se nossas validações (incluidas no model post) estão incluidas.
    {
        if (result.hasErrors()) {
            attributes.addFlashAttribute("mensagem","Verifique se todos os campos obrigatórios (*) foram preenchidos!");
            return "redirect:/newpost";
        }
        post.setData(LocalDate.now());
        coldBlogService.save(post);
        return "redirect:/posts";
    }
}
