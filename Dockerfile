#FROM amd64/openjdk:11-slim
FROM openjdk:11
VOLUME /tmp
ADD build/libs/test-0.0.1-SNAPSHOT.jar app.jar
ENV JAVA_OPTS=""
ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar
