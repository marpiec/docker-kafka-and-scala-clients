#!/bin/sh
docker stop zookeeper 1> /dev/null  2> /dev/null
docker rm zookeeper 1> /dev/null  2> /dev/null
mkdir -p /tmp/zookeeper/zookeeper-1
nohup docker run --rm -p 2181:2181 -p 2888:2888 -p 3888:3888 -v /tmp/zookeeper/zookeeper-1:/tmp/zookeeper -t --name zookeeper zookeeper:latest 1> /tmp/zookeeper/zookeeper-1.log  2> /tmp/zookeeper/zookeeper-1.log.err &
echo "Zookeeper container started."