package ec.jtux.kafkademo.main;

import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import ec.jtux.kafkademo.constants.IKafkaConstants;
import ec.jtux.kafkademo.pojo.CustomObject;

public class MainConsumer {
	public static void main(String[] args) {
		Properties props = new Properties();

		props.put("bootstrap.servers", IKafkaConstants.KAFKA_BROKER);
		props.put("group.id", IKafkaConstants.GROUP_NAME);
		props.put("key.deserializer", IKafkaConstants.KEY_DESERIALIZER);
		props.put("value.deserializer", IKafkaConstants.VALUE_DESERIALIZER);

		KafkaConsumer<Long, CustomObject> consumer = new KafkaConsumer<Long, CustomObject>(props);

		consumer.subscribe(Arrays.asList(IKafkaConstants.TOPIC_NAME));

		while (true) {
			ConsumerRecords<Long, CustomObject> records = consumer.poll(100);

			for (ConsumerRecord<Long, CustomObject> record : records) {
				System.out.println("MSG RECD: " + record.value().toString());
			}
		}
	}
}
