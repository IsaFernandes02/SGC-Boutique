# 👗 SGC - Boutique Chic & Elegance

## 📋 Sobre o Projeto

Sistema de Gestão Comercial (SGC) desenvolvido para uma boutique de moda feminina, com foco no controle de estoque, vendas e gestão de clientes.

O sistema foi projetado para auxiliar pequenos negócios na organização de suas operações diárias, proporcionando mais controle, eficiência e praticidade na gestão.

> 🎓 Projeto acadêmico da disciplina de Desenvolvimento de Sistemas (DS), do curso de Análise e Desenvolvimento de Sistemas (ADS).

---

## 🛠️ Tecnologias Utilizadas

* **Linguagem:** Java 21
* **Framework:** Spring Boot 3+
* **Banco de Dados:** MySQL
* **Segurança:** Spring Security + JWT (JSON Web Token)
* **Frontend:** HTML, CSS, JavaScript, Bootstrap
* **Arquitetura:** Arquitetura em Camadas

---

## 🏗️ Arquitetura do Sistema

O sistema segue o padrão de arquitetura em camadas, garantindo organização, escalabilidade e facilidade de manutenção:

* **Apresentação:** Interface Web que consome a API REST
* **Controller:** Responsável pelos endpoints da API
* **Service:** Contém as regras de negócio
* **Domain:** Entidades e modelos do sistema
* **Repository:** Comunicação com o banco de dados via JPA

---

## 🚀 Funcionalidades

* 📦 Controle de estoque
* 💰 Registro de vendas
* 👥 Gestão de clientes
* 📄 Relatório de vendas

---

## 🔐 Autenticação JWT

O sistema utiliza autenticação com JWT (JSON Web Token) para proteger os endpoints da API.

### Fluxo de autenticação

1. Realizar login no endpoint:

```http
POST /auth/login
```

2. Copiar o token retornado

3. Enviar o token nas requisições protegidas:

```http
Authorization: Bearer SEU_TOKEN
```

---

## 🌐 Endpoints Principais

### 👥 Clientes

* GET /clientes
* GET /clientes/{id}
* POST /clientes
* PUT /clientes/{id}
* DELETE /clientes/{id}

### 📦 Produtos

* GET /produtos
* GET /produtos/{id}
* POST /produtos
* PUT /produtos/{id}
* DELETE /produtos/{id}

### 💰 Vendas

* GET /vendas
* POST /vendas

### 🔐 Login

```http
POST /auth/login
```

---

## 🌐 Interface Web

O sistema possui interface web integrada à API, contendo:

* Dashboard com indicadores (clientes, produtos, vendas e faturamento)
* Tela de clientes
* Tela de produtos
* Tela de vendas
* Tela de relatórios

---

## ⚠️ Tratamento de Exceções

O sistema possui tratamento global de exceções utilizando `@RestControllerAdvice`.

### Exceções implementadas

* ClienteNaoEncontradoException
* ProdutoNaoEncontradoException
* CPFJaCadastradoException
* PrecoInvalidoException

---

## 🧪 Testes Realizados

Os testes da API foram realizados utilizando:

* Swagger UI
* Postman

### Testes executados

* ✅ Login com JWT
* ✅ CRUD completo de clientes
* ✅ CRUD completo de produtos
* ✅ Registro de vendas
* ✅ Atualização automática de estoque
* ✅ Testes de autenticação
* ✅ Validação de exceções
* ✅ Integração com banco de dados MySQL
* ✅ Relatório de vendas

---

## ⚙️ Como Executar o Projeto

### ✅ Pré-requisitos

Antes de executar o projeto, é necessário ter instalado:

* **Java 21**
* **MySQL Server 8+**
* **Maven**

---

## 📥 Clonando o Projeto

Abra o terminal e execute:

```bash
git clone https://github.com/IsaFernandes02/SGC-Boutique.git
```

Depois entre na pasta:

```bash
cd SGC-Boutique
```

---

## 🗄️ Configuração do Banco de Dados

1. Crie um banco no MySQL:

```sql
CREATE DATABASE sgc_boutique;
```

2. Execute o script SQL localizado em:

```text
/database/sgc.sql
```

---

## 🔧 Configuração do application.properties

No arquivo:

```text
src/main/resources/application.properties
```

Configure:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/sgc_boutique
spring.datasource.username=SEU_USUARIO
spring.datasource.password=SUA_SENHA

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

## ▶️ Executando o Projeto

Execute a aplicação pela IDE ou utilize:

```bash
mvn spring-boot:run
```

A API ficará disponível em:

```text
http://localhost:8080
```

---

## 🧪 Testando a API

A API pode ser testada utilizando:

* Postman
* Swagger

### Swagger

```text
http://localhost:8080/swagger-ui.html
```

---

## 👤 Autores

**Isadora Fernandes**
**Jhonata Araujo**

🎓 Análise e Desenvolvimento de Sistemas – CEUB
