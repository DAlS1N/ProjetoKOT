package Sesi.senai.Projeto.service;

import Sesi.senai.Projeto.repository.LivrosRepository;

public class LivrosService {

    private final LivrosRepository livrosRepository;

    public LivrosService(LivrosRepository livrosRepository) {
        this.livrosRepository = livrosRepository;
    }
}
