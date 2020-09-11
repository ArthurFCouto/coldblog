package com.spring.coldblog.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SegurityConfig extends WebSecurityConfigurerAdapter {
    private static final String[] AUTH_LIST = { //URI's que não precisam de autenticação para serem acessadas. Fora esses métodos, só usuários autenticados poderão fazer alteração
            "/",
            "/posts",
            "/posts/{id}",
    };

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.csrf().disable().authorizeRequests()
                .antMatchers(AUTH_LIST).permitAll() //Passamos a URI que permitirá acesso sem autenticação
                .anyRequest().authenticated() //Os demais precisam de autenticação
                .and().formLogin().permitAll() //Para acessar a página de login tem que permitir //Como estou utilizando o WebSegurity, vai utilizar a página padrão do SpringSecurity
                .and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{ //Definindo o usuário para autenticação em memória
        auth.inMemoryAuthentication()
                .withUser("84239590").password("{noop}4205").roles("ADMIN");
    }
    /*
    @Override
    public void configure(WebSecurity web) { //Caso você tenha páginas statics (.css ou .jsf) aqui você indicaria o caminho para que o Spring pudesse acessar sem a necessidade de autenticação.
        web.ignoring().antMatchers("/materialize/**");
    }**/
}
