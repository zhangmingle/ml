package com.ml.test.jms;

import java.util.Date;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import com.ml.test.InnerAnnouncement;

public class QueueProducerService {

    JmsTemplate jmsTemplate;  
    Destination destination;
	
	@Autowired
	static QueueProducerService queueProducerService;
    
    public void send() {
		MessageCreator messageCreator = new MessageCreator() {
			@Override
			public Message createMessage(Session session) throws JMSException {
				ObjectMessage objectMessage = session.createObjectMessage();
				InnerAnnouncement InnerAnnouncement = new InnerAnnouncement();
				InnerAnnouncement.setContent("QueueProducerService发送消息" + new Date());
				InnerAnnouncement.setId(1);
				objectMessage.setObject(InnerAnnouncement);
				return objectMessage;
			}
		};
		jmsTemplate.send(this.destination, messageCreator);
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
		queueProducerService.send();
	}
}
