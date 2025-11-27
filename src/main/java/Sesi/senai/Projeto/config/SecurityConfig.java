package Sesi.senai.Projeto.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.http.HttpMethod;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        // ENDPOINTS LIBERADOS
                        .requestMatchers("/auth/**").permitAll()

                        // ADMIN
                        .requestMatchers(HttpMethod.POST, "/Biblioteca/usuario/criarUsuario").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/Biblioteca/usuario/atualizar/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/Biblioteca/usuario/deletar/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST, "/Biblioteca/livros/criarLivro").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/Biblioteca/livros/atualizarlivros/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/Biblioteca/livros/deletarlivro/**").hasRole("ADMIN")



                        // USUÁRIO AUTENTICADO
                        .requestMatchers(HttpMethod.GET, "/Biblioteca/usuario/user/**").authenticated()
                        .requestMatchers(HttpMethod.GET, "/Biblioteca/livros/livro/**").authenticated()

                        // RESTO
                        .anyRequest().authenticated()
                )
                .httpBasic(Customizer.withDefaults());

        return http.build();
    }
}

