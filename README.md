### PROJETO POO 

Este projeto implementa uma API REST completa, com CRUD, persistência no Supabase (PostgreSQL) e organização profissional de código.
Atende integralmente aos requisitos do trabalho da disciplina.

### Objetivo do Projeto

Criar uma API REST que permita realizar operações de CRUD sobre uma entidade principal escolhida pelo grupo (ex.: Livro, Produto, Animal, Cliente, etc.), utilizando:

- Java 17
- Spring Boot
- Supabase (PostgreSQL)
- Spring Web
- Spring Data JPA

Este README explica como rodar, como usar, e como o código funciona, camada por camada.

### Integrantes do Grupo
Nome	Contribuições (exemplo)
Kauã:	Model, Repository, integração Supabase, estrutura do projeto, testes, revisão
Otávio:	README.md e documentação dos endpoints
Thiago:	Services e regras de negócio e configuração do Maven/Swagger

### Tecnologias Usadas

Spring Boot — cria a API e gerencia todo o servidor

Spring Web — permite criar rotas HTTP (GET, POST, PUT, DELETE)

Spring Data JPA — facilita salvar e buscar dados no banco usando Java

PostgreSQL (Supabase) — banco de dados externo onde ficam os registros

Maven — gerenciador de dependências e execução

Java 17 — versão mínima exigida para o projeto
### Estrutura do Projeto (explicada)
src/main/java/.../projeto
 ├── controller/
 ├── service/
 ├── repository/
 ├── model/
 └── ProjetoApplication.java

### controller → “onde ficam os endpoints”

É a camada responsável por receber requisições HTTP.
Exemplo:

@GetMapping("/livros")
public List<Livro> listarTodos() { ... }


Ela não contém regra de negócio, apenas chama o service.

### service → “regra de negócio”

Aqui ficam as validações e decisões da aplicação.
Exemplo:

public Livro atualizar(Long id, Livro novo){
    Livro existente = repository.findById(id).orElseThrow();
    existente.setTitulo(novo.getTitulo());
    return repository.save(existente);
}


Service não sabe nada sobre HTTP, apenas lógica.

### repository → “conexão com o banco”

Faz acesso direto ao banco usando JPA.

public interface LivroRepository extends JpaRepository<Livro, Long> {}


O Spring gera automaticamente:

findAll()

findById()

save()

deleteById()

### model → “entidade da tabela”

Representa a tabela do banco Supabase.

@Entity
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String autor;
}


Cada atributo vira uma coluna no PostgreSQL.

### ProjetoApplication

Classe que inicializa o servidor Spring Boot:

@SpringBootApplication
public class ProjetoApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProjetoApplication.class, args);
    }
}

### Banco de Dados — Supabase
Como configurar o application.properties:
spring.datasource.url=jdbc:postgresql://db.<ID>.supabase.co:5432/postgres
spring.datasource.username=postgres
spring.datasource.password=SENHA_AQUI

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect

O que cada linha significa:

url → endereço do banco no Supabase

username/password → credenciais geradas na aba “Project Settings → Database”

ddl-auto=update → cria/atualiza tabelas automaticamente

show-sql=true → mostra no console os comandos SQL executados

dialect → informa que é PostgreSQL

### Como Rodar o Projeto
Clonar o repositório
git clone https://github.com/grupo/projeto-api.git

2️⃣ Ajustar credenciais do Supabase

Editar src/main/resources/application.properties

3️⃣ Rodar com Maven Wrapper
./mvnw spring-boot:run        # Linux/Mac
mvnw spring-boot:run          # Windows

4️⃣ Testar API
http://localhost:8080

📚 CRUD Implementado

A seguir, o CRUD da entidade principal.
Substituir “Livro” pelo domínio escolhido.

➤ 1. Listar todos

GET /api/livros

Como funciona internamente:

Controller chama service

Service chama repository.findAll()

JPA gera o SQL SELECT * FROM livro

Resultado volta em lista JSON

➤ 2. Buscar por ID

GET /api/livros/{id}

Se o ID existir → retorna

Se não existir → lança exceção (404)

➤ 3. Criar

POST /api/livros

Exemplo JSON:

{
  "titulo": "1984",
  "autor": "George Orwell"
}


Processo interno:

JSON vira objeto Java (model)

Service valida e chama repository.save()

Hibernate gera INSERT INTO no Supabase

Retorna o objeto criado com ID

➤ 4. Atualizar

PUT /api/livros/{id}

Processo:

Busca registro existente

Atualiza campos válidos

Salva de volta

Hibernate gera UPDATE

➤ 5. Deletar

DELETE /api/livros/{id}

Processo:

Service chama repository.deleteById(id)

Hibernate gera DELETE FROM

📄 Documentação dos Endpoints (Swagger)

Se o projeto usar Swagger:

Acesso:
http://localhost:8080/swagger-ui/index.html

Dependência:
<dependency>
    <groupId>org.springdoc</groupId>
    <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
    <version>2.3.0</version>
</dependency>


Swagger gera documentação automática lendo suas controllers.

👨‍💻 Boas Práticas Usadas (pedidas na rubrica)
✔ Código limpo

Nome de classes claros

Separação correta das camadas

DTOs e validações (caso usem)

✔ Comentários explicativos

Cada classe contém comentários dizendo o propósito

✔ Uso correto de Git

Commits pequenos e claros, exemplo:

feat: criar entidade Livro
feat: implementar endpoint POST /livros
fix: corrigir validação de título vazio
docs: adicionar instruções de execução no README

✔ Participação de cada integrante

Listada na tabela.
