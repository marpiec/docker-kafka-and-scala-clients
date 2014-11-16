#!/bin/sh
cat /opt/kafka_2.10-0.8.1.1/config/generic-server.properties \
   | sed "s|{{advertised.host.name}}|$HOST_OS_IP|g" \
   | sed "s|{{zookeeper.connect}}|$ZOOKEEPER_ADDRESS|g" \
   > /opt/kafka_2.10-0.8.1.1/config/server.properties

/opt/kafka_2.10-0.8.1.1/bin/kafka-server-start.sh /opt/kafka_2.10-0.8.1.1/config/server.properties
