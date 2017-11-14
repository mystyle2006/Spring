package com.java.envitronmentObject;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;

public class AdminConnection implements EnvironmentAware, InitializingBean, DisposableBean {
	
	private Environment env;
	private String id;
	private String pw;
	
	@Override
	public void setEnvironment(Environment env) {
		System.out.println("setEnvironment");
		setEnv(env); //Creating Environment Object first
	}
	
	public AdminConnection() {
		
	}
	
	public Environment getEnv() {
		return env;
	}

	public void setEnv(Environment env) {
		this.env = env;
	}

	public AdminConnection(String id, String pw) {
		super();
		this.id = id;
		this.pw = pw;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("afterPropertiesSet()");
		setId(env.getProperty("id"));
		setPw(env.getProperty("pw"));
	}
	
	@Override
	public void destroy() throws Exception {
		System.out.println("Destroy()");
	}
}
