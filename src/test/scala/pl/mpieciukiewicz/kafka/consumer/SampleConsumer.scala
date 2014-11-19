package pl.mpieciukiewicz.kafka.consumer

object SampleConsumer {

  def main(args: Array[String]): Unit = {

    val consumer = new KafkaConsumer(topic = "test",
      KafkaConsumerConfig(clientId = "sample-client",
      groupId = "test-group",
      zookeeperConnect = "127.0.0.1:2181",
      autoOffsetReset = AutoOffsetReset.Largest,
      autoCommitEnable = true))

    consumer.consume(message => println(message.message))
  }

}
