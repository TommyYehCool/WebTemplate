package com.exfantasy.template.services.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exfantasy.template.jms.Producer;

/**
 * <pre>
 * 處理 JMS 相關 service
 * </pre>
 * 
 * @author tommy.feng
 *
 */
@Service
public class JmsService {

	@Autowired
	private Producer producer;
	
	public void sendMessageToTestingQ(String msg) {
		producer.sendToTestingQ(msg);
	}
}
