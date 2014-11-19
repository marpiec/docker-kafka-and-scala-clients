package pl.mpieciukiewicz.kafka.producer

object SampleProducer {

  def main(args: Array[String]): Unit = {

    val producer = new KafkaProducer(topic = "test", KafkaProducerConfig("sample-consumer", "192.168.1.103:9092"))

    while (true) {
      val message = "hello kafka " + System.currentTimeMillis() % 100
      producer.send(message)
      Thread.sleep(2000)
    }

  }
}
