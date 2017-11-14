package com.java.envitronmentObject;

import java.io.IOException;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.io.support.ResourcePropertySource;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConfigurableApplicationContext cac = new GenericXmlApplicationContext();
		ConfigurableEnvironment env = cac.getEnvironment();
		MutablePropertySources propertySources = env.getPropertySources();
		
		try {
			propertySources.addLast(new ResourcePropertySource("classpath:admin.properties"));
			System.out.println(env.getProperty("id"));
			System.out.println(env.getProperty("pw"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		GenericXmlApplicationContext gxac = (GenericXmlApplicationContext)cac;
		gxac.load("applicationCTX.xml");
		gxac.refresh(); // creating beans in above .xml file.
		
		AdminConnection adminConnection = gxac.getBean("adminConnection", AdminConnection.class);
		System.out.println("ID : " + adminConnection.getId());
		System.out.println("Pw : " + adminConnection.getPw());
		
		gxac.close();		
		cac.close();
	}

}
