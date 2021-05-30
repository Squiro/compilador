package com.unlam.compilador;

public class TercetoTwoIdx extends Terceto {

	private Integer firstIndex;
	private Integer secondIndex;
	
	public TercetoTwoIdx(int id, String value, Integer firstIndex, Integer secondIndex)
	{
		this.id = id;
		this.firstValue = value;
		this.firstIndex = firstIndex;
		this.secondIndex = secondIndex;
	}

	@Override
	public String toString() {
		return "[" + this.id + "] = (" + this.firstValue + ", [" + this.firstIndex + "], [" + this.secondIndex + "])";
	}
	
}
