package com.exfantasy.template.jms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.exfantasy.template.cnst.jms.QueueName;

/**
 * <pre>
 * 用來處理 ActiveMQ 的訊息
 * </pre>
 * 
 * @author tommy.feng
 *
 */
@Component
public class Consumer {
	private final Logger logger = LoggerFactory.getLogger(Consumer.class);

	@JmsListener(destination = QueueName.TESTING_Q)
	public void receiveFromTestingQueue(String text) {
		logger.info("Received message: <{}> from queue: <{}>", text, QueueName.TESTING_Q);
	}
}
