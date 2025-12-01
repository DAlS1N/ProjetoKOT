package Sesi.senai.Projeto.service;

import Sesi.senai.Projeto.model.Livros;
import Sesi.senai.Projeto.model.Usuario;
import Sesi.senai.Projeto.repository.LivrosRepository;
import Sesi.senai.Projeto.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private LivrosRepository livrosRepository;

    //Criar (POST)
    public Usuario criarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    public Usuario findByid(int id) {
        return usuarioRepository.findById(id).get();
    }

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

    public void deletarUsuario(int id) {
        usuarioRepository.deleteById(id);
    }


    public Usuario adicionarLivroExistente(Integer idUsuario, Integer idLivro) {

        Usuario usuario = usuarioRepository.findById(idUsuario)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        Livros livro = livrosRepository.findById(idLivro)
                .orElseThrow(() -> new RuntimeException("Livro não encontrado"));

        // Associa o livro ao usuário
        livro.setUsuario(usuario);
        livrosRepository.save(livro);

        return usuario; // retorna o usuário com o livro vinculado
    }
}

