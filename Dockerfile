# Usar imagem Java oficial
FROM openjdk:17-jdk-slim

# Criar pasta dentro do container
WORKDIR /app

# Copiar o jar gerado
COPY Caixa.jar .

# Rodar o jar quando o container iniciar
CMD ["java", "-jar", "Caixa.jar"]
