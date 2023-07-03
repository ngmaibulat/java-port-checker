# FROM gcr.io/distroless/base
FROM ubuntu:latest

WORKDIR /app

COPY install/tcpping-linux /app/tcpping


ENV LANG="en_US.UTF-8"
ENV NODE_ENV="production"

# Set environment variables
ENV PORTCHECKER_HOST="portquiz.net"
ENV PORTCHECKER_PORT="443"
ENV PORTCHECKER_TIMEOUT_MS="9000"

ENTRYPOINT ["/app/tcpping"]

CMD ["443"]
