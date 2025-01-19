FROM public.ecr.aws/docker/library/amazoncorretto:21.0.5
# FROM artifactory.spectrumtoolbox.com/docker-naas-virt/amazoncorretto:21.0.5

ARG JAR_FILE=target/*.jar

WORKDIR /app
COPY ${JAR_FILE} /app/app.jar
USER 1000:1000

EXPOSE 8090

ENTRYPOINT ["java", "-jar", "/app/app.jar"] 
