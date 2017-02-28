package com.ml.test.jms;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestJms {


    private static ApplicationContext appContext = new ClassPathXmlApplicationContext("spring/spring-general.xml");  
    QueueProducerService producerService = (QueueProducerService) appContext.getBean("queueProducerService");  
	
    private void send() {
    	producerService.send();
	}
	
	public static void main(String[] args) {
		TestJms a = new TestJms();
		a.send();
	}
}
