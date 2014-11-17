package pl.mpieciukiewicz.microservices.kafka

import java.util.Properties

import kafka.consumer.ConsumerConfig

case class KafkaConsumerConfig (clientId: String,
                                groupId: String,
                                zookeeperConnect: String,
                                autoOffsetReset: String, // "smallest" or "largest"
                                autoCommitEnable: Boolean) {

  def toConsumerConfig: ConsumerConfig = {

    val props = new Properties()

    props.put("group.id", groupId)
    props.put("zookeeper.connect", zookeeperConnect)
    props.put("auto.offset.reset", autoOffsetReset)
    props.put("client.id", clientId)
    props.put("auto.commit.enable", autoCommitEnable.toString)

    new ConsumerConfig(props)
  }

}
