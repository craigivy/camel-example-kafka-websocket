/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.camel.example.websocket;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.websocket.WebsocketComponent;

/**
 * A Camel route that updates from kafka all events.
 * And post the changes to web-socket, that can be viewed from a web page
 */
public class KafkaWebSocketRoute extends RouteBuilder {

    private int port = 9090;

    void setPort(int port) {
        this.port = port;
    }

    @Override
    public void configure() {
        // setup Camel web-socket component on the port we have defined
        WebsocketComponent wc = getContext().getComponent("websocket", WebsocketComponent.class);
        wc.setPort(port);
        // we can serve static resources from the classpath: or file: system
        wc.setStaticResources("classpath:.");

        // stream kafka events to web socket URL - camel-kafka
        from("kafka:localhost:9092?brokers=localhost:9092&topic=test")
            .to("log:kafka")
            .to("websocket:camel-kafka?sendToAll=true");
    }
}
