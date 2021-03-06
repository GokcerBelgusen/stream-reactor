package com.datamountaineer.streamreactor.connect.hbase

import BytesHelper._
import org.apache.hadoop.hbase.util.Bytes
import org.apache.kafka.connect.data.Schema
import org.apache.kafka.connect.sink.SinkRecord
import org.scalatest.{Matchers, WordSpec}

class GenericRowKeyBuilderTest extends WordSpec with Matchers {
  "GenericRowKeyBuilder" should {
    "use the topic, partition and offset to make the key" in {

      val topic = "sometopic"
      val partition = 2
      val offset = 1243L
      val sinkRecord = new SinkRecord(topic, partition, Schema.INT32_SCHEMA, 345, Schema.STRING_SCHEMA, "", offset)

      val keyBuilder = new GenericRowKeyBuilderBytes()
      val expected = Bytes.add(Array(topic.fromString(), keyBuilder.delimiterBytes, partition.fromString(),
        keyBuilder.delimiterBytes, offset.fromString()))
      keyBuilder.build(sinkRecord, Nil) shouldBe expected
    }
  }
}
