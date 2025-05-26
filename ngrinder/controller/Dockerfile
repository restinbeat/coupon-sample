FROM openjdk:11-jdk-slim

ENV NGRINDER_HOME=/opt/ngrinder
WORKDIR ${NGRINDER_HOME}

COPY ngrinder-controller.war .

EXPOSE 80 16001

CMD ["java", "-jar", "ngrinder-controller.war", "--port", "80"]

# https://github.com/naver/ngrinder/releases
