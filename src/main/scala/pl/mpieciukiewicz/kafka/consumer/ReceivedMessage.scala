package pl.mpieciukiewicz.kafka.consumer

case class ReceivedMessage(message: String,
                           topic: String,
                           offset: Long,
                           partition: Int)
