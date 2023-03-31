# Imersão Java

## Dia 1:

* Requisição GET na [API do TMDB](https://developers.themoviedb.org/3) em uma endpoint para listar filmes utilizando HttpClient e a biblioteca Gson para converter os dados de String para objetos.

* Foi criada a classe `Movie` para armazenar os filmes e a classe `MovieService` a fim de buscar os dados na API.

### Resultado:

<p align="center">
    <img src="https://github.com/AbnerHS/ImersaoJava/blob/main/screenshots/dia1.png?raw=true"/>
</p>

## Dia 2:

* Foi criada uma funcionalidade na classe `StickerService` para gerar uma "figurinha" em PNG com um legenda. Essa função recebe como parâmetros um `InputStream` que representa a imagem, o nome do arquivo e uma legenda para escrever na imagem.

* Para cada filme da API utilizada (TMDB), foi gerada uma figurinha com a legenda "Top demais" e "Mais ou menos" com base em sua avaliação.

### Resultado:

<p align="center">
    <img src="https://github.com/AbnerHS/ImersaoJava/blob/main/img/movie/A%20Baleia.png?raw=true" width="150" height="275"/>
    <img src="https://github.com/AbnerHS/ImersaoJava/blob/main/img/movie/As%20M%C3%BAmias%20e%20o%20Anel%20Perdido.png?raw=true" width="150" height="275"/>
    <img src="https://github.com/AbnerHS/ImersaoJava/blob/main/img/movie/John%20Wick%204%20-%20Baba%20Yaga.png?raw=true" width="150" height="275"/>
    <img src="https://github.com/AbnerHS/ImersaoJava/blob/main/img/movie/Shazam!%20F%C3%BAria%20dos%20Deuses.png?raw=true" width="150" height="275"/>
</p>


## Dia 3:

* O código foi refatorado utilizando padrões de OO. Foi criada a classe `Model` que contém os campos: `title`, `imageUrl` e `date`. A classe `Movie` recebe herança de `Model`.

* Foi utilizado o endpoint APOD (<em>Astronomy Picture of the Day</em>) da [API da NASA](https://api.nasa.gov/) para obter imagens, com título e data.

* Foi criada a classe `Nasa` que recebe herança de `Model` e a classe `NasaService`, que busca os dados da API.

* Utilizou-se a mesma estrutura de geração de figurinhas para as imagens dessa API.

### Resultado:

<p align="center">
    <img src="hhttps://github.com/AbnerHS/ImersaoJava/blob/main/img/nasa/Cosmic%20Clouds%20in%20Cygnus.png?raw=true" width="512" height="391"/>
    <img src="https://github.com/AbnerHS/ImersaoJava/blob/main/img/nasa/M51%20-%20The%20Whirlpool%20Galaxy%20from%20Hubble.png?raw=true" width="540" height="407"/>
</p>


## Dia 4:

* Foi criado um novo projeto chamado de `api-languages`, que consiste em uma REST API utilizando o framework Spring Boot e o banco de dados NoSQL MongoDB. Essa API manipula a classe Language, com possui os atributos de `title`, `image` e `ranking`.

* Foram criados os `endpoints` de CRUD (Create, Read, Update e Delete), seguindo os padrões de HTTP Status Code.

## Resultado:

<p align="center">
    <img src="https://github.com/AbnerHS/ImersaoJava/blob/main/screenshots/dia4.png?raw=true" width="600" height="382">
</p>
