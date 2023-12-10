package com.example.demoemail.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.example.basedomains.dto.TaskEvent;

@Service
public class TaskConsumer {

private static final Logger LOGGER = LoggerFactory.getLogger(TaskConsumer.class);
	
	@KafkaListener(topics = "${spring.kafka.topic.name}" , groupId = "${spring.kafka.consumer.group-id}")
	public void kafkaConsumerForOrder(TaskEvent taskEvent) {
		
		LOGGER.info(String.format("Task received in the email service => %s", taskEvent.toString()));
	}
}
