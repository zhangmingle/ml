package com.ml.test;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;

import com.ml.dao.mapper.InnerAnnouncementMapper;

public class TestBean implements BeanNameAware,BeanFactoryAware,InitializingBean,DisposableBean,BeanPostProcessor {

    private String name;
    private String address;     
    private int phone;
    
    private BeanFactory beanFactory;
    private String beanName;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		System.out.println("【注入属性】注入属性name");
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		System.out.println("【注入属性】注入属性address");
		this.address = address;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		System.out.println("【注入属性】注入属性phone");

		this.phone = phone;
	}

	@Override
	public void setBeanName(String name) {
		System.out.println("【BeanNameAware接口】调用BeanNameAware.setBeanName()");
		this.beanName = name;
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		System.out.println("【BeanFactoryAware接口】调用BeanFactoryAware.setBeanFactoryName()");
		this.beanFactory = beanFactory;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("【InitializingBean接口】调用InitializingBean.afterPropertiesSet()");
		
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("【DiposibleBean接口】调用DiposibleBean.destory()");		
	}
    
	// 通过<bean>的init-method属性指定的初始化方法
	public void myInit() {
		System.out.println("【init-method】调用<bean>的init-method属性指定的初始化方法");
	}
	
    // 通过<bean>的destroy-method属性指定的初始化方法
	public void myDestory() {
		System.out.println("【destroy-method】调用<bean>的destroy-method属性指定的初始化方法");
	}

/*	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName)
			throws BeansException {
		System.out.println("[TestBean]BeanPostProcessor接口方法postProcessBeforeInitialization对属性进行更改！");
		
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName)
			throws BeansException {
		System.out.println("[TestBean]BeanPostProcessor接口方法postProcessAfterInitialization对属性进行更改！");
		return bean;
	}*/
	
    @Override
    public Object postProcessAfterInitialization(Object arg0, String arg1)
            throws BeansException {
        System.out
        .println(arg0.getClass().getName() + "BeanPostProcessor接口方法postProcessAfterInitialization对属性进行更改！");
        return arg0;
    }

    @Override
    public Object postProcessBeforeInitialization(Object arg0, String arg1)
            throws BeansException {
        System.out
        .println(arg0.getClass().getName() + "BeanPostProcessor接口方法postProcessBeforeInitialization对属性进行更改！");
        return arg0;
    }

}
