package com.unlam.compilador;

import java.util.ArrayList;
import java.util.Stack;

public class TercetoManager {

	private int lastIdx;
	private ArrayList<Terceto> tercetoList;
	private Stack<Terceto> tercetoBranchStack;

	public int getLastIdx() {
		return lastIdx;
	}

	public TercetoManager() {
		this.lastIdx = 0;
		this.tercetoList = new ArrayList<Terceto>();
		this.tercetoBranchStack = new Stack<Terceto>();
	}

	public Terceto findTerceto(int index) {
		for (Terceto terceto : tercetoList) {
			if (terceto.getId() == index)
				return terceto;
		}
		return null;
	}

	public void processList() {
		for (Terceto terceto : tercetoList) {
			System.out.println(terceto.toString());
		}
	}

	public void apilarTercetoBranch(int idx) {
		this.tercetoBranchStack.push(findTerceto(idx));
	}

	public Terceto desapilarTercetoBranch() {
		return this.tercetoBranchStack.pop();
	}

	public int createTerceto(Object... val) {
		this.lastIdx++;
		this.tercetoList.add(TercetoFactory.getTerceto(this.lastIdx, val));
		return lastIdx;
	}

	public String getConditionInverse(Object objectCondition) {
		String inverseCondition = "";
		String condition = objectCondition.toString();
		if (condition.equals("BLE")) {
			inverseCondition = "BGT";
		} else if (condition.equals("BGE")) {
			inverseCondition = "BLT";
		} else if (condition.equals("BLT")) {
			inverseCondition = "BGE";
		} else if (condition.equals("BGT")) {
			inverseCondition = "BLE";
		} else if (condition.equals("BNE")) {
			inverseCondition = "BEQ";
		} else if (condition.equals("BEQ")) {
			inverseCondition = "BNE";
		}
		return inverseCondition;
	}
}
