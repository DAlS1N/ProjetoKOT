package Sesi.senai.Projeto.repository;

import Sesi.senai.Projeto.model.Livros;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivrosRepository extends JpaRepository<Livros, Integer> {
}
