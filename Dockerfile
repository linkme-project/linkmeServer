FROM tomcat:latest
MAINTAINER Keunhak Lim<limkeunhak@gamil.com>

RUN mkdir -p /home/linkme
ADD . /home/linkme

WORKDIR /home/linkme
RUN chmod +x ./gradlew
RUN ./gradlew build

RUN mv /usr/local/tomcat/webapps/ROOT /usr/local/tomcat/webapps/ROOT_BAK
RUN cp ./build/libs/*.war /usr/local/tomcat/webapps/ROOT.war

EXPOSE 8080
