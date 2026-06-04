# Sistema de Registro de Importações e Exportações por Vias Navais

## Descrição

O Sistema de Registro de Importações e Exportações por Vias Navais é uma aplicação desenvolvida para auxiliar no gerenciamento de operações de comércio marítimo. O sistema permite o cadastro e controle de informações relacionadas a cargas importadas e exportadas através de portos e embarcações.

Este projeto foi desenvolvido como um Produto Mínimo Viável (MVP), focando nas funcionalidades essenciais para registro e consulta de operações marítimas.

---

## Objetivos

* Registrar operações de importação e exportação.
* Armazenar informações sobre mercadorias transportadas.
* Controlar dados de navios e portos envolvidos nas operações.
* Permitir consultas e atualizações dos registros cadastrados.
* Demonstrar a aplicação dos conceitos de CRUD (Create, Read, Update e Delete).

---

## Funcionalidades

### Cadastro de Operações

Permite registrar uma nova operação contendo:

* Tipo da operação (Importação ou Exportação)
* Nome da mercadoria
* Quantidade transportada
* País de origem ou destino
* Porto envolvido
* Nome da embarcação

### Consulta de Registros

Permite visualizar todas as operações cadastradas no sistema.

### Atualização de Registros

Permite alterar informações de uma operação já cadastrada.

### Remoção de Registros

Permite excluir operações do sistema.

---

## Estrutura dos Dados

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

## Tecnologias Utilizadas

* Linguagem de Programação: (preencher)
* Terminal/Console para interação com o usuário
* Estruturas de dados para armazenamento dos registros

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
