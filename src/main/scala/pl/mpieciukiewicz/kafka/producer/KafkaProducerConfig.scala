package pl.mpieciukiewicz.kafka.producer

import java.util.Properties

import kafka.message.{NoCompressionCodec, DefaultCompressionCodec}
import kafka.producer.ProducerConfig

case class KafkaProducerConfig(clientId: String,
                               brokerList: String,
                               synchronous: Boolean = true,
                               compressed: Boolean = true,
                               batchSize: Integer = 200,
                               messageSendMaxRetries: Integer = 3,
                               requestRequiredAcks: Integer = -1) {

  def toProducerConfig: ProducerConfig = {

    val props = new Properties()

    props.put("client.id", clientId.toString)
    props.put("metadata.broker.list", brokerList)
    props.put("producer.type", if (synchronous) "sync" else "async")
    props.put("compression.codec", if (compressed) DefaultCompressionCodec.codec.toString else NoCompressionCodec.codec.toString)
    props.put("batch.num.messages", batchSize.toString)
    props.put("message.send.max.retries", messageSendMaxRetries.toString)
    props.put("request.required.acks", requestRequiredAcks.toString)

    new ProducerConfig(props)
  }

}
