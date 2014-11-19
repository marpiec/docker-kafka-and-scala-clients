package pl.mpieciukiewicz.kafka.consumer

import kafka.consumer.{Consumer, Whitelist}


class KafkaConsumer(final val topic: String, final val config: KafkaConsumerConfig) {

  private val connector = Consumer.create(config.toConsumerConfig)
  private val topicFilter = new Whitelist(topic)
  private val stream = connector.createMessageStreamsByFilter(topicFilter).head

  def consume(handler: ReceivedMessage => Unit): Unit = {
    for (messageAndTopic <- stream) {
      handler(ReceivedMessage(
        message = new String(messageAndTopic.message().asInstanceOf[Array[Byte]]),
        topic = messageAndTopic.topic,
        offset = messageAndTopic.offset,
        partition = messageAndTopic.partition
      ))
    }
  }

  def close(): Unit = {
    connector.shutdown()
  }

}
