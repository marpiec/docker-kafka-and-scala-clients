FROM fedora
MAINTAINER Marcin Pieciukiewicz <m.pieciukiewicz@gmail.com>

RUN yum update -y
RUN yum install -y -q zookeeper-server

ADD internal/zookeeper.sh /usr/bin/zookeeper.sh
ADD internal/conf/log4j.properties /etc/zookeeper/log4j.properties
ADD internal/conf/zoo.cfg /etc/zookeeper/zoo.cfg

VOLUME ["/tmp/zookeeper"]
EXPOSE 2181 2888 3888

CMD /usr/bin/zookeeper.sh