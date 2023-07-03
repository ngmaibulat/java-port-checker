# Start with a base Java image
FROM openjdk:21

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file to the container
COPY build/libs/tcpping-all.jar /app/tcpping.jar
COPY scripts/entrypoint.sh /app/entrypoint.sh

RUN chmod +x /app/entrypoint.sh

# Some common env, not really needed
# But useful for other containers
# so, keep them as standard practice

ENV LANG="en_US.UTF-8"
ENV NODE_ENV="production"

# Set environment variables
ENV PORTCHECKER_HOST="portquiz.net"
ENV PORTCHECKER_PORT="443"
ENV PORTCHECKER_TIMEOUT_MS="9000"

# Run the application


ENTRYPOINT ["/bin/sh", "/app/entrypoint.sh"]

# CMD ["java", "-jar", "/app/tcpping.jar"]
CMD ["443"]
