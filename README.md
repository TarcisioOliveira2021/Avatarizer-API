<p align="center">
  <img src="https://github.com/TarcisioOliveira2021/Avatarizer-API/blob/main/readme-imagens/Avatarizer_logo_png.png">
</p>

<p align="center">
  <img src="https://img.shields.io/badge/java-%23000000.svg?style=for-the-badge&logo=openjdk&logoColor=white">
  <img src="https://img.shields.io/badge/spring-%23000000.svg?style=for-the-badge&logo=spring&logoColor=white">
  <img src="https://img.shields.io/badge/-Swagger-%23000000?style=for-the-badge&logo=swagger&logoColor=white">
</p>


# Avatarizer
API REST que usa sensibilidade ao contexto para a customização de avatares.

# Funcionamento
O Avatarizer funciona da seguinte maneira, durante a requisição feita do cliente para aplicação devem ser passados:
* Código do avatar base.
* Latitude do usuário.
* Longitude do usuário.

O código do avatar base são **A_001**, **A_002**, **A_003**, **A_004**, representando:
* A_001 = Um rapaz careca.
* A_002 = Um moça de cabelo colorido.
* A_003 = Um rapaz de black-power.
* A_004 = Uma moça com vitiligo.

Executando a Aplicação localmente os testes de requisição podem ser feitos usando:
- Swagger: *http://localhost:8080/swagger-ui-avatarizer.html* 
- URL: *http://localhost:8080/avatar/dados/codigoDoAvatar* (Onde o código do avatar segue a lista citada acima).

Preview usnado Swagger:
https://github.com/TarcisioOliveira2021/Avatarizer-API/assets/79255361/75a48630-7464-41e7-80b5-c1780a7e660e

Preview usando URL:
https://github.com/TarcisioOliveira2021/Avatarizer-API/assets/79255361/25af43c8-faf6-48a6-aece-4b8d25f2304c




