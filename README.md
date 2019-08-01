# Kafka and WebSocket Example

### Introduction
This example demonstrates how to stream kafka messages to a WebSocket in real time and view them in a web page. 
It is based on the twitter WebSocket [example](https://github.com/apache/camel/tree/master/examples/camel-example-twitter-websocket) in camel. 
The example has hard coding and is nothing more than a sample.

For this example we will use kafka [quickstart](https://kafka.apache.org/quickstart) config.  Including creation of `test` topic

### Build
You will need to compile this example first:

	mvn compile

### Kafka Setup
Complete the following steps in [quickstart](https://kafka.apache.org/quickstart)
- Download the code
- Start the server
- Create a topic

### Run
To run the example type

    mvn camel:run

Then open a browser <http://localhost:9090>

Send some messages using [step 4](https://kafka.apache.org/quickstart#quickstart_send) of the kafka quick start.

View the messages in the browser




