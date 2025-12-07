# --------------------------------------------------------------------------------
# ETAPA 1: Construção do Artefato (Build)
# --------------------------------------------------------------------------------
FROM maven:3.9.5-eclipse-temurin-17 AS build

# Define o diretório de trabalho dentro do container
WORKDIR /app

# Copia o arquivo de configuração do Maven e baixa dependências
COPY pom.xml .
RUN mvn dependency:go-offline

# Copia todo o código-fonte
COPY src ./src

# Empacota a aplicação em um arquivo JAR executável
RUN mvn package -DskipTests

# --------------------------------------------------------------------------------
# ETAPA 2: Criação da Imagem Final (Runtime)
# --------------------------------------------------------------------------------
FROM eclipse-temurin:17-jre-alpine

# Define o diretório de trabalho
WORKDIR /usr/local/devcalc

# COPIA CORRIGIDA: Usa o nome do Fat JAR (devcalc-api-full.jar)
COPY --from=build /app/target/devcalc-api-full.jar devcalc-api.jar

# Expõe a porta que a aplicação Java usa (7000)
EXPOSE 7000

# Define o comando que será executado quando o container iniciar
ENTRYPOINT ["java", "-jar", "devcalc-api.jar"]