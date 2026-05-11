# 🕹️ Gamers Social - AC3

**Projeto Fullstack desenvolvido em Spring Boot + Frontend HTML/CSS/JS**

## 🚀 Funcionalidades Implementadas
✅ Sistema de Avaliações: Entidade Avaliacao com relacionamento Many-to-One (Usuários podem avaliar jogos com 1 a 5 estrelas).
✅ Cálculo de Média: Cards de jogos no Frontend agora exibem a média de estrelas em tempo real.
✅ Busca Inteligente: Implementação de Custom Queries no Repository para filtrar jogos por nome ou gênero.
✅ Barra de Pesquisa: Interface integrada no Frontend para localização rápida de títulos.
✅ Backend Evoluído: Endpoints específicos para salvar e listar o histórico de avaliações.
  
## 📱 Como testar
## 1. Backend
cd backend
mvn clean spring-boot:run
Roda na porta 8081 ✓

## 2. Frontend  
- Abra http://localhost:8081

## 3. Fluxo completo:
 - Acesse tela de login
 - Faça login/cadastro de usuário
 - Acesse CRUD de jogos
 - Cadastre/liste/remova jogos

## 📁 Estrutura
gamers-social/
├── .vscode/                 # Configurações do editor
├── backend/                 # Core da aplicação (Spring Boot)
│   ├── src/main/java/com/gamersocial/backend/
│   │   ├── controller/      # Endpoints (Avaliacao, Jogo, Users)
│   │   ├── model/           # Entidades (Avaliacao, Jogo, User)
│   │   ├── repository/      # Interfaces de acesso ao banco (JPA)
│   │   └── GamersSocialApplication.java
│   ├── src/main/resources/
│   │   ├── Static/          # Frontend (index.html)
│   │   └── application.properties
│   └── pom.xml              # Dependências Maven
└── readme.md


## 🛠️ **Stack Tecnológica**

| Frontend | Backend | Banco |
|----------|---------|-------|
| HTML5/CSS3/JS | Spring Boot 3.3.2 | PostgreSQL |
| Fetch API | JPA/Hibernate | HikariCP |
| Dark Mode | REST API | |

## 📊 Kanban
Jira/(https://kelvinlimasw.atlassian.net/jira/software/projects/KAN/boards/1?atlOrigin=eyJpIjoiZGZlYWUxNTFhMmJkNDI4ZDliZGJjOTFmM2FmZGYyN2QiLCJwIjoiaiJ9)

