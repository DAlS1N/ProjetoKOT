package Sesi.senai.Projeto.service;

import Sesi.senai.Projeto.model.Usuario;
import Sesi.senai.Projeto.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario u = usuarioRepository.findByEmail(email);

        if (u == null) {
            throw new UsernameNotFoundException("Usuário não encontrado");
        }

        return org.springframework.security.core.userdetails.User
                .withUsername(u.getEmail())
                .password(u.getSenha())
                .roles(u.getRole()) // "ADMIN" ou "USER"
                .build();
    }
}
