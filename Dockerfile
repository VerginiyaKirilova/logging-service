# Използваме официален JDK базиран image
FROM eclipse-temurin:17-jdk

# Създаваме директория в контейнера
WORKDIR /app

# Копираме jar файла (трябва вече да си билднала проекта с mvn package)
COPY target/logging-service-0.0.1-SNAPSHOT.jar app.jar

# Отваряме порт (по избор)
EXPOSE 8081

# Стартова команда
ENTRYPOINT ["java", "-jar", "app.jar"]
