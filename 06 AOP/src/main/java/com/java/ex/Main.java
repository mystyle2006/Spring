package com.java.ex;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("ApplicationCTX.xml");
		
		Student student = ctx.getBean("student", Student.class);
		student.info();
		
		ctx.close();
	}

}
