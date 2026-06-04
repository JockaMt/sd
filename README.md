# Sistema de Registro de Importações e Exportações por Vias Navais

## 🚀 Quick Start - Como Rodar e Testar

> ⭐ **IMPORTANTE:** Este projeto possui **Swagger UI integrado**! Você pode testar todos os endpoints diretamente no navegador sem precisar de cURL, Postman ou qualquer outra ferramenta. Basta acessar `http://localhost:8080/swagger-ui.html` após iniciar a aplicação.

### Pré-requisitos
- Java 25+
- Gradle (ou usar `./gradlew` incluído)
- Navegador web (para Swagger UI)

### 1. Iniciar a Aplicação

```bash
# Navegar ao diretório do projeto
cd /caminho/para/projeto

# Executar a aplicação
./gradlew bootRun
```

A aplicação estará disponível em `http://localhost:8080`

### 2. 🎯 Testar Endpoints com Swagger UI (Recomendado)

**⭐ A forma mais fácil de testar sem ferramentas externas!**

Assim que a aplicação iniciar, abra no navegador:

```
http://localhost:8080/swagger-ui.html
```

#### O que você encontra no Swagger:

✅ **Documentação completa** de todos os endpoints
✅ **Interface interativa** para testar cada operação
✅ **Visualização dos DTOs** e estruturas esperadas
✅ **Testes diretos** sem necessidade de cURL, Postman ou outras ferramentas
✅ **Histórico de requisições** realizadas

#### Como testar no Swagger:

1. Selecione um endpoint da lista
2. Clique em "Try it out"
3. Preencha os parâmetros/body conforme necessário
4. Clique em "Execute"
5. Visualize a resposta em tempo real

---

### 3. Testar os Endpoints via cURL (Alternativa)

#### **PORTOS (Harbor)**

```bash
# Listar todos os portos
curl http://localhost:8080/harbor

# Criar novo porto
curl -X POST http://localhost:8080/harbor \
  -H "Content-Type: application/json" \
  -d '{"name":"Porto de Santos","location":"São Paulo, Brasil"}'

# Obter porto por nome
curl http://localhost:8080/harbor/Santos

# Atualizar porto
curl -X PUT http://localhost:8080/harbor/Santos \
  -H "Content-Type: application/json" \
  -d '{"newName":"Porto de Santos","newLocation":"Santos, SP"}'

# Deletar porto
curl -X DELETE http://localhost:8080/harbor/Santos
```

#### **PAÍSES (Country)**

```bash
# Listar todos os países
curl http://localhost:8080/country

# Criar novo país
curl -X POST http://localhost:8080/country \
  -H "Content-Type: application/json" \
  -d '{"name":"Brasil","code":"BR"}'

# Obter país por código
curl http://localhost:8080/country/BR

# Atualizar país
curl -X PUT http://localhost:8080/country/BR \
  -H "Content-Type: application/json" \
  -d '{"newName":"República Federativa do Brasil","newCode":"BRA"}'

# Deletar país
curl -X DELETE http://localhost:8080/country/BR
```

#### **MERCADORIAS (Merchandise)**

```bash
# Listar todas as mercadorias
curl http://localhost:8080/merchandise

# Criar nova mercadoria
curl -X POST http://localhost:8080/merchandise \
  -H "Content-Type: application/json" \
  -d '{"name":"Café","description":"Grãos de café premium","weight":500.50}'

# Obter mercadoria por nome
curl http://localhost:8080/merchandise/Café

# Atualizar mercadoria
curl -X PUT http://localhost:8080/merchandise/Café \
  -H "Content-Type: application/json" \
  -d '{"newName":"Café Premium","newDescription":"Grãos de café arábica","newWeight":600.00}'

# Deletar mercadoria
curl -X DELETE http://localhost:8080/merchandise/Café
```

#### **NAVIOS (Ship)**

```bash
# Listar todos os navios
curl http://localhost:8080/ship

# Criar novo navio
curl -X POST http://localhost:8080/ship \
  -H "Content-Type: application/json" \
  -d '{"register":"BR12345"}'

# Obter navio por registro
curl http://localhost:8080/ship/BR12345

# Atualizar navio
curl -X PUT http://localhost:8080/ship/BR12345 \
  -H "Content-Type: application/json" \
  -d '{"newRegister":"BR54321"}'

# Deletar navio
curl -X DELETE http://localhost:8080/ship/BR12345
```

---

## 🗃️ Documentação Interativa com Swagger

**Aproveite a documentação interativa do Swagger para explorar e testar todos os endpoints de forma intuitiva!**

Acesse: `http://localhost:8080/swagger-ui.html`

### Recursos do Swagger neste Projeto:

✨ **Listagem completa** de todos os 4 controladores (Harbor, Ship, Country, Merchandise)
✨ **Visualização detalhada** de cada endpoint com parâmetros e tipos esperados
✨ **Exemplos de requisição e resposta** prontos para análise
✨ **Testes interativos** diretos na interface - clique, preencha e execute
✨ **Validação automática** de tipos de dados
✨ **Documentação de modelos** com descrição de cada campo

É a forma **mais rápida e fácil** de explorar a API sem sair do navegador! 🎯

---

## 📋 Descrição Geral do Projeto

O Sistema de Registro de Importações e Exportações por Vias Navais é uma aplicação desenvolvida para auxiliar no gerenciamento de operações de comércio marítimo. O sistema permite o cadastro e controle de informações relacionadas a cargas importadas e exportadas através de portos e embarcações.

Este projeto foi desenvolvido como um Produto Mínimo Viável (MVP), focando nas funcionalidades essenciais para registro e consulta de operações marítimas.

### Objetivos

* Registrar operações de importação e exportação
* Armazenar informações sobre mercadorias transportadas
* Controlar dados de navios, portos e países envolvidos nas operações
* Permitir consultas e atualizações dos registros cadastrados
* Demonstrar a aplicação dos conceitos de CRUD (Create, Read, Update e Delete)
* Implementar Web Services REST para comunicação cliente-servidor

---

## 🏗️ Arquitetura

O projeto segue uma arquitetura em camadas:

```
┌─────────────────────────────────────┐
│      Controladores (REST API)       │  ← Controllers (HarborController, etc)
├─────────────────────────────────────┤
│        Serviços de Negócio          │  ← Services (HarborServices, etc)
├─────────────────────────────────────┤
│      Repositórios (Persistência)    │  ← Repositories (HarborRepository, etc)
├─────────────────────────────────────┤
│         Modelos de Dados            │  ← Models (Harbor, Ship, Country, etc)
├─────────────────────────────────────┤
│         Data Transfer Objects       │  ← DTOs (CreateHarborDTO, etc)
└─────────────────────────────────────┘
```

### Componentes Principais

**Modelos (Models)**
- `Harbor` - Representação de um porto
- `Ship` - Representação de uma embarcação
- `Country` - Representação de um país
- `Merchandise` - Representação de uma mercadoria

**Repositórios (Repositories)**
- Implementam persistência em memória
- Métodos: `create()`, `findAll()`, `findByXXX()`, `update()`, `delete()`

**Serviços (Services)**
- Lógica de negócio
- Intermediam entre Controllers e Repositories
- Padrão: `ListXXX()`, `CreateXXX()`, `GetXXX()`, `UpdateXXX()`, `DeleteXXX()`

**Controladores (Controllers)**
- Expõem endpoints REST
- Mapeamentos: GET, POST, PUT, DELETE
- Documentação automática via Swagger

---

## 🔌 Endpoints Disponíveis

### Harbor (Portos)
| Método | Endpoint | Descrição |
|--------|----------|-----------|
| GET | `/harbor` | Listar todos os portos |
| GET | `/harbor/{name}` | Obter porto por nome |
| POST | `/harbor` | Criar novo porto |
| PUT | `/harbor/{name}` | Atualizar porto |
| DELETE | `/harbor/{name}` | Deletar porto |

### Ship (Navios)
| Método | Endpoint | Descrição |
|--------|----------|-----------|
| GET | `/ship` | Listar todos os navios |
| GET | `/ship/{register}` | Obter navio por registro |
| POST | `/ship` | Criar novo navio |
| PUT | `/ship/{register}` | Atualizar navio |
| DELETE | `/ship/{register}` | Deletar navio |

### Country (Países)
| Método | Endpoint | Descrição |
|--------|----------|-----------|
| GET | `/country` | Listar todos os países |
| GET | `/country/{code}` | Obter país por código ISO |
| POST | `/country` | Criar novo país |
| PUT | `/country/{code}` | Atualizar país |
| DELETE | `/country/{code}` | Deletar país |

### Merchandise (Mercadorias)
| Método | Endpoint | Descrição |
|--------|----------|-----------|
| GET | `/merchandise` | Listar todas as mercadorias |
| GET | `/merchandise/{name}` | Obter mercadoria por nome |
| POST | `/merchandise` | Criar nova mercadoria |
| PUT | `/merchandise/{name}` | Atualizar mercadoria |
| DELETE | `/merchandise/{name}` | Deletar mercadoria |

---

## 📦 Data Transfer Objects (DTOs)

### CreateHarborDTO
```json
{
  "name": "string",
  "location": "string"
}
```

### UpdateHarborDTO
```json
{
  "newName": "string (opcional)",
  "newLocation": "string (opcional)"
}
```

### CreateCountryDTO
```json
{
  "name": "string",
  "code": "string (código ISO)"
}
```

### UpdateCountryDTO
```json
{
  "newName": "string (opcional)",
  "newCode": "string (opcional)"
}
```

### CreateMerchandiseDTO
```json
{
  "name": "string",
  "description": "string",
  "weight": "number"
}
```

### UpdateMerchandiseDTO
```json
{
  "newName": "string (opcional)",
  "newDescription": "string (opcional)",
  "newWeight": "number (opcional)"
}
```

### CreateShipDTO
```json
{
  "register": "string"
}
```

### UpdateShipDTO
```json
{
  "newRegister": "string"
}
```

---

## 🛠️ Tecnologias Utilizadas

- **Java 25** - Linguagem de programação
- **Spring Boot 4.0.6** - Framework web
- **Spring Data** - Acesso a dados
- **Gradle** - Gerenciador de dependências e build
- **⭐ Swagger/OpenAPI 3.0** - Documentação interativa de APIs (acesse em `/swagger-ui.html`)
- **JUnit** - Testes unitários

---

## 📁 Estrutura dos Dados

Cada registro possui os seguintes atributos:

| Campo      | Descrição                  |
| ---------- | -------------------------- |
| ID         | Identificador único        |
| Tipo       | Importação ou Exportação   |
| Mercadoria | Nome da carga              |
| Quantidade | Quantidade transportada    |
| País       | Origem ou destino          |
| Porto      | Porto associado à operação |
| Navio      | Embarcação responsável     |

---

## Entidades da Aplicação

### 1. Ship (Navio)

**Descrição:** Representa uma embarcação registrada no sistema para operações de transporte marítimo.

**Localização:** `src/main/java/com/distributedsystems/naval/models/Ship.java`

**Atributos:**

| Atributo  | Tipo   | Descrição                              | Exemplo                              |
| --------- | ------ | -------------------------------------- | ------------------------------------ |
| `id`      | String | Identificador único (UUID gerado)      | `550e8400-e29b-41d4-a716-446655440000` |
| `register`| String | Número de registro oficial do navio    | `BR12345`                            |

**Métodos:**

| Método                  | Retorno | Descrição                          |
| ----------------------- | ------- | ---------------------------------- |
| `getId()`               | String  | Retorna o identificador único      |
| `getRegister()`         | String  | Retorna o registro do navio        |
| `setRegister(newRegister)` | void | Atualiza o registro do navio       |

**Exemplo de Instância:**
```java
Ship ship = new Ship("BR12345");
// ship.id = "550e8400-e29b-41d4-a716-446655440000"
// ship.register = "BR12345"
```

---

### 2. Harbor (Porto)

**Descrição:** Representa um porto onde as operações de importação e exportação são realizadas.

**Localização:** `src/main/java/com/distributedsystems/naval/models/Harbor.java`

**Status:** Entidade em desenvolvimento (classe atualmente vazia)

**Atributos Propostos:**

| Atributo    | Tipo   | Descrição                          |
| ----------- | ------ | ---------------------------------- |
| `id`        | String | Identificador único do porto       |
| `name`      | String | Nome do porto (ex: Santos, Rio)    |
| `country`   | String | País onde o porto está localizado  |
| `capacity`  | Long   | Capacidade de carga do porto       |

---

## Relacionamentos Entre Entidades

```
Ship (Navio)
  ├── Um navio pode estar em um porto
  └── Id: UUID gerado automaticamente

Harbor (Porto)
  ├── Um porto pode ter múltiplos navios
  └── Id: Identificador único do porto
```

---

## Fluxo do Sistema

1. Usuário inicia o sistema.
2. Escolhe uma opção do menu principal.
3. Realiza operações de cadastro, consulta, edição ou exclusão.
4. O sistema atualiza os registros armazenados.
5. As informações podem ser consultadas a qualquer momento.

---

## Exemplo de Uso

Menu Principal:

1 - Cadastrar Operação </br>
2 - Listar Operações </br>
3 - Atualizar Operação </br>
4 - Excluir Operação </br>
5 - Sair </br>

Exemplo de cadastro:

Tipo: Exportação </br>
Mercadoria: Açúcar </br>
Quantidade: 500 toneladas </br>
País Destino: China </br>
Porto: Santos </br>
Navio: Ocean Star </br>

Registro cadastrado com sucesso.

---

## Possíveis Melhorias Futuras

* Persistência em banco de dados.
* Interface gráfica.
* Controle de usuários e autenticação.
* Relatórios estatísticos.
* Integração com sistemas portuários.
* Exportação de dados em PDF e Excel.

---

## Conclusão

O projeto demonstra a aplicação prática das operações CRUD em um contexto de logística marítima, permitindo o gerenciamento básico de importações e exportações por vias navais de forma simples e eficiente.
