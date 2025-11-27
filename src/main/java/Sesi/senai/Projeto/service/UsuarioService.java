package Sesi.senai.Projeto.service;

import Sesi.senai.Projeto.model.Usuario;
import Sesi.senai.Projeto.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    //Criar (POST)
    public Usuario criarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    //Listar todos (GET)
    public List<Usuario> criarUsuarios() {
        return usuarioRepository.findAll();
    }

    //Buscar por id (GET /{id})
    public Usuario findByid(int id) {
        return usuarioRepository.findById(id).get();
    }

    //Atualizar (PUT /{id})
    public Usuario AtualizarUsuario(Usuario usuarioNovo, int id) {

        return usuarioRepository.findById(id)
                .map(usuarioAntigo -> {
                    usuarioAntigo.setNome(usuarioNovo.getNome());
                    usuarioAntigo.setEmail(usuarioNovo.getEmail());
                    usuarioAntigo.setSenha(usuarioNovo.getSenha());

                    return usuarioRepository.save(usuarioAntigo);
                })
                .orElse(null);
    }



    //Deletar (DELETE /{id})
    public void deletarUsuario(int id) {
         usuarioRepository.deleteById(id);
    }






}
