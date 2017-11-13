package com.java.ex;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String configLocation = "classpath:applicationCTX.xml"; //To get the .xml file.
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLocation); //parsing that file into context.
		MyCalculator myCal = ctx.getBean("myCalculator", MyCalculator.class); //To get a object.
		
		myCal.add();
		myCal.sub();
		myCal.multi();
		myCal.div();
		
	}

}
