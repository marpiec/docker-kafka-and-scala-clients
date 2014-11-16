#!/bin/sh

# Run the zookeeper instance
/usr/lib/jvm/jre-1.7.0/bin/java -classpath /etc/zookeeper:/usr/share/java/slf4j/slf4j-log4j12.jar:/usr/share/java/slf4j/slf4j-api.jar:/usr/share/java/netty.jar:/usr/share/java/log4j.jar:/usr/share/java/jline.jar:/usr/share/java/zookeeper/zookeeper.jar -Djava.net.preferIPv4Stack=false -Djava.net.preferIPv6Addresses=true org.apache.zookeeper.server.quorum.QuorumPeerMain /etc/zookeeper/zoo.cfg
