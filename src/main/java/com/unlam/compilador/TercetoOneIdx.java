package com.unlam.compilador;

public class TercetoOneIdx extends Terceto {

	private String secondValue;
	private Integer index;
	
	public TercetoOneIdx(int id, String firstValue, String secondValue, Integer index)
	{
		this.id = id;
		this.firstValue = firstValue;
		this.secondValue = secondValue;
		this.index = index;
	}	
	
	@Override
	public String toString() {
		return "[" + this.id + "] = (" + this.firstValue + ", " + this.secondValue + ", [" + this.index + "])";
	}
}

