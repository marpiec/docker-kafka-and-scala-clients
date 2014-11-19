package pl.mpieciukiewicz.kafka.consumer

import java.util.Properties

import kafka.consumer.ConsumerConfig


object AutoOffsetReset {
  sealed case class AutoOffsetReset(value: String)
  val Smallest = AutoOffsetReset("smallest")
  val Largest = AutoOffsetReset("largest")
}


case class KafkaConsumerConfig (clientId: String,
                                groupId: String,
                                zookeeperConnect: String,
                                autoOffsetReset: AutoOffsetReset.AutoOffsetReset,
                                autoCommitEnable: Boolean) {

  def toConsumerConfig: ConsumerConfig = {

    val props = new Properties()

    props.put("client.id", clientId)
    props.put("group.id", groupId)
    props.put("zookeeper.connect", zookeeperConnect)
    props.put("auto.offset.reset", autoOffsetReset.value)
    props.put("auto.commit.enable", autoCommitEnable.toString)

    new ConsumerConfig(props)
  }

}
