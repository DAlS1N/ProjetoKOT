📘 API REST — Projeto Spring Boot + PostgreSQL (Supabase)

Este projeto foi desenvolvido como trabalho prático da disciplina de Backend, com o objetivo de construir uma API REST completa, documentada, organizada e persistindo dados no Supabase (PostgreSQL).

O domínio escolhido foi:
📚 Sistema de Gerenciamento de Usuários e Livros

🧩 1. Objetivo do Projeto

Atender aos seguintes requisitos:

Criar uma API REST funcional em Java + Spring Boot

Implementar CRUD completo de pelo menos 1 entidade (Usuário)

Persistir informações no PostgreSQL via Supabase

Organizar código em camadas (Controller, Service, Repository, Model)

Criar um README didático explicando como rodar e testar

Documentar todos os endpoints

Uso correto do GitHub

🚀 2. Tecnologias Utilizadas

Java 17

Spring Boot

Spring Web

Spring Data JPA

Spring Security (apenas PasswordEncoder)

PostgreSQL (Supabase)

Springdoc OpenAPI (Swagger UI)

Maven

Lombok

🏗️ 3. Arquitetura do Projeto (Explicada)

A API segue a arquitetura em camadas:

src/main/java/Sesi/senai/Projeto
│
├── controller      → controla rotas HTTP
├── service         → regras de negócio
├── repository      → comunicação com o banco via JPA
├── model           → entidades (tabelas)
└── ProjetoApplication.java

🧱 4. Modelos do Sistema
📌 4.1. Entidade Usuario

Representa um usuário do sistema.

Campos:

id (Integer)

nome (String)

email (String)

senha (String) — idealmente encriptada

livros (List<Livros>)

📌 4.2. Entidade Livros

Representa um livro cadastrado no sistema.

Campos:

id (Integer)

titulo (String)

autor (String)

usuario (Usuario) — dono do livro

Relacionamento:
Um usuário pode ter vários livros (OneToMany).

📚 5. Explicação dos Códigos (Didática)

Esta seção foi feita para facilitar correção, entendimento e leitura do código.

✔️ 5.1. UsuarioService — Lógica de Negócio

Arquivo: UsuarioService.java

É a classe onde ficam todas as regras do sistema relacionadas ao usuário.

Métodos principais:
● criarUsuario(Usuario usuario)

Salva um novo usuário no banco.

● findAll()

Retorna todos os usuários cadastrados.

● findByid(int id)

Busca um usuário por ID.
Obs: O correto seria usar orElseThrow e não .get().

● AtualizarUsuario(Usuario usuarioNovo, int id)

Atualiza nome, email e senha do usuário.

● deletarUsuario(int id)

Remove o usuário do banco.

● adicionarLivroExistente(idUsuario, idLivro)

Associa um livro já existente a um usuário.

Fluxo:

Busca o usuário

Busca o livro

Liga o livro ao usuário

Salva

● buscarPorEmail(String email)

Retorna o usuário com esse email.

● listarPaginado(Pageable pageable)

Retorna usuários paginados.

✔️ 5.2. UsuarioController

Controla todas as rotas /usuario.

Exemplos:

GET /usuario → lista

POST /usuario → cria

PUT /usuario/{id} → atualiza

DELETE /usuario/{id} → exclui

✔️ 5.3. LivrosService & LivrosController

Idêntico à lógica de Usuário, porém aplicado a livros.

✔️ 5.4. Repositórios (UsuarioRepository e LivrosRepository)

São interfaces que estendem:

JpaRepository<Usuario, Integer>


Eles fornecem:

save()

findAll()

findById()

deleteById()

paginação

buscas personalizadas

Exemplo presente no projeto:

Usuario findByEmail(String email);

🗄️ 6. API estará disponível em:

👉 http://localhost:9090

👉 http://localhost:9090/swagger-ui/index.html
 (Swagger)

📑 7. Endpoints Documentados
🔵 USUÁRIOS — /usuario
GET /usuario

Lista todos os usuários.

GET /usuario/{id}

Retorna um usuário pelo ID.

POST /usuario

Cria um novo usuário.
Exemplo:

{
  "nome": "João",
  "email": "joao@mail.com",
  "senha": "1234",
  "role": "admin"
}

PUT /usuario/{id}

Atualiza dados do usuário.

DELETE /usuario/{id}

Remove o usuário.

🔴 LIVROS — /livros
GET /livros

Lista todos os livros.

POST /livros

Cria um novo livro.

PUT /livros/{id}

Atualiza um livro existente.

DELETE /livros/{id}

Remove um livro.

🟣 Associação
POST /usuario/{idUsuario}/add-livro/{idLivro}

Associa um livro existente ao usuário informado.

📘 8. Funcionalidades Extra Implementadas

✔️ Paginação de usuários
✔️ Busca por e-mail
✔️ Associação de livros a usuários
✔️ Swagger (documentação automática)

👥 9. Integrantes do Grupo
Nome	Função no Projeto
Kauã	Controller, organização do Git, services + lógica de negócio, configuração Supabase
Otávio	Entidades + Repositórios
Thiago 3	Documentação + Testes
