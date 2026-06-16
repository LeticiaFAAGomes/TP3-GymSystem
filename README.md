<div align="center">

# 🏋️ GymSystem

### Teste de Performance 3 — Arquitetura Poliglota com Spring Boot

<br/>

![Java](https://img.shields.io/badge/Java_21-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)
![H2](https://img.shields.io/badge/H2-003545?style=for-the-badge&logo=databricks&logoColor=white)
![MongoDB](https://img.shields.io/badge/MongoDB-4EA94B?style=for-the-badge&logo=mongodb&logoColor=white)
![Redis](https://img.shields.io/badge/Redis-DC382D?style=for-the-badge&logo=redis&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white)
![Status](https://img.shields.io/badge/Status-Concluído-brightgreen?style=for-the-badge)

<br/>

> Aplicação backend para gerenciamento de uma rede de academias, desenvolvida com **Spring Boot** e arquitetura poliglota utilizando **H2 (relacional)**, **MongoDB (NoSQL)** e **Redis (cache/token)**.

</div>

---

## 📋 Sumário

- [Sobre o Projeto](#-sobre-o-projeto)
- [Funcionalidades](#-funcionalidades)
- [Arquitetura](#-arquitetura)
- [Tecnologias](#-tecnologias)
- [Estrutura do Projeto](#-estrutura-do-projeto)
- [Como Executar](#-como-executar)
- [Bancos de Dados](#-bancos-de-dados)
- [Endpoints da API](#-endpoints-da-api)
- [Autora](#-autora)

---

## 💡 Sobre o Projeto

O **GymSystem** é uma API REST desenvolvida como entrega do **Teste de Performance 3** da disciplina de **Desenvolvimento de Serviços com Spring Boot** (Infnet).

O projeto demonstra na prática o uso de **persistência poliglota**, integrando três tecnologias de armazenamento distintas em uma única aplicação Spring Boot: banco relacional, NoSQL e cache em memória.

---

## ✅ Funcionalidades

- Cadastro de Alunos
- Listagem de Alunos Ativos
- Cadastro de Planos
- Cadastro de Instrutores
- Cadastro de Treinos vinculados a Instrutores
- Ranking de alunos por treinos concluídos
- Cadastro e consulta de Avaliações Físicas (MongoDB)
- Geração e validação de tokens de acesso (Redis)
- Monitoramento com Spring Actuator

---

## 🏛 Arquitetura

A aplicação segue o padrão de **arquitetura em camadas** com persistência poliglota:

```
┌─────────────────────────────────────────────┐
│           CLIENT  (Postman / cURL)           │
└─────────────────┬───────────────────────────┘
                  │  HTTP / REST (JSON)
┌─────────────────▼───────────────────────────┐
│           SPRING BOOT API · porta 8080       │
│                                              │
│  ┌──────────────────────────────────────┐   │
│  │         Controller  (REST)           │   │
│  └──────────────────┬───────────────────┘   │
│                     │                        │
│  ┌──────────────────▼───────────────────┐   │
│  │      Service  (Regras de Negócio)    │   │
│  └──────────────────┬───────────────────┘   │
│                     │                        │
│  ┌──────────────────▼───────────────────┐   │
│  │        Repository (Persistência)     │   │
│  └────────┬──────────────┬─────────┬────┘   │
└───────────┼──────────────┼─────────┼────────┘
            ▼              ▼         ▼
         H2 DB          MongoDB    Redis
      (Relacional)      (NoSQL)  (Cache / Token)
```

### Responsabilidade de cada banco

| Banco       | Tipo                | Uso no projeto                       |
| ----------- | ------------------- | ------------------------------------ |
| **H2**      | Relacional (SQL)    | Alunos, Planos, Instrutores, Treinos |
| **MongoDB** | Documento (NoSQL)   | Avaliações Físicas                   |
| **Redis**   | Chave-valor (Cache) | Geração e validação de tokens        |

---

## 🛠 Tecnologias

| Tecnologia          | Versão | Descrição                       |
| ------------------- | ------ | ------------------------------- |
| Java                | 21     | Linguagem principal             |
| Spring Boot         | 3.x    | Framework principal             |
| Spring Web          | —      | Camada REST / Controllers       |
| Spring Data JPA     | —      | Persistência relacional (H2)    |
| Spring Data MongoDB | —      | Persistência de documentos      |
| Spring Data Redis   | —      | Cache e gerenciamento de tokens |
| H2 Database         | —      | Banco relacional em memória     |
| Lombok              | —      | Redução de boilerplate          |
| Maven               | 3.x    | Gerenciamento de dependências   |
| Spring Actuator     | —      | Monitoramento e health check    |

---

## 📁 Estrutura do Projeto

```
GymSystem/
│
├── src/main/java/com/gymsystem/
│   ├── controllers/          # Endpoints REST
│   ├── services/             # Regras de negócio
│   ├── repositories/         # Acesso aos dados (JPA, Mongo, Redis)
│   ├── models/               # Entidades JPA e documentos MongoDB
│   ├── config/               # DataLoader e configurações
│   └── GymSystemApplication.java
│
├── src/main/resources/
│   └── application.properties
│
└── pom.xml
```

---

## 🚀 Como Executar

### Pré-requisitos

- [Java 21+](https://www.oracle.com/java/technologies/downloads/)
- [Maven 3.x](https://maven.apache.org/)
- [MongoDB](https://www.mongodb.com/try/download/community) rodando na porta `27017`
- [Redis](https://redis.io/downloads/) rodando na porta `6379`

### 1. Clone o repositório

```bash
git clone https://github.com/LeticiaFAAGomes/TP3-GymSystem.git
cd GymSystem
```

### 2. Execute a aplicação

```bash
mvn spring-boot:run
```

> A API estará disponível em: **`http://localhost:8080`**

---

## 🗄 Bancos de Dados

| Banco          | URL de acesso                      |
| -------------- | ---------------------------------- |
| **H2 Console** | `http://localhost:8080/h2-console` |
| **MongoDB**    | `mongodb://localhost:27017/gym`    |
| **Redis**      | `localhost:6379`                   |

---

## 🔗 Endpoints da API

### Alunos

| Método | Endpoint         | Descrição            |
| ------ | ---------------- | -------------------- |
| `POST` | `/alunos`        | Cadastrar aluno      |
| `GET`  | `/alunos/ativos` | Listar alunos ativos |

### Treinos

| Método | Endpoint   | Descrição      |
| ------ | ---------- | -------------- |
| `POST` | `/treinos` | Criar treino   |
| `GET`  | `/treinos` | Listar treinos |

### Ranking

| Método | Endpoint   | Descrição                                |
| ------ | ---------- | ---------------------------------------- |
| `GET`  | `/ranking` | Ranking de alunos por treinos concluídos |

### Avaliações Físicas — MongoDB

| Método | Endpoint                 | Descrição                   |
| ------ | ------------------------ | --------------------------- |
| `POST` | `/avaliacoes`            | Criar avaliação física      |
| `GET`  | `/avaliacoes/aluno/{id}` | Listar avaliações por aluno |

### Tokens — Redis

| Método | Endpoint            | Descrição             |
| ------ | ------------------- | --------------------- |
| `POST` | `/tokens/{alunoId}` | Gerar token de acesso |
| `GET`  | `/tokens/{token}`   | Validar token         |

### Actuator

| Método | Endpoint           | Descrição           |
| ------ | ------------------ | ------------------- |
| `GET`  | `/actuator/health` | Status da aplicação |

---

## 👩‍💻 Autora

Letícia Gomes Projeto desenvolvido para a disciplina de Projeto de Bloco de Desenvolvimento de Softwares Escaláveis.

---

## 📄 Licença

Este projeto foi desenvolvido para fins acadêmicos na disciplina de **Desenvolvimento de Serviços com Spring Boot** — Instituto Infnet.

---
