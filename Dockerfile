FROM openjdk:17-alpine
VOLUME /tmp
ADD ./servicio-conexiones.jar servicio-conexiones.jar
ENTRYPOINT ["java","-jar","/servicio-conexiones.jar"]
