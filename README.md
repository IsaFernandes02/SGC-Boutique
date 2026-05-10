# 👗 SGC - Boutique Chic & Elegance

## 📋 Sobre o Projeto
Sistema de Gestão Comercial (SGC) desenvolvido para uma boutique de moda feminina, com foco no controle de estoque, vendas e gestão de clientes.

O sistema foi projetado para auxiliar pequenos negócios na organização de suas operações diárias, proporcionando mais controle, eficiência e praticidade na gestão.

> 🎓 Projeto acadêmico da disciplina de Desenvolvimento de Sistemas (DS), do curso de Análise e Desenvolvimento de Sistemas (ADS).

---

## 🛠️ Tecnologias Utilizadas
- **Linguagem:** Java 21  
- **Framework:** Spring Boot 3+  
- **Banco de Dados:** MySQL  
- **Segurança:** Spring Security + JWT (JSON Web Token)  
- **Arquitetura:** Arquitetura em Camadas  

---

## 🏗️ Arquitetura do Sistema
O sistema segue o padrão de arquitetura em camadas, garantindo organização, escalabilidade e facilidade de manutenção:

- **Apresentação:** Interface (Java Swing ou Web) que consome a API REST  
- **Controller:** Responsável pelos endpoints da API  
- **Service:** Contém as regras de negócio  
- **Domain:** Entidades e modelos do sistema  
- **Repository:** Comunicação com o banco de dados via JPA  

---

## 🚀 Funcionalidades
- 📦 Controle de estoque  
- 💰 Registro de vendas  
- 👥 Gestão de clientes  
- 📊 Geração de relatórios  

---

## 🔐 Autenticação JWT

O sistema utiliza autenticação com JWT (JSON Web Token) para proteger os endpoints da API.

Fluxo de autenticação:

1. Realizar login no endpoint:
POST /auth/login

2. Copiar o token retornado

3. Enviar o token nas requisições protegidas:

Authorization: Bearer SEU_TOKEN

## 🌐 Endpoints Principais

👥 Clientes

- GET /clientes
- POST /clientes
- PUT /clientes/{id}
- DELETE /clientes/{id}

📦 Produtos

- GET /produtos
- POST /produtos
- PUT /produtos/{id}
- DELETE /produtos/{id}

🔐 Login

POST /auth/login

⚠️ Tratamento de Exceções

O sistema possui tratamento global de exceções utilizando @RestControllerAdvice.

Exceções implementadas:

- ClienteNaoEncontradoException
- ProdutoNaoEncontradoException
- CPFJaCadastradoException
- PrecoInvalidoException

🧪 Testes Realizados

Os testes da API foram realizados utilizando:

- Swagger UI
- Postman

Testes executados:

- ✅ Login com JWT
- ✅ CRUD completo de clientes
- ✅ CRUD completo de produtos
- ✅ Testes de autenticação
- ✅ Validação de exceções
- ✅ Integração com banco de dados MySQL

📘 Documentação Swagger

Após iniciar o projeto, acesse:

http://localhost:8080/swagger-ui.html

---

## 👤 Autores
**Isadora Fernandes** e **Jhonata Araujo**  
🎓 Análise e Desenvolvimento de Sistemas  
