package com.example.task.demotask.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
 
import com.example.basedomains.dto.TaskEvent;
 
@Service
public class TaskProducer {
	private static final Logger LOGGER=LoggerFactory.getLogger(TaskProducer.class);
	private NewTopic topic;
	private KafkaTemplate<String,TaskEvent> kafkaTemplate;

	public TaskProducer(NewTopic topic, KafkaTemplate<String, TaskEvent> kafkaTemplate) {
		super();
		this.topic = topic;
		this.kafkaTemplate = kafkaTemplate;
	}
 
 
	public void sendMessage(TaskEvent event){
		LOGGER.info(String.format("Task Event => %s", event.toString()));
		Message<TaskEvent> message = MessageBuilder
						.withPayload(event)
						.setHeader(KafkaHeaders.TOPIC,topic.name())
						.build();
		kafkaTemplate.send(message);
 
	}
}
