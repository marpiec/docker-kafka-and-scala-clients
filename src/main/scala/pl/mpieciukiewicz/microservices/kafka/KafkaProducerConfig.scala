package pl.mpieciukiewicz.microservices.kafka

import java.util.{Properties, UUID}

import kafka.message.{NoCompressionCodec, DefaultCompressionCodec}
import kafka.producer.ProducerConfig

case class KafkaProducerConfig(brokerList: String,
                               clientId: String = UUID.randomUUID().toString,
                               synchronously: Boolean = true,
                               compress: Boolean = true,
                               batchSize: Integer = 200,
                               messageSendMaxRetries: Integer = 3,
                               requestRequiredAcks: Integer = -1) {


  def toProducerConfig: ProducerConfig = {

    val props = new Properties()

    val codec = if (compress) DefaultCompressionCodec.codec else NoCompressionCodec.codec

    props.put("compression.codec", codec.toString)
    props.put("producer.type", if (synchronously) "sync" else "async")
    props.put("metadata.broker.list", brokerList)
    props.put("batch.num.messages", batchSize.toString)
    props.put("message.send.max.retries", messageSendMaxRetries.toString)
    props.put("request.required.acks", requestRequiredAcks.toString)
    props.put("client.id", clientId.toString)

    new ProducerConfig(props)
  }

}
