package com.spring.coldblog.util;

import com.spring.coldblog.model.Post;
import com.spring.coldblog.repository.ColdBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class DummyData { //Populando o primeiro dado no banco
    @Autowired
    ColdBlogRepository coldBlogRepository;
    //@PostConstruct //Tudo que for colocado nesse método vai ser atualizado conforme a aplicação for subindo
    //O PostConstruct foi utilizado apenas na primeira vez de criação desta classe, apenas para inserir o primeiro dado no banco de dados, não sendo mais necessário
    public void savePost()
    {
        List<Post> postList = new ArrayList<>(); //Criando uma lista de post
        Post post1 = new Post(); //Criando uma variável do tipo Post para informar os dados do post
        post1.setAutor("Arthur Couto");
        post1.setData(LocalDate.now());
        post1.setTitulo("Primeiro Post");
        post1.setText("Vamos ver se essa budega está funcionando mesmo.");

        postList.add(post1);

        for(Post post: postList){
            Post postSaved = coldBlogRepository.save(post);
            System.out.println(postSaved.getId());
        }
    }
}
