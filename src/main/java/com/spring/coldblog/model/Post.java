package com.spring.coldblog.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Entity
@Table (name="TB_Post") //Renomeando a tabela no banco de dados
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank //Não pode ser valor em branco
    private String titulo;
    @NotBlank
    private String autor;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy") //Formatando a data
    private LocalDate data;
    @NotBlank
    @Lob //Para que o banco aceite dados grandes e trabalhe com uma performace melhor
    private String text;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
