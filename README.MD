# Casino Romania

Este projeto é um jogo simples implementado em Java de como funcionas os Cassinos da Romênia. Este guia explica como configurar e executar o projeto usando Docker.

## Pré-requisitos

- [Docker](https://www.docker.com/get-started) instalado em sua máquina.

## Estrutura do Projeto

```bash
/casino-romania
├── Dockerfile
├── gradlew
├── gradle/
├── build.gradle
├── settings.gradle
└── src/
```

## Gerando .jar

```bash
./gradlew clean build
```

## Construindo a Imagem Docker

Para construir a imagem Docker do projeto, execute o seguinte comando no diretório onde está o `Dockerfile`:

```bash
docker build -t casino-romania
```

## Executando o Contêiner

```bash
docker run -it casino-romania
```