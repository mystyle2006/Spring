package com.java.ex;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
	
		AdminConnection adminConnection = ctx.getBean("adminConnection", AdminConnection.class);
		System.out.println("ID : " + adminConnection.getId());
		System.out.println("PW : " + adminConnection.getPw());
		
		ctx.close();
	}

}
