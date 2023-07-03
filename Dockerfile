FROM gcr.io/distroless/base
# FROM ubuntu:latest

WORKDIR /app

COPY install/tcpping-linux /app/tcpping

COPY install/libz.so.1 /lib
COPY install/libc.so.6 /lib/x86_64-linux-gnu/libc.so.6


ENV LANG="en_US.UTF-8"
ENV NODE_ENV="production"

# Set environment variables
ENV PORTCHECKER_HOST="portquiz.net"
ENV PORTCHECKER_PORT="443"
ENV PORTCHECKER_TIMEOUT_MS="9000"

ENTRYPOINT ["/app/tcpping"]

CMD ["443"]
