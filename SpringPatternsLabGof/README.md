# 🧩 Visão Geral do Projeto
O projeto tem como objetivo criar uma API REST para gerenciamento de clientes, integrando dados de endereços via consulta a um serviço externo (OpenCep). A arquitetura aplica o padrão de projeto Strategy para desacoplar operações de negócio e utiliza FeignClient para comunicação com APIs externas.

### 🛠️ Tecnologias Utilizadas

- Spring Boot – Framework principal para desenvolvimento do backend

- Spring Data JPA – Para integração com banco de dados relacional

- OpenFeign – Para realizar chamadas HTTP para serviços externos

- H2 Database (ou outro) – Banco de dados para persistência

- Maven – Gerenciador de dependências

- Jakarta Persistence API – Para anotação das entidades

- Documentação com OpenAPI (Swagger) – Gera documentação interativa para facilitar testes e compreensão da API.

### 📦 Estrutura de Pacotes
|Pacote	|Responsabilidade|
|-------|----------------|
|controllers	|Camada REST que recebe requisições HTTP|
|services	|Regras de negócio e integração entre componentes|
|models	|Entidades do sistema (Cliente, Endereco)|
|repositories	|Interfaces para persistência com JPA|
|strategy	|Interfaces para abstração das estratégias|

### 🧠 Padrões Implementados
#### Strategy Pattern

- ClienteStrategy: abstrai ações sobre clientes.

- ViaCepStrategy: abstrai consulta ao serviço de endereço por CEP.

> Isso permite adicionar novas implementações facilmente, como integrar outro serviço de CEP no futuro.

### 🔗 Integração com OpenCep
O projeto usa @FeignClient para acessar a API:

````java
@FeignClient(name = "opencep", url = "https://opencep.com/v1")
public interface ViaCepStrategy {
    @GetMapping("/{cep}")
    Endereco buscarEnderecoPorCep(@PathVariable("cep") String cep);
}
````

Essa chamada busca os dados do endereço quando o cliente é inserido.

### 🔁 Fluxo de Operações
> Inserir Cliente<br>
Recebe requisição com dados do cliente (inclui CEP).<br>
Verifica se o endereço já existe no banco.<br>
Se não existir, consulta via Feign (opencep.com) e salva.<br>
Associa endereço ao cliente e salva cliente.

### 📘 Endpoints da API
|Método HTTP	    |Endpoint	|Descrição  |
|-------------------|-----------|-----------|
|GET	|/cliente ou /cliente/123	|Retorna todos os clientes|
|POST	|/cliente	|Insere novo cliente|
|PUT	|/cliente/123	|Atualizar o cliente por id|
|DELETE	|/cliente/123	|Remove o cliente por id|


### 🔧 Passo a Passo para Testar a API

1
. Executar o Projeto<br>
Certifique-se de que o projeto está configurado como uma aplicação Spring Boot (@SpringBootApplication)<br>
Rode o projeto com mvn spring-boot:run ou executando a classe principal no seu IDE.

2
. Acessar a Documentação Swagger<br>
Ao iniciar a aplicação, a documentação estará disponível em: <br>
- 👉 http://localhost:8080/swagger-ui.html ou 👉 http://localhost:8080/swagger-ui/index.html

Use essa interface para testar os endpoints diretamente no navegador sem precisar de ferramentas externas.

3
. Testar o Endpoint de Cadastro<br>
Faça um POST para /cliente com um corpo JSON como este:

````json
{
  "nome": "Maria Teste",
  "endereco": {
    "cep": "01001000"
  }
}
````
O sistema irá buscar o endereço completo do CEP informado usando a API OpenCep e armazenar o cliente com os dados preenchidos.

4
. Consultar Clientes Cadastrados<br>
Faça um GET em /cliente para visualizar todos os registros de clientes.

5
. Ferramentas Alternativas de Teste<br>
Além do Swagger, você pode testar usando:

|Ferramenta	|Descrição|
|-----------|---------|
|Postman	|Permite criar coleções de requisições e testar APIs com maior controle.|
|curl	|Ferramenta de linha de comando para realizar requisições HTTP.|
|Insomnia	|Parecido com o Postman, com foco em interface leve e rápida.|

### 🚀 Possíveis Evoluções Futuras 
### Para enriquecer ainda mais a solução, considere os seguintes aprimoramentos:

- Autenticação e Autorização Implementar segurança com JWT para proteger os endpoints e controlar o acesso baseado em papéis de usuário.

- Validações e Tratamento de Erros Aplicar validações mais robustas com Bean Validation e criar um handler global de exceções para respostas padronizadas e amigáveis.

- Testes Automatizados Cobertura com testes unitários (JUnit + Mockito) e testes de integração para garantir confiabilidade e facilitar refatorações.

- Versionamento de API Adicionar versionamento nos endpoints (ex: /v1/cliente) para preservar compatibilidade com aplicações que já utilizam versões anteriores.

#### 🔧 Com essas evoluções, o projeto pode sair do nível local de testes e se tornar uma solução robusta e pronta para ambientes reais.

### 📎 Considerações Finais

Este projeto estabelece uma base sólida para uma API REST moderna e extensível, demonstrando boas práticas de arquitetura, separação de responsabilidades e integração externa. O uso do padrão Strategy junto ao FeignClient permite flexibilidade na comunicação com serviços de terceiros, facilitando manutenções e expansões futuras.

### 🤝 Contribuições Bem-Vindas
> Este projeto está em constante evolução e todas as contribuições são mais que bem-vindas!<br>
Se você quiser sugerir melhorias, corrigir erros, incluir novas funcionalidades ou aprimorar a documentação, fique à vontade para abrir uma issue ou um pull request.

#### 📜 Código de Conduta
- Todas as interações devem seguir os princípios de respeito, colaboração e gentileza.
- Este projeto valoriza um ambiente inclusivo, onde todos possam aprender e contribuir.

## 📜 Licença e Direitos
Este projeto está sob a licença MIT, o que significa que você é livre para usar, copiar, modificar, mesclar, publicar e distribuir o código, desde que mantenha os avisos de copyright e a licença original.

### ❗ Responsabilidade
- O uso do projeto é feito por sua conta e risco.

- O autor original não se responsabiliza por quaisquer danos causados pelo uso indevido do código.