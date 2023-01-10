###### apirest-springboot
>REST API using SPRINGBOOT, with MVC pattern.





# Sobre o projeto
Projeto prático com objetivo de criar uma API REST que otenha tais funcionalidades: 
* Criar uma pessoa
* Editar uma pessoa
* Consultar uma pessoa
* Listar pessoas
* Criar endereço para pessoa
* Listar endereços da pessoa
* Poder informar qual endereço é o principal da pessoa

## Progresso
* Projeto em desenvolvimento, progresso de 65%.
* Funcionalidades restantes: 
                    1. Criar endereço para pessoa
                    2.Listar endereços da pessoa
*Caso haja dúvidas ou considerações a fazer, envie um e-mail para: luiseduardobborges@gmail.com

## Tecnologias
* Java 17
* Springboot 3.0.1
* H2 Database Engine
* Apache Maven 3.8.6
* Lombok 1.18.24
* Postman v10.7.0
* ModelMapper-spring 3.0.0

## Requisitos
Necessário o uso do [JDK 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html) e plugin maven. Para requisições HTTP use um software como o [POSTMAN](https://www.postman.com/downloads/).
>Acesso banco H2(browser): http://localhost:8080/h2
```
Login H2:
JDBC URL: jdbc:h2:mem:addresses
username: admin
password: 
```
##Instalação e Uso
1. Clone o repositório, após starte o projeto em sua IDE de preferência. Recomenda-se o uso do [ECLIPSE](https://www.eclipse.org/downloads/). 
2. Abra seu software de requisções HTTP.
3. Abra seu banco H2 em seu browser de preferência.


##### Criar uma Pessoa
* Faça a requisção no software HTTP: http://localhost:8080/person
* Acesse através de um body usando formato JSON:
* O id de PESSOA e ENDEREÇO são gerados automáticamente.
```
{
    "name": "Luis",
    "birthdate": "08/11/2005",
    "mainAddress" : {
        "principalCity" : "Brasília",
        "principalZipCode" : 7137500,
        "principalPlace": "Águas Claras/DF",
        "pricipalNumber": "123"
    },
    "address" : [{
        "city" : "Brasília",
        "zipCode" : 7137500,
        "place": "Águas Claras/DF",
        "number": "123"
    },
    {
        "city" : "Salvador",
        "zipCode" : 7137500,
        "place": "Águas Claras/DF",
        "number": "123"}]
}
```

###### Consultar uma Pessoa
* Faça uma Requisição get no link http://localhost:8080/person/{id}
* O {id} deve ser substituído pelo id da pessoa que quer consultar. Exemplo para consultar pessoa de id 1: http://localhost:8080/person/1
* A resposta será no formato JSON, você pode acessá-lo pelo navegador também.

###### Listar Pessoas
* Faça uma Requisição get no link http://localhost:8080/person/
* As pessoas já estão listadas no painel administrativo, mas, nesse endereço você receberá um JSON com a lista de todas pessoas e seus detalhes. Você pode acessá-lo no navegador.

###### Deletar Pessoas
* Faça uma Requisição DELETE no link http://localhost:8080/person/{id}
* O {id} deve ser substituído pelo id da pessoa que quer deletar. Exemplo para consultar pessoa de id 1: http://localhost:8080/person/1

###### Outros recursos:
* Implementados a passo da conclusão do projeto.

###### Arquitetura do Projeto
```
addresses

  ├── AddressesApplication.java

  ├── configuration
          └── Instantiation.java

  ├── controller
          └── PersonController

  ├── model
         ├── EntidadeEndereco
         ├── EntidadeEnderecoPrincipal
         └── EntidadePessoa
        └──repository
              ├── EnderecoRepository
              └── PRepository

  ├── dto   
        ├── Config
              └── ModelMapperConfig
        ├── PersonMapper
              └── PersonMapper
        ├── REQUEST
                 ├── RequestEndereco
                 └── RequestPerson
        └── RESPONSE
                 ├── ResponseEndereco
                 └── ResponsePerson

  └── service
        └── PersonServices
```
