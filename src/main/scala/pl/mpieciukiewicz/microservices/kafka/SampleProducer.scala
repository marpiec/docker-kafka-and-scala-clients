package pl.mpieciukiewicz.microservices.kafka

import kafka.producer.{KeyedMessage, Producer}


object SampleProducer {
  def main(args: Array[String]): Unit = {
    val producer: SampleProducer = new SampleProducer(StaticProducerConfig("127.0.0.1:9092"))

    while (true) {
      producer.send("test", "hello kafka " + System.currentTimeMillis() % 100)
      Thread.sleep(2000)
    }

  }
}


class SampleProducer(config: StaticProducerConfig) {


  val producer = new Producer[AnyRef, AnyRef](config.toProducerConfig)


  def send(topic: String, message: String, partition: Option[String] = None): Unit = {
    val kafkaMessage = createKafkaMesssage(topic, message.getBytes("UTF8"), partition.map(_.getBytes("UTF8")))
    producer.send(kafkaMessage)
  }


  private def createKafkaMesssage(topic: String, message: Array[Byte], partition: Option[Array[Byte]]): KeyedMessage[AnyRef, AnyRef] = {
    if (partition.isDefined) {
      new KeyedMessage(topic, partition.get, message)
    } else {
      new KeyedMessage(topic, message)
    }
  }


}