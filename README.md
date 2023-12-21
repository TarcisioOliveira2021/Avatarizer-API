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

## Como clonar o projeto ? 
```
https://github.com/TarcisioOliveira2021/Avatarizer-API.git
```

## Como contribuir no projeto ?
Agradecemos o seu interesse em contribuir para o nosso projeto! Se você deseja fazer uma alteração ou adicionar um novo recurso, siga estes passos:

1. Crie um Fork do Projeto:
Faça um fork deste repositório para a sua própria conta no GitHub. Isso criará uma cópia do projeto que você pode modificar.

2. Realize as Alterações Propostas:
Faça as alterações necessárias no seu fork. Certifique-se de seguir as práticas recomendadas de codificação.

3. Solicite um Pull Request:
Quando estiver satisfeito com as suas alterações, envie um pull request. Estamos ansiosos para revisar suas contribuições!

4. Análise com Cuidado:
A nossa equipe analisará o seu pull request com atenção. Isso inclui verificar o código, testar as funcionalidades propostas e garantir que tudo esteja alinhado com os padrões do projeto.

5. Integração ao Projeto:
Se tudo estiver em ordem, estaremos felizes em integrar as suas alterações ao projeto principal. Agradecemos a sua colaboração!

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



