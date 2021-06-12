package com.unlam.compilador;

public class TercetoTwoIdx extends Terceto {

	private Integer firstIndex;
	private Integer secondIndex;

	public String getFirstValue(){
		return firstValue;
	}

	public void setFirstValue(String firstValue){
		this.firstValue = firstValue;
	}

	public void setFirstIndex(int idx) 
	{
		this.firstIndex = idx;
	}
	
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
