package Sesi.senai.Projeto.service;

import Sesi.senai.Projeto.model.Livros;
import Sesi.senai.Projeto.repository.LivrosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivrosService {


    @Autowired
    private LivrosRepository livrosRepository;

    //Criar (POST)
    public Livros CriarLivros(Livros livros) {
        return livrosRepository.save(livros);
    }

    //Listar todos (GET)
    public List <Livros> ListarLivros(){
        return livrosRepository.findAll();
    }

    //Buscar por id (GET /{id})
    public Livros BuscarLivro(int id){
        return livrosRepository.findById(id).get();
    }

    //Atualizar (PUT /{id})
    public Livros AtualizarLivro(Livros livros, int id){
        return livrosRepository.findById(id)
                .map(livroAntigo -> {
                    livroAntigo.setTitulo(livros.getTitulo());
                    livroAntigo.setAutor(livros.getAutor());
                    livroAntigo.setDescricao(livros.getDescricao());
                    livroAntigo.setGenero(livros.getGenero());

                    return livrosRepository.save(livroAntigo);
                })
                .orElse(null);
    }


    //Deletar (DELETE /{id})
    public void ExcluirLivro(int id){
        livrosRepository.deleteById(id);
    }

    public Page<Livros> listarPaginado(Pageable pageable) {
        return livrosRepository.findAll(pageable);
    }


}
