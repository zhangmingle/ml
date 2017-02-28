package com.ml.test.jms;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.TextMessage;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;

public class QueueConsumerService {

	JmsTemplate jmsTemplate;  
    Destination destination;
	
    private static ApplicationContext appContext = new ClassPathXmlApplicationContext("spring/spring-general.xml");  
    private static QueueConsumerService queueConsumerService = (QueueConsumerService) appContext.getBean("queueConsumerService");  
	
    
	private void receive() {
		TextMessage message = (TextMessage) jmsTemplate.receive();
		try {
			System.out.println("QueueConsumerService收到消息：" + message.getText());
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
    
    public JmsTemplate getJmsTemplate() {
		return jmsTemplate;
	}
	
    public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}
	
    public Destination getDestination() {
		return destination;
	}
	
    public void setDestination(Destination destination) {
		this.destination = destination;
	} 
    
	public static void main(String[] args) {
		queueConsumerService.receive();
	}
    
}
