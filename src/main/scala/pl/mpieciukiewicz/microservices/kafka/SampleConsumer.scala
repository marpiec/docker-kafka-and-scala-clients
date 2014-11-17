package pl.mpieciukiewicz.microservices.kafka

import kafka.consumer.{Whitelist, ConsumerConnector, Consumer}

object SampleConsumer {

  def main(args: Array[String]): Unit = {
    val consumer: SampleConsumer = new SampleConsumer("test", KafkaConsumerConfig("sample-client", "test-group", "127.0.0.1:2181", "smallest", true))
    consumer.consume()
  }

}


class SampleConsumer(topic: String, config: KafkaConsumerConfig) {

  private val connector = Consumer.create(config.toConsumerConfig)

  println("Connector created")
  private val topicFilter = new Whitelist(topic)

  println("Filter created")
  private val stream = connector.createMessageStreamsByFilter(topicFilter).head
  println("Stream created")

  def consume(): Unit = {
    println("Listening to stream")
    for(messageAndTopic <- stream) {
      println(messageAndTopic + " " + messageAndTopic.offset + " " +messageAndTopic.topic)
    }
  }
//
//  val bytes:Array[Byte] = messageAndTopic.message()
//
//  messageAndTopic.partition


  def close(): Unit = {
    connector.shutdown()
  }

}
