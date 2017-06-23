package com.ml.aop;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

import com.ml.annotation.Audit;
import com.ml.annotation.AuditField;

public class RestServiceAspect {
	
	public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("执行目标方法之前 ");
		Object[] args = pjp.getArgs();
		Object returnValue = pjp.proceed(args);

		MethodSignature msig = (MethodSignature)pjp.getSignature();  
		Method method = msig.getMethod();
		Audit dataSource = method.getAnnotation(Audit.class);
		/*如果被Audit注解修饰的方法进行记录*/
		if (dataSource != null) {
			String [] argNames = msig.getParameterNames();
			for (String string : argNames) {
				System.out.println("argNames :" + string);
			}			
			for (Object object : args) {
				System.out.println("argValues :" + object.toString());
				
				Class<? extends Object> clazz = object.getClass();
				Field[] fileds = clazz.getDeclaredFields();
				for (Field field : fileds) {
					Annotation annotation = field.getAnnotation(AuditField.class);
					if (annotation!=null) {
						System.out.println("记录:" + field.getName());
						field.setAccessible(true);//如果是私有的 先要设置可访问  
					    String value = (String) field.get(object);//获取值,这个get()方法重点是参数,参数是你要获取的类 
					    System.out.println("值为" + value);
					}
				}
			}

			System.out.println(pjp.getTarget().getClass().getName());
			System.out.println(pjp.getSignature().getName());
			
			System.out.println("执行目标方法之后");
		}
		return returnValue;
		
	}
}
