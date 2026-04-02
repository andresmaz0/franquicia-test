# Etapa 1: Construcción (Genera el .jar)
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app
COPY . .
# Ejecutamos el empaquetado saltando los tests para agilizar el despliegue
RUN mvn clean package -DskipTests

# Etapa 2: Ejecución (Imagen ligera para correr el .jar)
FROM eclipse-temurin:21-jre-jammy
WORKDIR /app
# Copiamos el jar generado en la etapa anterior
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
# Cloud Run usará este comando por defecto
ENTRYPOINT ["java", "-jar", "app.jar"]