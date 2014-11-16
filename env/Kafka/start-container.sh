#!/bin/sh
docker stop kafka 1> /dev/null  2> /dev/null
docker rm kafka 1> /dev/null  2> /dev/null
mkdir -p /tmp/kafka/kafka-1
CURRENT_HOST_IP=$(hostname -I | cut -d' ' -f1 )
nohup docker run --rm -p 9092:9092 -v /tmp/kafka/kafka-1:/tmp/kafka-logs --link zookeeper:zookeeper -e "HOST_OS_IP=$CURRENT_HOST_IP" -e "ZOOKEEPER_ADDRESS=$CURRENT_HOST_IP:2181" --name kafka kafka:latest 1> /tmp/kafka/kafka-1.log  2> /tmp/kafka/kafka-1.log.err &
echo "Kafka container started."
