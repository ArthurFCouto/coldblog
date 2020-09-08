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

        Post post2 = new Post();
        post2.setAutor("Ingride Barbosa");
        post2.setData(LocalDate.now());
        post2.setTitulo("Segundo Post");
        post2.setText("Nossa LUTA se acentua e se aproxima do momento decisivo, onde a participação de TODOS é essencial!!!\n" +
                "Faremos nessa terça-feira dia 08/09, mais um ato de convencimento e consciência de classe com nossos colegas, para que estes compreendam a necessidade \n" +
                "de se JUNTAR imediatamente ao movimento paredista na defesa dos nossos direitos, da nossa empresa PÚBLICA e dos nossos empregos.");
        postList.add(post1);
        postList.add(post2);

        for(Post post: postList){
            Post postSaved = coldBlogRepository.save(post);
            System.out.println(postSaved.getId());
        }
    }
}
