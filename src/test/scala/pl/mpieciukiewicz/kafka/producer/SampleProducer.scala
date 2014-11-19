package pl.mpieciukiewicz.kafka.producer

object SampleProducer {
  def main(args: Array[String]): Unit = {

    val producer = new KafkaProducer(KafkaProducerConfig("192.168.1.103:9092"), "test")

    while (true) {
      producer.send("hello kafka " + System.currentTimeMillis() % 100)
      Thread.sleep(2000)
    }

  }
}
