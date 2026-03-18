
# Spring Pdf Ai Resume

Este projeto tem como objetivo processar documentos PDF enviados por usuários, extraindo seu conteúdo textual por meio da biblioteca Apache PDFBox. Após a extração, o texto é analisado utilizando a LangChain4J, que atua como camada de integração com modelos de linguagem (LLMs), especificamente o Gemini. A partir dessa integração, o sistema é capaz de interpretar o conteúdo do documento e gerar automaticamente um resumo conciso e relevante do assunto abordado. A proposta central é demonstrar como combinar processamento de arquivos com inteligência artificial para automatizar a análise e síntese de informações em documentos.


## Tech Stack

**Back-end:** Java 21, Spring Boot 4.0.3, PDFBox, LangChain4J.



## Run Locally

1- Clone o Projeto

- Abra seu terminal ou prompt de comando e clone o projeto com o seguinte comando:

```bash
  git clone https://github.com/PedroUchoa/Spring-Pdf-Ai.git
```

2- Importação, Execução e Compilação do o Projeto na IDE


- Importe o projeto em sua IDE como um projeto Maven.

- Deixe que a IDE resolva e baixe todas as dependências do pom.xml.

```bash
   mvn clean package
```

- Rode o comando Maven para compilar o projeto antes da criação do container.

3- Rodando no Docker

- Rode o comando docker para criação do container e uso da aplicação e banco de dados no docker.

```bash
  docker-compose up --build
```



## API Reference

#### Get all items

```http
  POST /api/pdf/extract
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `form-data` | `file` | **Required**. Documento que será resumido. |