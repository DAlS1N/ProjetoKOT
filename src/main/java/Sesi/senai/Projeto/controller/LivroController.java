package Sesi.senai.Projeto.controller;

import Sesi.senai.Projeto.model.Livros;
import Sesi.senai.Projeto.service.LivrosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Biblioteca/livros/")
public class LivroController {

    @Autowired
    private LivrosService service;

    @PostMapping("criarLivro")
    public Livros criarLivro(@RequestBody Livros livros) {
        return service.CriarLivros(livros);
    }

    @GetMapping("livro/{id}")
    public Livros getLivro(@PathVariable int id) {
        return service.BuscarLivro(id);
    }

    @GetMapping
    public List<Livros> findAll() {
        return service.ListarLivros();
    }

    @PutMapping("atualizarlivros/{id}")
    public Livros atualizarLivro(@PathVariable int id, @RequestBody Livros livros) {
        return service.AtualizarLivro(livros, id);
    }

    @DeleteMapping("deletarlivro/{id}")
    public void deletarLivro(@PathVariable int id) {
        service.ExcluirLivro(id);
    }

    @GetMapping("paginado")
    public Page<Livros> listarPaginado(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        return service.listarPaginado(PageRequest.of(page, size));
    }


}
