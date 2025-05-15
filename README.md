
# arq-backend-api-spring


## Descrição

Este projeto é uma implementação de uma arquitetura API Backend.

## Funcionalidades Primarias

- Autenticação de usuários
- Autorização baseada em papéis
- Integração com JWT/OAuth2
- Auditoria
- Estrutura modular e extensível
- Tabelas de exemplos (Product e Piece)
- Documentação Swagger
   - http://localhost:8080/swagger-ui/index.html
   - http://localhost:8080/v3/api-docs.yaml - Download YAML
- Tabelas de Dominios para cadastro de listas recorrentes. (tipos de produtos, unidades ferderativas ...)

## Estrutura do Projeto

A estrutura do projeto segue as melhores práticas do Spring, com pacotes organizados para separar as responsabilidades:

- `controller`: Contém os controladores REST que lidam com as requisições HTTP.
- `dto`: Contém propiedades das requests e response das requisições.
- `service`: Contém a lógica de negócio relacionada à autenticação e autorização.
- `repository`: Contém as interfaces para acesso aos dados.
- `model`: Contém as classes de modelo de dados.
- `global`: Contém as configurações do Spring Security e outras configurações do projeto.

## Tecnologias Utilizadas

- Java 17+
- Spring Boot 3.3.0
- Spring Security
- JWT/OAuth2
- Maven
- Docker

## Configuração e Execução

### Pré-requisitos

- Java 17+
- Maven 3.6+
- Banco de dados (por exemplo, MySQL, PostgreSQL, SQL Server ...)

### Passos para execução

1. Clone o repositório:
   ```bash
   git clone https://xxxx.git
   ```

2. Navegue até o diretório do projeto:
   ```bash
   cd backend-api
   ```

3. Configure o banco de dados no arquivo `application.properties`.

4. Execute o projeto usando Maven:
   ```bash
   mvn spring-boot:run
   ```

## Contribuição

1. Fork este repositório.
2. Crie uma branch para sua feature ou correção de bug (`git checkout -b feature/nome-feature`).
3. Commit suas mudanças (`git commit -am 'Adiciona nova feature'`).
4. Push para a branch (`git push origin feature/nome-feature`).
5. Abra um Pull Request.

## Docker

A API foi Conteinerizada usando docker, para subir ambos os containers, execute o seguinte comando:

```bash
docker compose up -d
```

Nesse caso o parametro "-d" serve para "detached mode" onde o terminal fica livre.

Caso seja necessário subir recriando os containers sem usar o cache, execute o seguinte o comando:

```bash
docker compose up -d --build --force-recreate
```

No comando acima ele sempre ira criar o container do zero sem usar o cache.

Para destruir os containers, utilize o seguinte comando:

```bash
docker compose down
```

Para mais informações sobre o docker consulte a [documentação oficial do Docker](https://docs.docker.com/)

### Known Issues

- Problema envolvendo a execução do Docker Desktop Windows

## Licença

Este projeto está licenciado sob os termos da licença MIT. Veja o arquivo LICENSE para mais detalhes.

---

Para mais detalhes, consulte a [documentação oficial do Spring](https://spring.io/projects/spring-boot) e a [documentação do JWT](https://jwt.io/introduction/).
