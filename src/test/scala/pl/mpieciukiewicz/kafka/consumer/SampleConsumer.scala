package pl.mpieciukiewicz.kafka.consumer

object SampleConsumer {

  def main(args: Array[String]): Unit = {
    val consumer = new KafkaConsumer("test", KafkaConsumerConfig("sample-client", "test-group", "127.0.0.1:2181", "smallest", true))
    consumer.consume(message => println(message.message))
  }

}
