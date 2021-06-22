package com.unlam.compilador;

import java.util.ArrayList;
import java.util.Stack;
import java.util.logging.Logger;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class TercetoManager {

    public static Logger LOGGER = Logger.getLogger(TercetoManager.class.getName());
	private int lastIdx;
	private ArrayList<Terceto> tercetoList;
	private Stack<Terceto> tercetoBranchStack;

	public ArrayList<Terceto> getTercetoList() {
		return this.tercetoList;
	}

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
		try (BufferedWriter br = new BufferedWriter(new FileWriter("intermedia.txt"))) {            
            tercetoList.forEach(terceto -> {
                try {
                    br.write(terceto.toString() + "\n");
                } catch (IOException e) {
                    LOGGER.severe("Ocurrio un error al guardar el archivo de intermedia.txt");
                    e.printStackTrace();
                }
            });

        } catch (Exception e) {
            LOGGER.severe("Ocurrio un error al guardar el archivo intermedia.txt");
            e.printStackTrace();
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
