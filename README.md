# tqi_evolution_backend_2021

## Considerações iniciais
Esta é uma aplicação para solicitação de empréstimos. Essa API está sendo desenvolvida com:
* Java 11;
* Spring Boot 2.6.2;
* Maven;
* Banco de dados em memória H2;
* MapStruct;
* SpringDoc OpenAPI;
* Postman.

## Executando o projeto
Para executar o projeto com sucesso é necessário possuir o Java 11 instalado na máquina e também uma IDE que execute Java com Spring (as mais usadas são IntelliJ e
Eclipse). <br/>

Você deve baixar o projeto para a sua máquina (como zip ou usando o comando `git clone git@github.com:alanpinho/tqi_evolution_backend_2021.git` 
no diretório no qual você quer executar o projeto) e executar o projeto em uma IDE de sua preferência como uma Aplicação Spring Boot.

Você pode efetuar as requisições através do [Postman](https://www.postman.com/) ou do navegador. Ao executar a aplicação, estará disponível no navegador a interface do Swagger através da URL 
http://localhost:8080/swagger-ui.html para requisições, dispensando o uso do Postman.

## Endpoints
Até o momento tem-se dois endpoints, um para o cadastro de usuário e outro para o cadastro de solicitação de empréstimo. As requisições são da seguinte forma:

### Cadastro de usuário no Banco de Dados (POST)
* POST (http://localhost:8080/users/new) -> Cadastra um usuário no banco de dados. O formato suportado é JSON e os campos firstName, lastName, email, cpf, 
password e annualRevenue são obrigatórios. O modelo de requisição é apresentado logo abaixo. Cada cpf e email podem ser cadastrados em apenas uma conta.
````
{
    "firstName":  "Robert",
    "lastName": "C. Martin",
    "email": "robertcmartin@email.com",
    "cpf":"695.439.080-10",
    "rg":"1234564654",
    "password": "a nice password :D",
    "address": {
        "state": "Maranhão",
        "city": "New York",
        "street": "Rua das Margaridas",
        "houseNumber": "7",
        "district": "Manhattan",
        "zipCode": "65700000"
    },
    "annualRevenue": 2
}
````
### Cadastro de solicitação de empréstimo no Banco de Dados (POST)
* POST (http://localhost:8080/loans/new) -> Cadastra uma solicitação de empréstimo no banco de dados. O formato suportado é JSON e no campo "user" deve existir um 
usuário no banco de dados com o id indicado, caso contrário o código retornará status 400 Bad Request e não persistirá a requisição no banco. 
O modelo de requisição é apresentado logo abaixo. <br/>
O máximo de parcelas (instalments) é 60 e a data máxima para a primeira parcela é 3 meses contados a 
partir da data atual; <br/>
O valor requerido para empréstimo `totalLoanValueRequired` deve ser igual ou maior a 1; <br/>
O formato de data que deve ser passado é dd/MM/yyyy.
````
{
    "user": {        
        "id": 1
    },
    "totalLoanValueRequired": 20000,
    "dateOfFirstInstalment": "25/02/2022",
    "numberOfInstalments": 28
}
````
