<p align="center">
  <img src="https://github.com/TarcisioOliveira2021/Avatarizer-API/blob/main/readme-imagens/Avatarizer_logo_png.png">
</p>

<p align="center">
  <img src="https://img.shields.io/badge/java-%23000000.svg?style=for-the-badge&logo=openjdk&logoColor=white">
  <img src="https://img.shields.io/badge/spring-%23000000.svg?style=for-the-badge&logo=spring&logoColor=white">
</p>

# Avatarizer
API REST que usa sensibilidade ao contexto para a customização de avatares.

## Versão
Avatarizer1.0
* Nesta versão a aplicação atende apenas o contexto climatologico brasileiro com as temperaturas váriando de 22 ~ 29 graus celsius.

## Documentação da API
A nossa API é documentada usando o padrão OpenAPI, e a documentação interativa pode ser acessada através do Swagger UI. Isso facilita a compreensão dos endpoints disponíveis, parâmetros, e respostas esperadas.
Para acessar a documentação da API, basta iniciar o servidor e visitar o seguinte URL:
- URL produção : *http://avatarizer-prod.up.railway.app/avatar/dados/*
- Exemplo de consulta completo: http://avatarizer-prod.up.railway.app/avatar/dados/A_001?latitude=-9.974&longitude=-67.8076

## Avatares base
| Código avatar | Avatar Base |
|---|---|
| A_001 | ![Imagem 1](https://github.com/TarcisioOliveira2021/Avatarizer-API/blob/main/readme-imagens/A_001.png) |
| A_002 | ![Imagem 2](https://github.com/TarcisioOliveira2021/Avatarizer-API/blob/main/readme-imagens/A_002.png) |
| A_003 | ![Imagem 3](https://github.com/TarcisioOliveira2021/Avatarizer-API/blob/main/readme-imagens/A_003.png) |
| A_004 | ![Imagem 3](https://github.com/TarcisioOliveira2021/Avatarizer-API/blob/main/readme-imagens/A_004.png) |

## Alterações de contexto
Nas imagens a seguir estão definidas as regras que estão definidas dentro do processador de contexto.
![Imagem 3](https://github.com/TarcisioOliveira2021/Avatarizer-API/blob/main/readme-imagens/AdaptacoesDeContexto1.png)
![Imagem 1](https://github.com/TarcisioOliveira2021/Avatarizer-API/blob/main/readme-imagens/AdaptacoesDeContexto2.png)
![Imagem 2](https://github.com/TarcisioOliveira2021/Avatarizer-API/blob/main/readme-imagens/AdaptacoesDeContexto3.png)

## Funcionamento
O Avatarizer funciona da seguinte maneira, durante a requisição feita do cliente para aplicação devem ser passados:
* Código do avatar base.
* Latitude do usuário.
* Longitude do usuário.

Após isso será o servidor do Avatarizer vai processar a requisição no "processador de contexto" que a partir da regras definidas vai devolver o avatar customizado.



