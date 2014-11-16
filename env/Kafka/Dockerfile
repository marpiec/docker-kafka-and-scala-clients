FROM fedora
MAINTAINER Marcin Pieciukiewicz <m.pieciukiewicz@gmail.com>

RUN yum update -y
RUN yum install wget -y

# Install JDK
RUN wget -O /tmp/java-jdk.rpm --no-cookies --no-check-certificate --header "Cookie: gpw_e24=http%3A%2F%2Fwww.oracle.com%2F; oraclelicense=accept-securebackup-cookie" "http://download.oracle.com/otn-pub/java/jdk/8u25-b17/jdk-8u25-linux-x64.rpm"
RUN yum localinstall /tmp/java-jdk.rpm -y
RUN rm -f /tmp/java-jdk.rpm
RUN export JAVA_HOME=/usr/java/latest

#Install Kafka
RUN wget -O /tmp/kafka_2.10.0-0.8.1.1.tgz "http://ftp.piotrkosoft.net/pub/mirrors/ftp.apache.org/kafka/0.8.1.1/kafka_2.10-0.8.1.1.tgz"
RUN tar xfz /tmp/kafka_2.10.0-0.8.1.1.tgz -C /opt

VOLUME ["/tmp/kafka-logs"]

ENV KAFKA_HOME /opt/kafka_2.10.0-0.8.1.1

ADD internal/kafka.sh /usr/bin/kafka.sh
ADD internal/generic-server.properties /opt/kafka_2.10-0.8.1.1/config/generic-server.properties

EXPOSE 9092
CMD ["kafka.sh"]
