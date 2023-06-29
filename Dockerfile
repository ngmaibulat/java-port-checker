# Start with a base Java image
FROM openjdk:21

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file to the container
COPY build/libs/tcpping-all.jar /app/tcpping.jar

# Set environment variables

ENV PORTCHECKER_HOST="portquiz.net"
ENV PORTCHECKER_PORT="443"
ENV PORTCHECKER_TIMEOUT_MS="9000"

# Run the application
CMD ["java", "-jar", "/app/tcpping.jar"]
