package com.ml.test.jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;

import com.ml.pojo.innerannouncement.InnerAnnouncement;

public class QueueConsumerMessageListener implements MessageListener {

	private Object jmsMessager;
	
	public Object getJmsMessager() {
		return jmsMessager;
	}

	public void setJmsMessager(Object jmsMessager) {
		this.jmsMessager = jmsMessager;
	}

/*	public QueueConsumerMessageListener(Object jmsMessager) {
		System.out.println("--队列 MessageListener收到信息：" + jmsMessager.getClass());
		this.jmsMessager = jmsMessager;
	}*/
	
	@Override
	public void onMessage(Message message) {
		if (message instanceof TextMessage) {
			TextMessage textMessage = (TextMessage) message;
			try {
				System.out.println("--队列 MessageListener收到信息：" + textMessage.getText());
			} catch (JMSException e) {
				e.printStackTrace();
			}
		} else if (message instanceof ObjectMessage) {
			ObjectMessage objectMessage = (ObjectMessage) message;
			try {
				System.out.println(1111);
				Object[] args = (Object[])objectMessage.getObject();
				System.out.println(args);
			} catch (JMSException e1) {
				e1.printStackTrace();
			}
		}	
	}
}
