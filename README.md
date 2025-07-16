# 🚀 Desafio: Criando uma API REST para Gerenciamento de Clientes

## 📝 Descrição
Neste desafio, você deverá construir uma API REST utilizando Java com Spring Boot para gerenciar clientes. O diferencial é que, ao cadastrar um cliente, o endereço completo será preenchido automaticamente a partir do CEP informado, consultando uma API externa.

### 🎯 Objetivo
Crie uma API que permita:

> ✅ Cadastrar um cliente informando apenas nome e CEP

> ✅ Buscar o endereço automaticamente da API OpenCep (https://opencep.com/v1)

> ✅ Salvar clientes e seus respectivos endereços no banco

> ✅ Consultar todos os clientes cadastrados

### 🛠️ Tecnologias sugeridas

- Java 17+
- Spring Boot
- Spring Data JPA
- Spring Cloud OpenFeign
- Swagger para documentação da API

### 📌 Requisitos
&nbsp;&nbsp;&nbsp;&nbsp;🔹Criar as entidades Cliente e Endereco

&nbsp;&nbsp;&nbsp;&nbsp;🔹Criar repositórios com Spring Data

&nbsp;&nbsp;&nbsp;&nbsp;🔹Implementar consumo de API externa via Feign

&nbsp;&nbsp;&nbsp;&nbsp;🔹Utilizar padrão Strategy para organizar a lógica

&nbsp;&nbsp;&nbsp;&nbsp;🔹Documentar os endpoints com Swagger

### 🧪 Teste esperado
Ao fazer um POST para /cliente com:

````json
{
  "nome": "João Dev",
  "endereco": {
    "cep": "01001000"
  }
}
````
O sistema deve buscar os dados do CEP, salvar o endereço completo no banco, e associá-lo ao cliente.
