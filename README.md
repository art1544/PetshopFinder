# PetShop Finder
Teste prático dti

## Sobre o Projeto

O PetShop Finder é uma aplicação web desenvolvida para o teste prático da dti digital `https://www.dtidigital.com.br/` e tem como objetivo ajudar o usuário a encontrar o melhor PetShop com base em critérios como preços e distância, focando no atendimento para cães de diferentes tamanhos. O sistema permite ao usuário inserir a data desejada para o serviço, o número de cães pequenos e grandes, e calcula qual PetShop oferece o melhor custo benefício.

## Tecnologias e Ferramentas Utilizadas

- **Spring Boot**: Framework para desenvolvimento de aplicações Spring com mais facilidade e rapidez.
- **Thymeleaf**: Template engine para aplicações web Spring, permite a criação de HTML dinâmico no servidor.
- **H2 Database**: Banco de dados em memória, utilizado para desenvolvimento e testes, facilitando a prototipagem.
- **Spring Data JPA**: Facilita a implementação de repositórios baseados em JPA.
- **Maven**: Gerenciador de dependências e ferramenta de build.

## Dependências Principais

- `spring-boot-starter-data-jpa`: Starter para usar Spring Data JPA com Hibernate.
- `spring-boot-starter-thymeleaf`: Starter para usar Thymeleaf como template engine.
- `spring-boot-starter-web`: Starter para construir web, incluindo RESTful, aplicações usando Spring MVC.
- `h2`: Banco de dados em memória.
- `spring-boot-starter-test`: Starter para testar aplicações Spring Boot.

## Como Executar o Projeto

### Pré-requisitos

- JDK 17
- Maven

### Passos para Execução

1. **Clonar o repositório:**
    Para clonar o repositório utilize a ferramente de desejo, como por exemplo o git Bash. 
    Em caso de uso do git bash, abra-o e execute os seguintes comandos:
   ```
   git clone [URL do repositório]
   cd [diretório do projeto]
   ```
2. **Instalar e configurar Maven**

    Video para instalar e configurar o Maven de acordo: `https://youtu.be/-ucX5w8Zm8s?si=wZOMlt_dxS31dfBx`

3. **Compilar e executar o projeto:**

    - Abra a pasta do repositório clonado;
    - Abra o terminal de comando na pasta src (onde está o pom.xml) e execute os seguintes comandos:
   ```
   mvn clean install
   mvn spring-boot:run
   ```

3. **Acessar a aplicação:**
   - Navegador: `http://localhost:8080/petshopfinder`

## Banco de Dados

- **URL de Acesso**: `http://localhost:8080/h2`
- **JDBC URL**: `jdbc:h2:mem:bancodti`
- **Usuário**: `sa`
- **Senha**: (sem senha)

## Configurações e Informações Adicionais

- **Arquivo de Configuração**:
  - Localizado em `src/main/resources/application.properties`.
  - Contém configurações do banco de dados, parâmetros de inicialização e outras configurações específicas do Spring.

## Premissas Assumidas

- Assume-se que os dados dos PetShops e preços estão pré-cadastrados e são estáticos.
- O sistema espera que todos os campos sejam preenchidos corretamente para que a busca por PetShops possa ser realizada.

## Decisões de Projeto

- Uso do H2 database para armazenamento dos dados dos petshops.
- SUso do Spring Boot para facilitar a configuração e a inicialização do projeto.
- Uso do padrao MVC para estruturação da aplicação.

## Links de Acesso

- **PetShop Finder**: `http://localhost:8080/petshopfinder`
- **Console do Banco de Dados H2**: `http://localhost:8080/h2`

## Contato

- **Email**: arthurmirandapacher@gmail.com
