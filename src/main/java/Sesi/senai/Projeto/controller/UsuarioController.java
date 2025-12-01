package Sesi.senai.Projeto.controller;

import Sesi.senai.Projeto.model.Livros;
import Sesi.senai.Projeto.model.Usuario;
import Sesi.senai.Projeto.repository.UsuarioRepository;
import Sesi.senai.Projeto.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/Biblioteca/usuario/")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @PostMapping("criarUsuario")
    public Usuario criarUsuario(@RequestBody Usuario usuario) {
        return service.criarUsuario(usuario);
    }

    @GetMapping("user/{id}")
    public Usuario getUsuario(@PathVariable int id) {
            return service.findByid(id);
    }

    @GetMapping
    public List<Usuario> findAll() {
        return service.findAll();
    }

    @PutMapping("atualizar/{id}")
    public Usuario atualizarUsuario(@PathVariable int id, @RequestBody Usuario usuario) {
        return service.AtualizarUsuario(usuario, id);
    }

    @DeleteMapping("deletar/{id}")
    public void deletarUsuario(@PathVariable int id) {
        service.deletarUsuario(id);
    }

    @PostMapping("{idUsuario}/addLivro/{idLivro}")
    public Usuario adicionarLivroAoUsuario(
            @PathVariable Integer idUsuario,
            @PathVariable Integer idLivro) {

        return service.adicionarLivroExistente(idUsuario, idLivro);
    }
}
