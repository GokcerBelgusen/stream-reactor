/**
  * Copyright 2016 Datamountaineer.
  *
  * Licensed under the Apache License, Version 2.0 (the "License");
  * you may not use this file except in compliance with the License.
  * You may obtain a copy of the License at
  *
  * http://www.apache.org/licenses/LICENSE-2.0
  *
  * Unless required by applicable law or agreed to in writing, software
  * distributed under the License is distributed on an "AS IS" BASIS,
  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  * See the License for the specific language governing permissions and
  * limitations under the License.
  **/

package com.datamountaineer.streamreactor.socketstreamer

import com.typesafe.config.ConfigFactory

/**
  * Created by andrew@datamountaineer.com on 11/03/16. 
  * stream-reactor-websocket-feeder
  */
trait ConfigurationLoader {

  val config = ConfigFactory.load()
  val systemName = config.getString("system-name")
  val zookeepers = config.getString("kafka.zookeeper-servers")
  val kafkaBootstrapServers = config.getString("kafka.bootstrap-servers")
  val schemaRegistryUrl = config.getString("kafka.schema-registry-url")
  val port = config.getInt("port")
}
