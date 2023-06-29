#!/bin/sh

cd /app

# run the java application
exec java -jar /app/tcpping.jar "$@"

