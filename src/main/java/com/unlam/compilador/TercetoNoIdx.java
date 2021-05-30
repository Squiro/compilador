package com.unlam.compilador;

public class TercetoNoIdx extends Terceto {
	
	private String secondValue;
	private String thirdValue;
	
	public TercetoNoIdx(int id, String value)
	{
		this.id = id;
		this.firstValue = value;
		this.secondValue = null;
		this.thirdValue = null;
	}
	
	public TercetoNoIdx(int id, String firstValue, String secondValue, String thirdValue)
	{
		this.id = id;
		this.firstValue = firstValue;
		this.secondValue = secondValue;
		this.thirdValue = thirdValue;
	}
	
	@Override
	public String toString() {
		return "[" + this.id + "] =" + " (" + this.firstValue + ", " + this.secondValue + ", " + this.thirdValue + ")";
	}

}
