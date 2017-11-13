package com.java.ex;

public class MyCalculator {
	Calculator calculator;
	private int firstNum;
	private int SecondNum;
	
	public MyCalculator() {
	}
	
	public MyCalculator(Calculator calculator, int firstNum, int secondNum) {
		super();
		this.calculator = calculator;
		this.firstNum = firstNum;
		SecondNum = secondNum;
	}
	
	public Calculator getCalculator() {
		return calculator;
	}
	public void setCalculator(Calculator calculator) {
		this.calculator = calculator;
	}
	public int getFirstNum() {
		return firstNum;
	}
	public void setFirstNum(int firstNum) {
		this.firstNum = firstNum;
	}
	public int getSecondNum() {
		return SecondNum;
	}
	public void setSecondNum(int secondNum) {
		SecondNum = secondNum;
	}
	
	public void add() {
		calculator.add(firstNum, SecondNum);
	}
	
	public void sub() {
		calculator.sub(firstNum, SecondNum);
	}
	
	public void multi() {
		calculator.multi(firstNum, SecondNum);
	}
	
	public void div() {
		calculator.div(firstNum, SecondNum);
	}
}
