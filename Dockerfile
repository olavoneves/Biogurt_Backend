# ---- Etapa 1: Build ----
FROM maven:3.9.8-eclipse-temurin-17 AS builder

# Define o diretório de trabalho
WORKDIR /app

# Copia o pom.xml e baixa dependências
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copia o código-fonte
COPY src ./src

# Compila e empacota o projeto
RUN mvn clean package -DskipTests

# ---- Etapa 2: Runtime ----
FROM eclipse-temurin:17-jdk

# Define diretório de trabalho
WORKDIR /app

# Copia o JAR da etapa de build
COPY --from=builder /app/target/*.jar app.jar

# Expõe a porta padrão do Spring Boot
EXPOSE 8080

# Variável de ambiente (Render também usa)
ENV SPRING_PROFILES_ACTIVE=prod

# Comando de inicialização
ENTRYPOINT ["java", "-jar", "app.jar"]
