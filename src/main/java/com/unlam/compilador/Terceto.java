package com.unlam.compilador;

public abstract class Terceto {
	
	protected int id;
	protected String firstValue;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}	
	
	public abstract String toString();
}
