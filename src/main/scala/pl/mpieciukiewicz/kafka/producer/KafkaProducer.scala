package pl.mpieciukiewicz.kafka.producer

import kafka.producer.{KeyedMessage, Producer}



class KafkaProducer(final val topic: String, final val config: KafkaProducerConfig) {

  private val producer = new Producer[AnyRef, AnyRef](config.toProducerConfig)

  def send(message: String, partition: Option[String] = None): Unit = {
    val kafkaMessage = createKafkaMessage(message.getBytes("UTF8"), partition.map(_.getBytes("UTF8")))
    producer.send(kafkaMessage)
  }

  private def createKafkaMessage(message: Array[Byte], partition: Option[Array[Byte]]): KeyedMessage[AnyRef, AnyRef] = {
    if (partition.isDefined) {
      new KeyedMessage(topic, partition.get, message)
    } else {
      new KeyedMessage(topic, message)
    }
  }

}