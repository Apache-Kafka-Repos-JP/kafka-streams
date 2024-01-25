package com.kafka.streams;

import com.kafka.streams.model.Order;
import io.confluent.kafka.serializers.AbstractKafkaAvroSerDeConfig;
import io.confluent.kafka.streams.serdes.avro.SpecificAvroSerde;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.CommonClientConfigs;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.Topology;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Properties;

@SpringBootApplication
@Slf4j
public class StreamsApplication {

	public static void main(String[] args) {
		SpringApplication.run(StreamsApplication.class, args);

		Properties props = new Properties();
		props.put(StreamsConfig.APPLICATION_ID_CONFIG, "fraud-detection-application");
		props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "http://localhost:9092");
		props.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
		props.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, SpecificAvroSerde.class);
		props.put(AbstractKafkaAvroSerDeConfig.SCHEMA_REGISTRY_URL_CONFIG, "http://localhost:8081");
		//props.put(CommonClientConfigs.SECURITY_PROTOCOL_CONFIG, "PLAINTEXT");

		StreamsBuilder streamsBuilder = new StreamsBuilder();

		KStream<String, Order> stream = streamsBuilder.stream("payments");

		stream.peek(StreamsApplication::printOnEnter)
				.filter((transactionId, order) -> !order.getUserId().toString().equals(""))
				.filter((transactionId, order) -> order.getNbOfItems() < 1000)
				.filter((transactionId, order) -> order.getTotalAmount() < 10000)
				.mapValues((order) -> {
					order.setUserId(String.valueOf(order.getUserId()).toUpperCase());
					return order;
				})
				.peek(StreamsApplication::printOnExit)
				.to("validated-payments");

		Topology topology = streamsBuilder.build();

		KafkaStreams streams = new KafkaStreams(topology, props);

		streams.start();

		Runtime.getRuntime().addShutdownHook(new Thread(streams::close));

	}

	private static void printOnExit(String transactionId, Order order) {
		log.info("\n*************************");
		log.info("EXITING from stream transaction with ID < " + transactionId + " >, " +
				"of user < " + order.getUserId() + " >, total amount < " + order.getTotalAmount() +
				" > and nb of items < " + order.getNbOfItems() + " >");
	}

	private static void printOnEnter(String transactionId, Order order) {
		log.info("\n*************************");
		log.info("ENTERING stream transaction with ID < " + transactionId + " >, " +
				"of user < " + order.getUserId() + " >, total amount < " + order.getTotalAmount() +
				" > and nb of items < " + order.getNbOfItems() + " >");
	}

}
