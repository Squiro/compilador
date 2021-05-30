package com.unlam.compilador;

import java.util.ArrayList;

public class TercetoManager {
	
	private int lastIdx;
	private ArrayList<Terceto> tercetoList;
	
	public TercetoManager() {
		this.lastIdx = 0;
		this.tercetoList = new ArrayList<Terceto>();
	}
	
	public Terceto findTerceto(int index) {
		for (Terceto terceto : tercetoList) {
			if (terceto.getId() == index)
				return terceto;
		}
		return null;
	}
	
	public void processList()
	{
		for (Terceto terceto : tercetoList) {
			System.out.println(terceto.toString());
		}
	}
	
	public int createTerceto(String value)
	{
		this.lastIdx++;
		this.tercetoList.add(new TercetoNoIdx(lastIdx, value));
		return lastIdx;
	}
	
	public int createTerceto(String firstValue, String secondValue, String thirdValue)
	{
		this.lastIdx++;
		this.tercetoList.add(new TercetoNoIdx(lastIdx, firstValue, secondValue, thirdValue));
		return lastIdx;
	}	
	
	
	public int createTerceto(String firstValue, String secondValue, Integer idx)
	{
		this.lastIdx++;
		this.tercetoList.add(new TercetoOneIdx(lastIdx, firstValue, secondValue, idx));
		return lastIdx;
	}
	
	public int createTerceto(String value, Integer firstIdx, Integer secondIdx)
	{
		this.lastIdx++;
		this.tercetoList.add(new TercetoTwoIdx(lastIdx, value, firstIdx, secondIdx));
		return lastIdx;
	}

}
