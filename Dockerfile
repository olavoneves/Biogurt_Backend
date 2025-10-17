FROM eclipse-temurin:21-jdk

WORKDIR /biogurt

# Copia o .jar gerado da etapa de build
COPY --from=build /biogurt/target/*.jar biogurt-0.0.1-SNAPSHOT.jar

# Expõe a porta usada pela aplicação
EXPOSE 8080

# Define variáveis de ambiente (Render também pode sobrescrever)
ENV SPRING_PROFILES_ACTIVE=prod

# Comando para iniciar o app
ENTRYPOINT ["java", "-jar", "biogurt-0.0.1-SNAPSHOT.jar"]