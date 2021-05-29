package com.unlam.compilador;

public class Terceto<T> {
	
	private T operand1;
	public T operand2;
	public String operator;
	
	public Terceto(T operand1, T operand2, String operator)
	{
		this.operand1 = operand1;
		this.operand2 = operand2;
		this.operator = operator;
	}

	@Override
	public String toString() {
		return operand1.toString() + " " + operand2.toString() + " " + operator.toString();
	}
}
