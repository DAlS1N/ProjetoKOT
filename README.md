### Projeto API - Biblioteca
Este projeto é uma API biblioteca permitindo o cadastro de seus usuarios e seus livros.

---

### Equipe e Organização
### Kauã - 
 Regras de negócio
 Repositórios
 CRUD
### Otávio - 
 Setup inicial
 Documentação dos endpoints (README)
### Thiago - 
 Entidades
 Organização do repositório

---

### Tenologias utilizadas
Java
MySql
Spring boot
Spring data JPA
Mavem

---

### Entidades do sistema
- Livro
  id
  genero
  autor
  descricão
  usuario

- Usuario
  id
  nome
  email
  senha
  livros

#### EndPoints

### Livros
#### Criar Livro  
`POST /livros`  
Body:
```json
{
  "titulo": "O Hobbit",
  "descricao": "A aventura de Bilbo",
  "genero": "Fantasia",
  "autor": "J.R.R. Tolkien",
  "usuario": { "id": 1 }
}
```

#### Listar Livros  
`GET /livros`

#### Buscar Livro por ID  
`GET /livros/{id}`

#### Atualizar Livro  
`PUT /livros/{id}`

#### Deletar Livro  
`DELETE /livros/{id}`

---

### Usuarios

#### Criar Usuário  
`POST /usuarios`  
Body:

```json
{
  "nome": "Otávio",
  "email": "exemplo@email.com",
  "senha": "123456"
}
```

#### Listar Usuários  
`GET /usuarios`

#### Buscar Usuário por ID  
`GET /usuarios/{id}`

#### Atualizar Usuário  
`PUT /usuarios/{id}`

#### Deletar Usuário  
`DELETE /usuarios/{id}`

---

## Como Rodar o Projeto

### Clonar o repositório
```
git clone https://github.com/SEU-USUARIO/SEU-REPOSITORIO.git
```

### Configurar Banco de Dados  
Criar um banco no MySQL:
```
CREATE DATABASE biblioteca;
```

### Configurar o `application.properties`
```
spring.datasource.url=jdbc:mysql://localhost:3306/biblioteca
spring.datasource.username=root
spring.datasource.password=SUASENHA
spring.jpa.hibernate.ddl-auto=update
```

### Rodar o projeto
Via IDE ou:
```
mvn spring-boot:run
```

---

## Status do Projeto
100% funcional — pronto para testes no Postman!






